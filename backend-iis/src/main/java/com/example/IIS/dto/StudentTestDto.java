package com.example.IIS.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentTestDto {
    private Long id;
    private Long studentId;
    private String studentName;
    private String studentLastName;
    private String studentImageUrl;
    private int points;
    private boolean reviewed;
}
