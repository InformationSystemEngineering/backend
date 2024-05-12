package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FairPsychology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "psychologist_id", referencedColumnName = "id")
    private Psychologist psychologist;

    @ManyToOne
    @JoinColumn(name = "fair_id", referencedColumnName = "id")
    private Fair fair;

    @OneToMany(mappedBy = "fairPsychology")
    private Set<ExtraActivity> extraActivitySet;

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Psychologist getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(Psychologist psychologist) {
        this.psychologist = psychologist;
    }

    public Fair getFair() {
        return fair;
    }

    public void setFair(Fair fair) {
        this.fair = fair;
    }

    public Set<ExtraActivity> getExtraActivitySet() {
        return extraActivitySet;
    }

    public void setExtraActivitySet(Set<ExtraActivity> extraActivitySet) {
        this.extraActivitySet = extraActivitySet;
    }
}

