package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InternshipTestDto {
    private Long id;
    private String internshipTitle;
    private LocalDate date;
    private HallDto hall;
    private int internshipId;
    private Long duration;
    private String time;
    private boolean testReviewed;
}
