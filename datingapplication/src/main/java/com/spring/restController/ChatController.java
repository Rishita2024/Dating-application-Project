package com.spring.restController;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import com.spring.entity.ChatMessage;
import com.spring.repo.MessageRepository;

@RestController
@RequestMapping("/api/chat")
//@CrossOrigin(origins = "http://localhost:4200") // Adjust as needed
@CrossOrigin("*")
public class ChatController {

    private final MessageRepository chatMessageRepository;

    public ChatController(MessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    /** ✅ WebSocket - Send & Broadcast Message */
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
    	message.setTimestamp(LocalDateTime.now()); // ✅ Ensure timestamp is set
        ChatMessage savedMessage = chatMessageRepository.save(message);
        System.out.println("Message Sent: " + savedMessage);
        return savedMessage;
    }

    /** ✅ REST API - Save Message */
    @PostMapping("/send")
    public void sendMessageToDB(@RequestBody ChatMessage message) {
        message.setTimestamp(LocalDateTime.now()); // Ensure timestamp is set
        chatMessageRepository.save(message);
    }

    /** ✅ REST API - Get Chat History */
    @GetMapping("/{sender}/{receiver}")
    public List<ChatMessage> getChatHistory(@PathVariable String sender, @PathVariable String receiver) {
    	List<ChatMessage> sentMessages = chatMessageRepository.findBySenderAndReceiver(sender, receiver);
        List<ChatMessage> receivedMessages = chatMessageRepository.findByReceiverAndSender(sender,receiver);
//        System.out.println(sentMessages);
        System.out.println(receivedMessages);
        sentMessages.addAll(receivedMessages);
        sentMessages.sort((m1, m2) -> m1.getTimestamp().compareTo(m2.getTimestamp())); // Sort by timestamp

        return sentMessages;}
}
