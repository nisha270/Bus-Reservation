package com.masai.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.BusRepository;
import com.masai.Repository.ReservationRepository;
import com.masai.models.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	 ReservationRepository reservationRepository;
	
	@Autowired
	 BusRepository busRepository;

	@Override
	public Reservation save(Reservation reservation) {
		
		return reservationRepository.save(reservation);
	}
	
	@Override
	public Reservation createReservation(Reservation reservation) {
        
        return reservationRepository.save(reservation);
    }
	
	@Override
    public Optional<Reservation> getReservationById(int reservationId) {
//        return reservationRepository.findById(reservationId);
		return reservationRepository.findById(reservationId);
    }
	
	@Override
    public Reservation updateReservation(Reservation reservation) {
        
        return reservationRepository.save(reservation);
    }
	
	@Override
    public void deleteReservation(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }

//	@Override
//	public List<Reservation> getAllReservationsForUser(int userId) {
//		return  reservationRepository.findAllById(userId); //findAllByUserUserId(userId);
//	}
//	
//	@Override
//	public List<Reservation> getAllReservationsForBus(int busId) {
//	    return reservationRepository.findAllByBusBusId(busId);
//	}
//
//	
//	@Override
//	public List<Reservation> getReservationsWithinDateRange(LocalDate startDate, LocalDate endDate) {
//	    return reservationRepository.findAllByReservationDateBetween(startDate, endDate);
//	}
//	
//	@Override
//	public int getReservationCountForUser(int userId) {
//	    return reservationRepository.countByUserUserId(userId);
//	}

	@Override
	public int getAvailableSeatsForBus(int busId) {
//		int totalSeats = busRepository.findById(busId).getSeats();  //need to crete getSeats metod in busReository
//	    int reservedSeats = reservationRepository.countByBusBusIdAndReservationStatus(busId, ReservationStatus.CONFIRMED);
//	    return totalSeats - reservedSeats;
		return 0;
	}

	@Override
	public List<Reservation> getAllReservationsForUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getAllReservationsForBus(int busId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservationsWithinDateRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getReservationCountForUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}




	
}
