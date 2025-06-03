package com.spring.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoginRegister {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long loginRegId;
	 
	 @Column(length = 55)
		private String fullName;

	    @Column(unique = true, nullable = false, length = 50)
	    private String username;

	    @Column(unique = true, nullable = false, length = 100)
	    private String email;

	    @Column(nullable = false)
	    private String password;
	    
//		private long number;

	    @Column(nullable = false)
	    private boolean isActive = false; // User status (online/offline)

//	    @Column(nullable = false, updatable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();
	    
	    private Date dateOfBirth;
	    
	    @Column(nullable = false, length = 10)
	    private String gender;
	    
	    public LoginRegister(LoginRegister loginRegister) {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    public LoginRegister() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		@Override
		public String toString() {
			return "LoginRegister [loginRegId=" + loginRegId + ", username=" + username + ", email=" + email + ", password=" + password
					+ ", fullName=" + fullName + ", isActive=" + isActive + ", createdAt=" + createdAt
					+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
		}

		

		public Long getLoginRegId() {
			return loginRegId;
		}

		public void setLoginRegId(Long loginRegId) {
			this.loginRegId = loginRegId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}



		

}
