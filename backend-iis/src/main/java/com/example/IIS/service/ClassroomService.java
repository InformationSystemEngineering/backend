package com.example.IIS.service;

import com.example.IIS.domain.Classroom;
import com.example.IIS.dto.ClassroomDateDto;
import com.example.IIS.dto.ClassroomDto;

import java.util.List;
import java.util.Optional;

public interface ClassroomService {
    List<ClassroomDto> getAllClassroomsByRequestId(long requestId);
    Optional<ClassroomDto> getClassroomById(Long classroomId);
    List<ClassroomDto> getClassroomsByRequestId(Long requestId);
    Optional<ClassroomDateDto> getClassroomDateByTopicId(Long topicId);
}
