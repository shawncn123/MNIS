package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VmBmry;

public class VmBmryDao extends BaseDao {

	public List<VmBmry> getBmById(Long czy_id) {
		System.out.println("bmDao");
		String hql = "from VmBmry e where e.czy_id=:czy_id order by e.czy_id desc";
		Query query = getSession().createQuery(hql);
		query.setLong("czy_id", czy_id);
//		query.setMaxResults(5);
		return query.list();
	}
	public List<VmBmry> test() {
		System.out.println("bmDao1");
		String hql = "from VmBmry";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(5);
		//query.setLong("czy_id", czy_id);
		return query.list();
	}

}
