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

//		this.getHibernateTemplate().save(twTzdataTw);
		String sql = "insert into TW_TZDATA_TW(JLID,stime,czyid,czyxm,key1,key2,yebh,rq,sj,TW_LX,TW_TW,TW_TW_JWH,TW_MB,TW_XL,TW_HX,TW_RCBZ,TW_RCSJ)"
				+ " values(:JLID,:stime,:czyid,:czyxm,:key1,:key2,:yebh,:rq,:sj,:TW_LX,:TW_TW,:TW_TW_JWH,:TW_MB,:TW_XL,:TW_HX,:TW_RCBZ,:TW_RCSJ)";
		Query query = currentSession().createSQLQuery(sql);
		
		query.setLong("JLID",twTzdataTw.getJlid());
		query.setTimestamp("stime",twTzdataTw.getStime());
		query.setString("czyid",twTzdataTw.getCzyid());
		query.setString("czyxm",twTzdataTw.getCzyxm());
		query.setLong("key1",twTzdataTw.getKey1());
		query.setInteger("key2",twTzdataTw.getKey2());
		query.setShort("yebh",twTzdataTw.getYebh());
		query.setDate("rq",twTzdataTw.getRq());
		query.setString("sj",twTzdataTw.getSj());
		query.setString("TW_LX",twTzdataTw.getTwLx());
		query.setDouble("TW_TW",twTzdataTw.getTwTw());
		query.setDouble("TW_TW_JWH",twTzdataTw.getTwTwJwh());
		query.setShort("TW_MB",twTzdataTw.getTwMb());
		query.setShort("TW_XL",twTzdataTw.getTwXl());
		query.setShort("TW_HX",twTzdataTw.getTwHx());
		query.setString("TW_RCBZ",twTzdataTw.getTwRcbz());
		query.setString("TW_RCSJ",twTzdataTw.getTwRcsj());
		query.executeUpdate();
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
		Object errortext = pc.getOutputs().getOutputParameterValue("out_errortext");
		System.out.println("out_return:" + ls_return);
		if(errortext!=null){
			String ls_errortext = errortext.toString();
			System.out.println("ls_errortext:" + ls_errortext);
		}
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
