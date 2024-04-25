package com.example.IIS.repository;

import com.example.IIS.domain.Hall;
import com.example.IIS.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepo extends JpaRepository<Hall, Long> {
}
