package com.example.IIS.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExtraActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String activityType;
    private Date date;
    private Time startTime;
    private Time endTime;

    @JoinColumn(name = "fair_psychology_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private FairPsychology fairPsychology;
}
