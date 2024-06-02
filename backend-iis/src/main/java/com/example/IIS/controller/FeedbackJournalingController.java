package com.example.IIS.controller;

import com.example.IIS.dto.FeedbackJournalingDto;
import com.example.IIS.service.FeedbackJournalingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedbacksJournaling")
public class FeedbackJournalingController {
    @Autowired
    FeedbackJournalingService feedbackJournalingService;

    @GetMapping(value="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeedbackJournalingDto> getJournalById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(feedbackJournalingService.getById(id));
    }

}
