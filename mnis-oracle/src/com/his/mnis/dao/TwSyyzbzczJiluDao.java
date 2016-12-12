package com.his.mnis.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.TwSyyzbzczJilu;

public class TwSyyzbzczJiluDao extends HibernateDaoSupport {
	
	public void updateTwSyyzbzczJilu(TwSyyzbzczJilu twSyyzbzczJilu){
		this.getHibernateTemplate().saveOrUpdate(twSyyzbzczJilu);
	}

}
