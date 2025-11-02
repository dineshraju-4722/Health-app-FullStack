package com.application.DokterFinder.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.DokterFinder.Dto.GetDoctersDto;
import com.application.DokterFinder.Dto.getSpecializationDto;
import com.application.DokterFinder.Entities.DocterEntity;
import com.application.DokterFinder.Entities.RatingEntity;
import com.application.DokterFinder.Entities.SpecializationEntity;
import com.application.DokterFinder.Repositories.DocterRepository;
import com.application.DokterFinder.Repositories.RatingRepository;
import com.application.DokterFinder.Repositories.SpecializationRepository;

@Service
public class SpecializationService {

	@Autowired
	private SpecializationRepository srepo;
	
	@Autowired
	private DocterRepository drepo;
	
	@Autowired
	private RatingRepository rrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	public SpecializationEntity getById(int id) {
		// TODO Auto-generated method stub
		return srepo.findById(id).orElse(null);
	}
	
	public List<GetDoctersDto> getDoctorsByName(String name){
		List<DocterEntity> bySpecialization_Name = drepo.findBySpecialization_Name(name);
		return bySpecialization_Name.stream().map(ele->{GetDoctersDto map1 = modelmapper.map(ele, GetDoctersDto.class);
		
		Double avgRating = rrepo.findAll().stream()
                .filter(r -> r.getDoctor().getId() == map1.getId())
                .mapToInt(r -> r.getRatingValue())
                .average()
                .orElse(0.0);
	 
	 map1.setAverageRating(avgRating);
	 
//	 rrepo.findByDoctor_IdAndUser_Id(map.getId(),map.getu)
//     .ifPresent(r -> dto.setUserRating(r.getRatingValue()));
	 
	 map1.setUserRating(2);

		return map1;
		}).toList();
	}

	public SpecializationEntity postSpecialization(SpecializationEntity body) {
		// TODO Auto-generated method stub
		SpecializationEntity newfield=new SpecializationEntity();
		newfield.setName(body.getName());
		return srepo.save(newfield);
	}

	public List<getSpecializationDto> getAllSpecialations() {
		List<getSpecializationDto> list = srepo.findAll().stream().map(e ->  modelmapper.map(e,getSpecializationDto.class)).toList();
		return list;
	}

	

	
	
}
