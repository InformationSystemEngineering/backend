package com.example.IIS.repository;

import com.example.IIS.domain.Request;
import com.example.IIS.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByStatus(Status status);
}
