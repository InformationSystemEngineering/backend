package com.example.IIS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PsychologistWithTopicsDto {
    private Long psychologistId;
    private String psychologistName;
    private String psychologistLastName;
    private List<TopicWithDetailsDto> topics;


}
