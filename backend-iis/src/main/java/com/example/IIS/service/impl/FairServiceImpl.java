package com.example.IIS.service.impl;

import com.example.IIS.domain.Faculty;
import com.example.IIS.domain.Fair;
import com.example.IIS.dto.FacultyDto;
import com.example.IIS.dto.FairDto;
import com.example.IIS.repository.FacultyRepository;
import com.example.IIS.repository.FairRepository;
import com.example.IIS.service.FairService;
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
}
