package com.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profiles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long profileId;
	private Long loginRegiId;
	
	@Column(length = 20000)
	private String image1;

	@Column(length = 20000)
	private String image2;
	@Column(length = 20000)
	private String image3;
	@Column(length = 20000)
	private String image4;
	
	@Column(length = 20000)
	private String image5;
	@Column(length = 100)
	private String bio;
	@Column(length = 500)
	private String interests;
	@Override
	public String toString() {
		return "Profiles [profileId=" + profileId + ", loginRegiId=" + loginRegiId + ", image1=" + image1 + ", image2="
				+ image2 + ", image3=" + image3 + ", image4=" + image4 + ", image5=" + image5 + ", bio=" + bio
				+ ", interests=" + interests + "]";
	}
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
	public Profiles( Long loginRegiId, String image1, String image2, String image3, String image4,
			String image5, String bio, String interests) {
		super();
		
		this.loginRegiId = loginRegiId;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.bio = bio;
		this.interests = interests;
	}
	public Profiles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
