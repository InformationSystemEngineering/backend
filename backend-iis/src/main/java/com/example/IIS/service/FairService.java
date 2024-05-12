package com.example.IIS.service;

import com.example.IIS.domain.ExtraActivity;
import com.example.IIS.domain.Fair;
import com.example.IIS.domain.Psychologist;
import com.example.IIS.dto.*;

import java.util.List;

public interface FairService {
    List<FairDto> getAllFairs();

    FairDto createFair(FairDto fairDto);

    List<FairDto> getAllFairsWithPsychologist();

    Fair publishFair(FairDto dto);

    List<FairDto> getAllFairsWithPsychologistPublish();
}
