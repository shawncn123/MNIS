package com.his.mnis.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.TwTzdata;
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
		Object obj;
		obj = twTzdataTw.getTwTw();
		if (obj==null){
			query.setParameter("TW_TW",obj,StandardBasicTypes.DOUBLE);
		}else{
			query.setDouble("TW_TW",twTzdataTw.getTwTw());
		}
		obj = twTzdataTw.getTwTwJwh();
		if (obj==null){
			query.setParameter("TW_TW_JWH",obj,StandardBasicTypes.DOUBLE);
		}else{
			query.setDouble("TW_TW_JWH",twTzdataTw.getTwTwJwh());
		}
//		query.setDouble("TW_TW_JWH",twTzdataTw.getTwTwJwh());
		obj = twTzdataTw.getTwMb();
		if (obj==null){
			query.setParameter("TW_MB",obj,StandardBasicTypes.SHORT);
		}else{
			query.setShort("TW_MB",twTzdataTw.getTwMb());
		}
//		query.setShort("TW_MB",twTzdataTw.getTwMb());
		obj = twTzdataTw.getTwXl();
		if (obj==null){
			query.setParameter("TW_XL",obj,StandardBasicTypes.SHORT);
		}else{
			query.setShort("TW_XL",twTzdataTw.getTwXl());
		}
//		query.setShort("TW_XL",twTzdataTw.getTwXl());
		obj = twTzdataTw.getTwHx();
		if (obj==null){
			query.setParameter("TW_HX",obj,StandardBasicTypes.SHORT);
		}else{
			query.setShort("TW_HX",twTzdataTw.getTwHx());
		}
//		query.setShort("TW_HX",twTzdataTw.getTwHx());
		obj = twTzdataTw.getTwRcbz();
		if (obj==null){
			query.setParameter("TW_RCBZ",obj,StandardBasicTypes.STRING);
		}else{
			query.setString("TW_RCBZ",twTzdataTw.getTwRcbz());
		}
//		query.setString("TW_RCBZ",twTzdataTw.getTwRcbz());
		obj = twTzdataTw.getTwRcsj();
		if (obj==null){
			query.setParameter("TW_RCSJ",obj,StandardBasicTypes.STRING);
		}else{
			query.setString("TW_RCSJ",twTzdataTw.getTwRcsj());
		}
//		query.setString("TW_RCSJ",twTzdataTw.getTwRcsj());
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
	
	//根据key1 key2 yebh 日期查询出该病人该日期 体温录入数据
	public List<TwTzdataTw> getListTzDataTw(long key1,Integer key2,short yebh,Date lrrq){
		String hql = "from TwTzdataTw where key1=:key1 and key2=:key2 and yebh=:yebh and rq=:rq";
		Query query = currentSession().createQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		query.setShort("yebh", yebh);
		query.setDate("rq", lrrq);
		return query.list();
	}
	//根据key1 key2 yebh 日期查询出该病人该日期的体温多少次数记录
	public List<TwTzdataTw> getListTzDataTWJl(long key1,Integer key2,short yebh,Date lrrq){
		String hql = "from TwTzdataTw where KEY1=:key1 and KEY2=:key2 and YEBH=:yebh and RQ=:rq";
		Query query = currentSession().createQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		query.setShort("yebh", yebh);
		query.setDate("rq", lrrq);
		return query.list();
	}
	//根据key1 key2 yebh 日期,时间点查询出该病人该日期，时间 体温录入数据
		public TwTzdataTw getTzDataTwByJlid(long jlid){
			String hql = "from TwTzdataTw where jlid=:jlid";
			Query query = currentSession().createQuery(hql);
			query.setLong("jlid", jlid);
			TwTzdataTw twTdataTw = (TwTzdataTw) query.uniqueResult();
			return twTdataTw;
		}
		
	/*
	 * 根据jlid和参数 TwTzdataTw twTzdataTw 修改体温采集数据
	 */
		public int updateTzdataTwByJlid(TwTzdataTw twTzdataTw){
			String sql = "update TW_TZDATA_TW set stime=:stime,czyid=:czyid,czyxm=:czyxm,sj=:sj,"
					+ "TW_LX=:TW_LX,TW_TW=:TW_TW,TW_TW_JWH=:TW_TW_JWH,TW_MB=:TW_MB,TW_XL=:TW_XL,"
					+ "TW_HX=:TW_HX,TW_RCBZ=:TW_RCBZ,TW_RCSJ=:TW_RCSJ"
					+ " where JLID=:JLID";
			Query query = currentSession().createSQLQuery(sql);
			query.setLong("JLID",twTzdataTw.getJlid());
			query.setTimestamp("stime",twTzdataTw.getStime());
			query.setString("czyid",twTzdataTw.getCzyid());
			query.setString("czyxm",twTzdataTw.getCzyxm());
			query.setString("sj",twTzdataTw.getSj());
			query.setString("TW_LX",twTzdataTw.getTwLx());
			Object obj;
			obj = twTzdataTw.getTwTw();
			if (obj==null){
				query.setParameter("TW_TW",obj,StandardBasicTypes.DOUBLE);
			}else{
				query.setDouble("TW_TW",twTzdataTw.getTwTw());
			}
			obj = twTzdataTw.getTwTwJwh();
			if (obj==null){
				query.setParameter("TW_TW_JWH",obj,StandardBasicTypes.DOUBLE);
			}else{
				query.setDouble("TW_TW_JWH",twTzdataTw.getTwTwJwh());
			}
			obj = twTzdataTw.getTwMb();
			if (obj==null){
				query.setParameter("TW_MB",obj,StandardBasicTypes.SHORT);
			}else{
				query.setShort("TW_MB",twTzdataTw.getTwMb());
			}
			obj = twTzdataTw.getTwXl();
			if (obj==null){
				query.setParameter("TW_XL",obj,StandardBasicTypes.SHORT);
			}else{
				query.setShort("TW_XL",twTzdataTw.getTwXl());
			}
			obj = twTzdataTw.getTwHx();
			if (obj==null){
				query.setParameter("TW_HX",obj,StandardBasicTypes.SHORT);
			}else{
				query.setShort("TW_HX",twTzdataTw.getTwHx());
			}
			obj = twTzdataTw.getTwRcbz();
			if (obj==null){
				query.setParameter("TW_RCBZ",obj,StandardBasicTypes.STRING);
			}else{
				query.setString("TW_RCBZ",twTzdataTw.getTwRcbz());
			}
			obj = twTzdataTw.getTwRcsj();
			if (obj==null){
				query.setParameter("TW_RCSJ",obj,StandardBasicTypes.STRING);
			}else{
				query.setString("TW_RCSJ",twTzdataTw.getTwRcsj());
			}
			return query.executeUpdate();
		}
}
