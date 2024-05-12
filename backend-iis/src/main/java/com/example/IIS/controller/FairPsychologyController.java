package com.example.IIS.controller;

import com.example.IIS.domain.FairPsychology;
import com.example.IIS.dto.FairDto;
import com.example.IIS.dto.FairPsychologyDto;
import com.example.IIS.service.FairPsychologyService;
import com.example.IIS.service.FairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fairpsychology")
public class FairPsychologyController {

    @Autowired
    private FairPsychologyService fairPsychologyService;

    public FairPsychologyController(FairPsychologyService fairPsychologyService) {
        this.fairPsychologyService = fairPsychologyService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> createFairPsychology(@RequestBody FairPsychologyDto fairPsychologyDto){
        fairPsychologyService.createFairPsychology(fairPsychologyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
