package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackFairDto {

    private Long id;
    private String name;
    private double contentGrade;
    private double psychologistGrade;
    private double finalGrade;
    private double organizationGrade;
//    private int isRecommended;
    private String comment;
    private Long extraActivityId;
    private Long userId;
    private String fairPsychologyFairName;
}
