package com.example.IIS.service.impl;

import com.example.IIS.domain.FairPsychology;
import com.example.IIS.domain.StudentExtraActivity;
import com.example.IIS.dto.FairPsychologyDto;
import com.example.IIS.dto.StudentExtraActivityDto;
import com.example.IIS.repository.FairPsychologyRepository;
import com.example.IIS.repository.StudentExtraActivityRepository;
import com.example.IIS.service.FairPsychologyService;
import com.example.IIS.service.StudentExtraActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentExtraActivityServiceImpl implements StudentExtraActivityService {
    @Autowired
    StudentExtraActivityRepository studentExtraActivityRepository;

    @Autowired
    private ModelMapper mapper;

    private StudentExtraActivityDto mapToDTO(StudentExtraActivity studentExtraActivity){
        StudentExtraActivityDto studentExtraActivityDto = mapper.map(studentExtraActivity, StudentExtraActivityDto.class);
        return studentExtraActivityDto;
    }

    // convert DTO to entity
    private StudentExtraActivity mapToEntity(StudentExtraActivityDto studentExtraActivityDto){
        StudentExtraActivity studentExtraActivity = mapper.map(studentExtraActivityDto, StudentExtraActivity.class);
        return studentExtraActivity;
    }

    @Override
    public StudentExtraActivityDto createStudentExtraActivity(StudentExtraActivityDto studentExtraActivityDto) {

        // convert DTO to entity
        StudentExtraActivity studentExtraActivity = mapToEntity(studentExtraActivityDto);
        StudentExtraActivity newStudentExtraActitivty = studentExtraActivityRepository.save(studentExtraActivity);

        // convert entity to DTO
        StudentExtraActivityDto studentExtraActivityResponse = mapToDTO(newStudentExtraActitivty);
        return studentExtraActivityResponse;
    }
}
