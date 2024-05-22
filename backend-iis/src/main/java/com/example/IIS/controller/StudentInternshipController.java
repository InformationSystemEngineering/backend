package com.example.IIS.controller;

import com.example.IIS.dto.RegisterDTO;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.dto.StudentInternshipDto;
import com.example.IIS.dto.TaskDto;
import com.example.IIS.service.StudentInternshipService;
import com.example.IIS.service.StudentTestService;
import com.example.IIS.service.TaskService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping("/api/student-internships")
public class StudentInternshipController {

    @Autowired
    private StudentInternshipService _studentInternshipService;

    @Autowired
    private TaskService _taskService;

    @GetMapping("/by-student/{id}")
    public ResponseEntity<StudentInternshipDto> getByStudent(@PathVariable(name = "id") long id){
        StudentInternshipDto dto = _studentInternshipService.GetByStudent(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-psychologist/{id}")
    public ResponseEntity<StudentInternshipDto> getByPsychologist(@PathVariable(name = "id") long id){
        StudentInternshipDto dto = _studentInternshipService.GetByPsychologist(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping
    @PermitAll
    public ResponseEntity<Void> createTask(@RequestBody TaskDto taskDto){
        _taskService.createTask(taskDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/upload-pdf")
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
        }

        try {
            byte[] bytes = file.getBytes();
            File dir = new File("uploads/");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
            try (FileOutputStream fos = new FileOutputStream(serverFile)) {
                fos.write(bytes);
            }

            String fileDownloadUri = "/uploads/" + file.getOriginalFilename();
            return ResponseEntity.ok(fileDownloadUri);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
