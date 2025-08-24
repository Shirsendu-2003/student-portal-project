package com.studentform.controller;

import com.studentform.model.AdminCell;
import com.studentform.security.JwtUtil;
import com.studentform.service.AdminCellService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/admincell")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
public class AdminCellAuthController {

    private final AdminCellService adminCellService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AdminCell adminCell) {
        AdminCell saved = adminCellService.register(adminCell);
        return ResponseEntity.ok(Map.of(
                "message", "Admin Cell registered successfully",
                "adminCell", saved
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        String email = req.get("email");
        String password = req.get("password");

        return adminCellService.login(email, password)
                .map(adminCell -> {
                    String token = jwtUtil.generateToken(adminCell.getEmail(), "ADMIN_CELL");
                    Map<String, Object> res = new HashMap<>();
                    res.put("token", token);
                    res.put("adminCell", adminCell);
                    return ResponseEntity.ok(res);
                })
                .orElseGet(() -> ResponseEntity.status(401).body(
                        Map.of("message", "Invalid credentials")
                ));
    }
}
