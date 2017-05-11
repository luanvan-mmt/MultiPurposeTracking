package com.dev.model;

public class NguoiDung {
	
	private String userName; // ma so
	private String password; // mat khau
	private String fullName; // ho ten
	private int role; // 1: admin, 2: can bo, 3: sinh vien
	private String userNameSip;
	private String passwordSip;
	private boolean sipStatus;
	
	public NguoiDung() {
		super();
	}

	public NguoiDung(String userName, String password, String fullName,
			int role, String userNameSip, String passwordSip, boolean sipStatus) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
		this.userNameSip = userNameSip;
		this.passwordSip = passwordSip;
		this.sipStatus = sipStatus;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUserNameSip() {
		return userNameSip;
	}

	public void setUserNameSip(String userNameSip) {
		this.userNameSip = userNameSip;
	}

	public String getPasswordSip() {
		return passwordSip;
	}

	public void setPasswordSip(String passwordSip) {
		this.passwordSip = passwordSip;
	}

	public boolean isSipStatus() {
		return sipStatus;
	}

	public void setSipStatus(boolean sipStatus) {
		this.sipStatus = sipStatus;
	}
	
}

