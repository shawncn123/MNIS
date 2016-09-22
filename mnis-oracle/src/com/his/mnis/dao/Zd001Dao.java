package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.Zd001;

public class Zd001Dao extends BaseDao {
	
	public List<Zd001> getListYiZhuZXFL(){
		String hql = "from Zd001 where fl='Z1' order by sxh";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

}
