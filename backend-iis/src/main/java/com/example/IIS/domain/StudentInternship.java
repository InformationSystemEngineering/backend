package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentInternship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="psychologist_id")
    private Psychologist psychologist;

    @ManyToOne
    @JoinColumn(name="internship_id")
    private Internship internship;

    @OneToMany(mappedBy = "studentInternship")
    private Set<Task> tasks;

}
