package com.example.IIS.controller;

import com.example.IIS.dto.RequestDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.service.RequestService;
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
@RequestMapping("/api/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping
    public ResponseEntity<RequestDto> createRequest(@Valid @RequestBody RequestDto requestDto){
        return new ResponseEntity<>(requestService.createRequest(requestDto), HttpStatus.CREATED);
    }
}
