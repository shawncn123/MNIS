package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VwTzzdTwLx;

public class VwTzzdTwLxDao extends BaseDao {
	
	public List<VwTzzdTwLx> getListTwLx(){
		
		String hql = "from VwTzzdTwLx order by sxh";
		
		Query query = getSession().createQuery(hql);
		
		return query.list();
	}

}
