package com.masai.models;

import java.util.List;

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
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeId;
    private String routeFrom;
    private String routeTo;
    private int distance;
    private List<Bus> buses;
}
