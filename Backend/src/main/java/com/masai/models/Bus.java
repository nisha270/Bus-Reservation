package com.masai.models;

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
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busId;
    private String busName;
    private String driverName;
    private String busType;
    private String routeFrom;
    private String routeTo;
    private int seats;
    private String arrivalTime;
    private String departureTime;
    private int availableSeats;
    // Many buses can belong to one route
    @ManyToOne
    @JoinColumn(name = "route_id") // Foreign key column in the Bus table referencing the Route table
    private Route route;

}

