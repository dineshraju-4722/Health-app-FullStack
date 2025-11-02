package com.application.DokterFinder.Repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.DokterFinder.Entities.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
