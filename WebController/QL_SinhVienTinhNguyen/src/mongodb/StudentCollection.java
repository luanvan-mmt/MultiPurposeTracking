package mongodb;

import java.util.ArrayList;
import java.util.List;

import model.Student;

import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;

public class StudentCollection {
	private MongoDatabase db;
	private MongoCollection<Document> studentColl;
	
	public static final String STUDENT_COLL_NAME = "Student";
	
	public StudentCollection() {
		switchToDB();
		createStudentCollIfNotExist();
	}
	
	public static void main(String[] args) {
		
	}
	
	public void switchToDB() {
		db = DBManager.getDB();
	}
	
	/**
	 * Kiem tra Collection co ton tai hay chua
	 * @param collectionName
	 * @return TRUE : Collection da ton tai , FALSE : Collection chua ton tai
	 */
	public boolean checkCollectionExist(String collectionName) {
		// Lay danh sach Collections:
		MongoIterable<String> collectionNames = db.listCollectionNames();
		
		// Kiem tra collection cos trong danh sach ko?
		for (String collName : collectionNames) {
			
			//Neu co return true
			if(collectionName.equalsIgnoreCase(collName)) 
				return true;
		}
		
		// Neu khong co return false;
		return false;
	}
	
	/**
	 * Ham tao ra collection Student. <br>
	 * Neu User collection chua ton tai -> create new <br>
	 * Nguoc lai -> switch to Student collection
	 */
	public void createStudentCollIfNotExist() {
		// Lay danh sach Collections:
		MongoIterable<String> collectionNames = db.listCollectionNames();
		
		// Kiem tra collection co trong danh sach ko?
		for (String collName : collectionNames) {
			
			// Neu co : getCollection
			if (STUDENT_COLL_NAME.equalsIgnoreCase(collName)) {
				studentColl = db.getCollection(STUDENT_COLL_NAME);
				
				return; // Thoat khoi ham
			}
		}
		
		// Neu chua : create new collection + set unique key for userName
		db.createCollection(STUDENT_COLL_NAME);
		studentColl = db.getCollection(STUDENT_COLL_NAME);
		
		// Set unique key for studentId
		IndexOptions uniqueIndex = new IndexOptions().unique(true);
		studentColl.createIndex(Indexes.text("studentId"), uniqueIndex);
	}
	
	/**
	 * Ham insert 1 Student vao CSDL. (Note: Phai xu ly Exception)
	 * @param student : Student (model)
	 * @throws DuplicateKeyException
	 */
	public void saveUser(Student student) throws DuplicateKeyException {
		// Tao Document de luu tru key va value
		Document document = new Document();
		
		// Dua du lieu voi key va value vao docment
		document.append("studentId", student.getStudentId());
		document.append("fullName", student.getFullName());
		document.append("sex", student.getSex());
		document.append("phone", student.getPhone());
		document.append("address", student.getAddress());
		document.append("idNumber", student.getIdNumber());
		document.append("email", student.getEmail());
		document.append("classCode", student.getClassCode());
		// document.append("leader", student.isLeader());
		
		// Insert vao mongodb
		studentColl.insertOne(document);
	}
	
	/**
	 * Ham tra ra 1 List Student co trong CSDL 
	 * @return studentList : List<Student> || NULL : neu Collection ko ton tai hoac rong
	 */
	public List<Student> getAllStudent() {
		FindIterable<Document> documentList = studentColl.find();
		List<Student> sdtudentList = new ArrayList<Student>();
		
		// Convert form FindIterable<Document> to List<User> ... 
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
			sdtudentList.add(student);
		} // ... end convert
		
		return sdtudentList;
	}
	
	/**
	 * Ham lay ra 1 Student tu tham so truyen vao la studentId
	 * @param studentId
	 * @return NULL || Student : neu student ton tai
	 */
	public Student getUserByStudentId(String studentId) {
		/*
		 * Tao Filter de tim kiem User theo userName
		 * Khoi tao Document de luu User vua tim duoc
		 * */
		FindIterable<Document> student = studentColl.find(Filters.text(studentId));
		Document doc = student.first();
		
		return doc.isEmpty() ? null : 			// if doc rong -> return NULL
			// else -> return new User (convert from doc)
			new Student(doc.getString("studentId"),
					doc.getString("fullName"),
					doc.getString("sex"),
					doc.getString("phone"),
					doc.getString("address"),
					doc.getString("idNumber"),
					doc.getString("email"),
					doc.getString("classCode")
					);
	}
	
	/**
	 * Ham xoa collection Student
	 * @throws NullPointerException
	 */
	public void dropCollection() throws NullPointerException{
		studentColl.drop();
	}
}
