package com.his.mnis.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;

import com.his.mnis.entities.VwBryz;

public class VwBryzDao extends BaseDao {
	
	/*
	 * 根据病人key1,key2值查询病人医嘱数据
	 */

	public List<VwBryz> getListBrYzByKey(long v_key1,int v_key2,short v_yebh){
		
		String hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh order by groupxh,xsxh,pwflag" ;
		Query query = getSession().createQuery(hql);
		query.setLong("key1", v_key1);
		query.setInteger("key2", v_key2);
		query.setShort("yebh", v_yebh);
		return query.list();
		
	}
	
	/*
	 * 根据病人key1,key2值和给定的条件值查询病人医嘱数据  String v_tiaojianstr;      //条件字符串
	 */
	
	public List<VwBryz> getListBrYzByKeyAndTiaoJian(long v_key1,int v_key2,short v_yebh,String v_tiaojianstr){
		
		String hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh" + v_tiaojianstr + " order by groupxh,xsxh,pwflag";
		Query query = getSession().createQuery(hql);
		query.setLong("key1", v_key1);
		query.setInteger("key2", v_key2);
		query.setShort("yebh", v_yebh);
		return query.list();
		
	}
	
	/*
	 * 执行产生，修过病人医嘱数据的存储过程
	 * 
	 */
	
	public String callProcedureBrYz(long v_key1,int v_key2){
		
		ProcedureCall pc = getSession().createStoredProcedureCall("pw_bryz");
		pc.registerParameter("key1_In", long.class, ParameterMode.IN).bindValue(v_key1);
		pc.registerParameter("key2_In", int.class, ParameterMode.IN).bindValue(v_key2);
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		String ls_errortext=pc.getOutputs().getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		System.out.println("ls_errortext:" + ls_errortext);
		return ls_return;
		
	}

}
