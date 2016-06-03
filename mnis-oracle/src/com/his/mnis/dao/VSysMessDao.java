package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VSysMessReader;

public class VSysMessDao extends BaseDao {

	/*
	 * 根据参数用户id，第几页、每页行数 查询消息记录
	 */
	public List<VSysMessReader> getListSysMessByRenyId(String renyid,int pageno,int pagerows){
		String hql = "from VSysMessReader where ryid=:ryid";
		Query query = getSession().createQuery(hql);
		query.setString("ryid", renyid);
		int beginrow = (pageno-1)*pagerows;
		query.setFirstResult(beginrow);
		query.setMaxResults(pagerows);
		return query.list();
	}
	/*
	 * 根据参数用户id，第几页、每页行数, 已读未读参数状态 查询消息记录
	 */
	public List<VSysMessReader> getListSysMessByRenyIdZhuangt(String renyid,int pageno,int pagerows,String readflag){
		String hql = "from VSysMessReader where ryid=:ryid and readflag=:readflag";
		Query query = getSession().createQuery(hql);
		query.setString("ryid", renyid);
		query.setString("readflag", readflag);
		int beginrow = (pageno-1)*pagerows;
		query.setFirstResult(beginrow);
		query.setMaxResults(pagerows);
		return query.list();
	}
}
