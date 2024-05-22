package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HallReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Long duration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="internship_test_id", referencedColumnName = "id" )
    private InternshipTest internshipTest;

    @ManyToOne
    @JoinColumn(name="hall_id")
    private Hall hall;

}
