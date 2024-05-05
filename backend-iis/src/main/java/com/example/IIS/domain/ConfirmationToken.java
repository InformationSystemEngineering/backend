package com.example.IIS.domain;

import com.example.IIS.dto.PsychologistDto;
import com.example.IIS.dto.StudentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Long tokenId;

    @Column(name ="confirmationToken")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
/*
    @OneToOne(targetEntity = Student.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "student_id")
    private Student student;
*/
    public ConfirmationToken(Student student) {
        this.createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

}
