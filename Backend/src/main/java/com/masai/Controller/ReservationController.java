package com.masai.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Services.ReservationService;
import com.masai.mail.EmailService;
import com.masai.mail.EmailService;
import com.masai.models.Reservation;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
    private ReservationService reservationService;
	
	@Autowired
	EmailService emailService;

//  <--- checking controller --->
	
	@GetMapping("/check")
	public String checkingController() {
		log.info("application is working properly");
		
		
		
		return "welcome to reservation controller";
	}


//  <--- Method to create a new reservation --->
	
    @PostMapping("/reservation")
    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        if (createdReservation != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Reservation created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create reservation");
        }
    }
    
    
//  <--- Method to retrieve a reservation by ID --->
    
    @GetMapping("/{reservationId}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int reservationId) {
        Optional<Reservation> reservation = reservationService.getReservationById(reservationId);
        if (reservation.isPresent()) {
            return ResponseEntity.ok(reservation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
//  <--- Method to update a reservation --->
    
    @PutMapping("/{reservationId}")
    public ResponseEntity<String> updateReservation(@PathVariable int reservationId, @RequestBody Reservation reservation) {
        reservation.setReservationId(reservationId); // Ensure the ID is set correctly
        Reservation updatedReservation = reservationService.updateReservation(reservation);
        if (updatedReservation != null) {
            return ResponseEntity.ok("Reservation updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update reservation");
        }
    }
    
    
//  <--- Method to delete a reservation by ID --->
    
    @DeleteMapping("/{reservationId}")
    public ResponseEntity<String> deleteReservation(@PathVariable int reservationId) {
        reservationService.deleteReservation(reservationId);
        return ResponseEntity.ok("Reservation deleted successfully");
    }

//  <--- Method to Get all reservations for a specific user: --->
    
    @GetMapping("/users/{userId}/reservations")
    public ResponseEntity<List<Reservation>> getAllReservationsForUser(@PathVariable int userId) {
        List<Reservation> reservations = reservationService.getAllReservationsForUser(userId);
        return ResponseEntity.ok(reservations);
    }
    
    
//  <--- Method to Get all reservations for a specific bus: --->

    @GetMapping("/buses/{busId}/reservations")
    public ResponseEntity<List<Reservation>> getAllReservationsForBus(@PathVariable int busId) {
        List<Reservation> reservations = reservationService.getAllReservationsForBus(busId);
        return ResponseEntity.ok(reservations);
    }

    
//  <--- Get all reservations within a date range: --->
    
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservationsWithinDateRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Reservation> reservations = reservationService.getReservationsWithinDateRange(startDate, endDate);
        return ResponseEntity.ok(reservations);
    }
    
    
//  <--- Method to Get the count of reservations for a specific user: --->
    
    @GetMapping("/users/{userId}/reservations/count")
    public ResponseEntity<Integer> getReservationCountForUser(@PathVariable int userId) {
        int count = reservationService.getReservationCountForUser(userId);
        return ResponseEntity.ok(count);
    }
    


//  <--- Method to Get the available seats for a specific bus: --->
    
    @GetMapping("/customer/{customerId}/orders")
    public List<Reservation> fetchUserReservationHistory(@PathVariable Integer userId) {
        return reservationService.fetchUserReservationHistory(userId);
    }
    
    
}
