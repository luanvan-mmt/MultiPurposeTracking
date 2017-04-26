package model;

public class NguoiDung {
	
	private String userName;
	private String password;
	private int role; // 1: admin, 2: can bo, 3: sinh vien
	
	public NguoiDung() {
		super();
	}

	public NguoiDung(String userName, String password, int role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
}

