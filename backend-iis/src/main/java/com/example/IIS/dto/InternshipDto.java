package com.example.IIS.dto;

import com.example.IIS.domain.enums.InternshipCategory;
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
public class InternshipDto {
    private Long id;
    private LocalDate date;
    private String title;
    private String imageUrl;
    private InternshipCategory category;
}
