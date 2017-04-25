package model;

public class CanBo extends ConNguoi{
	
	private String mscb;
	private String chucVu;
	
	public CanBo() {
		super();
	}

	public CanBo(String mscb, String chucVu) {
		super();
		this.mscb = mscb;
		this.chucVu = chucVu;
	}

	public CanBo(String mscb, String hoTen, String chucVu, String gioiTinh, String sdt, String diaChi,
			String cmnd, String email) {
		super(hoTen, gioiTinh, sdt, diaChi, cmnd, email);
		this.mscb = mscb;
		this.chucVu = chucVu;
	}

	public String getMscb() {
		return mscb;
	}

	public void setMscb(String mscb) {
		this.mscb = mscb;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

}
