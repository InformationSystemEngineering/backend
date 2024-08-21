package com.example.IIS.controller;

import com.example.IIS.domain.Topic;
import com.example.IIS.domain.TopicCreationRequest;
import com.example.IIS.domain.UpdateReservationRequest;
import com.example.IIS.dto.TopicWithDetailsDto;
import com.example.IIS.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

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


}
