package com.his.mnis.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;

import com.his.mnis.entities.TwBryzzx;

public class TwBryzzxDao extends BaseDao {

	/*
	 * 根据病人key1,key2值查询病人医嘱执行数据
	 */

	public List<TwBryzzx> getListBrYzzxByKey(long v_key1,int v_key2,short v_yebh){
		
		String hql = "from TwBryzzx where key1=:key1 and key2=:key2 and yebh=:yebh order by groupxh,sjd";
		Query query = getSession().createQuery(hql);
		query.setLong("key1", v_key1);
		query.setInteger("key2", v_key2);
		query.setShort("yebh", (short)(0));
		return query.list();
		
	}
	
	/*
	 * 执行产生，病人医嘱执行数据的存储过程
	 * 
	 */
	
	public String callProcedureBrYzzx(long v_key1,int v_key2){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date rq = new Date();
		ProcedureCall pc = getSession().createStoredProcedureCall("pw_bryzzx_sc");
		pc.registerParameter("key1_In", long.class, ParameterMode.IN).bindValue(v_key1);
		pc.registerParameter("key2_In", int.class, ParameterMode.IN).bindValue(v_key2);
		pc.registerParameter("yebh_In", short.class, ParameterMode.IN).bindValue((short) 0);
		try {
			rq = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		pc.registerParameter("rq_In", Date.class, ParameterMode.IN).bindValue(rq);
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		String ls_errortext=pc.getOutputs().getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		System.out.println("ls_errortext:" + ls_errortext);
		return ls_return;
		
	}
	
	/*
	 * 执行保存医嘱执行的数据的存储过程
	 */
	
	public String callProcedureBrYzzx_baocun(Date rq,String sjd,long groupxh,String hsid,String hsxm,Date zxsj,String zxms){
		
		ProcedureCall pc = getSession().createStoredProcedureCall("pw_bryz_zx");
		pc.registerParameter("rq_In", Date.class, ParameterMode.IN).bindValue(rq);
		pc.registerParameter("groupxh_In", Long.class, ParameterMode.IN).bindValue(groupxh);
		pc.registerParameter("sjd_In", String.class, ParameterMode.IN).bindValue(sjd);
		pc.registerParameter("zxhsid_In", String.class, ParameterMode.IN).bindValue(hsid);
		pc.registerParameter("zxhsxm_In", String.class, ParameterMode.IN).bindValue(hsxm);
		pc.registerParameter("zxtime_In", Date.class, ParameterMode.IN).bindValue(zxsj);
		pc.registerParameter("zxms_In", String.class, ParameterMode.IN).bindValue(zxms);
		
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		String ls_errortext=pc.getOutputs().getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		System.out.println("ls_errortext:" + ls_errortext);
		return ls_return;
		
	}
}
