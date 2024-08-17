package com.example.IIS.service.impl;

import com.example.IIS.domain.Classroom;
import com.example.IIS.domain.Faculty;
import com.example.IIS.domain.Fair;
import com.example.IIS.dto.ClassroomDto;
import com.example.IIS.dto.FacultyDto;
import com.example.IIS.dto.FairDto;
import com.example.IIS.repository.ClassroomRepository;
import com.example.IIS.repository.FacultyRepository;
import com.example.IIS.service.ClassroomService;
import com.example.IIS.service.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    private ModelMapper mapper;

    private ClassroomDto mapToDTO(Classroom classroom){
        ClassroomDto classroomDto = mapper.map(classroom, ClassroomDto.class);
        return classroomDto;
    }

    // convert DTO to entity
    private Classroom mapToEntity(ClassroomDto classroomDto){
        Classroom classroom = mapper.map(classroomDto, Classroom.class);
        return classroom;
    }

    @Override
    public List<ClassroomDto> getAllClassroomsByRequestId(long requestId) {
        List<Classroom> classrooms=classroomRepository.findAll();
        ClassroomDto classroomDto=new ClassroomDto();
        List<ClassroomDto> classroomDtos =new ArrayList<ClassroomDto>();

        for (Classroom classroom : classrooms) {
            if(classroom.getRequest().getId() == requestId){
                classroomDto=mapToDTO(classroom);
                classroomDtos.add(classroomDto);
            }
        }
        return classroomDtos;
    }
}
