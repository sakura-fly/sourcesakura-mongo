package com.mongo.model;

import java.util.regex.Pattern;

public class MongodbModel extends Mongodb{
	
	public MongodbModel() {
		                       
	}
	
	public MongodbModel(String dbHost, int dbport) {
		linkDb(dbHost, dbport);
	}
	
	public MongodbModel(String dbHost, int dbport,String dbName) {
		linkDb(dbHost, dbport);
		setDatabase(dbName);
	}
	
	public MongodbModel(String dbHost, int dbport,String dbName, String connName) {
		linkDb(dbHost, dbport);
		setDatabase(dbName);
		setCollection(connName);
	}
	
	
	

	@Override
	public void putSortDoc(String key, Object value) {
		sortDoc.put(key, value);
	}

	@Override
	public void putQuery(String key, int value) {
		query.put(key, value);
	}

	@Override
	public void putFuzzyQuery(String key, String value) {
		Pattern pattern = Pattern.compile("^.*" + value + ".*$",Pattern.CASE_INSENSITIVE);
		query.put(key, pattern);
	}

	@Override
	public void putUpdateDoc(String key, Object value) {
		updateDoc.put(key, value);
	}

	@Override
	public void pushUpdateFilter(String UpdateSym) {
		updateFilter.put(UpdateSym, updateDoc);
	}

	@Override
	public void putInsertDocument(String key, Object value) {
		insertDocument.put(key, value);
	}

}
