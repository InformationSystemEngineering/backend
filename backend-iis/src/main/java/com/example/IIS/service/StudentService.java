package com.example.IIS.service;

import com.example.IIS.dto.InternshipTestDto;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.dto.StudentTestDto;
import com.example.IIS.dto.UserDTO;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    List<StudentDto> GetAll();

}
