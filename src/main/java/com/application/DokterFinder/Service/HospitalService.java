package com.application.DokterFinder.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.DokterFinder.Dto.GetHospitalsDto;
import com.application.DokterFinder.Entities.HospitalEntity;
import com.application.DokterFinder.Repositories.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	public GetHospitalsDto getById(int id) {
		 HospitalEntity orElse = hrepo.findById(id).orElse(null);
		 return  modelmapper.map(orElse,GetHospitalsDto.class);
		 
		 
	}

	public HospitalEntity postHospital(HospitalEntity body) {
		// TODO Auto-generated method stub
//		HospitalEntity newfield=new HospitalEntity();
//		newfield.setName(body.getName());
//		newfield.setLocation(body.getLocation());
		return hrepo.save(body);
	}

	public List<GetHospitalsDto> getAllHosp() {
		// TODO Auto-generated method stub
		return hrepo.findAll().stream().map(e-> modelmapper.map(e,GetHospitalsDto.class)).toList();
	}

	

	
	
}
