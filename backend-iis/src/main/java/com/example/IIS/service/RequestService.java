package com.example.IIS.service;

import com.example.IIS.dto.FacultyDto;
import com.example.IIS.dto.RequestDto;
import com.example.IIS.dto.WorkShopDto;

import java.util.List;

public interface RequestService {
    RequestDto createRequest(RequestDto requestDto);

    List<RequestDto> getAllAcceptedRequest();
}
