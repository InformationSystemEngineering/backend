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
public class FairDto {
    private Long id;
    private Date approvedStartDate;
    private Date approvedEndDate;
    private boolean isPublish;
}
