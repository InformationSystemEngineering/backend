package com.example.IIS.service;

import com.example.IIS.domain.Reservation;

import java.sql.Time;

public interface ReservationService {
    Reservation createReservation(Time startTime, Time endTime, Long classroomId);
}
