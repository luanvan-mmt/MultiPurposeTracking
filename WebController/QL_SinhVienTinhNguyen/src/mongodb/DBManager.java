package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;


public class DBManager {
	
	public static final String HOST = "127.0.0.1";
	public static final int PORT = 27017;
	// private static final String DB_USERNAME = "";
	// private static final String DB_PASSWORD = "";
	
	private static MongoClient mongoClient;
	private static MongoDatabase db;
	
	// Auto connect to MongoDB when call to DBManager Class
	static {
		try {
			mongoClient = new MongoClient(HOST, PORT);
			db = mongoClient.getDatabase("kaa");
			System.out.println("Connected to MongoDB");
		} catch (MongoException e) {
			System.out.println("Connect to MongoDB failed! " + e.getMessage());
		}
	}
	
	public static MongoClient getMongoClient() {
		return mongoClient;
	}
	
	public static MongoDatabase getDB() {
		return db;
	}
	
	public static void closeConnection() {
		mongoClient.close();
	}

}
