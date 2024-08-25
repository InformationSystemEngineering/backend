package com.example.IIS.controller;

import com.example.IIS.domain.Reservation;
import com.example.IIS.domain.ReservationCreationRequest;
import com.example.IIS.dto.ReservationDto;
import com.example.IIS.service.RequestService;
import com.example.IIS.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable Long id) {
        Optional<ReservationDto> reservation = reservationService.getReservationById(id);
        return reservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
