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
public class FairPsychology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "psychologist_id")
    Long psychologistId;

    @Column(name = "fair_id")
    Long fairId;

    @ManyToOne
    @MapsId("psychologistId")
    @JoinColumn(name = "psychologist_id")
    Psychologist psychologist;

    @ManyToOne
    @MapsId("fairId")
    @JoinColumn(name = "fair_id")
    Fair fair;

    @OneToMany(mappedBy = "fairPsychology")
    Set<ExtraActivity> extraActivitySet;

}
