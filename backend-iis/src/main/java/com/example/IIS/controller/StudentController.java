package com.example.IIS.controller;

import com.example.IIS.dto.StudentDto;
import com.example.IIS.dto.UserDTO;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.service.StudentService;
import com.example.IIS.service.WorkshopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService _studentService;
    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll(){
        List<StudentDto> users = _studentService.GetAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
