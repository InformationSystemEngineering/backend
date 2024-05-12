package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExtraActivityDto {
    private Long id;
    private String name;
    private String activityType;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Long fairPsychologyId;
    private String classroom;
    private Long capacity;
}
