package com.example.IIS.controller;

import com.example.IIS.dto.FacultyDto;
import com.example.IIS.dto.FairDto;
import com.example.IIS.service.FacultyService;
import com.example.IIS.service.FairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fairs")
public class FairController {
    @Autowired
    private FairService fairService;



    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping("/getAll")
    public ResponseEntity<List<FairDto>> getAllFairs() {
        List<FairDto> allFairs = fairService.getAllFairs();
        return new ResponseEntity<>(allFairs, HttpStatus.OK);
    }
}
