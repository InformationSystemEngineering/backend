package com.example.IIS.repository;

import com.example.IIS.domain.Post;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.dto.PsychologistDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PsychologistRepo extends JpaRepository<Psychologist, Long> {
    @Query("SELECT p FROM Psychologist p WHERE p.id = :fairId")
    List<Psychologist> findByFairId(Long fairId);

    @Query("SELECT p FROM Topic t JOIN t.psychologist p WHERE t.id = :topicId")
    Psychologist findPsychologistByTopicId(@Param("topicId") Long topicId);

}

