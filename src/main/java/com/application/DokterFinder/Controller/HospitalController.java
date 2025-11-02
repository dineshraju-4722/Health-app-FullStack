package com.application.DokterFinder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.DokterFinder.Dto.GetHospitalsDto;
import com.application.DokterFinder.Entities.HospitalEntity;
import com.application.DokterFinder.Service.HospitalService;

@RestController
@CrossOrigin("*")
public class HospitalController {

	@Autowired
	private HospitalService hserv;

	@GetMapping("/getHospital/{id}")
	public ResponseEntity<GetHospitalsDto> gettingById(@PathVariable("id") int id) {
		return ResponseEntity.ok(hserv.getById(id));
	}
	
	@GetMapping("/getAllHospitals")
	public ResponseEntity<List<GetHospitalsDto>> gettingAll() {
		return ResponseEntity.ok(hserv.getAllHosp());
	}

	@PostMapping("/postHospital")
	public HospitalEntity postById(@RequestBody HospitalEntity body) {
		return hserv.postHospital(body);
	}

}
