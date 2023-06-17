package com.masai.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;
    private String reservationStatus;
    private String reservationType;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String source;
    private String destination;

    // Each reservation is associated with one bus
    @ManyToOne
    @JoinColumn(name = "bus_id") // Foreign key column in the Reservation table referencing the Bus table
    private Bus bus;

    // Each reservation is associated with one user
    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key column in the Reservation table referencing the User table
    private User user;

}
