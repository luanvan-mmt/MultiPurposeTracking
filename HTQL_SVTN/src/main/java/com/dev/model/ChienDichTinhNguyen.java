package com.dev.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class ChienDichTinhNguyen {

	private int maChienDich;
	private String diaDiem;
	private String mucDich;
	private Date thoiGianBD;
	private Date thoiGianKT;
	private int soLuong;
	private String yeuCau;
	private String keHoach;
	private Date bdDangKy;
	@DateTimeFormat(iso = ISO.DATE_TIME) private Date ktDangKy;

	public ChienDichTinhNguyen() {
		super();
	}

	public ChienDichTinhNguyen(int maChienDich, String diaDiem,
			String mucDich, Date thoiGianBD, Date thoiGianKT, int soLuong,
			String yeuCau, String keHoach) {
		super();
		this.maChienDich = maChienDich;
		this.diaDiem = diaDiem;
		this.mucDich = mucDich;
		this.thoiGianBD = thoiGianBD;
		this.thoiGianKT = thoiGianKT;
		this.soLuong = soLuong;
		this.yeuCau = yeuCau;
		this.keHoach = keHoach;
	}

	public ChienDichTinhNguyen(int maChienDich, String diaDiem, String mucDich,
			Date thoiGianBD, Date thoiGianKT, int soLuong, String yeuCau,
			String keHoach, Date bdDangKy, Date ktDangKy) {
		super();
		this.maChienDich = maChienDich;
		this.diaDiem = diaDiem;
		this.mucDich = mucDich;
		this.thoiGianBD = thoiGianBD;
		this.thoiGianKT = thoiGianKT;
		this.soLuong = soLuong;
		this.yeuCau = yeuCau;
		this.keHoach = keHoach;
		this.bdDangKy = bdDangKy;
		this.ktDangKy = ktDangKy;
	}

	public Date getBdDangKy() {
		return bdDangKy;
	}

	public void setBdDangKy(Date bdDangKy) {
		this.bdDangKy = bdDangKy;
	}

	public Date getKtDangKy() {
		return ktDangKy;
	}

	public void setKtDangKy(Date ktDangKy) {
		this.ktDangKy = ktDangKy;
	}

	public int getMaChienDich() {
		return maChienDich;
	}

	public void setMaChienDich(int maChienDich) {
		this.maChienDich = maChienDich;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getMucDich() {
		return mucDich;
	}

	public void setMucDich(String mucDich) {
		this.mucDich = mucDich;
	}

	public Date getThoiGianBD() {
		return thoiGianBD;
	}

	public void setThoiGianBD(Date thoiGianBD) {
		this.thoiGianBD = thoiGianBD;
	}

	public Date getThoiGianKT() {
		return thoiGianKT;
	}

	public void setThoiGianKT(Date thoiGianKT) {
		this.thoiGianKT = thoiGianKT;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getYeuCau() {
		return yeuCau;
	}

	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}

	public String getKeHoach() {
		return keHoach;
	}

	public void setKeHoach(String keHoach) {
		this.keHoach = keHoach;
	}

}
