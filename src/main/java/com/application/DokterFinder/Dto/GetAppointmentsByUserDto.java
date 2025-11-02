package com.application.DokterFinder.Dto;


import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAppointmentsByUserDto {
	private int id;
    private LocalDate date;
    private LocalTime time;

    private String doctorName;
    private String specializationName;
    private String hospitalName;
}
