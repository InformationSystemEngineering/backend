package com.example.IIS.service.impl;

import com.example.IIS.domain.*;
import com.example.IIS.dto.*;
import com.example.IIS.repository.FacultyRepository;
import com.example.IIS.repository.FairRepository;
import com.example.IIS.repository.PsychologistRepo;
import com.example.IIS.service.FairService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FairServiceImpl implements FairService {
    @Autowired
    FairRepository fairRepository;

    @Autowired
    PsychologistRepo psychologistRepository;

    @Autowired
    private ModelMapper mapper;

    private FairDto mapToDTO(Fair fair){
        FairDto fairDto = mapper.map(fair, FairDto.class);
        return fairDto;
    }

    // convert DTO to entity
    private Fair mapToEntity(FairDto fairDto){
        Fair fair = mapper.map(fairDto, Fair.class);
        return fair;
    }

    @Override
    public List<FairDto> getAllFairs() {
        List<Fair> fairs=fairRepository.findAll();
        FairDto fairDto=new FairDto();
        List<FairDto> fairDtos =new ArrayList<FairDto>();

        for (Fair fair : fairs) {
            fairDto=mapToDTO(fair);
            fairDtos.add(fairDto);

        }
        return fairDtos;
    }

    @Override
    public FairDto createFair(FairDto fairDto) {

        // convert DTO to entity
        Fair fair = mapToEntity(fairDto);
        Fair newFair = fairRepository.save(fair);

        // convert entity to DTO
        FairDto fairResponse = mapToDTO(newFair);
        return fairResponse;
    }


    @Override
    public Fair publishFair(FairDto dto) {
        // Pronađite postojeći Fair objekat koji želite da ažurirate
        Fair existingFair = fairRepository.findById(dto.getId()).orElseThrow(() -> new EntityNotFoundException("Fair not found"));

        // Postavite nove vrednosti na osnovu informacija iz FairDto objekta
        existingFair.setPublish(true); // Ovo možete promeniti u skladu sa logikom aplikacije

        // Vratite ažurirani Fair objekat
        return fairRepository.save(existingFair);
    }

    @Override
    public List<FairDto> getAllFairsByRequestId(long requestId) {
        List<Fair> fairs=fairRepository.findAll();
        FairDto fairDto=new FairDto();
        List<FairDto> fairDtos =new ArrayList<FairDto>();

        for (Fair fair : fairs) {
            if(fair.getRequest().getId() == requestId){
                fairDto=mapToDTO(fair);
                fairDtos.add(fairDto);
            }
        }
        return fairDtos;
    }
}
