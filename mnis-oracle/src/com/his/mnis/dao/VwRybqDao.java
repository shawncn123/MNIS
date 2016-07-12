package com.his.mnis.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import com.his.mnis.entities.VwRybq;

public class VwRybqDao extends BaseDao {
	/*
	 * 根据操作员ID 列出相对应病区
	 */
	public List<VwRybq> getListBingQu(String caoZyId){
		String hql="from VwRybq where ryid=:id";
		Query query = getSession().createQuery(hql);
		query.setString("id", caoZyId);
		return query.list();
	}
	
	/*
	 * 根据操作员id，获取缺省病区
	 */
	public VwRybq getDefaultBingQuByCaozyId(String caoZyId){
		String hql = "from VwRybq where ryid = :id and defualtflag = 1";
		Query query = getSession().createQuery(hql);
		query.setString("id", caoZyId);
		return (VwRybq) query.uniqueResult();
	}
	/*
	 * 根据操作员代码(登录的操作员代码)，获取人员id
	 */
	public VwRybq getRenYuanIdByCaozyDaiMa(String caoZuoYuanid){
		String hql = "from VwRybq where ryid = :ryid";
		Query query = getSession().createQuery(hql);
		query.setString("ryid", caoZuoYuanid);
		query.setMaxResults(1);
		return (VwRybq) query.uniqueResult();
	}
	/*
	 * 根据病区id获取病区名称
	 */
	public String getBingQuMingCheng(String bqid){
		String hql = "from VwRybq where bq=:bqid";
		Query query = getSession().createQuery(hql);
		query.setString("bqid", bqid);
		query.setMaxResults(1);
		VwRybq vwRybq = (VwRybq) query.uniqueResult();
		return vwRybq.getBqmc();
	}
	
	/*
	 * 执行验证登录存储过程
	 * 
	 */
	
	public String callProcedurePW_Identify(String czydm,String mima){
		
		ProcedureCall pc = getSession().createStoredProcedureCall("PW_IDENTIFY");
		pc.registerParameter("czydm_In", String.class, ParameterMode.IN).bindValue(czydm);
		pc.registerParameter("password_In", String.class, ParameterMode.IN).bindValue(mima);
		pc.registerParameter("out_czyid", String.class, ParameterMode.OUT);
		pc.registerParameter("out_czyxm", String.class, ParameterMode.OUT);
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		if(ls_return.equals("1")){
			//表失败 
			String ls_errortext=pc.getOutputs().getOutputParameterValue("out_errortext").toString();
			System.out.println("out_return:" + ls_return);    //0 表成功 1 表失败
			System.out.println("ls_errortext:" + ls_errortext);
			return ls_return;
		}else{
			String out_czyid = pc.getOutputs().getOutputParameterValue("out_czyid").toString();
			return out_czyid;
		}
	}
}
