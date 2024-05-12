package com.example.IIS.repository;

import com.example.IIS.domain.Post;
import com.example.IIS.domain.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PsychologistRepo extends JpaRepository<Psychologist, Long> {
    @Query("SELECT p FROM Psychologist p WHERE p.id = :fairId")
    List<Psychologist> findByFairId(Long fairId);

}

