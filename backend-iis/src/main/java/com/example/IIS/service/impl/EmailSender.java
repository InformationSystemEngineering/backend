package com.example.IIS.service.impl;
import com.example.IIS.domain.ConfirmationToken;
import com.example.IIS.domain.Student;
import com.example.IIS.dto.InternshipTestDto;
import com.example.IIS.dto.StudentDto;
import com.example.IIS.repository.TokenRepo;
import com.example.IIS.service.StudentService;
import com.example.IIS.service.StudentTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentTestService studentTestService;
    @Autowired
    private Environment env;
    @Autowired
    private TokenRepo _tokenRepository;

    @Autowired
    private ModelMapper mapper;

    @Async
    public void sendEmail(InternshipTestDto dto) throws MailException {
        List<StudentDto> students = studentTestService.getStudentsByInternshipTest(dto.getId());
        List<SimpleMailMessage> emails = new ArrayList<>();

        for (StudentDto studentDto: students) {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(studentDto.getEmail());
            mail.setFrom(env.getProperty("spring.mail.username"));
            mail.setSubject("Complete Registration!");
            mail.setText("To confirm your attendance at: " + dto.getTime() + ":00h ,please click here: " + "http://localhost:8080/auth/confirm-account?token=" + generateToken(studentDto));
            emails.add(mail);
        }
        SimpleMailMessage[] mailArray = emails.toArray(new SimpleMailMessage[0]);

        javaMailSender.send(mailArray);
    }


    private String generateToken(StudentDto studentDto){
        Student student = mapper.map(studentDto, Student.class);
        ConfirmationToken confirmationToken = new ConfirmationToken(student);
        _tokenRepository.save(confirmationToken);
        return confirmationToken.getConfirmationToken();
    }

}


