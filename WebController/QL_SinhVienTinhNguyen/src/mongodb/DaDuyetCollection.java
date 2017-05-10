package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;

import model.DaDuyet;
import model.SinhVien;

public class DaDuyetCollection extends CollectionManager<DaDuyet>{
	
	private final String collName = "daduyet";

	public DaDuyetCollection() {
		super();
		createCollIfNotExist(collName, "mssv");
	}

	@Override
	public void save(DaDuyet obj) throws DuplicateKeyException {
		// Tao Document de luu tru Doi tuong
		Document document = new Document();
		
		// Dua du lieu voi key va value vao docment
		document.append("mssv", obj.getMssv());
		document.append("hoTen", obj.getHoTen());
		document.append("gioiTinh", obj.getGioiTinh());
		document.append("sdt", obj.getSdt());
		document.append("diaChi", obj.getDiaChi());
		document.append("cmnd", obj.getCmnd());
		document.append("email", obj.getEmail());
		document.append("maLop", obj.getMaLop());
		document.append("maChienDich", obj.getMaChienDich());
		
		// Insert vao mongodb
		collection.insertOne(document);
	}

	@Override
	public List<DaDuyet> getAll() {
		FindIterable<Document> documentList = collection.find();
		List<DaDuyet> studentList = new ArrayList<DaDuyet>();
		
		// Convert form FindIterable<Document> to List<Student> ... 
		for (Document document : documentList) {
			DaDuyet student = new DaDuyet(document.getString("mssv"),
					document.getString("hoTen"),
					document.getString("gioiTinh"),
					document.getString("sdt"),
					document.getString("diaChi"),
					document.getString("cmnd"),
					document.getString("email"),
					document.getString("maLop"),
					document.getString("maChienDich")
					);
			studentList.add(student);
		} // ... end convert
		
		return studentList;
	}

	@Override
	public DaDuyet getByFieldName(String fieldName, String value) {
		return null;
	}

	@Override
	public void update(DaDuyet obj) {
		
	}

}
