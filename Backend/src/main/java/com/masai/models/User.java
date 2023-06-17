package com.masai.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userLoginId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private long contact;
    private String email;

    // One user can have multiple reservations
    @OneToMany(mappedBy = "user") // "user" refers to the 'user' property in the Reservation class
    private List<Reservation> reservations;

}
