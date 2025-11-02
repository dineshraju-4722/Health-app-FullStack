package com.application.DokterFinder.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.DokterFinder.Dto.GetDocterAvailabilityDto;
import com.application.DokterFinder.Dto.PostDocterAvailabilityDto;
import com.application.DokterFinder.Entities.DocterEntity;
import com.application.DokterFinder.Entities.DoctorAvailabilityEntity;
import com.application.DokterFinder.Repositories.DocterAvailabilityRepository;
import com.application.DokterFinder.Repositories.DocterRepository;


@Service
public class DocterAvailabilityService {

	@Autowired
	private DocterAvailabilityRepository darepo;

	@Autowired
	private DocterRepository drepo;

	@Autowired
	private ModelMapper modelmapper;

	public List<GetDocterAvailabilityDto> getBydate(LocalDate date, int id) {

		List<DoctorAvailabilityEntity> byDoctor_IdAndDate = darepo.findByDoctor_IdAndDate(id, date);
		List<GetDocterAvailabilityDto> list = byDoctor_IdAndDate.stream().map(ele -> {
			return modelmapper.map(ele, GetDocterAvailabilityDto.class);
		}).toList();
		return list;
	}
	
	public GetDocterAvailabilityDto getBydateAndTime(LocalDate date, int id,LocalTime time) {

		DoctorAvailabilityEntity byDoctor_IdAndDate = darepo.findByDoctor_IdAndDateAndStartTime(id, date,time);
		 GetDocterAvailabilityDto map = modelmapper.map(byDoctor_IdAndDate, GetDocterAvailabilityDto.class);
		return map;
	}

	public void postDoctorAvailabliity(PostDocterAvailabilityDto body) {
	    DocterEntity doctor = drepo.findById(body.getDoctorId())
	            .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + body.getDoctorId()));
		DoctorAvailabilityEntity newRow = new DoctorAvailabilityEntity();
		newRow.setDate(body.getDate());
		newRow.setStartTime(body.getStartTime());
		newRow.setEndTime(body.getEndTime());
		newRow.setMaxAppointments(body.getMaxAppointments());
		newRow.setBookedAppointments(body.getBookedAppointments());
		newRow.setDoctor(doctor);
		 darepo.save(newRow);
	}

	public void update(int id) {
		DoctorAvailabilityEntity orElse = darepo.findById(id).orElse(null);
		orElse.setBookedAppointments(orElse.getBookedAppointments()+1);
		darepo.save(orElse);
	}

}
