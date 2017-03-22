package mongodb;

import java.util.ArrayList;
import java.util.List;

import model.User;

import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;

public class UsersCollection {
	private MongoDatabase db;
	private MongoCollection<Document> userColl;
	
	public static final String USER_COLL_NAME = "Users";
	
	public UsersCollection() {
		switchToDB();
		createUserCollIfNotExist();
	}
	
	public static void main(String[] args) {
		UsersCollection userColl = new UsersCollection();
		
		// create new user
		User user = new User("B1304568", "12345", 3);
		
		// Save user to db
		// userColl.saveUser(user);
		
		// Get password user:
		System.out.println(userColl.getPasswordByUserName(user.getUserName()));
		
		List<User> userList = userColl.getAllUser();
		for (User user2 : userList) {
			System.out.printf("%s - %s - %d\n", user2.getUserName(), user2.getPassword(), user2.getRole());
		}
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
	 * Ham tao ra collection User. <br>
	 * Neu User collection chua ton tai -> create new <br>
	 * Nguoc lai -> switch to User collection
	 */
	public void createUserCollIfNotExist() {
		// Lay danh sach Collections:
		MongoIterable<String> collectionNames = db.listCollectionNames();
		
		// Kiem tra collection co trong danh sach ko?
		for (String collName : collectionNames) {
			
			// Neu co : getCollection
			if (USER_COLL_NAME.equalsIgnoreCase(collName)) {
				userColl = db.getCollection(USER_COLL_NAME);
				
				return; // Thoat khoi ham
			}
		}
		
		// Neu chua : create new collection + set unique key for userName
		db.createCollection(USER_COLL_NAME);
		userColl = db.getCollection(USER_COLL_NAME);
		
		// Set unique key for userName
		IndexOptions uniqueIndex = new IndexOptions().unique(true);
		userColl.createIndex(Indexes.text("userName"), uniqueIndex);
	}
	
	/**
	 * Ham insert 1 user vao CSDL. (Note: Phai xu ly Exception)
	 * @param user : User (model)
	 * @throws DuplicateKeyException
	 */
	public void saveUser(User user) throws DuplicateKeyException {
		// Tao Document de luu tru key va value
		Document document = new Document();
		
		// Dua du lieu voi key va value vao docment
		document.append("userName", user.getUserName());
		document.append("password", user.getPassword());
		document.append("role", user.getRole());
		
		// Insert vao mongodb
		userColl.insertOne(document);
	}
	
	/**
	 * Ham tra ra 1 List User co trong CSDL 
	 * @return userList : List<User> || NULL : neu Collection ko ton tai hoac rong
	 */
	public List<User> getAllUser() {
		FindIterable<Document> documentList = userColl.find();
		List<User> userList = new ArrayList<User>();
		
		// Convert form FindIterable<Document> to List<User> ... 
		for (Document document : documentList) {
			User user = new User(document.getString("userName"),
					document.getString("password"),
					document.getInteger("role"));
			userList.add(user);
		} // ... end convert
		
		return userList;
	}
	
	/**
	 * Ham lay password cua 1 User voi tham so truyen vao la userName
	 * @param userName : String
	 * @return password : String || NULL : Neu User ko ton tai 
	 */
	public String getPasswordByUserName(String userName) {
		/*
		 * Tao Filter de tim kiem User theo userName
		 * Khoi tao Document de luu User vua tim duoc
		 * */
		FindIterable<Document> user = userColl.find(Filters.text(userName));
		
		// Tra ra password cua user
		return user.first().getString("password");
	}
	
	/**
	 * Ham lay ra 1 User tu tham so truyen vao la userName
	 * @param userName
	 * @return NULL || User : neu user ton tai
	 */
	public User getUserByUserName(String userName) {
		/*
		 * Tao Filter de tim kiem User theo userName
		 * Khoi tao Document de luu User vua tim duoc
		 * */
		FindIterable<Document> user = userColl.find(Filters.text(userName));
		Document doc = user.first();
		
		return doc.isEmpty() ? null : 			// if doc rong -> return NULL
			new User(doc.getString("userName"), // else -> return new User (convert from doc)
				doc.getString("password"), 
				doc.getInteger("role"));
	}
	
	/**
	 * Ham xoa collection User
	 * @throws NullPointerException
	 */
	public void dropCollection() throws NullPointerException{
		userColl.drop();
	}
	
}
