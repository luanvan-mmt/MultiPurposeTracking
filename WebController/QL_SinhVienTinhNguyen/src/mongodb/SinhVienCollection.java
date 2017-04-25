package mongodb;

import java.util.ArrayList;
import java.util.List;

import model.SinhVien;

import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

public class SinhVienCollection extends CollectionManager<SinhVien> {
	private final String collName = "sinhvien";
	
	public SinhVienCollection() {
		super();
		createCollIfNotExist(collName, "mssv");
	}

	@Override
	public List<SinhVien> getAll() {
		FindIterable<Document> documentList = collection.find();
		List<SinhVien> studentList = new ArrayList<SinhVien>();
		
		// Convert form FindIterable<Document> to List<Student> ... 
		for (Document document : documentList) {
			SinhVien student = new SinhVien(document.getString("mssv"),
					document.getString("hoTen"),
					document.getString("gioiTinh"),
					document.getString("sdt"),
					document.getString("diaChi"),
					document.getString("cmnd"),
					document.getString("email"),
					document.getString("maLop")
					);
			studentList.add(student);
		} // ... end convert
		
		return studentList;
	}

	@Override
	public SinhVien getByFieldName(String fieldName, String value) {
		/*
		 * Tao Filter de tim kiem User theo userName
		 * Khoi tao Document de luu User vua tim duoc
		 * */
		FindIterable<Document> student = collection.find(Filters.eq(fieldName, value));
		Document document = student.first();
		
		return document.isEmpty() ? null : 			// if doc rong -> return NULL
			new SinhVien(document.getString("mssv"),
					document.getString("hoTen"),
					document.getString("gioiTinh"),
					document.getString("sdt"),
					document.getString("diaChi"),
					document.getString("cmnd"),
					document.getString("email"),
					document.getString("maLop")
					);
	}
	
	@Override
	public void save(SinhVien obj) throws DuplicateKeyException {
		
		// Tao Document de luu tru Doi tuong
		Document document = new Document();
		
		// Dua du lieu voi key va value vao docment
		document.append("studentId", obj.getMssv());
		document.append("fullName", obj.getHoTen());
		document.append("sex", obj.getGioiTinh());
		document.append("phone", obj.getSdt());
		document.append("address", obj.getDiaChi());
		document.append("idNumber", obj.getCmnd());
		document.append("email", obj.getEmail());
		document.append("classCode", obj.getMaLop());
		// document.append("leader", student.isLeader());
		
		// Insert vao mongodb
		collection.insertOne(document);
		
	}

	@Override
	public void update(SinhVien obj) {
		// TODO Auto-generated method stub
		
	}
	
}
