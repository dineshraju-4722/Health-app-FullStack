package com.application.DokterFinder.Repositories;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.DokterFinder.Entities.DoctorAvailabilityEntity;


public interface DocterAvailabilityRepository extends JpaRepository<DoctorAvailabilityEntity, Integer>{
	

    List<DoctorAvailabilityEntity> findByDoctor_IdAndDate(int doctorId, LocalDate date);
    DoctorAvailabilityEntity findByDoctor_IdAndDateAndStartTime(int doctorId, LocalDate date,LocalTime time);
	
}
