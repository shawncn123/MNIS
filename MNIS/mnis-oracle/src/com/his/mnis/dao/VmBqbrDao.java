package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VmBqbr;

public class VmBqbrDao extends BaseDao {
	
	private Long keshi_id;
	
	public void setKeshi_id(Long keshi_id) {
		this.keshi_id = keshi_id;
	}
	
	public List<VmBqbr> getBrByBmid(Long keshi_id){
		
		String hql = "from VmBqbr e where e.keshi_id = :keshi_id";
		
		Query query = getSession().createQuery(hql);
		query.setLong("keshi_id", keshi_id);
		return query.list();
	}

}
