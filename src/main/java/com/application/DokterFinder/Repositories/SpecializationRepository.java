package com.application.DokterFinder.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.DokterFinder.Entities.SpecializationEntity;

public interface SpecializationRepository extends JpaRepository<SpecializationEntity, Integer>{

}
