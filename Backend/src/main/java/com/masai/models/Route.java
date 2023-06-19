package com.masai.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="route_id")
    private int routeId;
    
    @NotBlank(message="Please add the source")
    @Column(name="route_from")
    private String routeFrom;
    
    @NotBlank(message="Please add the destination")
    @Column(name="route_to")
    private String routeTo;
    
    @NotNull(message = "Distance cannot be null")
    @Column(name="distance")
    private int distance;

    // One route can have multiple buses
//    @JsonIgnore
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL) // "route" refers to the 'route' property in the Bus class
    private List<Bus> buses;

}
