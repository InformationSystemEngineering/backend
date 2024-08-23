package com.example.IIS.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long duration;
    private Long availableSpots;

    @JoinColumn(name = "fair_id")
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private Fair fair;

    @JoinColumn(name = "psychologist_id")
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference
    private Psychologist psychologist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;

    @OneToMany(mappedBy = "topic", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Application> applications = new HashSet<Application>();
}
