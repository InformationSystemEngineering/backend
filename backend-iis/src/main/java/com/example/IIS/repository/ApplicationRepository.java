package com.example.IIS.repository;

import com.example.IIS.domain.Application;
import com.example.IIS.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Optional<Application> findByStudentIdAndTopicId(Long studentId, Long topicId);
    List<Application> findByStudentId(Long studentId);
}
