package com.example.IIS.controller;

import com.example.IIS.domain.Classroom;
import com.example.IIS.dto.ClassroomDateDto;
import com.example.IIS.dto.ClassroomDto;
import com.example.IIS.dto.FairDto;
import com.example.IIS.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @GetMapping("/getAllClassroomsByRequestId/{requestId}")
    public ResponseEntity<List<ClassroomDto>> getAllClassroomsByRequestId(@PathVariable(name = "requestId") long requestId) {
        List<ClassroomDto> allClassroomsByRequestId = classroomService.getAllClassroomsByRequestId(requestId);
        return new ResponseEntity<>(allClassroomsByRequestId, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable Long id) {
        Optional<ClassroomDto> classroom = classroomService.getClassroomById(id);
        return classroom.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // New endpoint to get classrooms by requestId
    @GetMapping("/byRequest/{requestId}")
    public ResponseEntity<List<ClassroomDto>> getClassroomsByRequestId(@PathVariable Long requestId) {
        List<ClassroomDto> classrooms = classroomService.getClassroomsByRequestId(requestId);
        if (!classrooms.isEmpty()) {
            return ResponseEntity.ok(classrooms);
        }
        return ResponseEntity.notFound().build();
    }

    // New endpoint to get classroom date by topic ID
    @GetMapping("/date/byTopic/{topicId}")
    public ResponseEntity<ClassroomDateDto> getClassroomDateByTopicId(@PathVariable Long topicId) {
        Optional<ClassroomDateDto> classroomDateDto = classroomService.getClassroomDateByTopicId(topicId);
        return classroomDateDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
