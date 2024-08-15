package com.example.IIS.service.impl;

import com.example.IIS.domain.Student;
import com.example.IIS.domain.StudentTest;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.dto.StudentTestDto;
import com.example.IIS.repository.StudentTestRepo;
import com.example.IIS.service.InternshipTestService;
import com.example.IIS.service.StudentInternshipService;
import com.example.IIS.service.StudentTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentTestServiceImpl implements StudentTestService {

    @Autowired
    private StudentTestRepo studentTestRepo;

    @Autowired
    private InternshipTestService internshipTestService;

    @Autowired
    private StudentInternshipService studentInternshipService;

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

    private StudentTest mapToEntity(StudentTestDto studentTestDto){
        StudentTest studentTest = mapper.map(studentTestDto, StudentTest.class);
        return studentTest;
    }

    private StudentTestDto mapSTToDTO(StudentTest studentTest){
        StudentTestDto studentTestDto = mapper.map(studentTest, StudentTestDto.class);
        return studentTestDto;
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

    @Override
    public List<StudentTestDto> getStudentTestsByInternshipTest(long id) {
        List<StudentTest> studentTests = studentTestRepo.findStudentTestsByInternshipTest_Id(id);
        List<StudentTestDto> dtos = new ArrayList<>();
        for (StudentTest st: studentTests) {
            dtos.add(mapper.map(st, StudentTestDto.class));
        }
        return dtos;
    }

    @Override
    public void isInternshipTestReviewedMeanwhile(long id) {
        List<StudentTest> studentTests = studentTestRepo.findStudentTestsByInternshipTest_Id(id);
        boolean areThereUnreviewed = false;
        for (StudentTest st: studentTests) {
            if(!st.isReviewed()){
                areThereUnreviewed = true;
            }
        }
        if(!areThereUnreviewed){
            internshipTestService.doneReviewingTest(id);
        }
    }


    @Override
    public StudentTestDto updateStudentTest(StudentTestDto dto) {
        StudentTest studentTest = studentTestRepo.findById(dto.getId()).orElse(null);
        if(studentTest != null){
            studentTest.setPoints(dto.getPoints());
            studentTest.setReviewed(true);
            studentTestRepo.save(studentTest);
            this.isInternshipTestReviewedMeanwhile(studentTest.getInternshipTest().getId());
        }
        return  mapper.map(studentTest, StudentTestDto.class);
    }

    @Override
    public List<StudentTestDto> getBestStudents(long id) {
        List<StudentTestDto> tests = getStudentTestsByInternshipTest(id);
        Collections.sort(tests, Comparator.comparing(StudentTestDto::getPoints).reversed());

        int secondBestPoints = tests.size() >= 2 ? tests.get(1).getPoints() : Integer.MIN_VALUE;

        List<StudentTestDto> bestStudents = new ArrayList<>();
        List<StudentTest> studentTests = new ArrayList<>();
        if (!tests.isEmpty()) {
            bestStudents.add(tests.get(0));
        }

        for (int i = 1; i < tests.size(); i++) {
            if (tests.get(i).getPoints() == secondBestPoints) {
                bestStudents.add(tests.get(i));
            } else {
                break;
            }
        }
        for (StudentTestDto dto: bestStudents ) {
            studentTests.add(studentTestRepo.getById(dto.getId()));
        }
        studentInternshipService.create(studentTests);
        return bestStudents;
    }

    @Override
    public StudentTestDto createStudentTest(StudentTestDto studentTestDto) {

        // convert DTO to entity
        StudentTest studentTest = mapToEntity(studentTestDto);
        StudentTest newStudentTest = studentTestRepo.save(studentTest);

        // convert entity to DTO
        StudentTestDto studentTestResponse = mapSTToDTO(newStudentTest);
        return studentTestResponse;
    }

}
