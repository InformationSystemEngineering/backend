package com.example.IIS.repository;

import com.example.IIS.domain.FairPsychology;
import com.example.IIS.domain.StudentExtraActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentExtraActivityRepository extends JpaRepository<StudentExtraActivity, Long> {
}
