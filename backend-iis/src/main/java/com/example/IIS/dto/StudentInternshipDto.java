package com.example.IIS.dto;

import com.example.IIS.domain.Internship;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.Student;
import com.example.IIS.domain.Task;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class StudentInternshipDto {
    private Long id;
    private Long studentId;
    private Long psychologistId;
    private Long studentInternshipId;
    private int studentInternshipPoints;
}
