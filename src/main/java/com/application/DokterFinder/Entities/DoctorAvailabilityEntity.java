package com.application.DokterFinder.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="doctor_availability")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorAvailabilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;
    
    @Column(nullable = false)
    private LocalTime startTime;         // e.g. 09:00
    @Column(nullable = false)
    private LocalTime endTime;   

    private int maxAppointments;   // e.g., 10 slots available for that day
    private int bookedAppointments = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private DocterEntity doctor;

    public boolean isAvailable() {
        return bookedAppointments < maxAppointments;
    }

}
