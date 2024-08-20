package com.example.IIS.repository;

import com.example.IIS.domain.Request;
import com.example.IIS.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
