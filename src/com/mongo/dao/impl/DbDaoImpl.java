package com.mongo.dao.impl;

import com.mongo.model.Mongodb;

public interface DbDaoImpl {
	
	public int insert(Mongodb mdb);//��

	public int del(Mongodb mdb);//ɾ

	public int update(Mongodb mdb);//��
	
	public int find(Mongodb mdb);//��

}
