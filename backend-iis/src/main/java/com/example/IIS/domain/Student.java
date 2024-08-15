package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "student")
    private Set<StudentTest> studentTests;

    @OneToMany(mappedBy = "student")
    private Set<StudentInternship> studentInternships;

    private String facultyName;

    @OneToMany(mappedBy = "student", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Application> applications = new HashSet<Application>();

}
