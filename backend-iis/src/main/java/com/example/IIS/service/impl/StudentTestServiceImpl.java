package com.example.IIS.service.impl;

import com.example.IIS.domain.Student;
import com.example.IIS.domain.StudentTest;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.repository.StudentTestRepo;
import com.example.IIS.service.StudentTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentTestServiceImpl implements StudentTestService {

    @Autowired
    private StudentTestRepo studentTestRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public StudentTest findByStudentId(long id) {
        return studentTestRepo.findById(id).orElse(null);
    }

    private StudentDto mapToDTO(Student student){
        StudentDto studentDto = mapper.map(student, StudentDto.class);
        return studentDto;
    }

    @Override
    public List<StudentDto> getStudentsByInternshipTest(long id) {
        List<Student> students = studentTestRepo.findStudentsByInternshipTestId(id);
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student s: students) {
            studentDtos.add(mapToDTO(s));
        }
        return studentDtos;
    }
}
