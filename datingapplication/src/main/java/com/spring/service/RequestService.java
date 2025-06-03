package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.LoginRegister;
import com.spring.entity.Request;
import com.spring.repo.LoginRegisterRepo;
import com.spring.repo.RequestRepo;

@Service
public class RequestService {
	
	@Autowired
	RequestRepo requestRepo;
	
	@Autowired
	LoginRegisterRepo loginRegisterRepo;
	
	public Request requestdata(Long receiverId, Long senderId) {
		Request request = new Request();
	    request.setReceiverId(receiverId);
	    request.setSenderId(senderId);
	    request.setStatus("pending");
	    
	    Optional<Request> requestDta =requestRepo.findByReceiverIdAndSenderId(receiverId, senderId);
	    System.out.println(requestDta.isPresent());
	    if(requestDta.isPresent()) {
	    	return requestRepo.save(requestDta.get());
	    } 
	    return requestRepo.save(request);
	}
	
	public List<LoginRegister> showrequest(Long receiverId) {
		
		System.out.println("receiver Id"+receiverId);
		List<LoginRegister> loginRegistersList= new ArrayList<>();
		List<Request> Loginlist= requestRepo.findByReceiverIdAndStatus(receiverId,"pending");
		for (Request request : Loginlist) {
			Optional<LoginRegister> loginRegister=loginRegisterRepo.findById(request.getSenderId());
			System.out.println(loginRegister.get());
			loginRegistersList.add(loginRegister.get());
		}	
		System.out.println("rtyui"+loginRegistersList);
		return loginRegistersList;
		
	}

	public Request acceptStatus(Long receiverId,Long senderId) {
		Request request = new Request();
	    request.setReceiverId(receiverId);
	    request.setSenderId(senderId);
	    request.setStatus("Accept");
	    
	    Optional<Request> requestDta =requestRepo.findByReceiverIdAndSenderId(receiverId, senderId);
	    
	    System.out.println(requestDta.isPresent());
	    if(requestDta.isPresent()) {
	    	requestDta.get().setStatus("Accept");
	    	return requestRepo.save(requestDta.get());
	    } 
	    return requestRepo.save(request);
	}
	
	
public List<LoginRegister> showFriendsInMessages(Long receiverId) {
		
		System.out.println("receiver Id"+receiverId);
		List<LoginRegister> loginRegistersList= new ArrayList<>();
		List<Request> Loginlist= requestRepo.findByReceiverIdAndStatus(receiverId,"Accept");
//		List<Request> Loginlist= requestRepo.findByReceiverIdOrSenderIdAndStatus(receiverId,"Accept");
		for (Request request : Loginlist) {
			Optional<LoginRegister> loginRegister=loginRegisterRepo.findById(request.getSenderId());
			System.out.println(loginRegister.get());
			loginRegistersList.add(loginRegister.get());
		}	
		System.out.println("rtyui"+loginRegistersList);
		return loginRegistersList;
		
	}


}
