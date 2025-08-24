package com.studentform.controller;

import com.studentform.model.Admin;
import com.studentform.repository.AdminRepository;
import com.studentform.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3001") // React Admin Frontend
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ Admin Registration
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin) {
        if (adminRepo.findByEmail(admin.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("❌ Email already exists!");
        }

        // Hash the password before saving
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Admin savedAdmin = adminRepo.save(admin);

        // Don’t send password back in response
        savedAdmin.setPassword(null);

        return ResponseEntity.ok(savedAdmin);
    }

    // ✅ Admin Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(payload.get("email"), payload.get("password"))
            );

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String token = jwtUtil.generateToken(userDetails.getUsername(), "ADMIN");


            Admin admin = adminRepo.findByEmail(payload.get("email")).orElseThrow();

            // Remove password from response
            admin.setPassword(null);

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("expiresAt", new Date(System.currentTimeMillis() + 1000 * 60 * 60)); // 1h expiry
            response.put("admin", admin);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(403).body("❌ Invalid email or password");
        }
    }
}
