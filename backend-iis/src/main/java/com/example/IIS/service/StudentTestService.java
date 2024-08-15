package com.example.IIS.service;

import com.example.IIS.domain.StudentTest;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.dto.StudentTestDto;

import java.util.List;

public interface StudentTestService {
    StudentTest findByStudentId(long id);

    List<StudentDto> getStudentsByInternshipTest(long id);

    List<StudentTestDto> getStudentTestsByInternshipTest(long id);

    void isInternshipTestReviewedMeanwhile(long id);

    StudentTestDto updateStudentTest(StudentTestDto dto);

    List<StudentTestDto> getBestStudents(long id);

    StudentTestDto createStudentTest(StudentTestDto studentTestDto);
}
