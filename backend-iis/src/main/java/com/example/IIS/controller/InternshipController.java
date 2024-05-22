package com.example.IIS.controller;

import com.example.IIS.domain.InternshipTest;
import com.example.IIS.domain.Student;
import com.example.IIS.domain.StudentTest;
import com.example.IIS.dto.InternshipDto;
import com.example.IIS.dto.InternshipTestDto;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.dto.StudentTestDto;
import com.example.IIS.service.InternshipService;
import com.example.IIS.service.InternshipTestService;
import com.example.IIS.service.StudentTestService;
import com.example.IIS.service.impl.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {

    @Autowired
    private InternshipTestService testService;

    @Autowired
    private InternshipService internshipService;

    @Autowired
    private StudentTestService studentTestService;

    @Autowired
    private EmailSender emailSender;

    @GetMapping("/test/{id}")
    public ResponseEntity<InternshipTestDto> getInternshipTestByInternId(@PathVariable(name = "id") int id){
        InternshipTestDto internshipTestDto = testService.FindByInternshipId(id);
        return new ResponseEntity<>(internshipTestDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/test")
    public ResponseEntity<Void> updateTest(@RequestBody InternshipTestDto dto){

        InternshipTest test = testService.updateTest(dto);
        test.setTime(LocalTime.of(parseInt(dto.getTime()), 0, 0));
        if (test != null) {
            emailSender.sendEmail(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<InternshipDto>> getAll(){
        List<InternshipDto> internships = internshipService.GetAll();
        return new ResponseEntity<>(internships, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<List<InternshipTestDto>> getAllInternshipTests(){
        List<InternshipTestDto> tests = testService.GetAll();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<List<StudentDto>> getStudentsByInternshipTest(@PathVariable(name = "id") long id){
        List<StudentDto> students = studentTestService.getStudentsByInternshipTest(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student-test/by-internship-test-id/{id}")
    public ResponseEntity<List<StudentTestDto>> getStudentTestsByInternshipTest(@PathVariable(name = "id") long id){
        List<StudentTestDto> students = studentTestService.getStudentTestsByInternshipTest(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student-test/{id}")
    public ResponseEntity<StudentTest> getStudentTestByStudentId(@PathVariable(name = "id") long id){
        StudentTest studentTest = studentTestService.findByStudentId(id);
        return new ResponseEntity<>(studentTest, HttpStatus.OK);
    }
}
