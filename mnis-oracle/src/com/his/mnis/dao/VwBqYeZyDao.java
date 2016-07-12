package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VwBqyeZy ;

public class VwBqYeZyDao extends BaseDao{

	/*
	 * 获取婴儿列表数据 by key
	 */
	public List<VwBqyeZy> getListBqYeByKey(long key1,int key2){
		String hql = "from VwBqyeZy where key1=:key1 and key2=:key2 order by yebh";
		Query query = getSession().createQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		return query.list();
	}
}
