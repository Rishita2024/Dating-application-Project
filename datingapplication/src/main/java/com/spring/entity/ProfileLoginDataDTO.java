package com.spring.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;

public class ProfileLoginDataDTO {

	private Long profileId;
	private Long loginRegiId;

	private String image1;

	private String image2;
	private String image3;
	private String image4;

	private String image5;
	private String bio;
	private String interests;

	private String fullName;

	private String username;

	private String email;

	private String password;

//	private long number;

	private boolean isActive = false; // User status (online/offline)

//    @Column(nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	private Date dateOfBirth;

	private String gender;

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public Long getLoginRegiId() {
		return loginRegiId;
	}

	public void setLoginRegiId(Long loginRegiId) {
		this.loginRegiId = loginRegiId;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
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

	@Override
	public String toString() {
		return "ProfileLoginDataDTO [profileId=" + profileId + ", loginRegiId=" + loginRegiId + ", image1=" + image1
				+ ", image2=" + image2 + ", image3=" + image3 + ", image4=" + image4 + ", image5=" + image5 + ", bio="
				+ bio + ", interests=" + interests + ", fullName=" + fullName + ", username=" + username + ", email="
				+ email + ", password=" + password + ", isActive=" + isActive + ", createdAt=" + createdAt
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
	}

//	@Override
//		public String toString() {
//			return "ProfileLoginDataDTO [profileId=" + profileId + ", loginRegiId=" + loginRegiId + ", image1=" + image1
//					+ ", image2=" + image2 + ", image3=" + image3 + ", image4=" + image4 + ", image5=" + image5
//					+ ", bio=" + bio + ", interests=" + interests + ", fullName=" + fullName + ", username=" + username
//					+ ", email=" + email + ", password=" + password + ", isActive=" + isActive + ", createdAt="
//					+ createdAt + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
//		}     

	
}
