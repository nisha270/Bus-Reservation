package com.masai.models;

import java.time.LocalDate;

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
public class feedBack {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackId;
    private Integer driverRating;
    private Integer serviceRating;
    private Integer overallRating;
    private String comments;
    private LocalDate feedbackDate;
    
    private User users;
    
    private Bus bus;
}
