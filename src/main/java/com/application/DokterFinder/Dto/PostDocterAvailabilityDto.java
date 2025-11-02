package com.application.DokterFinder.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDocterAvailabilityDto {
	private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int maxAppointments;
    private int bookedAppointments;

    private int doctorId;
}
