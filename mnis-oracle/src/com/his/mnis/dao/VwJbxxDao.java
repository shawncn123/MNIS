package com.his.mnis.dao;

import org.hibernate.Query;

import com.his.mnis.entities.VwJbxx;

public class VwJbxxDao extends BaseDao {
	
	/*
	 * 根据key1,key2查病人基本信息
	 */
	
	public VwJbxx getBingRenJiBenXxByKey(Long key1,Integer key2){
		String hql = "from VwJbxx where key1=:key1 and key2=:key2";
		Query query = getSession().createQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		return (VwJbxx) query.uniqueResult();
	}

}
