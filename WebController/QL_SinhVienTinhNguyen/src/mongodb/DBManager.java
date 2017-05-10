package mongodb;

import services.Properties;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

public class DBManager {

	private static MongoClient mongoClient;
	private static MongoDatabase db;

	// Auto connect to MongoDB when call to DBManager Class
	static {
		try {
			System.out.println(Properties.prop.getProperty("mongodb-host"));
			
			mongoClient = new MongoClient(
					Properties.prop.getProperty("mongodb-host"),
					Integer.parseInt(Properties.prop
							.getProperty("mongodb-port")));
			
			db = mongoClient.getDatabase(Properties.prop
					.getProperty("mongodb-host"));

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
