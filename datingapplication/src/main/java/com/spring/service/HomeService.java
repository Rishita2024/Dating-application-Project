package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.LoginRegister;
import com.spring.repo.LoginRegisterRepo;

@Service
public class HomeService {

	@Autowired
	LoginRegisterRepo loginRegisterRepo;
	
	
	
}
