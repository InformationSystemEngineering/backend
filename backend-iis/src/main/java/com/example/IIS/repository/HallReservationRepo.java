package com.example.IIS.repository;
import com.example.IIS.domain.HallReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallReservationRepo extends JpaRepository<HallReservation, Long> {
}