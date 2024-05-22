package com.example.IIS.service.impl;

import com.example.IIS.domain.HallReservation;
import com.example.IIS.dto.InternshipTestDto;
import com.example.IIS.repository.HallReservationRepo;
import com.example.IIS.service.HallReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@Service
public class HallReservationServiceImpl implements HallReservationService {

    @Autowired
    private HallReservationRepo hallReservationRepo;
    @Override
    public boolean isHallFree(InternshipTestDto dto) {
        List<HallReservation> reservations = hallReservationRepo.findAll();
        for (HallReservation res: reservations) {
            if (Objects.equals(res.getHall().getId(), dto.getHall().getId()) && res.getDate().equals(dto.getDate())){
                LocalTime dtoTime = LocalTime.of(parseInt(dto.getTime()), 0, 0);
                if(dtoTime.plusHours(dto.getDuration()).isBefore(res.getTime()) || dtoTime.isAfter(res.getTime().plusHours(res.getDuration()))){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void create(HallReservation reservation) {
        hallReservationRepo.save(reservation);
    }
}
