package com.mongo.dao.impl;

import java.util.ArrayList;

import com.mongo.model.Mongodb;

public interface DbDaoImpl {
	
	
	public int insert(Mongodb mdb);//Ôö

	public int delOne(Mongodb mdb);//É¾
	
	public int delMany(Mongodb mdb);

	public long update(Mongodb mdb);//¸Ä
	
	public ArrayList<String> find(Mongodb mdb);//²é
	

}
