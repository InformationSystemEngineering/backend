package com.example.IIS.service.impl;

import com.example.IIS.domain.*;
import com.example.IIS.dto.InternshipDto;
import com.example.IIS.dto.InternshipTestDto;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.repository.InternshipTestRepo;
import com.example.IIS.service.HallReservationService;
import com.example.IIS.service.HallService;
import com.example.IIS.service.InternshipTestService;
import com.example.IIS.service.StudentTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class InternshipTestServiceImpl implements InternshipTestService {

    @Autowired
    private InternshipTestRepo internshipTestRepo;

    @Autowired
    private HallReservationService hallReservationService;

    @Autowired
    private HallService hallService;

    @Autowired
    private ModelMapper mapper;


    private InternshipTestDto mapToDTO(InternshipTest internshipTest){
        InternshipTestDto internshipTestDto = mapper.map(internshipTest, InternshipTestDto.class);
        return internshipTestDto;
    }

    private InternshipTest mapToEntity(InternshipTestDto internshiptestDto){
        InternshipTest internshipTest = mapper.map(internshiptestDto, InternshipTest.class);
        return internshipTest;
    }

    @Override
    public InternshipTestDto FindByInternshipId(int internshipId) {
        return mapToDTO(internshipTestRepo.findInternshipTestByInternship_Id(internshipId));
    }

    @Override
    public InternshipTest updateTest(InternshipTestDto dto) {
        if(hallReservationService.isHallFree(dto)){

            InternshipTest internshipTest = internshipTestRepo.findInternshipTestByInternship_Id(dto.getInternshipId());
            internshipTest.setTime(LocalTime.of(parseInt(dto.getTime()), 0, 0));
            internshipTestRepo.save(internshipTest);

            HallReservation reservation = new HallReservation();
            reservation.setDate(dto.getDate());
            reservation.setDuration(dto.getDuration());
            reservation.setTime(LocalTime.of(parseInt(dto.getTime()), 0, 0));
            reservation.setHall(hallService.getById(dto.getHall().getId()));
            reservation.setInternshipTest(internshipTest);
            hallReservationService.create(reservation);

            return internshipTest;
        }
        return null;
    }

    @Override
    public List<InternshipTestDto> GetAll() {
        List<InternshipTest> tests = internshipTestRepo.findAll();
        List<InternshipTestDto> dtos = new ArrayList<>();
        for (InternshipTest test: tests) {
            dtos.add(mapToDTO(test));
        }
        return  dtos;
    }

    @Override
    public void doneReviewingTest(long id) {
        InternshipTest test = internshipTestRepo.findById(id).orElse(null);
        if(test != null){
            test.setTestReviewed(true);
            internshipTestRepo.save(test);
        }
    }
}
