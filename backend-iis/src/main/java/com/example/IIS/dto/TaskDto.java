package com.example.IIS.dto;

import com.example.IIS.domain.StudentInternship;
import com.example.IIS.domain.enums.StudentInternshipPriority;
import com.example.IIS.domain.enums.StudentInternshipStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    public String title;

    public String description;

    public String status;

    public String priority;

    public Long studentInternshipId;
}
