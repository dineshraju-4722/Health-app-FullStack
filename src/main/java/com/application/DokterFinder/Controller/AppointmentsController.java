package com.application.DokterFinder.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.DokterFinder.Dto.AppointmentPostDto;
import com.application.DokterFinder.Dto.GetAppointmentsByUserDto;
import com.application.DokterFinder.Entities.AppointmentEntity;
import com.application.DokterFinder.Service.AppointmentsService;


@RestController
@CrossOrigin("*")
public class AppointmentsController {

	@Autowired
	private AppointmentsService appserv;

	@GetMapping("/getAppointment/{id}")
	public ResponseEntity<AppointmentEntity> gettingById(@PathVariable("id") int id) {
		return ResponseEntity.ok(appserv.getById(id));
	}
	
	@GetMapping("/getAppointmentsByUsers/{id}")
	public ResponseEntity<List<GetAppointmentsByUserDto>> gettingByUserId(@PathVariable("id") int id) {
		return ResponseEntity.ok(appserv.getByUserId(id));
	}
	

	@PostMapping("/postAppointment")
	public Map<String,Integer> postById(@RequestBody AppointmentPostDto body) {
		int id= appserv.postAppointment(body);
		return Map.of("id",id);
	}

}
