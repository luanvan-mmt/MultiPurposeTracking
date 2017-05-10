package mongodb;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import model.CanBo;
import model.NguoiDung;
import model.SIPAccount;
import model.SinhVien;

public class NguoiDungCollection extends CollectionManager1<NguoiDung> {
	
	private final String collName = "users";
	
	private SIPAccountCollection sipAccColl = new SIPAccountCollection();
	
	public NguoiDungCollection() {
		super();
		createCollIfNotExist(collName, "userName");
	}
	
	public void updateSipStatus(String userName, boolean status) {
		Document newDoc = new Document("sipStatus", status);
		
		collection.updateOne(Filters.eq("userName", userName),
				new Document("$set", newDoc));
		
	}
	
	public String autoCreateUser(SinhVien sinhVien) {
		// Khoi tao mat khau ngau nhien gom 8 ky tu
		String password = "@43kj32*";
		
		// Lay ra tai khoan SIP chua co nguoi su dung
		SIPAccount sipAccount = sipAccColl.getInactiveAccount();
		
		// Tao nguoi dung cho Sinh vien
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setUserName(sinhVien.getMssv());
		nguoiDung.setPassword(password);
		nguoiDung.setFullName(sinhVien.getHoTen());
		nguoiDung.setRole(3);
		nguoiDung.setUserNameSip(sipAccount.getUserName());
		nguoiDung.setPasswordSip(sipAccount.getPassword());
		nguoiDung.setSipStatus(false);
		
		save(nguoiDung);
				
		return password;
	}
	
	public String autoCreateUser(CanBo canBo) {
		// Khoi tao mat khau ngau nhien gom 8 ky tu
		String password = "@43kj32*";
		
		// Lay ra tai khoan SIP chua co nguoi su dung
		SIPAccount sipAccount = sipAccColl.getInactiveAccount();
		
		// Tao nguoi dung cho Can bo
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setUserName(canBo.getMscb());
		nguoiDung.setPassword(password);
		nguoiDung.setFullName(canBo.getHoTen());
		nguoiDung.setRole(2);
		nguoiDung.setUserNameSip(sipAccount.getUserName());
		nguoiDung.setPasswordSip(sipAccount.getPassword());
		nguoiDung.setSipStatus(false);
		
		save(nguoiDung);
				
		return password;
	}

	@Override
	public Document convertToDocument(NguoiDung obj) {

		if(!"".equals(obj.getUserName())) {
			Document doc = new Document();
			doc.append("userName", obj.getUserName());
			doc.append("password", obj.getPassword());
			doc.append("role", obj.getRole());
			doc.append("userNameSip", obj.getUserNameSip());
			doc.append("passwordSip", obj.getPasswordSip());
			doc.append("sipStatus", obj.isSipStatus());
			
			return doc;
		}
		
		System.out.println("NguoiDung - Doc rong!");
		return null;
	}
	
	@Override
	public NguoiDung convertToObject(Document doc) {
		
		if(!doc.isEmpty()) {
			NguoiDung nguoiDung = new NguoiDung();
			nguoiDung.setUserName(doc.getString("userName"));
			nguoiDung.setPassword(doc.getString("password"));
			nguoiDung.setFullName(doc.getString("fullName"));
			nguoiDung.setRole(doc.getInteger("role"));
			nguoiDung.setUserNameSip(doc.getString("userNameSip"));
			nguoiDung.setPasswordSip(doc.getString("passwordSip"));
			nguoiDung.setSipStatus(doc.getBoolean("sipStatus"));
			
			return nguoiDung;
		}
		
		System.out.println("Document - NguoiDung rong!");
		return null;
	}
	
	public static void main(String[] args) {
		NguoiDungCollection nguoiDungColl = new NguoiDungCollection();
		
		nguoiDungColl.updateSipStatus("B1304568", false);
		
		/*
		NguoiDung nguoiDung = nguoiDungColl.getByFieldName("userName", "B1304568");
		System.out.println(nguoiDung.getUserName());
		*/
		
		/*
		CanBo canBo = new CanBo();
		canBo.setMscb("CB103000");
		canBo.setHoTen("Le Nguyen Hai Dang");
		
		nguoiDungColl.autoCreateUser(canBo);
		*/
				
		/*
		SinhVien sinhVien = new SinhVien();
		sinhVien.setMssv("B1304568");
		sinhVien.setHoTen("Chau Quoc Minh");
		
		nguoiDungColl.autoCreateUser(sinhVien);
		*/
	}

	

}
