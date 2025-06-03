package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.entity.LoginRegister;

import com.spring.entity.Profiles;
import com.spring.repo.LoginRegisterRepo;
import com.spring.repo.ProfileRepo;

@Service
public class ProfileService {
	@Autowired
	ProfileRepo profileRepo;
	
	@Autowired
	LoginRegisterRepo loginRegisterRepo;

	public List<Profiles> showallDataProfile() {
		return	profileRepo.findAll();
		
	}
	
}
