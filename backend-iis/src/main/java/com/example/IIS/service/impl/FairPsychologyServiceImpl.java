package com.example.IIS.service.impl;

import com.example.IIS.domain.Fair;
import com.example.IIS.domain.FairPsychology;
import com.example.IIS.dto.FairDto;
import com.example.IIS.dto.FairPsychologyDto;
import com.example.IIS.repository.FairPsychologyRepository;
import com.example.IIS.repository.FairRepository;
import com.example.IIS.service.FairPsychologyService;
import com.example.IIS.service.FairService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FairPsychologyServiceImpl implements FairPsychologyService {

    @Autowired
    FairPsychologyRepository fairPsychologyRepository;

    @Autowired
    private ModelMapper mapper;

    private FairPsychologyDto mapToDTO(FairPsychology fairPsychology){
        FairPsychologyDto fairPsychologyDto = mapper.map(fairPsychology, FairPsychologyDto.class);
        return fairPsychologyDto;
    }

    // convert DTO to entity
    private FairPsychology mapToEntity(FairPsychologyDto fairPsychologyDto){
        FairPsychology fairPsychology = mapper.map(fairPsychologyDto, FairPsychology.class);
        return fairPsychology;
    }

    @Override
    public FairPsychologyDto createFairPsychology(FairPsychologyDto fairPsychologyDto) {

        // convert DTO to entity
        FairPsychology fairPsychology = mapToEntity(fairPsychologyDto);
        FairPsychology newFairPsychology = fairPsychologyRepository.save(fairPsychology);

        // convert entity to DTO
        FairPsychologyDto fairPsychologyResponse = mapToDTO(newFairPsychology);
        return fairPsychologyResponse;
    }
}
