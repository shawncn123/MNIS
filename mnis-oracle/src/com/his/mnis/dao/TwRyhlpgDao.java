package com.his.mnis.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.TwRyhlpg;

public class TwRyhlpgDao extends HibernateDaoSupport {
	
	public void updateTwRyhlpg(TwRyhlpg twRyhlpg){
		this.getHibernateTemplate().saveOrUpdate(twRyhlpg);
	}

}
