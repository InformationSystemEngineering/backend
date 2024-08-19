package com.example.IIS.service.impl;

import com.example.IIS.domain.Fair;
import com.example.IIS.domain.Topic;
import com.example.IIS.repository.FairRepository;
import com.example.IIS.repository.TopicRepository;
import com.example.IIS.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private FairRepository fairRepository;

    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(Long requestId, String name, Long duration, Long availableSpots) {
        // Pronađi fair na osnovu requestId
        Fair fair = fairRepository.findByRequestId(requestId)
                .orElseThrow(() -> new RuntimeException("Fair not found for request id: " + requestId));

        // Kreiraj novi Topic
        Topic topic = new Topic();
        topic.setName(name);
        topic.setDuration(duration);
        topic.setAvailableSpots(availableSpots);
        topic.setFair(fair);

        // Sačuvaj Topic u bazi
        return topicRepository.save(topic);
    }
}
