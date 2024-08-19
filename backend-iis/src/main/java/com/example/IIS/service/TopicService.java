package com.example.IIS.service;

import com.example.IIS.domain.Topic;

public interface TopicService {
    Topic createTopic(Long requestId, String name, Long duration, Long availableSpots);
}
