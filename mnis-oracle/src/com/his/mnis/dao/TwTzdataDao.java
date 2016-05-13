package com.his.mnis.dao;

import javax.persistence.ParameterMode;

import org.hibernate.procedure.ProcedureCall;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.TwTzdata;

public class TwTzdataDao extends HibernateDaoSupport {
	

	
	public void doCreateTwTzdata(TwTzdata twTzdata){
		this.getHibernateTemplate().save(twTzdata);
	}
	
public String callProcedurePwTzdata(long p_pcid){
		
		ProcedureCall pc = currentSession().createStoredProcedureCall("PW_if_tzdata");
		pc.registerParameter("pcid_In", long.class, ParameterMode.IN).bindValue(p_pcid);
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		String ls_errortext=pc.getOutputs().getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		System.out.println("ls_errortext:" + ls_errortext);
		return ls_return;
		
	}

}
