package com.masai.Services;

import java.time.LocalDate;
import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import com.masai.models.Reservation;

public interface ReservationService {
	
    Reservation save(Reservation reservation);
    
    public Reservation createReservation(Reservation reservation);

    public Optional<Reservation> getReservationById(int reservationId);

    public Reservation updateReservation(Reservation reservation);

    public void deleteReservation(int reservationId);
    
    public List<Reservation> getAllReservationsForUser(int userId);
    
    public List<Reservation> getAllReservationsForBus(int busId);


    public List<Reservation> getReservationsWithinDateRange(LocalDate startDate, LocalDate endDate);


    public int getReservationCountForUser(int userId);
    
    public int getAvailableSeatsForBus(int busId);


    
    
//    Reservation updateReservation(Reservation reservation);
//    Reservation deleteReservation(int reservationId);
//    Reservation viewAllReservation(int reservationId) throws NoReservationAvailableException;
//    List<Reservation> viewAllReservations();
//    List<Reservation> getAllReservations(LocalDate date);
}
