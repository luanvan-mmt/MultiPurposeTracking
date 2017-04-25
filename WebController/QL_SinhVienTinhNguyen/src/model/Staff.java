package model;

public class Staff {
	private String staffId;
	private String fullName;
	private String position;
	private String sex;
	private String phone;
	private String address;
	private String idNumber;
	private String email;

	public Staff() {
		super();
	}

	public Staff(String staffId, String fullName, String position, String sex,
			String phone, String address, String idNumber, String email) {
		super();
		this.staffId = staffId;
		this.fullName = fullName;
		this.position = position;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.idNumber = idNumber;
		this.email = email;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
