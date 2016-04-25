package com.his.mnis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VwHy101;

public class VwHy101Dao extends BaseDao {
	/*
	 * 根据病人key值查询病人的化验单主表信息
	 */
	public List<VwHy101> getListBingRenHuaYanByKey(Long key1,Integer key2,Short key3){
		
		String hql  = "from VwHy101 where key1=:key1 and key2=:key2 and yebh=:key3 order by sqrq,sqdh";
		Query query = getSession().createQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		query.setShort("key3", key3);
		return query.list();
	}
	/*
	 * 根据申请医生ID,病人Key查询病人的化验单主表信息
	 */
	public List<VwHy101> getListHuaYanDanByShenqysAndKey(String sqysid,Long key1,Integer key2,Short key3){
		
		String hql = "from VwHy101 where sqysid=:sqysid and key1=:key1 and key2=:key2 and yebh=:key3 order by sqrq,sqdh";
		Query query = getSession().createQuery(hql);
		query.setString("sqysid", sqysid);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		query.setShort("key3", key3);
		return query.list();
	}
	/*
	 * 根据时间段,病人Key查询病人的化验单主表信息
	 */
	public List<VwHy101> getListBingRenHuaYanByDate(Date sqrq1,Date sqrq2,Long key1,Integer key2,Short key3){
		
		String hql = "from VwHy101 where sqrq >=:sqrq1 and sqrq <= :sqrq2 and key1=:key1 and key2=:key2 and yebh=:key3 order by sqrq,sqdh";
		Query query = getSession().createQuery(hql);
		query.setDate("sqrq1", sqrq1);
		query.setDate("sqrq2", sqrq2);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		query.setShort("key3", key3);
		return query.list();
	}
}
