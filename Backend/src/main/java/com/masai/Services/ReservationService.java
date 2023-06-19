package com.masai.Services;

import java.time.LocalDate;
import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import com.masai.Exceptions.BusExceptions;
import com.masai.Exceptions.NoReservationFoundException;
import com.masai.Exceptions.NoSeatAvailableException;
import com.masai.Exceptions.NoUserFoundException;
import com.masai.models.Reservation;

public interface ReservationService {
	
    public Reservation save(Reservation reservation) throws BusExceptions;

    public Reservation createReservation(Reservation reservation);

    public Optional<Reservation> getReservationById(int reservationId) throws NoReservationFoundException;

    public Reservation updateReservation(Reservation reservation) throws NoReservationFoundException;

    public void deleteReservation(int reservationId) throws NoReservationFoundException;
    
    public List<Reservation> getAllReservationsForUser(int userId) throws NoReservationFoundException;
    
    public List<Reservation> getAllReservationsForBus(int busId) throws NoReservationFoundException;

    public List<Reservation> getReservationsWithinDateRange(LocalDate startDate, LocalDate endDate) throws NoReservationFoundException;

    public int getReservationCountForUser(int userId) throws NoReservationFoundException;
    
    public int getAvailableSeatsForBus(int busId) throws NoSeatAvailableException;

    public List<Reservation> getAllReservations(LocalDate date) throws NoReservationFoundException;
    
    public List<Reservation> viewAllReservations() throws NoReservationFoundException;

	public List<Reservation> fetchUserReservationHistory(Integer userId) throws NoReservationFoundException, NoUserFoundException;

    
}
