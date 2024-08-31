package com.example.IIS.dto;

import com.example.IIS.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String description;
    private Status status;
    private Long facultyId;
    private FacultyDto facultyDto;
    private Long userId;
    private Long numberOfDays;
    private Date sentDate;
}
