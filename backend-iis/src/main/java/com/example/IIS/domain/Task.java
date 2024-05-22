package com.example.IIS.domain;

import com.example.IIS.domain.enums.StudentInternshipPriority;
import com.example.IIS.domain.enums.StudentInternshipStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_internship_id")
    private StudentInternship studentInternship;

    private String title;

    private String description;

    private StudentInternshipStatus status;

    private StudentInternshipPriority priority;
}
