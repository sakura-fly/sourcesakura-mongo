package com.mongo.model;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class Mongodb {
	protected MongoClient mongoClient;
	protected MongoDatabase dbConn;
	protected MongoCollection<Document> dc;

	protected Document sortDoc = new Document();
	protected int limitNum = 0;
	protected int skipNum = 0;

	protected Document query = new Document();
	protected Document updateFilter = new Document();
	protected Document updateDoc = new Document();
	protected Document insertDocument = new Document();

	public Document getInsertDocument() {
		return insertDocument;
	}

	public void setInsertDocument(Document insertDocument) {
		this.insertDocument = insertDocument;
	}

	public Document getUpdateFilter() {
		return updateFilter;
	}

	public void setUpdateFilter(Document updateFilter) {
		this.updateFilter = updateFilter;
	}

	protected String dbHost;
	protected String dbName;
	protected int DbPort;
	protected String connName;

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public String getDbHost() {
		return dbHost;
	}

	public String getDbName() {
		return dbName;
	}

	public int getDbPort() {
		return DbPort;
	}

	public String getConnName() {
		return connName;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public MongoDatabase getDbConn() {
		return dbConn;
	}

	public void setDbConn(MongoDatabase dbConn) {
		this.dbConn = dbConn;
	}

	public MongoCollection<Document> getDc() {
		return dc;
	}

	public void setDc(MongoCollection<Document> dc) {
		this.dc = dc;
	}

	public Document getQuery() {
		return query;
	}

	public void setQuery(Document query) {
		this.query = query;
	}

	public int getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}

	public int getSkipNum() {
		return skipNum;
	}

	public void setSkipNum(int skipNum) {
		this.skipNum = skipNum;
	}

	public Document getSortDoc() {
		return sortDoc;
	}
	
	
	//连接数据库
	public int linkDb(String dbHost, int dbport){
		int res = -1;
		try {
			mongoClient = new MongoClient(dbHost, dbport);
			Builder mco = MongoClientOptions.builder();
			mco.connectTimeout(2 * 1000);
			mco.socketTimeout(2 * 1000);
			mco.build();
			res = 1;
			this.dbHost = dbHost;
			this.DbPort = dbport;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	//设置数据库
	public void setDatabase(String dbName){
		dbConn = mongoClient.getDatabase(dbName);
		this.dbName = dbName;
	}
	
	
	//设置集合
	public void setCollection(String connName){
		dc = dbConn.getCollection(connName);
		this.connName = connName;
	}

	
	
	//清除查询条件
	public void clearQuery() {
		query.clear();
	}
	
	//清除添加文档
	public void clearInsertDocument(){
		insertDocument.clear();
	}

	//关闭数据库
	public void close() {
		if (mongoClient != null)
			mongoClient.close();
	}
	
	@Override
	public String toString() {
		return "host:" + dbHost + ",dbport:" + DbPort + ",dbName:" + dbName + ",conn:" + connName;
	}
	
	public abstract void putSortDoc(String key, Object value);//查询顺序

	public abstract void putQuery(String key, int value);//填查询条件

	public abstract void putFuzzyQuery(String key, String value);//模糊查询

	public abstract void putUpdateDoc(String key, Object value);//填修改内容
	
	public abstract void pushUpdateFilter(String UpdateSym);//将修改内容
	
	public abstract void putInsertDocument(String key, Object value);//填添加文档

}
