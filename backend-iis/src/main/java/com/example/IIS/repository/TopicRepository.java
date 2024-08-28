package com.example.IIS.repository;

import com.example.IIS.domain.Fair;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findByName(String name);
    Topic findByReservationId(Long reservationId);

    List<Topic>  findByFairRequestId(Long requestId);

    List<Topic> findByFairId(Long fairId);

    Topic findByPsychologistId(Long reservationId);

    List<Topic> findByPsychologist_Id(Long reservationId);



}
