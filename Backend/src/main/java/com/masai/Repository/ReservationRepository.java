package com.masai.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Reservation;
import com.masai.models.ReservationStatus;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>,PagingAndSortingRepository<Reservation, Integer> {
    Page<Reservation> findAll(Pageable pageable);
    List<Reservation> findAllByOrderByReservationDateDesc(Pageable pageable);
    

    @Query("Select bus from Bus bus where bus.busType = ?1 ")
    List<Reservation> getReservationByBusType(String bus);
    
    
    ////////////////////
//    
// // Method to retrieve a reservation by ID
//    Reservation findById(int reservationId);
//    
// // Method to update a reservation
//    Reservation save(Reservation reservation);
//    
// // Method to delete a reservation by ID
//    void deleteById(int reservationId);
//    
// // Get all reservations for a specific user:
//    List<Reservation> findAllByUserUserId(int userId);
//    
////    Get all reservations for a specific bus:
//    List<Reservation> findAllByBusBusId(int busId);
//
//    
//    // Get all reservations within a date range:
//    List<Reservation> findAllByReservationDateBetween(LocalDate startDate, LocalDate endDate);
//
////    Get the count of reservations for a specific user:
//    int countByUserUserId(int userId);
//
//    
////    Get the available seats for a specific bus:
//    int countByBusBusIdAndReservationStatus(int busId, ReservationStatus reservationStatus);

    
}
