package com.example.IIS.repository;

import com.example.IIS.domain.ExtraActivity;
import com.example.IIS.domain.Faculty;
import com.example.IIS.domain.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExtraActivityRepository extends JpaRepository<ExtraActivity, Long> {

    @Query("SELECT p FROM ExtraActivity p WHERE p.fairPsychology.fair.id = :fairId")
    List<ExtraActivity> findByFairId(Long fairId);
}
