package com.example.IIS.service.impl;

import com.example.IIS.domain.Classroom;
import com.example.IIS.domain.Reservation;
import com.example.IIS.repository.ClassroomRepository;
import com.example.IIS.repository.ReservationRepository;
import com.example.IIS.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Time startTime, Time endTime, Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));

        Reservation reservation = new Reservation();
        reservation.setStartTime(startTime);
        reservation.setEndTime(endTime);
        reservation.setClassroom(classroom);

        return reservationRepository.save(reservation);
    }

}
