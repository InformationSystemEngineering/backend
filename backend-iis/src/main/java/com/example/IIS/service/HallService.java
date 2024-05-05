package com.example.IIS.service;

import com.example.IIS.domain.Hall;
import com.example.IIS.domain.HallReservation;
import com.example.IIS.dto.HallDto;

import java.util.List;

public interface HallService {
    List<HallDto> getAllHalls();
    List<HallDto> getAll();

    void addNewReservation(HallReservation reservation, Long id);

    Hall getById(Long id);
}
