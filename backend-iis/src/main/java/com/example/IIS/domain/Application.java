package com.example.IIS.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String studyYear;
    private String email;

    @JoinColumn(name = "topic_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Topic topic;

    @JoinColumn(name = "student_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Student student;
}
