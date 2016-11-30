package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.TwHulijlbiaoZd1;

public class TwHulijlbiaoZd1Dao extends BaseDao {

	public List<TwHulijlbiaoZd1> getListTwHulijlbiaoZd1(int bbfl){
		String hql = "from TwHulijlbiaoZd1 where bbfl=:bbfl order by id";
		Query query = getSession().createQuery(hql);
		query.setInteger("bbfl", bbfl);
		return query.list();
	}
}
