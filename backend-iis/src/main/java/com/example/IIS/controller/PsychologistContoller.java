package com.example.IIS.controller;

import com.example.IIS.domain.Psychologist;
import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.dto.PsychologistWithTopicsDto;
import com.example.IIS.repository.PsychologistRepo;
import com.example.IIS.service.PsychologistService;
import com.example.IIS.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/psychologists")
public class PsychologistContoller {

    @Autowired
    private PsychologistService psychologistService;

    @GetMapping("/psychologists")
    public ResponseEntity<List<PsychologistDto>> getAllPsychologists() {
        List<PsychologistDto> psychologists = psychologistService.getAllPsychologists();
        return ResponseEntity.ok(psychologists);
    }

    @GetMapping("/with-topics")
    public ResponseEntity<List<PsychologistWithTopicsDto>> getAllPsychologistsWithTopics() {
        List<PsychologistWithTopicsDto> psychologists = psychologistService.getAllPsychologistsWithTopics();
        return ResponseEntity.ok(psychologists);
    }

    @GetMapping("/{topicId}/psychologist")
    public PsychologistDto getPsychologistByTopicId(@PathVariable Long topicId) {
        return psychologistService.getPsychologistByTopicId(topicId);
    }

}
