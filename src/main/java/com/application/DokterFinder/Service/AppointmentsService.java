package com.application.DokterFinder.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.DokterFinder.Dto.AppointmentPostDto;
import com.application.DokterFinder.Dto.GetAppointmentsByUserDto;
import com.application.DokterFinder.Dto.GetDocterAvailabilityDto;
import com.application.DokterFinder.Entities.AppointmentEntity;
import com.application.DokterFinder.Repositories.AppointmentsRepository;
import com.application.DokterFinder.Repositories.DocterRepository;
import com.application.DokterFinder.Repositories.UserRepository;

@Service
public class AppointmentsService {

	
	@Autowired
	private AppointmentsRepository apprepo;
	
	@Autowired
	private DocterRepository drepo;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private DocterAvailabilityService daserv;
	
	@Autowired
	private ModelMapper modelmapper;
	
	public AppointmentEntity getById(int id) {
		return apprepo.findById(id).orElse(null);
		
	}

	public List<GetAppointmentsByUserDto> getByUserId(int id) {
		List<AppointmentEntity> appointmentsByUserId = apprepo.findAppointmentsByUserId(id);
	
		return appointmentsByUserId.stream().map(a -> {
            GetAppointmentsByUserDto dto = new GetAppointmentsByUserDto();
            dto.setId(a.getId());
            dto.setDate(a.getAppointmentDate());
            dto.setTime(a.getAppointmentTime());
            dto.setDoctorName(a.getDoctor().getName());
            dto.setHospitalName(a.getDoctor().getHospital().getName());
            dto.setSpecializationName(a.getDoctor().getSpecialization().getName());
            return dto;
        }).toList();
		
	}

	public int postAppointment(AppointmentPostDto body) {
		// TODO Auto-generated method stub
	AppointmentPostDto abc=body;
		
		
		
		AppointmentEntity map = modelmapper.map(body,AppointmentEntity.class);
		map.setDoctor(drepo.findById(body.getDocter()).orElse(null));
		map.setUser(userrepo.findById(body.getUser()).orElse(null));
		 apprepo.save(map);
		
			GetDocterAvailabilityDto bydateAndTime = daserv.getBydateAndTime(abc.getAppointmentDate(), abc.getDocter(), abc.getAppointmentTime());
		return bydateAndTime.getId();
	 
	}

   
	
}
