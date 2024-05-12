package com.example.IIS.controller;

import com.example.IIS.domain.ExtraActivity;
import com.example.IIS.domain.Fair;
import com.example.IIS.dto.ExtraActivityDto;
import com.example.IIS.dto.FairDto;
import com.example.IIS.dto.FairPsychologyDto;
import com.example.IIS.service.ExtraActivityService;
import com.example.IIS.service.FacultyService;
import com.example.IIS.service.FairService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/extraactivities")
public class ExtraActivityController {

    @Autowired
    private ExtraActivityService extraActivityService;

    public ExtraActivityController(ExtraActivityService extraActivityService) {
        this.extraActivityService = extraActivityService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> createExtraActivity(@RequestBody ExtraActivityDto extraActivityDto){
        extraActivityService.createExtraActivity(extraActivityDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/extraactivity")
    public ResponseEntity<Void> applyForActivity(@RequestBody ExtraActivityDto dto){

        ExtraActivity extraActivity = extraActivityService.applyForActivity(dto);
        extraActivity.setCapacity(extraActivity.getCapacity()-1);
        if (extraActivity != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
