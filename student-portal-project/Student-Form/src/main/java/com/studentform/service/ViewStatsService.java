package com.studentform.service;

import com.studentform.dto.ViewStatsDTO;
import com.studentform.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViewStatsService {

    private final StudentRepository studentRepository;

    public ViewStatsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<ViewStatsDTO> getViewsBySource() {
        List<Object[]> results = studentRepository.countStudentsBySource();
        return results.stream()
                .map(r -> new ViewStatsDTO((String) r[0], (Long) r[1]))
                .collect(Collectors.toList());
    }
}
