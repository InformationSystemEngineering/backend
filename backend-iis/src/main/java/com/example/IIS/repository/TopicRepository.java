package com.example.IIS.repository;

import com.example.IIS.domain.Fair;
import com.example.IIS.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
