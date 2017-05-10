package com.dev.model;

public class SIPAccount {
	
	private String userName;
	private String password;
	private boolean active;
	
	public SIPAccount() {
		super();
	}

	public SIPAccount(String userName, String password, boolean active) {
		super();
		this.userName = userName;
		this.password = password;
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
}
