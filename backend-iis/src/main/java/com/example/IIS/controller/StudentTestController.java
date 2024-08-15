package com.example.IIS.controller;

import com.example.IIS.dto.StudentTestDto;
import com.example.IIS.service.StudentTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studenttest")
public class StudentTestController {
    @Autowired
    private StudentTestService studentTestService;

    public StudentTestController(StudentTestService studentTestService) {
        this.studentTestService = studentTestService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> createStudentTest(@RequestBody StudentTestDto studentTestDto){
        studentTestService.createStudentTest(studentTestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
