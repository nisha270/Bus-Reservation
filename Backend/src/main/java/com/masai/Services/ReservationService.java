package com.masai.Services;

import java.time.LocalDate;
import java.util.List;

import com.masai.models.Reservation;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    Reservation deleteReservation(int reservationId);
    Reservation viewReservation(int reservationId);
    List<Reservation> viewAllReservations();
    List<Reservation> getAllReservations(LocalDate date);
}
