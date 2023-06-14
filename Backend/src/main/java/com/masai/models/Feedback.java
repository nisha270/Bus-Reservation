package com.masai.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feedbackId;
    private int driverRating;
    private int serviceRating;
    private int overallRating;
    private String comments;
    private LocalDate feedbackDate;

    // Each feedback is associated with one user
    @OneToOne
    @JoinColumn(name = "user_id") // Foreign key column in the Feedback table referencing the User table
    private User user;

    // Each feedback is associated with one bus
    @OneToOne
    @JoinColumn(name = "bus_id") // Foreign key column in the Feedback table referencing the Bus table
    private Bus bus;
}
