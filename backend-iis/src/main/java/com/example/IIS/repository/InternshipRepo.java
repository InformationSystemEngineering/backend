package com.example.IIS.repository;
import com.example.IIS.domain.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface InternshipRepo  extends JpaRepository<Internship, Long> {
    @Query("SELECT i from Internship i WHERE i.date > :currentDate")
    List<Internship> findFutureInternships(@Param("currentDate") LocalDate currentDate);
}