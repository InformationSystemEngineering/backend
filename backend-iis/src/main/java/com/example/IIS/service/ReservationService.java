package com.example.IIS.service;

import com.example.IIS.domain.Reservation;
import com.example.IIS.dto.ReservationDto;

import java.sql.Time;
import java.util.Optional;

public interface ReservationService {
    Reservation createReservation(Time startTime, Time endTime, Long classroomId);
    Optional<ReservationDto> getReservationById(Long reservationId);
}
