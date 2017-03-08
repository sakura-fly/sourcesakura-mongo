package com.mongo.dao.impl;

import java.util.ArrayList;

import com.mongo.model.Mongodb;

public abstract class DbDaoImpl {
	
	public DbFindBody dfb = null;
	
	
	public void setDfb(DbFindBody dfb) {
		this.dfb = dfb;
	}

	public abstract int insert(Mongodb mdb);//增

	public abstract int delOne(Mongodb mdb);//删
	
	public abstract int delMany(Mongodb mdb);//删除多个

	public abstract long update(Mongodb mdb);//改
	
	public abstract ArrayList<String> find(Mongodb mdb);//查
	

}
