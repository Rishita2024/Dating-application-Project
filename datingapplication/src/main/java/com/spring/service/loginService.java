package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.LoginRegDto;
import com.spring.entity.LoginRegister;
import com.spring.entity.Profiles;
import com.spring.repo.LoginRegisterRepo;
import com.spring.repo.ProfileRepo;

@Service
public class loginService {
	@Autowired
	LoginRegisterRepo loginRegisterRepo;
	
	@Autowired
	ProfileRepo profileRepo;
	
	public LoginRegister register(LoginRegister loginRegister) {
		return loginRegisterRepo.save(loginRegister);
		
	}
	public LoginRegister loginuser(LoginRegister loginRegister) {
		System.out.println("fghjk"+loginRegister);
		
		Optional<LoginRegister> logOptional=loginRegisterRepo.findByEmailAndPassword(loginRegister.getEmail(), loginRegister.getPassword());
		
		
		System.out.println("optional "+logOptional);
		
		if (logOptional.isPresent()) {

			return logOptional.get();
		}else {
			return null;
		}
	}
	
//	public List<LoginRegister> showAlldata(){
//		return loginRegisterRepo.findAll();
//	}
	public List<LoginRegDto> showAllDataByGender(String gender) {
		
	    List<LoginRegister> list= loginRegisterRepo.findAll().stream()
	            .filter(user -> user.getGender().equalsIgnoreCase(gender))
	            .collect(Collectors.toList());
	    
	    List<LoginRegDto> dtos= new ArrayList<>();
	    for (LoginRegister loginRegister : list) {
			System.out.println(loginRegister.getLoginRegId());
			Optional<Profiles> profile=profileRepo.findByLoginRegiId(loginRegister.getLoginRegId());
			System.out.println("opjhg"+profile.get());
			dtos.add(new LoginRegDto(loginRegister, profile.get()));
		}
	    
	    System.out.println(dtos);
	    return dtos;
	}
	
	
}
