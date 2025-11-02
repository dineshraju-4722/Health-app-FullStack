package com.application.DokterFinder.Dto;

import java.time.LocalDateTime;
import java.util.List;

import com.application.DokterFinder.Dto.GetDoctersDto.AppointmentInfo;
import com.application.DokterFinder.Dto.GetDoctersDto.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetHospitalsDto {

	private int id;
	private String name;
	private String location;
	private List<DocterDTO> docters;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class DocterDTO {
		private int id;
		private String name;
		private String experience;
		private SpecializationDTO specialization;
		private List<AppointmentInfo> appointments;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SpecializationDTO {
		private int id;
		private String name;
	}
	
	@Data
	public static class AppointmentInfo {
		private int id;
		private LocalDateTime appointmentDate;
		private UserInfo user;
	}
	@Data
	public static class UserInfo{
		private int id;
		private String name;
	
	}
}
