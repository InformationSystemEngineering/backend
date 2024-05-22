package com.example.IIS.controller;

import com.example.IIS.dto.FairPsychologyDto;
import com.example.IIS.dto.StudentExtraActivityDto;
import com.example.IIS.service.FairPsychologyService;
import com.example.IIS.service.StudentExtraActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studentextraactivity")
public class StudentExtraActivityController {
    @Autowired
    private StudentExtraActivityService studentExtraActivityService;

    public StudentExtraActivityController(StudentExtraActivityService studentExtraActivityService) {
        this.studentExtraActivityService = studentExtraActivityService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> createStudentExtraActivity(@RequestBody StudentExtraActivityDto studentExtraActivityDto){
        studentExtraActivityService.createStudentExtraActivity(studentExtraActivityDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
