package com.example.IIS.repository;

import com.example.IIS.domain.Post;
import com.example.IIS.domain.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsychologistRepo extends JpaRepository<Psychologist, Long> {
}
