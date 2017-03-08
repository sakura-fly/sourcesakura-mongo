package com.mongo.dao.impl;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

public interface DbFindBody {
	public ArrayList<String> findBody(MongoCursor<Document> coursor); 
}
