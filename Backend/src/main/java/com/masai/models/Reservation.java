package com.masai.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;
    
    @NotNull(message = "Reservation Status cannot be null")
    private ReservationStatus reservationStatus;
    
    @NotNull(message = "Reservation Type Should be AC/SL/GEN")
    private String reservationType;
  
    private String reservationDate;
    private String reservationTime;
    
    @NotNull(message = "Source must be there")
    private String source;
    
    @NotNull(message = "destination must be there")
    private String destination;

    // Each reservation is associated with one bus
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id") // Foreign key column in the Reservation table referencing the Bus table
    private Bus bus;

    // Each reservation is associated with one user
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // Foreign key column in the Reservation table referencing the User table
    private User user;

}
