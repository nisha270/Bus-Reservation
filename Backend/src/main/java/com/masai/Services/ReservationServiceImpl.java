package com.masai.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.BusExceptions;
import com.masai.Exceptions.NoReservationAvailableException;
import com.masai.Exceptions.NoReservationFoundException;
import com.masai.Exceptions.NoUserFoundException;
import com.masai.Repository.BusRepository;
import com.masai.Repository.ReservationRepository;
import com.masai.Repository.UserRepository;
import com.masai.models.Reservation;
import com.masai.models.User;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	 ReservationRepository reservationRepository;
	
	@Autowired
	 BusRepository busRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Reservation save(Reservation reservation) throws BusExceptions {
		//logger
		if(reservation == null) throw new BusExceptions("Reservation is null");
		Optional<Reservation> res = reservationRepository.findById(reservation.getReservationId());
		if(res.isPresent()) throw new BusExceptions("Reservation has been done with resevation Id "+reservation.getReservationId());
		
		return reservationRepository.save(reservation);
	}

	
	@Override
	public Reservation createReservation(Reservation reservation) {
        
        return reservationRepository.save(reservation);
    }
	
	@Override
    public Optional<Reservation> getReservationById(int reservationId) {
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

	@Override
	public List<Reservation> getAllReservations(LocalDate date) throws NoReservationFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> viewAllReservations() throws NoReservationFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Reservation> fetchUserReservationHistory(Integer userId)
			throws NoReservationFoundException, NoUserFoundException {
//		Optional<Reservation> res = userRepository.findById(userId ) ;
//    	if(res.isEmpty()) throw new NoReservationAvailableException ("null value") ;
//    	if( res.get().getReservation().isEmpty()) throw new BusExceptions("Empty order list") ;
//    	return res.get().getReservation() ;
		return null;
	}

	




	
}
