package com.example.IIS.service;

import com.example.IIS.domain.InternshipTest;
import com.example.IIS.dto.InternshipTestDto;
import com.example.IIS.dto.StudentDto;

import java.util.List;

public interface InternshipTestService {

    InternshipTestDto FindByInternshipId(int internshipId);

    InternshipTest updateTest(InternshipTestDto dto);

    List<InternshipTestDto> GetAll();

    void doneReviewingTest(long id);
}
