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
		String hql = "from VwBqbrZy where bq = :bq order by jcflag,chw";
		Query query = getSession().createQuery(hql);
		query.setString("bq",bqid);
		return query.list();
	}
	
	/*
	 * 根据key1，key2 查询病人个体信息
	 */
	public VwBqbrZy getBingRenXingXiByKey(Long key1,Integer key2){
		String hql = "from VwBqbrZy where key1=:key1 and key2=:key2";
		Query query = getSession().createQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		return (VwBqbrZy) query.uniqueResult();
	}
}
