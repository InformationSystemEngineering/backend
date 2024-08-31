package com.example.IIS.service;

import com.example.IIS.domain.Psychologist;
import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.dto.PsychologistWithTopicsDto;
import com.example.IIS.dto.RegisterDTO;
import com.example.IIS.dto.RegisteredUserDto;

import java.util.List;

public interface PsychologistService {
    PsychologistDto createPsych(PsychologistDto psychologistDto);

    List<PsychologistDto> getPsychologistsForFair(Long fairId);

    List<PsychologistDto> getAllPsychologists();
    List<PsychologistWithTopicsDto> getAllPsychologistsWithTopics();
    PsychologistDto getPsychologistByTopicId(Long topicId);
    List<PsychologistDto> getAllPsychologistsOrg();
    List<PsychologistDto> getAllPsychologistsNotOrg();
}
