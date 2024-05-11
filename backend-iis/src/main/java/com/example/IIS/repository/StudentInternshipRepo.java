package com.example.IIS.repository;
import com.example.IIS.domain.StudentInternship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInternshipRepo extends JpaRepository<StudentInternship, Long> {
}