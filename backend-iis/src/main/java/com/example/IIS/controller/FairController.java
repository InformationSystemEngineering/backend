package com.example.IIS.controller;

import com.example.IIS.domain.ExtraActivity;
import com.example.IIS.domain.Fair;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.dto.*;
import com.example.IIS.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fairs")
public class FairController {
    @Autowired
    private FairService fairService;

    @Autowired
    private PsychologistService psychologistService;

    @Autowired
    private ExtraActivityService extraActivityService;

    public FairController(FairService fairService) {
        this.fairService = fairService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FairDto>> getAllFairs() {
        List<FairDto> allFairs = fairService.getAllFairs();
        return new ResponseEntity<>(allFairs, HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> createFair(@RequestBody FairDto fairDto){
        fairService.createFair(fairDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllFairsWithPsychologist")
    public ResponseEntity<List<FairDto>> getAllFairsWithPsychologist() {
        List<FairDto> allFairsWithPsychologist = fairService.getAllFairsWithPsychologist();
        return new ResponseEntity<>(allFairsWithPsychologist, HttpStatus.OK);
    }

    @GetMapping("/getAllFairsWithPsychologistPublish")
    public ResponseEntity<List<FairDto>> getAllFairsWithPsychologistPublish() {
        List<FairDto> allFairsWithPsychologist = fairService.getAllFairsWithPsychologistPublish();
        return new ResponseEntity<>(allFairsWithPsychologist, HttpStatus.OK);
    }

    @GetMapping("/{fairId}/psychologists")
    public ResponseEntity<List<PsychologistDto>> getPsychologistsForFair(@PathVariable Long fairId) {
        try {
            List<PsychologistDto> psychologists = psychologistService.getPsychologistsForFair(fairId);
            return new ResponseEntity<>(psychologists, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{fairId}/extraActivities")
    public ResponseEntity<List<ExtraActivityDto>> getExtraActivitiesForFair(@PathVariable Long fairId) {
        try {
            List<ExtraActivityDto> extraActivities = extraActivityService.getExtraActivitiesForFair(fairId);
            return new ResponseEntity<>(extraActivities, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @CrossOrigin
    @PutMapping("/fair")
    public ResponseEntity<Void> publishFair(@RequestBody FairDto dto){

        Fair fair = fairService.publishFair(dto);
        fair.setPublish(true);
        if (fair != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
