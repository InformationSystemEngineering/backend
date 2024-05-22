package com.example.IIS.service;

import com.example.IIS.domain.StudentTest;
import com.example.IIS.dto.StudentInternshipDto;

import java.util.List;

public interface StudentInternshipService {
    void create(List<StudentTest> bestStudents);

    StudentInternshipDto GetByStudent(long id);

    StudentInternshipDto GetByPsychologist(long id);
}
