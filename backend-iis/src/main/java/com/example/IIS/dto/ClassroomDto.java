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
public class ClassroomDto {
    private Long id;
    private String name;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Long floor;
    private Long capacity;
}
