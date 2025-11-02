package com.application.DokterFinder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.DokterFinder.Dto.LogInDto;
import com.application.DokterFinder.Dto.SignUpDto;
import com.application.DokterFinder.Dto.UserResponseDto; 
import com.application.DokterFinder.Service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;

	// ✅ Sign Up
	@PostMapping("/signup")
	public ResponseEntity<UserResponseDto> registerUser(@RequestBody SignUpDto request) {
		UserResponseDto user = userService.registerUser(request);
		return ResponseEntity.ok(user);
	}

	// ✅ Sign In
	@PostMapping("/signin")
	public ResponseEntity<UserResponseDto> loginUser(@RequestBody LogInDto request) {
		UserResponseDto user = userService.loginUser(request);
		return ResponseEntity.ok(user);
	}
}
