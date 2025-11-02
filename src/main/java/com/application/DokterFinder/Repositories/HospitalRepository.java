package com.application.DokterFinder.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.DokterFinder.Entities.HospitalEntity;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer>{

}
