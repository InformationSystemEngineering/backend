package com.example.IIS.service;

import com.example.IIS.domain.HallReservation;
import com.example.IIS.dto.InternshipTestDto;

public interface HallReservationService {
    boolean isHallFree(InternshipTestDto dto);

    void create(HallReservation reservation);
}
