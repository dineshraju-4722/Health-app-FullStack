package com.application.DokterFinder.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.DokterFinder.Dto.PostRatingDto;
import com.application.DokterFinder.Entities.DocterEntity;
import com.application.DokterFinder.Entities.RatingEntity;
import com.application.DokterFinder.Entities.UserEntity;
import com.application.DokterFinder.Repositories.DocterRepository;
import com.application.DokterFinder.Repositories.RatingRepository;
import com.application.DokterFinder.Repositories.UserRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository rrepo;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private DocterRepository drepo;

	public void postrating(PostRatingDto body) {
		
		         RatingEntity byDoctor_IdAndUser_Id = rrepo.findByDoctor_IdAndUser_Id(body.getDocterid(), body.getUserid());
		         
		         if(byDoctor_IdAndUser_Id==null) {
		        	 DocterEntity doctor = drepo.findById(body.getDocterid())
		        		        .orElseThrow(() -> new RuntimeException("Doctor not found"));
		        		UserEntity user = urepo.findById(body.getUserid())
		        		        .orElseThrow(() -> new RuntimeException("User not found"));
		         		RatingEntity newrow=new RatingEntity();
		         		newrow.setDoctor(doctor);
		         		newrow.setUser(user);
		         		newrow.setRatingValue(body.getRating());
		         		rrepo.save(newrow);
		         }
		         else {
		        	 byDoctor_IdAndUser_Id.setRatingValue(body.getRating());
		        	 rrepo.save(byDoctor_IdAndUser_Id);
		         }
         		
         		
	}
	
	
}
