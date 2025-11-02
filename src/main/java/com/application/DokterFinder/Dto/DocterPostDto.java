package com.application.DokterFinder.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocterPostDto {
    
	 private String email;
	    
	    private String password;
	    
	    private String imglink;
	    
	    private String contact;
	
	private String name;
	private String experience;
	private int specializationId;
	private int hospitalId;

}
