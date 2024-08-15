package com.example.IIS.domain;

import com.example.IIS.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;
    private Long description;
    private Status status;

    @JoinColumn(name = "faculty_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Faculty faculty;

    @OneToMany(mappedBy = "request", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Classroom> classrooms = new HashSet<Classroom>();

    @OneToOne(mappedBy = "request")
    private Fair fair;
}
