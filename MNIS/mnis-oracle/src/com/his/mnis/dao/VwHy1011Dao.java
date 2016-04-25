package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VwHy1011;

public class VwHy1011Dao extends BaseDao {

	/*
	 * 根据申请单号查询病人相关化验从表信息
	 */
	public List<VwHy1011> getListBingrHuayChongb(String sqdh){
		
		String hql = "from VwHy1011 where sqdh = :sqdh";
		Query query = getSession().createQuery(hql);
		query.setString("sqdh", sqdh);
		return query.list();
		
	}
	
}
