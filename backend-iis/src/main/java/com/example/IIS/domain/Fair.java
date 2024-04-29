package com.example.IIS.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Date date;

    private Time startTime;

    private Time endTime;


    @JoinColumn(name = "faculty_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Faculty faculty;

    @OneToMany(mappedBy = "fair", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FairPsychology> fairPsychologies = new HashSet<FairPsychology>();
}
