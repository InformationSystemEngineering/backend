package com.example.IIS.controller;

import com.example.IIS.dto.HallDto;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.service.HallService;
import com.example.IIS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/halls")
public class HallController {
    @Autowired
    private HallService _hallService;
    @GetMapping
    public ResponseEntity<List<HallDto>> getAll(){
        List<HallDto> halls = _hallService.getAll();
        return new ResponseEntity<>(halls, HttpStatus.OK);
    }
}
