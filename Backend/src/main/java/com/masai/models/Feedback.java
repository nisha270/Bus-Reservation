package com.masai.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
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
    private Integer feedbackId;
    @NotNull(message="Driver rating can not be null")
    private Integer driverRating;
    @NotNull(message="Service rating can not be null")
    private Integer serviceRating;
    @NotNull(message="Overall rating can not be null")
    private Integer overallRating;
    @NotNull(message="Comments can not be null")
    private String comments;
    private String feedbackDate;

    // Each feedback is associated with one user
    @OneToOne
    @JoinColumn(name = "user_id") // Foreign key column in the Feedback table referencing the User table
    private User user;

    // Each feedback is associated with one bus
    @OneToOne
    @JoinColumn(name = "bus_id") // Foreign key column in the Feedback table referencing the Bus table
    private Bus bus;
}
