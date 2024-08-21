package com.example.IIS.service.impl;

import com.example.IIS.domain.Classroom;
import com.example.IIS.domain.Fair;
import com.example.IIS.domain.Reservation;
import com.example.IIS.domain.Topic;
import com.example.IIS.dto.TopicWithDetailsDto;
import com.example.IIS.repository.FairRepository;
import com.example.IIS.repository.ReservationRepository;
import com.example.IIS.repository.TopicRepository;
import com.example.IIS.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private FairRepository fairRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ReservationRepository reservationRepository;

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

    public Topic updateTopicWithReservation(String topicName, Long reservationId) {
        Topic topic = topicRepository.findByName(topicName);
        if (topic != null) {
            // Proveri da li je rezervacija već povezana sa nekom temom
            Topic existingTopicWithReservation = topicRepository.findByReservationId(reservationId);
            if (existingTopicWithReservation != null) {
                throw new RuntimeException("This reservation is already assigned to another topic: " + existingTopicWithReservation.getName());
            }

            // Pronađi rezervaciju prema ID-u
            Reservation reservation = reservationRepository.findById(reservationId)
                    .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + reservationId));

            // Poveži rezervaciju sa temom
            topic.setReservation(reservation);
            topicRepository.save(topic);
        }
        return topic;
    }

    public List<TopicWithDetailsDto> getTopicsWithDetails(Long requestId) {
        // Pronađi Fair na osnovu requestId
        Fair fair = fairRepository.findByRequestId(requestId)
                .orElseThrow(() -> new RuntimeException("Fair not found for request id: " + requestId));

        // Pronađi sve Topic entitete povezane sa ovim Fair
        List<Topic> topics = topicRepository.findByFairId(fair.getId());

        return topics.stream().map(topic -> {
            Reservation reservation = topic.getReservation();
            Classroom classroom = reservation != null ? reservation.getClassroom() : null;
            return new TopicWithDetailsDto(
                    topic.getName() != null ? topic.getName() : "No Name",
                    classroom != null ? classroom.getName() : "No Classroom",
                    reservation != null ? reservation.getStartTime() : null,
                    reservation != null ? reservation.getEndTime() : null
            );
        }).collect(Collectors.toList());
    }







}
