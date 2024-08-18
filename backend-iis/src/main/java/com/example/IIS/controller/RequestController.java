package com.example.IIS.controller;

import com.example.IIS.dto.FacultyDto;
import com.example.IIS.dto.RequestDetailDto;
import com.example.IIS.dto.RequestDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.service.RequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllAcceptedRequest")
    public ResponseEntity<List<RequestDto>> getAllAcceptedRequest() {
        List<RequestDto> allAcceptedRequest = requestService.getAllAcceptedRequest();
        return new ResponseEntity<>(allAcceptedRequest, HttpStatus.OK);
    }

    @GetMapping("/getRequestDetails/{requestId}")
    public ResponseEntity<RequestDetailDto> getRequestDetails(@PathVariable(name = "requestId") long requestId) {
        RequestDetailDto requestDetails = requestService.getRequestDetailsById(requestId);
        return new ResponseEntity<>(requestDetails, HttpStatus.OK);
    }

    @GetMapping("/getAllAcceptedRequestDetails")
    public ResponseEntity<List<RequestDetailDto>> getAllAcceptedRequestDetails() {
        List<RequestDetailDto> requestDetails = requestService.getAllAcceptedRequestDetails();
        return new ResponseEntity<>(requestDetails, HttpStatus.OK);
    }
}
