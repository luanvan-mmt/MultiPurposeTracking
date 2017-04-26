package model;

public class SinhVien extends ConNguoi {

	private String mssv;
	private String maLop;
	private boolean nhomTruong;

	public SinhVien() {
		super();
	}

	public SinhVien(String mssv, String maLop, boolean nhomTruong) {
		super();
		this.mssv = mssv;
		this.maLop = maLop;
		this.nhomTruong = nhomTruong;
	}

	public SinhVien(String mssv, String hoTen, String gioiTinh, String sdt,
			String diaChi, String cmnd, String email, String maLop) {
		super(hoTen, gioiTinh, sdt, diaChi, cmnd, email);
		this.mssv = mssv;
		this.maLop = maLop;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public boolean isNhomTruong() {
		return nhomTruong;
	}

	public void setNhomTruong(boolean nhomTruong) {
		this.nhomTruong = nhomTruong;
	}

}
