package com.example.IIS.service;

import com.example.IIS.domain.ExtraActivity;
import com.example.IIS.domain.Fair;
import com.example.IIS.dto.ExtraActivityDto;
import com.example.IIS.dto.FairDto;

import java.util.List;

public interface ExtraActivityService {

    ExtraActivityDto createExtraActivity(ExtraActivityDto extraActivityDto);

    List<ExtraActivityDto> getExtraActivitiesForFair(Long fairId);

    ExtraActivity applyForActivity(ExtraActivityDto extraActivityDto);
}
