package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TopicWithDetailsDto {
    private Long topicId;
    private String topicName;
    private Long availableSpots;
    private String classroomName;
    private Time startTime;
    private Time endTime;
    private String facultyName;  // New field
    private String requestName;


}

