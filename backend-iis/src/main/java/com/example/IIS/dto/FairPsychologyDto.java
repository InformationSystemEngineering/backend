package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FairPsychologyDto {
    private Long id;
    private Long psychologistId;
    private Long fairId;
}
