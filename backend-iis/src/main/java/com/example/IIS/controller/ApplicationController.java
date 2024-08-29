package com.example.IIS.controller;

import com.example.IIS.domain.Application;
import com.example.IIS.dto.ApplicationDto;
import com.example.IIS.dto.TopicWithDetailsDto;
import com.example.IIS.service.ApplicationService;
import com.example.IIS.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<ApplicationDto> applyForTopic(@RequestBody ApplicationDto applicationDto) {
        ApplicationDto savedApplicationDto = applicationService.applyForTopic(applicationDto);
        return new ResponseEntity<>(savedApplicationDto, HttpStatus.CREATED);
    }

    @GetMapping("/topics-by-student/{studentId}")
    public ResponseEntity<List<TopicWithDetailsDto>> getTopicsByStudentId(@PathVariable(name = "studentId") long studentId) {
        List<TopicWithDetailsDto> topics = applicationService.getTopicsByStudentId(studentId);
        return ResponseEntity.ok(topics);
    }

}
