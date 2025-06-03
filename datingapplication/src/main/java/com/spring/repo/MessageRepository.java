package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ChatMessage;

import java.util.List;


public interface MessageRepository extends JpaRepository<ChatMessage, Long> {

	 List<ChatMessage> findBySenderAndReceiver(String sender, String receiver);
	 List<ChatMessage> findByReceiverAndSender(String receiver, String sender);
}
