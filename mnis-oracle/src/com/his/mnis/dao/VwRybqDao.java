package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.his.mnis.entities.VwRybq;

public class VwRybqDao extends BaseDao {
	/*
	 * 根据操作员ID 列出相对应病区
	 */
	public List<VwRybq> getListBingQu(String caoZyId){
		String hql="from VwRybq where id=:id";
		Query query = getSession().createQuery(hql);
		query.setString("id", caoZyId);
		return query.list();
	}
	
	/*
	 * 根据操作员id，获取缺省病区
	 */
	public VwRybq getDefaultBingQuByCaozyId(String caoZyId){
		String hql = "from VwRybq where id = :id and defualtflag = 1";
		Query query = getSession().createQuery(hql);
		query.setString("id", caoZyId);
		return (VwRybq) query.uniqueResult();
	}
	/*
	 * 根据操作员代码(登录的操作员代码)，获取人员id
	 */
	public VwRybq getRenYuanIdByCaozyDaiMa(String caoZuoYuanDaiMa){
		String hql = "from VwRybq where rydm = :rydm";
		Query query = getSession().createQuery(hql);
		query.setString("rydm", caoZuoYuanDaiMa);
		query.setMaxResults(1);
		return (VwRybq) query.uniqueResult();
	}
	/*
	 * 根据病区id获取病区名称
	 */
	public String getBingQuMingCheng(String bqid){
		String hql = "from VwRybq where bq=:bqid";
		Query query = getSession().createQuery(hql);
		query.setString("bqid", bqid);
		query.setMaxResults(1);
		VwRybq vwRybq = (VwRybq) query.uniqueResult();
		return vwRybq.getBqmc();
	}
}
