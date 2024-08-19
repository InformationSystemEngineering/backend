package com.example.IIS.repository;

import com.example.IIS.domain.Faculty;
import com.example.IIS.domain.Fair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FairRepository extends JpaRepository<Fair, Long> {

    Optional<Fair> findByRequestId(long requestId);


}
