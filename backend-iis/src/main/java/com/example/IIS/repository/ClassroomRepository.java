package com.example.IIS.repository;

import com.example.IIS.domain.Classroom;
import com.example.IIS.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    @Query("SELECT c FROM Classroom c WHERE c.request.id = :requestId")
    List<Classroom> findClassroomsByRequestId(Long requestId);
}
