package com.his.mnis.dao;

import java.util.Date;

import org.hibernate.Query;

import com.his.mnis.entities.TwTwdMess;

public class TwTwdMessDao extends BaseDao {
	
	private TwTwdMess twTwdMess;

	public TwTwdMess getTwTwdMess() {
		return twTwdMess;
	}

	public void setTwTwdMess(TwTwdMess twTwdMess) {
		this.twTwdMess = twTwdMess;
	}

	public Long getJlidByRiQiAndKey(Long vkey1,Integer vkey2,Integer vkey3,Date vrq){
		
		String hql = "select jlid from TwTwdMess where beginrq=:v_rq and key1=:v_key1 and key2=:v_key2 and yebh=:v_key3";
		Query query = getSession().createQuery(hql);
		query.setDate("v_rq", vrq);
		query.setLong("v_key1", vkey1);
		query.setInteger("v_key2", vkey2);
		query.setInteger("v_key3", vkey3);
		return  (Long) query.uniqueResult();		
	}
}
