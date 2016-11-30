package com.his.mnis.dao;

import org.hibernate.Query;

import com.his.mnis.entities.VwRyhlpg;

public class VwRyhlpgDao extends BaseDao {

	/*
	 * 根据key1 key2 查询病人护理评估一般信息
	 */
	 public VwRyhlpg getVwRyhlpgByKey1Key2(Long key1,Integer key2){
		 String hql = "from VwRyhlpg where key1=:key1 and key2=:key2";
		 Query query = getSession().createQuery(hql);
		 query.setLong("key1", key1);
		 query.setInteger("key2", key2);
		 VwRyhlpg vwRyhlpg = (VwRyhlpg) query.uniqueResult();
		 return vwRyhlpg;
	 }
}
