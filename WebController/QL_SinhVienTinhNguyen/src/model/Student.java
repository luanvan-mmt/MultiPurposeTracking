package model;

public class Student {
	private String studentId;
	private String fullName;
	private String sex;
	private String phone;
	private String address;
	private String idNumber;
	private String email;
	private String classCode;
	private boolean leader;
	
	public Student() {
		super();
	}

	public Student(String studentId, String fullName, String sex, String phone,
			String address, String idNumber, String email, String classCode,
			boolean leader) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.idNumber = idNumber;
		this.email = email;
		this.classCode = classCode;
		this.leader = leader;
	}
	
	public Student(String studentId, String fullName, String sex, String phone,
			String address, String idNumber, String email, String classCode) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.idNumber = idNumber;
		this.email = email;
		this.classCode = classCode;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public boolean isLeader() {
		return leader;
	}

	public void setLeader(boolean leader) {
		this.leader = leader;
	}
	
}
