package com.application.DokterFinder.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ratings")
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int ratingValue; 

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DocterEntity doctor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

