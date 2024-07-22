package com.example.IIS.service.impl;

import com.example.IIS.domain.Faculty;
import com.example.IIS.domain.Hall;
import com.example.IIS.domain.Post;
import com.example.IIS.dto.FacultyDto;
import com.example.IIS.dto.HallDto;
import com.example.IIS.dto.PostDto;
import com.example.IIS.repository.FacultyRepository;
import com.example.IIS.repository.HallRepo;
import com.example.IIS.service.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    private ModelMapper mapper;

    private FacultyDto mapToDTO(Faculty faculty){
        FacultyDto facultyDto = mapper.map(faculty, FacultyDto.class);
        return facultyDto;
    }

    // convert DTO to entity
    private Faculty mapToEntity(FacultyDto facultyDto){
        Faculty faculty = mapper.map(facultyDto, Faculty.class);
        return faculty;
    }

    @Override
    public List<FacultyDto> getAllFaculties() {
        List<Faculty> faculties=facultyRepository.findAll();
        FacultyDto facultyDto=new FacultyDto();
        List<FacultyDto> facultyDtos =new ArrayList<FacultyDto>();

        for (Faculty faculty : faculties) {
            facultyDto=mapToDTO(faculty);
            facultyDtos.add(facultyDto);

        }
        return facultyDtos;
    }

    @Override
    public FacultyDto getFacultyById(long id) {
        Faculty faculty = facultyRepository.findById(id).get();
        return mapToDTO(faculty);
    }
}
