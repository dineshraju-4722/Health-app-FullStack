package com.application.DokterFinder.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.DokterFinder.Dto.LogInDto;
import com.application.DokterFinder.Dto.SignUpDto;
import com.application.DokterFinder.Dto.UserResponseDto;
import com.application.DokterFinder.Entities.UserEntity;
import com.application.DokterFinder.Repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	public UserResponseDto loginUser(LogInDto request) {
		UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(),user.getRole());
	}

	public UserResponseDto registerUser(SignUpDto request) {
		if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // ⚠️ In real apps, hash this!
        user.setRole(request.getRole());

        UserEntity savedUser = userRepository.save(user);
         UserResponseDto userResponseDto = new UserResponseDto();
         userResponseDto.setEmail(savedUser.getEmail());
         userResponseDto.setId(savedUser.getId());
         userResponseDto.setName(savedUser.getName());
         userResponseDto.setRole(savedUser.getRole());
       return userResponseDto;
	}

}
