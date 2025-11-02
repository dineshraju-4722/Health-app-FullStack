package com.application.DokterFinder.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.application.DokterFinder.Entities.RatingEntity;


public interface RatingRepository extends JpaRepository<RatingEntity, Integer>{
	
  RatingEntity	findByDoctor_IdAndUser_Id(int did,int uid);
	
}
