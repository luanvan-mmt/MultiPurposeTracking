package com.dev.mongodb.utils;

import com.dev.services.Parameters;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

public class DBManager {

	private static MongoClient mongoClient;
	private static MongoDatabase db;

	// Auto connect to MongoDB when call to DBManager Class
	static {
		try {
			mongoClient = new MongoClient(Parameters.MONGODB_HOST, Parameters.MONGODB_PORT);
			
			db = mongoClient.getDatabase(Parameters.MONGODB_DBNAME);

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
