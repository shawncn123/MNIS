package com.his.mnis.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;

import com.his.mnis.entities.VwBbBrxm;

public class BaiBanGongZhuoTiXingDao extends BaseDao {

	/*
	 * 查询有哪些可显示的项目 from vw_bb_brxm
	 */
	public List<VwBbBrxm> getListBaiBanBingRenXiangMu(String bqid) {
		String hql = "from VwBbBrxm where bq=:bqid";
		Query query = getSession().createQuery(hql);
		query.setString("bqid", bqid);
		return query.list();
	}

	/*
	 * 按床位查项目相关显示内容 PW_Get_hlxmnr_chw 
	 */
	public String callProcedurePwGetHlxmnrChw(String bqid, String chw, String xmbm) {

		ProcedureCall pc = getSession().createStoredProcedureCall("PW_Get_hlxmnr_chw");
		pc.registerParameter("in_bq", String.class, ParameterMode.IN).bindValue(bqid);
		pc.registerParameter("in_chw", String.class, ParameterMode.IN).bindValue(chw);
		pc.registerParameter("in_xmbm", String.class, ParameterMode.IN).bindValue(xmbm);
		pc.registerParameter("out_nr", String.class, ParameterMode.OUT);
//		String ls_return = pc.getOutputs().getOutputParameterValue("out_nr").toString();
//		System.out.println("out_nr:" + ls_return);
//		return ls_return;
		Object obj = pc.getOutputs().getOutputParameterValue("out_nr");
		if(obj!=null){
			String ls_return = obj.toString();
			return ls_return;
		}else{
			return null;
		}
	}

	/*
	 * 按我的病人查各项目相关显示内容  PW_Get_hlxmnr_czyid
	 */
	public String callProcedurePWGetHlxmnrCzyid(String bqid, String czyid, String xmbm) {

		ProcedureCall pc = getSession().createStoredProcedureCall("PW_Get_hlxmnr_czyid");
		pc.registerParameter("in_bq", String.class, ParameterMode.IN).bindValue(bqid);
		pc.registerParameter("in_czyid", String.class, ParameterMode.IN).bindValue(czyid);
		pc.registerParameter("in_xmbm", String.class, ParameterMode.IN).bindValue(xmbm);
		pc.registerParameter("out_nr", String.class, ParameterMode.OUT);
		Object obj = pc.getOutputs().getOutputParameterValue("out_nr");
		if(obj!=null){
			String ls_return = obj.toString();
			return ls_return;
		}else{
			return null;
		}
	}

	/*
	 * 按床位查项目相关显示内容 PW_Get_hlxmnr_chw2 不需要循环项目查询
	 */
	public String callProcedurePwGetHlxmnrChw2(String bqid, String chw) {

		ProcedureCall pc = getSession().createStoredProcedureCall("PW_Get_hlxmnr_chw2");
		pc.registerParameter("in_bq", String.class, ParameterMode.IN).bindValue(bqid);
		pc.registerParameter("in_chw", String.class, ParameterMode.IN).bindValue(chw);
		pc.registerParameter("out_nr", String.class, ParameterMode.OUT);
		Object obj = pc.getOutputs().getOutputParameterValue("out_nr");
		if(obj!=null){
			String ls_return = obj.toString();
			return ls_return;
		}else{
			return null;
		}
	}
	
}
