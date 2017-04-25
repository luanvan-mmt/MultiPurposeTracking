package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import model.Staff;

public class StaffCollection extends CollectionManager<Staff>{
	
	private final String collName = "staff";
	
	public StaffCollection() {
		super();
		createCollIfNotExist(collName, "staffId");
	}

	@Override
	public void save(Staff obj) throws DuplicateKeyException {
		// Chuyen Staff thanh Document
		Document doc = new Document("staffId", obj.getStaffId());
		doc.append("fullName", obj.getFullName());
		doc.append("position", obj.getPosition());
		doc.append("sex", obj.getSex());
		doc.append("phone", obj.getPhone());
		doc.append("address", obj.getAddress());
		doc.append("idNumber", obj.getIdNumber());
		doc.append("email", obj.getEmail());
		
		// Inert vao CSDL
		collection.insertOne(doc);
	}

	@Override
	public List<Staff> getAll() {
		FindIterable<Document> docs = collection.find(); // Lay tat ca Document co trong CSDL
		List<Staff> staffList = new ArrayList<Staff>();
		
		for (Document doc : docs) { // Chuyen danh sach Document thanh List<Staff> ... 
			staffList.add(new Staff(
					doc.getString("staffId"),
					doc.getString("fullName"),
					doc.getString("position"),
					doc.getString("sex"),
					doc.getString("phone"),
					doc.getString("address"),
					doc.getString("idNumber"),
					doc.getString("email")
					));
		} // ... ket thuc chuyen
		
		return staffList;
	}

	@Override
	public Staff getByFieldName(String fieldName, String value) {
		// Tim Document theo dieu kien dat trong Filters, eq la so sanh =
		FindIterable<Document> docs = collection.find(Filters.eq(fieldName, value));
		Document doc = docs.first();
		
		return doc.isEmpty() ? null : // Neu Document rong thi return NULL
			new Staff(
					doc.getString("staffId"),
					doc.getString("fullName"),
					doc.getString("position"),
					doc.getString("sex"),
					doc.getString("phone"),
					doc.getString("address"),
					doc.getString("idNumber"),
					doc.getString("email")
					);
	}

	@Override
	public void update(Staff obj) {
		// TODO Auto-generated method stub
		
	}

}
