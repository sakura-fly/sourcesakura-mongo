package com.mongo.dao.impl;

import java.util.ArrayList;

import com.mongo.model.Mongodb;

public interface DbDaoImpl {
	
	
	public int insert(Mongodb mdb);//��

	public int delOne(Mongodb mdb);//ɾ
	
	public int delMany(Mongodb mdb);

	public long update(Mongodb mdb);//��
	
	public ArrayList<String> find(Mongodb mdb);//��
	

}
