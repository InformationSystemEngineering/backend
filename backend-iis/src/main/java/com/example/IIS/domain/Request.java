package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long daysNum;
    private Date startDate;
    private Date endDate;
    private Long capacity;

    @JoinColumn(name = "faculty_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Faculty faculty;

}
