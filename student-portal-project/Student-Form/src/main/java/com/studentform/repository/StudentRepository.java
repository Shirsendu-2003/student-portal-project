package com.studentform.repository;


import com.studentform.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {



    // ✅ Return list of [source, count]
    @Query("SELECT s.source, COUNT(s) FROM Student s GROUP BY s.source")
    List<Object[]> countStudentsBySource();
}
