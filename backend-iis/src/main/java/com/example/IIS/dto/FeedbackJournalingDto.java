package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackJournalingDto {
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
    private Date dateFilled;
    private String operationType;
}
