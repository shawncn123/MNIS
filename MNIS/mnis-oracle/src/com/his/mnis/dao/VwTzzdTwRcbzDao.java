package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VwTzzdTwRcbz;

public class VwTzzdTwRcbzDao extends BaseDao {

	public List<VwTzzdTwRcbz> getListVwTzzdTwRcbz(){
		String hql = "from VwTzzdTwRcbz order by sxh";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
}
