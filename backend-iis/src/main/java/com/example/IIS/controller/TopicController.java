package com.example.IIS.controller;

import com.example.IIS.domain.Topic;
import com.example.IIS.domain.TopicCreationRequest;
import com.example.IIS.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
