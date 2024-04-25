package com.example.IIS.domain;

import com.example.IIS.domain.enums.WorkshopCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workshops")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Date date;

    private Time startTime;

    private Time endTime;

    private WorkshopCategory category;

    private boolean isOnline;

    private double price;

    @ElementCollection
    @CollectionTable(name = "workshop_images", joinColumns = @JoinColumn(name = "workshop_id"))
    @Column(name = "image")
    private List<String> images;

    @JoinColumn(name = "psychologist_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Psychologist psychologist;

    @ManyToMany(mappedBy = "workshops")
    private List<RegisteredUser> users;

    @JoinColumn(name = "hall_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Hall hall;

}
