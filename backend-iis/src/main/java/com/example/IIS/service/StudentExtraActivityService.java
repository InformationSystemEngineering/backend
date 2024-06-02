package com.example.IIS.service;

import com.example.IIS.dto.FairPsychologyDto;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.StudentExtraActivityDto;

import java.util.List;

public interface StudentExtraActivityService {
    StudentExtraActivityDto createStudentExtraActivity(StudentExtraActivityDto studentExtraActivityDto);

    public List<StudentExtraActivityDto> getAll ();

}
