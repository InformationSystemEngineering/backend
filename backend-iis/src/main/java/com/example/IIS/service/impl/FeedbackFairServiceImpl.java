package com.example.IIS.service.impl;

import com.example.IIS.domain.*;
import com.example.IIS.dto.FeedbackFairDto;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.StudentExtraActivityDto;
import com.example.IIS.dto.UserDTO;
import com.example.IIS.repository.ExtraActivityRepository;
import com.example.IIS.repository.FeedbackFairRepository;
import com.example.IIS.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackFairServiceImpl implements FeedbackFairService {
    @Autowired
    FeedbackFairRepository feedbackFairRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    StudentExtraActivityService studentExtraActivityService;

    @Autowired
    UserService userService;

    @Autowired
    ExtraActivityRepository extraActivityRepository;


    private FeedbackFair mapToEntity(FeedbackFairDto feedbackFairDto){
        FeedbackFair feedbackFair = mapper.map(feedbackFairDto, FeedbackFair.class);
        return feedbackFair;
    }

    private FeedbackFairDto mapToDTO(FeedbackFair feedbackFair){
        FeedbackFairDto feedbackFairDto= mapper.map(feedbackFair, FeedbackFairDto.class);
        return feedbackFairDto;
    }

    @Override
    public FeedbackFairDto createFeedback(FeedbackFairDto feedbackFairDto) {
        feedbackFairDto.setFinalGrade((double) (feedbackFairDto.getOrganizationGrade() + feedbackFairDto.getContentGrade() + feedbackFairDto.getPsychologistGrade()) /4);
        feedbackFairRepository.save(mapToEntity(feedbackFairDto));

        return feedbackFairDto;
    }

//    @Override
//    public WorkshopEvaluationDto getEvaluationByWorkshop(long workshopId) {
//        WorkshopEvaluationDto workshopEvaluationDto=new WorkshopEvaluationDto();
//
//        workshopEvaluationDto.setWorkshopName(workshopService.getWorkshopNameByWorkshopId(workshopId));
//        workshopEvaluationDto.setTotalNumberOfParticipants((int) registeredUserService.getUsersByWorkshopId(workshopId).stream().count());
//        workshopEvaluationDto.setFemaleParticipation((int) registeredUserService.getFemalesByWorkshopId(workshopId).stream().count());
//        workshopEvaluationDto.setMaleParticipation((int) registeredUserService.getMalesByWorkshopId(workshopId).stream().count());
//        workshopEvaluationDto.setGradeByFemale(getGradeByFemales(workshopId));
//        workshopEvaluationDto.setGradeByMale(getGradeByMale(workshopId));
//        workshopEvaluationDto.setFinalGrade(getFinalGrade(workshopId));
//        workshopEvaluationDto.setTotalNumberOfFeedback(getAllByWorkshopId(workshopId).size());
//        workshopEvaluationDto.setTotalOrgGrade(getTotalOrganizationGrade(workshopId));
//        workshopEvaluationDto.setTotalContentGrade(getTotalContentGrade(workshopId));
//        workshopEvaluationDto.setTotalPriceGrade(getTotalPriceGrade(workshopId));
//        workshopEvaluationDto.setTotalPsychologicalGrade(getTotalPsychologistGrade(workshopId));
//        workshopEvaluationDto.setNumberRecommended(getNumberOfRecommended(workshopId));
//        workshopEvaluationDto.setNumberNotRecommended(getAllByWorkshopId(workshopId).size()-getNumberOfRecommended(workshopId));
//
//
//        return  workshopEvaluationDto;
//    }
//
//    @Override
//    public double getGradeByFemales(long workshopId) {
//        List<RegisteredUserDto> users=registeredUserService.getFemalesByWorkshopId(workshopId);
//
//        double finalGrade=0;
//
//        for(FeedbackWorkshopDto feedbackWorkshopDto:getAllByWorkshopId(workshopId))
//        {
//            for(RegisteredUserDto registeredUserDto:users)
//            {
//                if (feedbackWorkshopDto.getRegisteredUserId()==registeredUserDto.getId())
//                {
//                    finalGrade+=feedbackWorkshopDto.getFinalGrade();
//                }
//            }
//        }
//        if (finalGrade!=0)
//            return finalGrade/ (long) users.size() ;
//        else
//            return 0;
//
//    }
//
//    @Override
//    public double getGradeByMale(long workshopId) {
//        List<RegisteredUserDto> users=registeredUserService.getMalesByWorkshopId(workshopId);
//
//        double finalGrade=0;
//
//        for(FeedbackWorkshopDto feedbackWorkshopDto:getAllByWorkshopId(workshopId))
//        {
//            for(RegisteredUserDto registeredUserDto:users)
//            {
//                if (feedbackWorkshopDto.getRegisteredUserId()==registeredUserDto.getId())
//                {
//                    finalGrade+=feedbackWorkshopDto.getFinalGrade();
//                }
//            }
//        }
//        if (finalGrade!=0)
//            return finalGrade/ (long) users.size() ;
//        else
//            return 0;
//    }

    @Override
    public List<FeedbackFairDto> getAllByExtraActivityId(Long extraActivityId) {
        // Fetching all feedback entries for a specific workshop ID
        List<FeedbackFair> fairs = feedbackFairRepository.findAllByExtraActivityId(extraActivityId);
        List<FeedbackFairDto> fairDtos = new ArrayList<>();

        // Mapping each FeedbackWorkshop to FeedbackWorkshopDto
        for (FeedbackFair fair : fairs) {
            FeedbackFairDto feedbackFairDto = mapToDTO(fair);
            fairDtos.add(feedbackFairDto);
        }
        return fairDtos;
    }


    @Override
    public double getFinalGrade(long extraActivityId) {
        List<UserDTO> users = userService.getUsersByExtraActivityId(extraActivityId);

        double finalGrade=0;

        for(FeedbackFairDto feedbackFairDto:getAllByExtraActivityId(extraActivityId))
        {
            for(UserDTO userDTO:users)
            {
                    finalGrade+=feedbackFairDto.getFinalGrade();
            }
        }
        return finalGrade;
    }

    @Override
    public double getTotalContentGrade(long extraActivityId) {
        double totalCount=0;
        List<FeedbackFairDto> feedbackFairDtos=getAllByExtraActivityId(extraActivityId);

        for(FeedbackFairDto feedbackFairDto:feedbackFairDtos)
        {
            totalCount+=feedbackFairDto.getContentGrade();
        }
        return totalCount/feedbackFairDtos.size();
    }

    @Override
    public double getTotalOrganizationGrade(long extraActivityId) {
        double totalCount=0;
        List<FeedbackFairDto> feedbackFairDtos=getAllByExtraActivityId(extraActivityId);

        for(FeedbackFairDto feedbackFairDto:feedbackFairDtos)
        {
            totalCount+=feedbackFairDto.getOrganizationGrade();
        }
        return totalCount/feedbackFairDtos.size();    }


    @Override
    public double getTotalPsychologistGrade(long extraActivityId) {
        double totalCount=0;
        List<FeedbackFairDto> feedbackFairDtos=getAllByExtraActivityId(extraActivityId);

        for(FeedbackFairDto feedbackFairDto:feedbackFairDtos)
        {
            totalCount+=feedbackFairDto.getPsychologistGrade();
        }
        return totalCount/feedbackFairDtos.size();    }

    @Override
    public int getNumberOfRecommended(long extraActivityId) {
        int totalCount=7;
        List<FeedbackFairDto> feedbackFairDtos=getAllByExtraActivityId(extraActivityId);

        for(FeedbackFairDto feedbackFairDto:feedbackFairDtos)
        {
            /*if(feedbackFairDto.isRecommended())
            {
                totalCount+=1;
            }*/
        }
        return totalCount;
    }

    @Override
    public List<FeedbackFairDto> getAll() {
        List<ExtraActivity> extraActivities = extraActivityRepository.findAll();
        List<FeedbackFairDto> feedbackFairDtos = new ArrayList<>();
        for (ExtraActivity actavity: extraActivities) {
            FeedbackFairDto dto = new FeedbackFairDto();
            dto.setName(actavity.getName());
            dto.setFinalGrade(getFinalGrade(actavity.getId()));
            dto.setFairPsychologyFairName(actavity.getFairPsychology().getFair().getName());
            dto.setContentGrade(getTotalContentGrade(actavity.getId()));
            dto.setOrganizationGrade(getTotalOrganizationGrade(actavity.getId()));
            dto.setPsychologistGrade(getTotalPsychologistGrade(actavity.getId()));
//            dto.setIsRecommended(getNumberOfRecommended(actavity.getId()));
            feedbackFairDtos.add(dto);
        }
        return  feedbackFairDtos;
    }
}
