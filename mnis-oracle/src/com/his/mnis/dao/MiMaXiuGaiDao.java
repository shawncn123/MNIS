package com.his.mnis.dao;

import javax.persistence.ParameterMode;

import org.hibernate.procedure.ProcedureCall;

public class MiMaXiuGaiDao extends BaseDao {

	public String callProcedureModifyPassWord(String czydm,String oldpass,String newpass) {

		ProcedureCall pc = getSession().createStoredProcedureCall(
				"PW_Identify_modifypassword");
		pc.registerParameter("czydm_In", String.class, ParameterMode.IN).bindValue(czydm);
		pc.registerParameter("oldpassword_In", String.class, ParameterMode.IN).bindValue(oldpass);
		pc.registerParameter("newpassword_in", String.class, ParameterMode.IN).bindValue(newpass);
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return = pc.getOutputs()
				.getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);   //0 表成功
		return ls_return;
	}
	
}
