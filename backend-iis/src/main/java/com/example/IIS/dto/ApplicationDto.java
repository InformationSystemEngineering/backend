package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private Long studentId;
    private Long topicId;
    private String name;
    private String surname;
    private String studyYear;
    private String email;

}

