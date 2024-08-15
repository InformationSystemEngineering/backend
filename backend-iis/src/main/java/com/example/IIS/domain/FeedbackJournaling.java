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
public class FeedbackJournaling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long contentGrade;
    private Long psychologistGrade;
    private Long organizationGrade;
    private String comment;
    private double finalGrade;
    private double contentGrades;
    private double organizationGrades;
    private double psychologistGrades;
    private long average_count;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFilled;

    private String operationType;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
