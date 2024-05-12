package com.example.IIS.repository;

import com.example.IIS.domain.Faculty;
import com.example.IIS.domain.Fair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FairRepository extends JpaRepository<Fair, Long> {

    @Query("SELECT f FROM Fair f INNER JOIN f.fairPsychologies fp WHERE fp IS NOT NULL")
    List<Fair> findAllFairsWithPsychologist();
}
