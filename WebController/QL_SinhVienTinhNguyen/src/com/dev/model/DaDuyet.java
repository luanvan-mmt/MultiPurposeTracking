package com.dev.model;

public class DaDuyet extends SinhVien{

	private String maChienDich;

	public DaDuyet() {
		super();
	}

	public DaDuyet(String mssv, String maLop, boolean nhomTruong) {
		super(mssv, maLop, nhomTruong);
	}

	public DaDuyet(String mssv, String hoTen, String gioiTinh, String sdt,
			String diaChi, String cmnd, String email, String maLop) {
		super(mssv, hoTen, gioiTinh, sdt, diaChi, cmnd, email, maLop);
	}
	public DaDuyet(String mssv, String hoTen, String gioiTinh, String sdt,
			String diaChi, String cmnd, String email, String maLop, String maChienDich) {
		super(mssv, hoTen, gioiTinh, sdt, diaChi, cmnd, email, maLop);
		this.maChienDich = maChienDich;
	}

	public DaDuyet(String maChienDich) {
		super();
		this.maChienDich = maChienDich;
	}

	public String getMaChienDich() {
		return maChienDich;
	}

	public void setMaChienDich(String maChienDich) {
		this.maChienDich = maChienDich;
	}
	
}
