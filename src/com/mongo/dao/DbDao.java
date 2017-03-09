package com.mongo.dao;

import java.util.ArrayList;

import net.sf.json.JSONObject;

import org.bson.Document;

import com.mongo.dao.impl.DbDaoImpl;
import com.mongo.dao.impl.DbFindBody;
import com.mongo.model.Mongodb;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;

public class DbDao extends DbDaoImpl implements DbFindBody{
	
	
	public DbDao() {
		dfb = this;
	}
	
	

	public int insert(Mongodb mdb) {
		int res = -1;
		try {
			mdb.getDc().insertOne(mdb.getInsertDocument());
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public int delOne(Mongodb mdb) {
		int res = -1;
		try {
			DeleteResult rr = mdb.getDc().deleteOne(mdb.getQuery());
			System.out.println("del res:" + rr);
			res = (int)rr.getDeletedCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public long update(Mongodb mdb) {
		long res = -1;
		try {
			res = mdb.getDc().updateOne(mdb.getQuery(), mdb.getUpdateFilter()).getMatchedCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public ArrayList<String> find(Mongodb mdb) {
		ArrayList<String> res = null;
		try {
			FindIterable<Document> itera = mdb.getDc().find(mdb.getQuery())
													  .sort(mdb.getSortDoc())
													  .skip(mdb.getSkipNum())
													  .limit(mdb.getLimitNum());
			MongoCursor<Document> coursor = itera.iterator();
			res = dfb.findBody(coursor);
		} catch (Exception e) {
			e.printStackTrace();
			res = new ArrayList<String>();
		}
		return res;
	}

	public long delMany(Mongodb mdb) {
		long res = -1;
		try {
			DeleteResult rr = mdb.getDc().deleteOne(mdb.getQuery());
			res = rr.getDeletedCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public ArrayList<String> findBody(MongoCursor<Document> coursor) {
		ArrayList<String> res = new ArrayList<String>();
		while(coursor.hasNext()){
			Document doc = coursor.next();
			JSONObject r = JSONObject.fromObject(doc);
			r.put("_id", doc.get("_id").toString());
			res.add(r.toString());
		}
		return res;
	}



	@Override
	public long count(Mongodb mdb) {
		return mdb.getDc().count(mdb.getQuery());
	}


}
