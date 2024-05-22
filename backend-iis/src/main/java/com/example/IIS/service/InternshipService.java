package com.example.IIS.service;


import com.example.IIS.dto.InternshipDto;
import com.example.IIS.dto.StudentDto;

import java.util.List;

public interface InternshipService {
    List<InternshipDto> GetAll();
}
