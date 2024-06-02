package com.example.IIS.repository;

import com.example.IIS.domain.FeedbackFair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackFairRepository extends JpaRepository<FeedbackFair, Long> {
    List<FeedbackFair> findAllByExtraActivityId(Long id);
}
