package com.studentform.controller;

import com.studentform.model.Student;
import com.studentform.repository.StudentRepository;
import com.studentform.service.EmailService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private EmailService emailService;


    @PostMapping
    public Student saveStudent(@RequestBody Student student) {

        // Generate only if new student (id == null)
        if (student.getId() == null) {

            // 1️⃣ Get initials from name
            String[] names = student.getName().split(" ");
            String initials = "";
            if (names.length >= 2) {
                initials = names[0].substring(0, 1).toUpperCase() +
                        names[1].substring(0, 1).toUpperCase();
            } else if (names.length == 1) {
                initials = names[0].substring(0, 1).toUpperCase() + "X"; // X as placeholder
            } else {
                initials = "XX";
            }

            // 2️⃣ Get current date
            java.time.LocalDate today = java.time.LocalDate.now();
            String datePart = String.format("%02d%02d%04d",
                    today.getDayOfMonth(), today.getMonthValue(), today.getYear());

            // 3️⃣ Get serial number (optional: count existing students today)
            long countToday = studentRepository.count(); // simple, can improve later
            String serial = String.valueOf(countToday + 1);

            // 4️⃣ Combine
            String uniqueId = initials + datePart + serial;
            student.setStudentsId(uniqueId);
        }

        Student savedStudent = studentRepository.save(student);

        // Send email after saving
        emailService.sendVerificationEmail(savedStudent.getEmail(), savedStudent.getName());

        return savedStudent;
    }



    @GetMapping
    @PreAuthorize("hasRole('ADMIN','ADMIN_CELL')")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }




    // ✅ Update remark by AdminCell
    @PutMapping("/{id}/remark")
    @PreAuthorize("hasRole('ADMIN_CELL')")
    public Student updateRemark(@PathVariable Long id, @RequestBody Student remarkRequest) {
        return studentRepository.findById(id).map(student -> {
            student.setRemark(remarkRequest.getRemark());
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }





}
