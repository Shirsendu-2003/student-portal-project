package com.studentform.controller;

import com.studentform.model.Student;
import com.studentform.repository.StudentRepository;
import com.studentform.service.StudentExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3001") // Adjust as per your frontend
public class AdminController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private StudentExportService studentExportService;

    @GetMapping("/me")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, String>> getAdminInfo(Authentication auth) {
        System.out.println("Roles: " + auth.getAuthorities()); // ✅ Debug output
        return ResponseEntity.ok(Map.of("name", auth.getName()));
    }





    // ✅ Protected route - only accessible with valid JWT token and ROLE_ADMIN
   @GetMapping("/students")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Student>> getAllSubmittedForms() {
        List<Student> allForms = studentRepo.findAll();
        return ResponseEntity.ok(allForms);
    }

    // Export ALL students
    @GetMapping("/students/export/{type}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<byte[]> exportAll(@PathVariable String type) throws Exception {
        List<Student> students = studentRepo.findAll();

        if ("excel".equalsIgnoreCase(type)) {
            byte[] data = studentExportService.exportAllToExcel(students);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=students.xlsx")
                    .contentType(MediaType.parseMediaType(
                            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(data);
        } else if ("pdf".equalsIgnoreCase(type)) {
            byte[] data = studentExportService.exportAllToPdf(students);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=students.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(data);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/students/{id}/export/{type}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<byte[]> exportStudentData(@PathVariable Long id, @PathVariable String type) {
        Optional<Student> studentOpt = studentRepo.findById(id);
        if (studentOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Student student = studentOpt.get();
        byte[] data;
        String contentType;
        String fileName;

        try {
            if (type.equalsIgnoreCase("excel")) {
                data = studentExportService.exportToExcel(student);
                contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                fileName = "student_" + id + ".xlsx";
            } else if (type.equalsIgnoreCase("pdf")) {
                data = studentExportService.exportToPdf(student);
                contentType = "application/pdf";
                fileName = "student_" + id + ".pdf";
            } else {
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                    .body(data);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}


