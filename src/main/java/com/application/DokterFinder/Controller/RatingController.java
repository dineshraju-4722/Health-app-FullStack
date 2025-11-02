package com.application.DokterFinder.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.DokterFinder.Dto.PostRatingDto;
import com.application.DokterFinder.Service.RatingService;

@RestController
@CrossOrigin("*")
public class RatingController {

	@Autowired
	 private RatingService rserv;
	
	@PostMapping("/postRating")
	public void postRating(@RequestBody PostRatingDto body) {
		rserv.postrating(body);
	}
	
	
}
