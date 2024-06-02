package com.example.IIS.repository;

import com.example.IIS.domain.FeedbackJournaling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackJournalingRepository extends JpaRepository<FeedbackJournaling, Long> {
}
