package com.studentform.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String studentsId;   // Business ID (one per person, never changes)

    private String name;
    private String email;
    private String phone;



    @ElementCollection
    @MapKeyColumn(name = "choice_order", columnDefinition = "VARCHAR(255)")
    @Column(name = "course_name", columnDefinition = "VARCHAR(255)")
    private Map<String, String> courseChoices;

    private String source; // 👈 facebook, whatsapp, etc.


    // ✅ Server date timestamps
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @Column(length = 500)
    private String remark;


    private boolean verified = true; // ✅ default false

    private String verificationToken; // ✅ for storing token




}
