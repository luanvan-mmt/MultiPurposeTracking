package com.dev.mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.dev.model.SIPAccount;
import com.dev.mongodb.utils.CollectionManager;
import com.mongodb.DuplicateKeyException;
import com.mongodb.client.model.Filters;

public class SIPAccountColl extends CollectionManager<SIPAccount> {

	public SIPAccountColl() {
		super();
		createCollIfNotExist("sipaccount", "userName");
	}

	@Override
	public void save(SIPAccount obj) throws DuplicateKeyException {
		Document doc = new Document("userName", obj.getUserName());
		doc.append("password", obj.getPassword());
		doc.append("active", obj.isActive());

		collection.insertOne(doc);
	}

	@Override
	public List<SIPAccount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SIPAccount getByFieldName(String fieldName, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SIPAccount obj) {
		Document newDoc = new Document("password", obj.getPassword());
		newDoc.append("active", obj.isActive());

		collection.updateOne(Filters.eq("userName", obj.getUserName()),
				new Document("$set", newDoc));
	}

	public SIPAccount getInactiveAccount() {
		// Lay ra Account dau tien co trang thai active = false
		Document doc = collection.findOneAndUpdate(Filters.eq("active", false),
				new Document("$set", new Document("active", true)));

		// Tra ra account
		return new SIPAccount(doc.getString("userName"), 
				doc.getString("password"), 
				doc.getBoolean("active"));
	}

	// Chi chay voi ham main:
	public void saveMany() {
		List<Document> docs = new ArrayList<Document>();

		for (int i = 1; i <= 20; i++) {
			Document doc = new Document("userName", "user" + i);
			doc.append("password", "user" + i + "user" + i);
			doc.append("active", false);

			docs.add(doc);
		}

		collection.insertMany(docs);
	}

	public static void main(String[] args) {
		SIPAccountColl a = new SIPAccountColl();
		 a.saveMany();

		// a.update(new SIPAccount("user1", "user1user1", false));
		// System.out.println(a.getInactiveAccount().getUserName());
	}

}
