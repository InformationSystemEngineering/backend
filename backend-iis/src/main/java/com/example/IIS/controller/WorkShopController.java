package com.example.IIS.controller;

import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.service.PostService;
import com.example.IIS.service.WorkshopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workshops")
public class WorkShopController {
    @Autowired
    private WorkshopService workshopService;



    @PreAuthorize("hasRole('ROLE_PSYCHOLOG')")
    @PostMapping
    public ResponseEntity<WorkShopDto> createWorkshop(@Valid @RequestBody WorkShopDto workShopDto){
        return new ResponseEntity<>(workshopService.createWorkshop(workShopDto), HttpStatus.CREATED);
    }

}
