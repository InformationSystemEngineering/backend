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
public class Psychologist  extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String biography;

    @OneToMany(mappedBy = "psychologist", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Workshop> workshops = new HashSet<Workshop>();

    @OneToMany(mappedBy = "psychologist")
    private Set<StudentInternship> studentInternships;

    @OneToMany(mappedBy = "psychologist", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Topic> topics = new HashSet<Topic>();
}
