package com.example.IIS.service;

import com.example.IIS.domain.StudentTest;
import com.example.IIS.dto.StudentDto;

import java.util.List;

public interface StudentTestService {
    StudentTest findByStudentId(long id);

    List<StudentDto> getStudentsByInternshipTest(long id);
}
