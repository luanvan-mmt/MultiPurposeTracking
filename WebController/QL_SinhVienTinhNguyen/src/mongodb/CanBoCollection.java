package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import model.CanBo;

public class CanBoCollection extends CollectionManager<CanBo>{
	
	private final String collName = "canbo";
	
	public CanBoCollection() {
		super();
		createCollIfNotExist(collName, "mscb");
	}

	@Override
	public void save(CanBo obj) throws DuplicateKeyException {
		// Chuyen Staff thanh Document
		Document doc = new Document("mscb", obj.getMscb());
		doc.append("hoTen", obj.getHoTen());
		doc.append("chucVu", obj.getChucVu());
		doc.append("gioiTinh", obj.getGioiTinh());
		doc.append("sdt", obj.getSdt());
		doc.append("diaChi", obj.getDiaChi());
		doc.append("cmnd", obj.getCmnd());
		doc.append("email", obj.getEmail());
		
		// Inert vao CSDL
		collection.insertOne(doc);
	}

	@Override
	public List<CanBo> getAll() {
		FindIterable<Document> docs = collection.find(); // Lay tat ca Document co trong CSDL
		List<CanBo> staffList = new ArrayList<CanBo>();
		
		for (Document doc : docs) { // Chuyen danh sach Document thanh List<Staff> ... 
			staffList.add(new CanBo(
					doc.getString("mscb"),
					doc.getString("hoTen"),
					doc.getString("chucVu"),
					doc.getString("gioiTinh"),
					doc.getString("sdt"),
					doc.getString("diaChi"),
					doc.getString("cmnd"),
					doc.getString("email")
					));
		} // ... ket thuc chuyen
		
		return staffList;
	}

	@Override
	public CanBo getByFieldName(String fieldName, String value) {
		// Tim Document theo dieu kien dat trong Filters, eq la so sanh =
		FindIterable<Document> docs = collection.find(Filters.eq(fieldName, value));
		Document doc = docs.first();
		
		return doc.isEmpty() ? null : // Neu Document rong thi return NULL
			new CanBo(
					doc.getString("mscb"),
					doc.getString("hoTen"),
					doc.getString("chucVu"),
					doc.getString("gioiTinh"),
					doc.getString("sdt"),
					doc.getString("diaChi"),
					doc.getString("cmnd"),
					doc.getString("email")
					);
	}

	@Override
	public void update(CanBo obj) {
		// TODO Auto-generated method stub
		
	}

}
