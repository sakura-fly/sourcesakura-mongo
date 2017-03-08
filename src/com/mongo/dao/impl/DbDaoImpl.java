package com.mongo.dao.impl;

import java.util.ArrayList;

import com.mongo.model.Mongodb;

public abstract class DbDaoImpl {
	
	public DbFindBody dfb = null;
	
	
	public void setDfb(DbFindBody dfb) {
		this.dfb = dfb;
	}

	public abstract int insert(Mongodb mdb);//��

	public abstract int delOne(Mongodb mdb);//ɾ
	
	public abstract int delMany(Mongodb mdb);

	public abstract long update(Mongodb mdb);//��
	
	public abstract ArrayList<String> find(Mongodb mdb);//��
	

}
