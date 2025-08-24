package com.studentform.repository;


import com.studentform.model.AdminCell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminCellRepository extends JpaRepository<AdminCell, Long> {
    Optional<AdminCell> findByEmail(String email);
    boolean existsByEmail(String email);
}