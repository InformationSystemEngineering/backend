package com.example.IIS.service;

import com.example.IIS.dto.ClassroomDto;

import java.util.List;

public interface ClassroomService {
    List<ClassroomDto> getAllClassroomsByRequestId(long requestId);
}
