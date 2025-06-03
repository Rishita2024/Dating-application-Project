package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Request;
import java.util.List;
import java.util.Optional;


public interface RequestRepo extends JpaRepository<Request, Long> {
	
	
   List<Request> findByReceiverIdAndStatus(Long receiverId, String status);
   List<Request> findBySenderIdAndStatus(Long senderId, String status);
//   List<Request> findByReceiverIdOrSenderIdAndStatus(Long receiverId, String status);
   
   Optional<Request> findByReceiverIdAndSenderId(Long receiverId, Long senderId);
}

