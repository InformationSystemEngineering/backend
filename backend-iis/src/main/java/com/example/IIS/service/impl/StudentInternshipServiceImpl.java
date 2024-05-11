package com.example.IIS.service.impl;

import com.example.IIS.domain.StudentInternship;
import com.example.IIS.domain.StudentTest;
import com.example.IIS.repository.StudentInternshipRepo;
import com.example.IIS.service.StudentInternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInternshipServiceImpl implements StudentInternshipService {

    @Autowired
    private StudentInternshipRepo studentInternshipRepo;

    @Override
    public void create(List<StudentTest> studentTests) {
        for (StudentTest studentTest : studentTests) {
            StudentInternship studentInternship = new StudentInternship();
            studentInternship.setInternship(studentTest.getInternshipTest().getInternship());
            studentInternship.setStudent(studentTest.getStudent());
            studentInternshipRepo.save(studentInternship);
        }
    }
}
