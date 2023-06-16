package com.masai.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bus")
public class Bus {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busId;
    
    @Column(name="bus_name")
    @NotBlank(message="Bus name is required")
    private String busName;
    
    @Column(name="driver_name")
    @NotBlank(message="driver name is required")
    private String driverName;
    
    @Column(name="bus_type")
    @NotBlank(message="bus type is required")
    private String busType;
    
//    @Column(name="route_from")
//    @NotBlank(message="")
//    private String routeFrom;
//    
//    @Column(name="route_to")
//    private String routeTo;
    
    @NotNull(message="Please mention number of seats")
    @Column(name="seats")
    private int seats;
    
    @Column(name="arrival_time")
    private String arrivalTime;
    
    @Column(name="departure_time")
    private String departureTime;
    
    @Column(name="available_seats")
    private int availableSeats;
    // Many buses can belong to one route
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "route_id") // Foreign key column in the Bus table referencing the Route table
    private Route route;

    
}

