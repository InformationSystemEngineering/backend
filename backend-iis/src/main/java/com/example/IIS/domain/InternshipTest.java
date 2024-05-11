package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InternshipTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="maxPoints")
    private int maxPoints;

    @Column(name="testReviewed")
    private boolean testReviewed;

    @Column(name="date")
    private LocalDate date;

    @Column(name="time")
    private LocalTime time;

    @OneToMany(mappedBy = "internshipTest")
    Set<StudentTest> studentTests;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="internship_id", referencedColumnName = "id" )
    private Internship internship;

    @OneToOne(mappedBy = "internshipTest")
    private HallReservation hallReservation;
}
