package com.his.mnis.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.TwTzdata;
import com.his.mnis.entities.TwTzdata_update;
import com.his.mnis.entities.TwZyhzPgXX;

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

	//根据key1 key2 yebh 日期查询出该病人该日期的体征录入数据
	public List<TwTzdata> getListTzData(long key1,Integer key2,short yebh,Date lrrq){
		String hql = "from TwTzdata where key1=:key1 and key2=:key2 and yebh=:yebh and rq=:rq";
		Query query = currentSession().createQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		query.setShort("yebh", yebh);
		query.setDate("rq", lrrq);
		return query.list();
	}
	
	//根据key1 key2 yebh 日期查询出该病人该日期的多少次数记录
	public List<String> getListTzDataJl(long key1,Integer key2,short yebh,Date lrrq){
		String hql = "select distinct(SJ) from TW_TZDATA where KEY1=:key1 and KEY2=:key2 and YEBH=:yebh and RQ=:rq";
		Query query = currentSession().createSQLQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		query.setShort("yebh", yebh);
		query.setDate("rq", lrrq);
		return query.list();
	}
	
	//根据key1 key2 yebh 日期 时间点查询出该病人该日期该时间点的的体征录入数据
	public List<TwTzdata_update> getListTzDataByShiJianDian(long key1,Integer key2,short yebh,Date lrrq,String sjd){
		String hql = "select t1.XMID,t1.XMMC,t2.JLID,t2.VALUE1,t2.VALUE2,t2.BZ,t1.DW,t1.BZFLAG,t2.SJ,t2.PCID "
		 + "from TW_TZZD t1,TW_TZDATA t2 where t2.KEY1=:key1 and t2.KEY2=:key2 and t2.YEBH=:yebh and t2.RQ=:rq and t2.SJ=:sjd  and t2.XMID=t1.XMID order by t1.XSXH";
		Query query = currentSession().createSQLQuery(hql)
				.addScalar("xmid", StringType.INSTANCE).addScalar("xmmc", StringType.INSTANCE)
				.addScalar("jlid",LongType.INSTANCE).addScalar("value1", StringType.INSTANCE)
				.addScalar("value2", StringType.INSTANCE).addScalar("bz", StringType.INSTANCE)
				.addScalar("dw", StringType.INSTANCE).addScalar("bzflag", StringType.INSTANCE)
				.addScalar("sj", StringType.INSTANCE).addScalar("pcid", LongType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(TwTzdata_update.class));
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		query.setShort("yebh", yebh);
		query.setDate("rq", lrrq);
		query.setString("sjd", sjd);
		return query.list();
	}
	
	public int updateTwTzdata(TwTzdata_update twTzdata_update,String czyid,String czyxm){
//		this.getHibernateTemplate().save(twTzdata);
		String sql = "update TW_TZDATA set STIME=:STIME,CZYID=:CZYID,CZYXM=:CZYXM,SJ=:SJ,VALUE1=:VALUE1,VALUE2=:VALUE2,BZ=:BZ "
				+ " where JLID = :JLID";
		Query query = currentSession().createSQLQuery(sql);
		query.setLong("JLID",twTzdata_update.getJlid());
		query.setTimestamp("STIME",twTzdata_update.getStime());
		query.setString("CZYID",czyid);
		query.setString("CZYXM",czyxm);
		query.setString("SJ",twTzdata_update.getSj());
		query.setString("VALUE1", twTzdata_update.getValue1());
		query.setString("VALUE2", twTzdata_update.getValue2());
		query.setString("BZ", twTzdata_update.getBz());
		return query.executeUpdate();
	}
}
