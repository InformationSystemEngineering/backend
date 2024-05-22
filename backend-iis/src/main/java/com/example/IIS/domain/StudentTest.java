package com.example.IIS.domain;

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
public class StudentTest
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name="internship_test_id")
    InternshipTest internshipTest;

    @Column(name="points")
    private int points;

    @Column(name="is_reviewed")
    private boolean isReviewed;
}
