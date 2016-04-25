package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.TwZd;

public class TwZdDao extends BaseDao {

	public List<TwZd> getListTwZd(){
		
		String hql = "from TwZd order by sxh";
		
		Query query = getSession().createQuery(hql);
		
		return query.list();
		
	}
	
}
