package com.example.IIS.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time startTime;
    private Time endTime;

    @JoinColumn(name = "classroom_id")
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference
    private Classroom classroom;

    @OneToOne(mappedBy = "reservation")
    private Topic topic;
}
