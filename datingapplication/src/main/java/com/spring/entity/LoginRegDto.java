package com.spring.entity;

public class LoginRegDto {
	
	LoginRegister loginRegister;
	Profiles profiles;
	@Override
	public String toString() {
		return "LoginRegDto [loginRegister=" + loginRegister + ", profiles=" + profiles + "]";
	}
	public LoginRegDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginRegDto(LoginRegister loginRegister, Profiles profiles) {
		super();
		this.loginRegister = loginRegister;
		this.profiles = profiles;
	}
	public LoginRegister getLoginRegister() {
		return loginRegister;
	}
	public void setLoginRegister(LoginRegister loginRegister) {
		this.loginRegister = loginRegister;
	}
	public Profiles getProfiles() {
		return profiles;
	}
	public void setProfiles(Profiles profiles) {
		this.profiles = profiles;
	}
	
	
	
	

}
