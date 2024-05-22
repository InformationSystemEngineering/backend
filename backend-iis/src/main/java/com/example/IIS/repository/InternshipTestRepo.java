package com.example.IIS.repository;
import com.example.IIS.domain.InternshipTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipTestRepo extends JpaRepository<InternshipTest, Long> {
    InternshipTest findInternshipTestByInternship_Id(int intershipId);
}
