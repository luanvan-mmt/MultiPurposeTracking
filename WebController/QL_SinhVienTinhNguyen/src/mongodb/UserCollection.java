package mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import model.User;

public class UserCollection extends CollectionManager<User> {
	
	private final String collName = "users";
	
	public UserCollection() {
		super();
		createCollIfNotExist(collName, "userName");
	}

	@Override
	public void save(User obj) throws DuplicateKeyException {
		Document doc = new Document("userName", obj.getUserName());
		doc.append("password", obj.getPassword());
		doc.append("role", obj.getRole());
		
		collection.insertOne(doc);
	}

	@Override
	public List<User> getAll() {
		FindIterable<Document> docs = collection.find();
		List<User> userList = new ArrayList<User>();
		
		for (Document doc : docs) {
			userList.add(new User(doc.getString("userName"),
					doc.getString("password"), 
					doc.getInteger("role")));
		}
		
		return userList;
	}

	@Override
	public User getByFieldName(String fieldName, String value) {
		FindIterable<Document> docs = collection.find(Filters.eq(fieldName, value));
		Document doc = docs.first();
		
		return doc.isEmpty() ? null :
			new User(doc.getString("userName"),
					doc.getString("password"), 
					doc.getInteger("role"));
	}

	@Override
	public void update(User obj) {
		// TODO Auto-generated method stub
		
	}
	
	public String autoCreateUser(String id, int role) {
		// Khoi tao mat khau ngau nhien gom 8 ky tu
		String password = "@43kj32*";
		
		save(new User(id, password, role));
		
		return password;
	}

}
