package com.his.mnis.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.his.mnis.entities.RybqDefault;
import com.his.mnis.entities.RybqDefault;

public class RyBqDefaultDao extends BaseDao {
	Query query = null;
	/*
	 *根据人员id查询上次登录的病区id 
	 */
	public RybqDefault getRyBqDefaultById(String id){
		String hql = "from RybqDefault where ryid=:ryid";
		query = getSession().createQuery(hql);
		query.setString("ryid", id);
		return (RybqDefault) query.uniqueResult();
	}
	/*
	 * 修改缺省的病区ID
	 */
	public void updateRyBqDefaultById(String id,String bqid){
		
		String hql = "from RybqDefault where ryid=:ryid";
		query = getSession().createQuery(hql);
		query.setString("ryid", id);
		RybqDefault rybqDefault = (RybqDefault) query.uniqueResult();
		if( rybqDefault != null){
			String hql1 = "update RybqDefault set bq =:bqid where ryid=:ryid";
			query = getSession().createQuery(hql1);
			query.setString("bqid", bqid);
			query.setString("ryid", id);
			query.executeUpdate();
		}else{
			String hql2 = "insert into RybqDefault(ryid,bq) values(:ryid,:bqid)";
			query = getSession().createQuery(hql2);
			query.setString("ryid", id).setString("bqid", bqid);
			query.executeUpdate();
		}
	}
}
