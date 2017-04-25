package mongodb;

import java.util.ArrayList;
import java.util.List;

import model.Student;

import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

public class StudentCollection extends CollectionManager<Student> {
	private final String collName = "student";
	
	public StudentCollection() {
		super();
		createCollIfNotExist(collName, "studentId");
	}

	@Override
	public List<Student> getAll() {
		FindIterable<Document> documentList = collection.find();
		List<Student> studentList = new ArrayList<Student>();
		
		// Convert form FindIterable<Document> to List<Student> ... 
		for (Document document : documentList) {
			Student student = new Student(document.getString("studentId"),
					document.getString("fullName"),
					document.getString("sex"),
					document.getString("phone"),
					document.getString("address"),
					document.getString("idNumber"),
					document.getString("email"),
					document.getString("classCode")
					);
			studentList.add(student);
		} // ... end convert
		
		return studentList;
	}

	@Override
	public Student getByFieldName(String fieldName, String value) {
		/*
		 * Tao Filter de tim kiem User theo userName
		 * Khoi tao Document de luu User vua tim duoc
		 * */
		FindIterable<Document> student = collection.find(Filters.eq(fieldName, value));
		Document doc = student.first();
		
		return doc.isEmpty() ? null : 			// if doc rong -> return NULL
			new Student(doc.getString("studentId"), // else -> return new User (convert from doc)
					doc.getString("fullName"),
					doc.getString("sex"),
					doc.getString("phone"),
					doc.getString("address"),
					doc.getString("idNumber"),
					doc.getString("email"),
					doc.getString("classCode")
					);
	}
	
	public static void main(String[] args) {
		StudentCollection a = new StudentCollection();
		System.out.println(a.getByFieldName("studentId", "B1304567").getFullName());
	}

	@Override
	public void save(Student obj) throws DuplicateKeyException {
		
		// Tao Document de luu tru Doi tuong
		Document document = new Document();
		
		// Dua du lieu voi key va value vao docment
		document.append("studentId", obj.getStudentId());
		document.append("fullName", obj.getFullName());
		document.append("sex", obj.getSex());
		document.append("phone", obj.getPhone());
		document.append("address", obj.getAddress());
		document.append("idNumber", obj.getIdNumber());
		document.append("email", obj.getEmail());
		document.append("classCode", obj.getClassCode());
		// document.append("leader", student.isLeader());
		
		// Insert vao mongodb
		collection.insertOne(document);
		
	}

	@Override
	public void update(Student obj) {
		// TODO Auto-generated method stub
		
	}
	
}
