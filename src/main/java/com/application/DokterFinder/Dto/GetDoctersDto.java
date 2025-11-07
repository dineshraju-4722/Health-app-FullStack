package com.application.DokterFinder.Dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
public class GetDoctersDto {
	private int id;
	private String name;
	private String experience;
	private HospitalInfo hospital;
	private String email;
	private String imglink;
	private String contact;
	private String status;
	private SpecializationInfo specialization;
	private List<AppointmentInfo> appointments;
	private Double averageRating;
	private Integer userRating;

	@Data
	public static class HospitalInfo {
		private int id;
		private String name;
		private String location;
		private String email;
		private String contact;
	}

	@Data
	public static class SpecializationInfo {
		private int id;
		private String name;
	}

	@Data
	public static class AppointmentInfo {
		private int id;
		private LocalDateTime appointmentDate;
		private LocalTime appointmentTime;
		private UserInfo user;
	}

	@Data
	public static class UserInfo {
		private int id;
		private String name;
		private String email;
	}
}
