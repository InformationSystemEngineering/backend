package com.example.IIS.service.impl;

import com.example.IIS.domain.Internship;
import com.example.IIS.domain.InternshipTest;
import com.example.IIS.domain.Student;
import com.example.IIS.dto.InternshipDto;
import com.example.IIS.dto.InternshipTestDto;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.repository.InternshipRepo;
import com.example.IIS.repository.InternshipTestRepo;
import com.example.IIS.service.InternshipService;
import com.example.IIS.service.InternshipTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InternshipServiceImpl implements InternshipService {

    @Autowired
    private InternshipRepo internshipRepo;

    @Autowired
    private ModelMapper mapper;


    private InternshipDto mapToDTO(Internship internship){
        InternshipDto internshipDto = mapper.map(internship, InternshipDto.class);
        return internshipDto;
    }

    private Internship mapToEntity(InternshipDto internshipDto){
        Internship internshipTest = mapper.map(internshipDto, Internship.class);
        return internshipTest;
    }

    @Override
    public List<InternshipDto> GetAll() {
        LocalDate currentDate = LocalDate.now();
        List<Internship> internships = internshipRepo.findFutureInternships(currentDate);
        List<InternshipDto> dtos = new ArrayList<>();
        for (Internship internship: internships) {
            dtos.add(mapToDTO(internship));
        }
        return dtos;
    }
}
