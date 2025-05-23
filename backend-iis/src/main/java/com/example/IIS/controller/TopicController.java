package com.example.IIS.controller;

import com.example.IIS.domain.*;
import com.example.IIS.dto.MessageDto;
import com.example.IIS.dto.TopicDto;
import com.example.IIS.dto.TopicWithDetailsDto;
import com.example.IIS.repository.TopicRepository;
import com.example.IIS.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping("/create")
    public ResponseEntity<Topic> createTopic(@RequestBody TopicCreationRequest request) {
        Topic topic = topicService.createTopic(request.getRequestId(), request.getName(), request.getDuration(), request.getAvailableSpots());
        return ResponseEntity.ok(topic);
    }

    @PutMapping("/update-reservation")
    public ResponseEntity<Topic> updateTopicWithReservation(@RequestBody UpdateReservationRequest updateRequest) {
        Topic updatedTopic = topicService.updateTopicWithReservation(updateRequest.getTopicName(), updateRequest.getReservationId());
        return ResponseEntity.ok(updatedTopic);
    }

    @GetMapping("/topics-with-details/{requestId}")
    public ResponseEntity<List<TopicWithDetailsDto>> getTopicsWithDetails(@PathVariable Long requestId) {
        List<TopicWithDetailsDto> topicsWithDetails = topicService.getTopicsWithDetails(requestId);
        return ResponseEntity.ok(topicsWithDetails);
    }

    @PutMapping("/update-psychologist")
    public ResponseEntity<TopicDto> updateTopicWithPsychologist(@RequestBody UpdatePsychologistRequest updateRequest) {
        TopicDto updatedTopicDto = topicService.updateTopicWithPsychologist(updateRequest);
        return ResponseEntity.ok(updatedTopicDto);
    }

    @GetMapping("/topics-with-details-no-psychologist/{requestId}")
    public ResponseEntity<List<TopicWithDetailsDto>> getTopicsWithDetailsNoPsychologist(@PathVariable Long requestId) {
        List<TopicWithDetailsDto> topicsWithDetails = topicService.getTopicsWithDetailsNoPsychologist(requestId);
        return ResponseEntity.ok(topicsWithDetails);
    }

    @GetMapping("/psychologist")
    public List<TopicWithDetailsDto> getTopicsForPsychologist(@RequestParam Long psychologistId) {
        // Koristi servis za preuzimanje topic-a
        return topicService.getTopicsForPsychologist(psychologistId);
    }



}
