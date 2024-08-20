package com.example.IIS.controller;

import com.example.IIS.domain.Reservation;
import com.example.IIS.domain.ReservationCreationRequest;
import com.example.IIS.service.RequestService;
import com.example.IIS.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationCreationRequest req) {
        Reservation reservation = reservationService.createReservation(req.getStartTime(), req.getEndTime(), req.getClassroomId());
        return ResponseEntity.ok(reservation);
    }

}
