package com.application.DokterFinder.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.DokterFinder.Entities.DocterEntity;

public interface DocterRepository extends JpaRepository<DocterEntity, Integer>{
	List<DocterEntity> findBySpecialization_Name(String specializationName);
	DocterEntity findByEmail(String email);
}
