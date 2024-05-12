package com.example.IIS.service.impl;

import com.example.IIS.domain.ExtraActivity;
import com.example.IIS.domain.Fair;
import com.example.IIS.dto.ExtraActivityDto;
import com.example.IIS.dto.FairDto;
import com.example.IIS.repository.ExtraActivityRepository;
import com.example.IIS.repository.FairRepository;
import com.example.IIS.service.ExtraActivityService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtraActivityServiceImpl implements ExtraActivityService {
    @Autowired
    ExtraActivityRepository extraActivityRepository;

    @Autowired
    private ModelMapper mapper;

    private ExtraActivityDto mapToDTO(ExtraActivity extraActivity){
        ExtraActivityDto extraActivityDto = mapper.map(extraActivity, ExtraActivityDto.class);
        return extraActivityDto;
    }

    // convert DTO to entity
    private ExtraActivity mapToEntity(ExtraActivityDto extraActivityDto){
        ExtraActivity extraActivity = mapper.map(extraActivityDto, ExtraActivity.class);
        return extraActivity;
    }

    @Override
    public ExtraActivityDto createExtraActivity(ExtraActivityDto extraActivityDto) {


        // convert DTO to entity
        ExtraActivity extraActivity = mapToEntity(extraActivityDto);

        ExtraActivity newExtraActivity = extraActivityRepository.save(extraActivity);

        // convert entity to DTO
        ExtraActivityDto extraActivityResponse = mapToDTO(newExtraActivity);
        return extraActivityResponse;
    }

    @Override
    public List<ExtraActivityDto> getExtraActivitiesForFair(Long fairId) {
        List<ExtraActivity> extraActivities = extraActivityRepository.findByFairId(fairId); // Pretraga dodatnih aktivnosti na osnovu fairId
        return extraActivities.stream().map(this::mapToDTO).collect(Collectors.toList()); // Mapiranje dodatnih aktivnosti na DTO objekte
    }

    @Override
    public ExtraActivity applyForActivity(ExtraActivityDto dto) {
        // Pronađite postojeći Fair objekat koji želite da ažurirate
        ExtraActivity existingExtraActivity = extraActivityRepository.findById(dto.getId()).orElseThrow(() -> new EntityNotFoundException("ExtraActivity not found"));

        // Postavite nove vrednosti na osnovu informacija iz FairDto objekta
        existingExtraActivity.setName(dto.getName());
        existingExtraActivity.setStartTime(dto.getStartTime());
        existingExtraActivity.setEndTime(dto.getEndTime());
        existingExtraActivity.setDate(dto.getDate());
        existingExtraActivity.setActivityType(dto.getActivityType());
        existingExtraActivity.setClassroom(dto.getClassroom());
        existingExtraActivity.setCapacity(dto.getCapacity()-1);

        // Vratite ažurirani Fair objekat
        return extraActivityRepository.save(existingExtraActivity);
    }
}
