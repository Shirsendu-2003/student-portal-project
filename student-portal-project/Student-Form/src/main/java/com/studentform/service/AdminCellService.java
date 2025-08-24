package com.studentform.service;



import com.studentform.model.AdminCell;
import com.studentform.repository.AdminCellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminCellService {
    private final AdminCellRepository adminCellRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminCell register(AdminCell adminCell) {
        if (adminCellRepository.existsByEmail(adminCell.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        adminCell.setPassword(passwordEncoder.encode(adminCell.getPassword()));
        return adminCellRepository.save(adminCell);
    }

    public Optional<AdminCell> login(String email, String rawPassword) {
        return adminCellRepository.findByEmail(email)
                .filter(ac -> passwordEncoder.matches(rawPassword, ac.getPassword()));
    }
}