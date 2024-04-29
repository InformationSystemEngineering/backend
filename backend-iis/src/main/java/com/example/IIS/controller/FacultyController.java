package com.example.IIS.controller;

import com.example.IIS.dto.FacultyDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.service.FacultyService;
import com.example.IIS.service.WorkshopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;



    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping("/getAll")
    public ResponseEntity<List<FacultyDto>> getAllFaculties() {
        List<FacultyDto> allFaculties = facultyService.getAllFaculties();
        return new ResponseEntity<>(allFaculties, HttpStatus.OK);
    }
}
