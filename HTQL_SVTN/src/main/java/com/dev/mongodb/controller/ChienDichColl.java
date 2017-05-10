package com.dev.mongodb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.dev.model.*;
import com.dev.mongodb.utils.CollectionManager1;

public class ChienDichColl extends CollectionManager1<ChienDichTinhNguyen> {
	
	private final String collName = "chiendichtinhnguyen";
	
	public ChienDichColl() {
		super();
		createCollIfNotExist(collName, "maChienDich");
	}
	
	public List<ChienDichTinhNguyen> layDSChuaHetHan(Date ngayHienTai) {
		FindIterable<Document> docs = collection
				.find(Filters.gte("ktDangKy", ngayHienTai));
		
		List<ChienDichTinhNguyen> dsChienDich = new ArrayList<ChienDichTinhNguyen>();
		
		for (Document doc : docs) {
			ChienDichTinhNguyen chienDich = convertToObject(doc);
			
			dsChienDich.add(chienDich);
		}
		
		return dsChienDich;
	}
	
	@Override
	public Document convertToDocument(ChienDichTinhNguyen obj) {
		Document doc = new Document();
		doc.append("maChienDich", obj.getMaChienDich());
		doc.append("diaDiem", obj.getDiaDiem());
		doc.append("mucDich", obj.getMucDich());
		doc.append("thoiGianBD", obj.getThoiGianBD());
		doc.append("thoiGianKT", obj.getThoiGianKT());
		doc.append("soLuong", obj.getSoLuong());
		doc.append("yeuCau", obj.getYeuCau());
		doc.append("keHoach", obj.getKeHoach());
		doc.append("bdDangKy", obj.getBdDangKy());
		doc.append("ktDangKy", obj.getKtDangKy());
		
		return doc;
	}

	@Override
	public ChienDichTinhNguyen convertToObject(Document doc) {
		ChienDichTinhNguyen chienDich = new ChienDichTinhNguyen(
				doc.getInteger("maChienDich"),
				doc.getString("diaDiem"),
				doc.getString("mucDich"),
				doc.getDate("thoiGianBD"),
				doc.getDate("thoiGianKT"),
				doc.getInteger("soLuong"),
				doc.getString("yeuCau"),
				doc.getString("keHoach"),
				doc.getDate("bdDangKy"),
				doc.getDate("ktDangKy")
				);
		
		return chienDich;
	}
	
	public static void main(String[] args) {
		ChienDichColl cdColl = new ChienDichColl();
		
		@SuppressWarnings("deprecation")
		List<ChienDichTinhNguyen> dsChienDich = cdColl.layDSChuaHetHan(
				new Date(2011, 05, 05));
		
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		
		for (ChienDichTinhNguyen chienDich : dsChienDich) {
			System.out.println(chienDich.getKtDangKy());
		/*
		ChienDichTinhNguyen chienDich = new ChienDichTinhNguyen();
		chienDich.setMaChienDich(5);
		chienDich.setDiaDiem("Xã Vĩnh Lộc A, Huyện Hồng Dân, Bạc Liêu");
		chienDich.setMucDich("Làm lộ bê tông chiều dài 120km");
		chienDich.setThoiGianBD(new Date(2017, 05, 13));
		chienDich.setThoiGianKT(new Date(2017, 05, 25));
		chienDich.setSoLuong(40);
		chienDich.setYeuCau("La Sinh vien truong dai hoc Can Tho");
		chienDich.setKeHoach("Chua co ke hoach cu the");
		chienDich.setBdDangKy(new Date(2017, 04, 13));
		chienDich.setKtDangKy(new Date(2017, 10, 20));
		
		cdColl.save(chienDich);
		*/
	}
	}
}
