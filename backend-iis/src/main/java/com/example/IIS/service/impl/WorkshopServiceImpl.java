package com.example.IIS.service.impl;

import com.example.IIS.domain.Workshop;
import com.example.IIS.dto.WorkShopDto;
import com.example.IIS.repository.WorkshopRepo;
import com.example.IIS.service.WorkshopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkshopServiceImpl implements WorkshopService {
    @Autowired
private WorkshopRepo workshopRepo;
  

    @Autowired
    private ModelMapper mapper;


    @Override
    public WorkShopDto createWorkshop(WorkShopDto workShopDto) {

        Workshop workshop = mapToEntity(workShopDto);
        Workshop newWorkshop = workshopRepo.save(workshop);

        WorkShopDto WorkshopResponse = mapToDTO(newWorkshop);
        return WorkshopResponse;


    }

    private WorkShopDto mapToDTO(Workshop workshop){
        WorkShopDto workShopDto = mapper.map(workshop, WorkShopDto.class);
        return workShopDto;
    }

    // convert DTO to entity
    private Workshop mapToEntity(WorkShopDto workshopDto){
        Workshop workshop = mapper.map(workshopDto, Workshop.class);
        return workshop;
    }
    
}
