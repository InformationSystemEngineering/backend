package com.example.IIS.repository;

import com.example.IIS.domain.Classroom;
import com.example.IIS.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
