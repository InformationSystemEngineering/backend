package com.example.IIS.repository;

import com.example.IIS.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByTopicIdAndPsychologistId(Long topicId, Long psychologistId);
}
