package com.dev.mongodb.utils;

import java.util.List;

import org.bson.Document;

import com.mongodb.DuplicateKeyException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;

public abstract class CollectionManager1<T> {
	
	protected MongoDatabase db;
	protected MongoCollection<Document> collection;
	
	public CollectionManager1() {
		switchToDB();
		// createCollIfNotExist();
	}
	
	// CAC HAM CAN DINH NGHIA LAI .................
	
	/**
	 * Ham chuyen doi tu mot doi tuong sang Document
	 * 
	 * @param obj
	 * @return
	 */
	abstract public Document convertToDocument(T obj);
	
	abstract public T convertToObject(Document doc);
	
	// ...... CAC HAM CAN DINH NGHIA LAI
	
	/**
	 * Ham insert 1 Document (Object) vao CSDL. (Note: Phai xu ly Exception)
	 * @param obj : Object (model)
	 * @throws DuplicateKeyException
	 */
	public void save(T obj) throws DuplicateKeyException {
		
		// Chuyen obj thanh Document va insert vao Mongodb
		collection.insertOne(convertToDocument(obj));
	}
	
	/**
	 * Ham tra ra 1 List Docments co trong CSDL 
	 * @param <T>
	 * @return List<Object> || NULL : neu Collection ko ton tai hoac rong
	 */
	public List<T> getAll() {
		
		return null;
	}
	
	/**
	 * Ham lay ra 1 Object theo ten cot
	 * @param fieldName : Ten cot
	 * @param value	: Gia tri can tim
	 * @return Object 
	 */
	public T getByFieldName(String fieldName, String value) {
		System.out.println("Finding");
		
		FindIterable<Document> findIterable = collection.find(Filters.eq(
				fieldName, value));
		Document findDoc = findIterable.first();
		
		if(!findDoc.isEmpty())
			return convertToObject(findDoc);
		
		return null;
	}
	
	/**
	 * Ham cap nhat thong tin cua doi tuong trong CSDL 
	 * @param obj : model
	 */
	public void update(T obj){
		
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
	public void createCollIfNotExist(String collName, String uniqueKey) {
		// Lay danh sach Collections:
		MongoIterable<String> collectionNames = db.listCollectionNames();
		
		// Kiem tra collection co trong danh sach ko?
		for (String collectionName : collectionNames) {
			
			// Neu co : getCollection
			if (collName.equalsIgnoreCase(collectionName)) {
				collection = db.getCollection(collName);
				
				return; // Thoat khoi ham
			}
		}
		
		// Neu chua : create new collection + set unique key for userName
		db.createCollection(collName);
		collection = db.getCollection(collName);
		
		// Set unique key for studentId
		if(uniqueKey != null || !"".equals(uniqueKey)) { // Kiem tra uniqueKey khac rong hay khong
			IndexOptions uniqueIndex = new IndexOptions().unique(true);
			collection.createIndex(Indexes.text("studentId"), uniqueIndex);
		}
	}
	
	/**
	 * Ham xoa collection Student
	 * @throws NullPointerException
	 */
	public void dropCollection() throws NullPointerException{
		collection.drop();
	}
}
