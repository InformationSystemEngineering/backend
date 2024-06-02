package com.example.IIS.service;

import com.example.IIS.dto.FeedbackFairDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FeedbackFairService {
    FeedbackFairDto createFeedback(FeedbackFairDto feedbackFairDto);
//    double getGradeByFemales(long workshopId);
//    double getGradeByMale(long workshopId) ;
    List<FeedbackFairDto> getAllByExtraActivityId(Long extraActivityId) ;
    double getFinalGrade(long extraActivityId);
    double getTotalContentGrade(long extraActivityId);
    double getTotalOrganizationGrade(long extraActivityId);
//    double getTotalPriceGrade(long extraActivityId);
    double getTotalPsychologistGrade(long extraActivityId);
    int getNumberOfRecommended(long extraActivityId);

    List<FeedbackFairDto> getAll();
}
