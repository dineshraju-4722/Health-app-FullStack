package com.application.DokterFinder.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.DokterFinder.Dto.DocterPostDto;
import com.application.DokterFinder.Dto.GetDocterAvailabilityDto;
import com.application.DokterFinder.Dto.GetDoctersDto;
import com.application.DokterFinder.Dto.PostDocterAvailabilityDto;
import com.application.DokterFinder.Entities.DocterEntity;
import com.application.DokterFinder.Entities.DoctorAvailabilityEntity;
import com.application.DokterFinder.Service.DocterAvailabilityService;
import com.application.DokterFinder.Service.DocterService;

@RestController
@CrossOrigin("*")
public class DocterAvailabilityController {
     
	@Autowired
	private DocterAvailabilityService daserv;
	
	@GetMapping("/getDoctorAvailability/{id}/{date}")
	public ResponseEntity<List<GetDocterAvailabilityDto>> gettingById(@PathVariable("date") LocalDate date,@PathVariable("id") int id) {
		return ResponseEntity.ok(daserv.getBydate(date,id)); 
	}
	
	@PostMapping("/postDoctorAvailability")
	public void gettingById(@RequestBody PostDocterAvailabilityDto body) {
		 daserv.postDoctorAvailabliity(body);
	}
	
	@PutMapping("/incrementBookedAppointments/{id}")
	public void updateCount(@PathVariable("id") int id) {
		daserv.update(id);
	}
	
	
	
}
