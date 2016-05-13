package com.his.mnis.dao;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.TwTzdataTw;

public class TwTzdataTwDao extends HibernateDaoSupport {
	/*
	 * doCreateTwTzdataTw 录入病人一次体温记录
	 * getMinRqTwTzdataTw 获取病人日期最小的体温记录
	 * getMaxRqTwTzdataTw 获取病人日期最大的体温记录
	 */

	public void doCreateTwTzdataTw(TwTzdataTw twTzdataTw) {

		this.getHibernateTemplate().save(twTzdataTw);

	}

	public String callProcedurePwTzdataTw(long p_jlid) {

		ProcedureCall pc = currentSession().createStoredProcedureCall(
				"PW_if_tzdata_tw");
		pc.registerParameter("jlid_In", long.class, ParameterMode.IN)
				.bindValue(p_jlid);
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return = pc.getOutputs()
				.getOutputParameterValue("out_return").toString();
		String ls_errortext = pc.getOutputs()
				.getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		System.out.println("ls_errortext:" + ls_errortext);
		return ls_return;

	}
	
	public TwTzdataTw getMinRqTwTzdataTw(Long vkey1,Integer vkey2, Short vyebh){
		String hql = "from TwTzdataTw where key1=:key1 and key2=:key2 and yebh=:key3 order by rq";
		Query query = currentSession().createQuery(hql);
		query.setLong("key1", vkey1);
		query.setInteger("key2", vkey2);
		query.setShort("key3", vyebh);
		query.setFirstResult(0);
		query.setMaxResults(1);
		return (TwTzdataTw) query.uniqueResult();
	}
	
	public TwTzdataTw getMaxRqTwTzdataTw(Long vkey1,Integer vkey2, Short vyebh){
		String hql = "from TwTzdataTw where key1=:key1 and key2=:key2 and yebh=:key3 order by rq desc";
		Query query = currentSession().createQuery(hql);
		query.setLong("key1", vkey1);
		query.setInteger("key2", vkey2);
		query.setShort("key3", vyebh);
		query.setFirstResult(0);
		query.setMaxResults(1);
		return (TwTzdataTw) query.uniqueResult();
	}
}
