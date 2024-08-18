package com.example.IIS.service;

import com.example.IIS.domain.Fair;
import com.example.IIS.dto.*;

import java.util.List;

public interface FairService {
    List<FairDto> getAllFairs();

    FairDto createFair(FairDto fairDto);


    Fair publishFair(FairDto dto);

    List<FairDto> getAllFairsByRequestId(long requestId);

    FairDto getFairByRequestId(long requestId);
}
