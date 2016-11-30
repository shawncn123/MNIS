package com.his.mnis.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.TwPeiyeczJilu;

public class TwBryzPeiYeDao  extends HibernateDaoSupport {

	/*
	 * 保存对象TwBryzzx
	 */
	public void updateTwPeiyeczJiluByTwPeiyeczJilu(TwPeiyeczJilu twPeiyeczJilu){
//		getSession().saveOrUpdate(twPeiyeczJilu);
		this.getHibernateTemplate().saveOrUpdate(twPeiyeczJilu);
	}
}
