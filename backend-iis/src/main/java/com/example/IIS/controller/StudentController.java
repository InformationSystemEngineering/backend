package com.example.IIS.controller;

import com.example.IIS.domain.InternshipTest;
import com.example.IIS.domain.StudentTest;
import com.example.IIS.dto.*;
import com.example.IIS.service.StudentService;
import com.example.IIS.service.StudentTestService;
import com.example.IIS.service.WorkshopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService _studentService;
    @Autowired
    private StudentTestService _studentTestService;

    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll(){
        List<StudentDto> users = _studentService.GetAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/student-test")
    public ResponseEntity<Void> updateTest(@RequestBody StudentTestDto dto){

        StudentTestDto updatedDto = _studentTestService.updateStudentTest(dto);
        if (updatedDto != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/student-test/get-best-students/{id}")
    public ResponseEntity<List<StudentTestDto>> getBestStudents(@PathVariable(name = "id") long id){
        List<StudentTestDto> bestStudents = _studentTestService.getBestStudents(id);
        return new ResponseEntity<>(bestStudents, HttpStatus.OK);
    }

}
