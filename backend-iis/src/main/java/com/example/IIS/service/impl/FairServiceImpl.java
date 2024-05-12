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
    public List<FairDto> getAllFairsWithPsychologist() {
        // Dobijanje svih sajmova koji imaju bar jednog psihologa vezanog za njih
        List<Fair> fairs = fairRepository.findAllFairsWithPsychologist();

        // Mapiranje dobijenih sajmova na DTO objekte
        List<FairDto> fairDtos = new ArrayList<>();

        for (Fair fair : fairs) {
            fairDtos.add(mapToDTO(fair));
        }

        return fairDtos;
    }


    @Override
    public Fair publishFair(FairDto dto) {
        // Pronađite postojeći Fair objekat koji želite da ažurirate
        Fair existingFair = fairRepository.findById(dto.getId()).orElseThrow(() -> new EntityNotFoundException("Fair not found"));

        // Postavite nove vrednosti na osnovu informacija iz FairDto objekta
        existingFair.setName(dto.getName());
        existingFair.setStartTime(dto.getStartTime());
        existingFair.setEndTime(dto.getEndTime());
        existingFair.setDescription(dto.getDescription());
        existingFair.setDate(dto.getDate());
        existingFair.setPublish(true); // Ovo možete promeniti u skladu sa logikom aplikacije

        // Vratite ažurirani Fair objekat
        return fairRepository.save(existingFair);
    }



    @Override
    public List<FairDto> getAllFairsWithPsychologistPublish() {
        // Dobijanje svih sajmova koji imaju bar jednog psihologa vezanog za njih
        List<Fair> fairs = fairRepository.findAllFairsWithPsychologist();
        List<Fair> publishFairs = new ArrayList<>();

        for (Fair fair : fairs) {
            if (fair.isPublish()) { // Proverite da li je publish polje postavljeno na true
                publishFairs.add(fair); // Dodajte fair u listu publishFairs
            }
        }

        // Mapiranje dobijenih sajmova na DTO objekte
        List<FairDto> fairDtos = new ArrayList<>();

        for (Fair fair : publishFairs) {
            fairDtos.add(mapToDTO(fair));
        }

        return fairDtos;
    }

}
