package com.example.IIS.service.impl;

import com.example.IIS.domain.FeedbackJournaling;
import com.example.IIS.dto.FeedbackJournalingDto;
import com.example.IIS.repository.FeedbackJournalingRepository;
import com.example.IIS.service.FeedbackJournalingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackJournalingServiceImpl implements FeedbackJournalingService {
    @Autowired
    FeedbackJournalingRepository feedbackJournalingRepository;

    @Autowired
    ModelMapper mapper;

    private FeedbackJournalingDto mapToDTO(FeedbackJournaling feedbackJournaling){
        FeedbackJournalingDto feedbackJournalingDto = mapper.map(feedbackJournaling, FeedbackJournalingDto.class);
        return feedbackJournalingDto;
    }

    // convert DTO to entity
    private FeedbackJournaling mapToEntity(FeedbackJournalingDto feedbackJournalingDto){
        FeedbackJournaling feedbackJournaling = mapper.map(feedbackJournalingDto, FeedbackJournaling.class);
        return feedbackJournaling;
    }

    @Override
    public FeedbackJournalingDto getById(long id) {
        return mapToDTO(feedbackJournalingRepository.findAll().getLast());
    }
}
