package com.example.IIS.domain;

import com.example.IIS.domain.enums.InternshipCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "category", nullable = false)
    private InternshipCategory category;

    @OneToOne(mappedBy = "internship")
    private InternshipTest internshipTest;

    @OneToMany(mappedBy = "internship")
    private Set<StudentInternship> studentInternships;
}
