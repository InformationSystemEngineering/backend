package com.example.IIS.service;

import com.example.IIS.domain.Topic;
import com.example.IIS.dto.TopicWithDetailsDto;

import java.util.List;

public interface TopicService {
    Topic createTopic(Long requestId, String name, Long duration, Long availableSpots);
    Topic updateTopicWithReservation(String topicName, Long reservationId);

    List<TopicWithDetailsDto> getTopicsWithDetails(Long requestId);
}
