package com.application.DokterFinder.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentPostDto {

	 private int docter;
	 private int user;
	 private LocalTime appointmentTime;
	 private LocalDate appointmentDate;
}
