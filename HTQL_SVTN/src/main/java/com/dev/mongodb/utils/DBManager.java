package com.dev.mongodb.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

public class DBManager {

	private static MongoClient mongoClient;
	private static MongoDatabase db;

	// Auto connect to MongoDB when call to DBManager Class
	static {
		try {
			mongoClient = new MongoClient("127.0.0.1", 27017);

			db = mongoClient.getDatabase("svtn");

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
