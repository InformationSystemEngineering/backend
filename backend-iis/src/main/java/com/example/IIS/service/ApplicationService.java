package com.example.IIS.service;

import com.example.IIS.domain.Application;
import com.example.IIS.dto.ApplicationDto;
import com.example.IIS.dto.TopicWithDetailsDto;

import java.util.List;

public interface ApplicationService {
    ApplicationDto applyForTopic(ApplicationDto applicationDto);
    List<TopicWithDetailsDto> getTopicsByStudentId(Long studentId);
}
