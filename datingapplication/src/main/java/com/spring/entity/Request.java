package com.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "request7")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;
	private Long senderId;
	private Long receiverId;
	@Column(length = 10)
	private String status = "Pending";
	public Request(Long requestId, Long senderId, Long receiverId, String status) {
		super();
		this.requestId = requestId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.status = status;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getSenderId() {
		return senderId;
	}
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	public Long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", senderId=" + senderId + ", receiverId=" + receiverId + ", status="
				+ status + "]";
	}
	
	
	

}
