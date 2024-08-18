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
public class RequestDetailDto {
    private RequestDto request;
    private FairDto fair;  // 1:1 veza, samo jedan Fair
    private FacultyDto faculty;
    private List<ClassroomDto> classrooms;
}
