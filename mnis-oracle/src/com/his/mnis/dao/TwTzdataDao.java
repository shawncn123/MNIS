package com.his.mnis.dao;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.TwTzdata;

public class TwTzdataDao extends HibernateDaoSupport {
	
	public int doCreateTwTzdata(TwTzdata twTzdata){
//		this.getHibernateTemplate().save(twTzdata);
		String sql = "insert into TW_TZDATA(JLID,STIME,CZYID,CZYXM,PCID,KEY1,KEY2,YEBH,RQ,SJ,XMID,VALUE1,VALUE2,BZ)"
				+ " values(:JLID,:STIME,:CZYID,:CZYXM,:PCID,:KEY1,:KEY2,:YEBH,:RQ,:SJ,:XMID,:VALUE1,:VALUE2,:BZ)";
		Query query = currentSession().createSQLQuery(sql);
		query.setLong("JLID",twTzdata.getJlid());
		query.setTimestamp("STIME",twTzdata.getStime());
		query.setString("CZYID",twTzdata.getCzyid());
		query.setString("CZYXM",twTzdata.getCzyxm());
		query.setLong("PCID",twTzdata.getPcid());
		query.setLong("KEY1",twTzdata.getKey1());
		query.setInteger("KEY2",twTzdata.getKey2());
		query.setShort("YEBH",twTzdata.getYebh());
		query.setDate("RQ",twTzdata.getRq());
		query.setString("SJ",twTzdata.getSj());
		query.setString("XMID", twTzdata.getXmid());
		query.setString("VALUE1", twTzdata.getValue1());
		query.setString("VALUE2", twTzdata.getValue2());
		query.setString("BZ", twTzdata.getBz());
		return query.executeUpdate();
	}
	
public String callProcedurePwTzdata(long p_pcid){
		
		ProcedureCall pc = currentSession().createStoredProcedureCall("PW_if_tzdata");
		pc.registerParameter("pcid_In", long.class, ParameterMode.IN).bindValue(p_pcid);
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		Object obj = pc.getOutputs().getOutputParameterValue("out_errortext");
		if(obj!=null){
			String ls_errortext=obj.toString();
			System.out.println("ls_errortext:" + ls_errortext);
		}
		return ls_return;
	}

}
