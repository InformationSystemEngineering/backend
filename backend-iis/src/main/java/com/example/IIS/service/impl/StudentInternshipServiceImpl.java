package com.example.IIS.service.impl;

import com.example.IIS.domain.InternshipTest;
import com.example.IIS.domain.StudentInternship;
import com.example.IIS.domain.StudentTest;
import com.example.IIS.dto.InternshipTestDto;
import com.example.IIS.dto.StudentInternshipDto;
import com.example.IIS.repository.StudentInternshipRepo;
import com.example.IIS.service.StudentInternshipService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInternshipServiceImpl implements StudentInternshipService {

    @Autowired
    private StudentInternshipRepo studentInternshipRepo;

    @Autowired
    private ModelMapper mapper;

    private StudentInternshipDto mapToDTO(StudentInternship studentInternship){
        StudentInternshipDto dto = mapper.map(studentInternship, StudentInternshipDto.class);
        return dto;
    }

    private StudentInternship mapToEntity(StudentInternshipDto dto){
        StudentInternship studentInternship = mapper.map(dto, StudentInternship.class);
        return studentInternship;
    }


    @Override
    public void create(List<StudentTest> studentTests) {
        for (StudentTest studentTest : studentTests) {
            StudentInternship studentInternship = new StudentInternship();
            studentInternship.setInternship(studentTest.getInternshipTest().getInternship());
            studentInternship.setStudent(studentTest.getStudent());
            studentInternshipRepo.save(studentInternship);
        }
    }

    @Override
    public StudentInternshipDto GetByStudent(long id) {
        StudentInternship studentInternship = studentInternshipRepo.getStudentInternshipByStudent_Id(id);
        if(studentInternship != null){
            return mapToDTO(studentInternship);
        }
        return null;
    }

    @Override
    public StudentInternshipDto GetByPsychologist(long id) {
        StudentInternship studentInternship = studentInternshipRepo.getStudentInternshipByPsychologist_Id(id);
        if (studentInternship != null){
            return mapToDTO(studentInternship);
        }
        return null;
    }
}
