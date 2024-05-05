package com.example.IIS.service.impl;
import com.example.IIS.domain.Student;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.dto.UserDTO;
import com.example.IIS.repository.RoleRepo;
import com.example.IIS.repository.StudentRepo;
import com.example.IIS.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private ModelMapper mapper;

    private StudentDto mapToDTO(Student student){
        StudentDto studentDto = mapper.map(student, StudentDto.class);
        return studentDto;
    }

    private Student mapToEntity(StudentDto studentDto){
        Student student = mapper.map(studentDto, Student.class);
        return student;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student=mapToEntity(studentDto);
        student.setRole(roleRepository.findByName("ROLE_STUDENT"));
        Student newStudent=studentRepo.save(student);

        StudentDto StudentResponse = mapToDTO(newStudent);
        return StudentResponse;
    }

    @Override
    public List<StudentDto> GetAll() {
        List<Student> students = studentRepo.findAll();
        List<StudentDto> dtos = new ArrayList<>();
        for (Student student: students) {
            dtos.add(mapToDTO(student));
        }
        return dtos;
    }
}
