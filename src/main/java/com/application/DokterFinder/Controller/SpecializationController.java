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

import com.application.DokterFinder.Dto.GetDoctersDto;
import com.application.DokterFinder.Dto.getSpecializationDto;
import com.application.DokterFinder.Entities.SpecializationEntity;
import com.application.DokterFinder.Service.SpecializationService;

@RestController
@CrossOrigin("*")
public class SpecializationController {
     
	@Autowired
	private SpecializationService sserv;
	
	@GetMapping("/getSpecialization/{id}")
	public ResponseEntity<SpecializationEntity> gettingById(@PathVariable("id") int id) {
		return ResponseEntity.ok(sserv.getById(id)); 
	}
	
	@GetMapping("/getAllSpecilizations")
		public List<getSpecializationDto> getAll(){
			return sserv.getAllSpecialations();
		}
	
	@GetMapping("/getSpecializationByName/{name}")
	public ResponseEntity<List<GetDoctersDto>> gettingByName(@PathVariable("name") String name) {
		return ResponseEntity.ok(sserv.getDoctorsByName(name)); 
	}
	
	@PostMapping("/postSpecialization")
	public SpecializationEntity gettingById(@RequestBody SpecializationEntity body) {
		return sserv.postSpecialization(body);
	}
	
	
	
}
