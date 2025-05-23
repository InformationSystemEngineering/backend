package com.example.IIS.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
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
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean activeContract;
    private String photo;
    private String email;

    @OneToMany(mappedBy = "faculty", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Request> requests = new HashSet<Request>();
}
