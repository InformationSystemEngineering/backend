package com.example.IIS.service;

import com.example.IIS.dto.FacultyDto;
import com.example.IIS.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FacultyService {
    List<FacultyDto> getAllFaculties();
}
