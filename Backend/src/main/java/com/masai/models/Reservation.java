package com.masai.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationId;
    private String reservationStatus;
    private String reservationType;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String source;
    private String destination;
    private Bus bus;
}
