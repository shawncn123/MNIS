package com.his.mnis.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;

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
	/*
	 * 根据参数用户id，第几页、每页行数, 查询过期未读消息记录
	 */
	public List<VSysMessReader> getListSysMessByRenyIdGcwd(String renyid,int pageno,int pagerows){
		String hql = "from VSysMessReader where ryid=:ryid and qcwdflag='1'";
		Query query = getSession().createQuery(hql);
		query.setString("ryid", renyid);
//		query.setString("readflag", readflag);
		int beginrow = (pageno-1)*pagerows;
		query.setFirstResult(beginrow);
		query.setMaxResults(pagerows);
		return query.list();
	}
	
	
	/*
	 * 根据messid 和人员id 确定消息已读
	 */
	public String queDingXiaoXiYiDu(String messid, String ryid){
		ProcedureCall pc = getSession().createStoredProcedureCall("P_messid_read");
		pc.registerParameter("al_messid", String.class, ParameterMode.IN).bindValue(messid);
		pc.registerParameter("as_ryid", String.class, ParameterMode.IN).bindValue(ryid);
		pc.registerParameter("as_readflag", String.class, ParameterMode.IN).bindValue("1");
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		String ls_errortext=pc.getOutputs().getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		System.out.println("ls_errortext:" + ls_errortext);
		return ls_return;
	}
}
