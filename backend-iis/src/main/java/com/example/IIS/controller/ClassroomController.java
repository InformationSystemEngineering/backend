package com.example.IIS.controller;

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
}
