package com.example.IIS.service.impl;

import com.example.IIS.domain.Psychologist;
import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.repository.PsychologistRepo;
import com.example.IIS.repository.WorkshopRepo;
import com.example.IIS.service.PsychologistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PsychologistServiceImpl implements PsychologistService {
    @Autowired
    private PsychologistRepo psychologistRepo;

    @Autowired
    private ModelMapper mapper;

    private PsychologistDto mapToDTO(Psychologist psychologist){
        PsychologistDto psychologistDto = mapper.map(psychologist, PsychologistDto.class);
        return psychologistDto;
    }

    // convert DTO to entity
    private Psychologist mapToEntity(PsychologistDto psychologistDto){
        Psychologist psychologist = mapper.map(psychologistDto, Psychologist.class);
        return psychologist;
    }

    @Override
    public PsychologistDto createPsych(PsychologistDto psychologistDto) {

        Psychologist psychologist=mapToEntity(psychologistDto);
        Psychologist newPsychologist=psychologistRepo.save(psychologist);


        PsychologistDto PsyhologistResponse = mapToDTO(newPsychologist);
        return PsyhologistResponse;    }

    @Override
    public List<PsychologistDto> getPsychologistsForFair(Long fairId) {
        List<Psychologist> psychologists = psychologistRepo.findByFairId(fairId); // Pretraga psihologa na osnovu fairId
        return psychologists.stream().map(this::mapToDTO).collect(Collectors.toList()); // Mapiranje psihologa na DTO objekte
    }



    public List<PsychologistDto> getAllPsychologists() {
        List<Psychologist> psychologists = psychologistRepo.findAll();
        return psychologists.stream().map(psychologist -> new PsychologistDto(
                psychologist.getId(),
                psychologist.getName(),
                psychologist.getLastName(),
                psychologist.getBiography(),
                psychologist.getImageUrl()
        )).collect(Collectors.toList());
    }
}
