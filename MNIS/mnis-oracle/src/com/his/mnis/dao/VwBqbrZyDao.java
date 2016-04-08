package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VwBqbrZy;

public class VwBqbrZyDao extends BaseDao {

	private String bqid;

	public String getBqid() {
		return bqid;
	}

	public void setBqid(String bqid) {
		this.bqid = bqid;
	}
	
	public List<VwBqbrZy> getListVwBqbrZyByBqid(String bqid){
		String hql = "from VwBqbrZy where bq = :bq";
		Query query = getSession().createQuery(hql);
		query.setString("bq",bqid);
		return query.list();
	}
}
