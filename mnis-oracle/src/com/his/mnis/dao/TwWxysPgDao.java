package com.his.mnis.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.his.mnis.entities.TwWxysPgDm;
import com.his.mnis.entities.TwZyhzPgXX;
import com.his.mnis.entities.TwZyhzpg;

public class TwWxysPgDao extends BaseDao {
	
	public List<TwWxysPgDm> getListWxysPgDm(){
		String hql = "from TwWxysPgDm where tyflag=0 order by sxh";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	
	public int updateTwWxysPg(TwZyhzpg twZyhzpg,String mflag){
		String sql = "";
		if(mflag.equals("1")){   //表示旧数据
			 sql = "update TW_ZYHZPG set QDFLAG=:QDFLAG,ZXHSID=:ZXHSID,JLRQ=:JLRQ"
					+ " where PGRQ = :PGRQ and PGDM = :PGDM";
			 Query query = getSession().createSQLQuery(sql);
			 query.setString("PGDM", twZyhzpg.getPgdm());
			 query.setString("QDFLAG", twZyhzpg.getQdflag());
			 query.setString("ZXHSID", twZyhzpg.getZxhsid());
			 query.setDate("PGRQ", twZyhzpg.getPgrq());
			 query.setDate("JLRQ", twZyhzpg.getJlrq());
			 return query.executeUpdate();
		}else{
			 sql = "insert into TW_ZYHZPG(ROWKEY,KEY1,KEY2,YEBH,PGDM,QDFLAG,ZXHSID,PGRQ,JLRQ)"
					+ " values(:ROWKEY,:KEY1,:KEY2,:YEBH,:PGDM,:QDFLAG,:ZXHSID,:PGRQ,:JLRQ)";
			 Query query = getSession().createSQLQuery(sql);
			 query.setInteger("ROWKEY", twZyhzpg.getRowkey());
			 query.setLong("KEY1", twZyhzpg.getKey1());
			 query.setInteger("KEY2", twZyhzpg.getKey2());
			 query.setShort("YEBH", twZyhzpg.getYebh());
			 query.setString("PGDM", twZyhzpg.getPgdm());
			 query.setString("QDFLAG", twZyhzpg.getQdflag());
			 query.setString("ZXHSID", twZyhzpg.getZxhsid());
			 query.setDate("PGRQ", twZyhzpg.getPgrq());
			 query.setDate("JLRQ", twZyhzpg.getJlrq());
			 return query.executeUpdate();
		}
	}
	
	public List<TwZyhzpg> getListTwZyhzpg(Date cxrq){
		String hql = "from TwZyhzpg where pgrq=:cxrq";
		Query query = getSession().createQuery(hql);
		query.setDate("cxrq", cxrq);
		return query.list();
	}
	
	public List<TwZyhzPgXX> getListTwZyhzpgXX(Date cxrq){
		String sql = "select t1.key1,t1.key2,t1.yebh,t1.pgdm,t2.wxys,t2.pgfeng,t1.qdflag,t1.zxhsid,t1.pgrq,t1.jlrq"
				+ " from TW_ZYHZPG t1,TW_WXYS_PG_DM t2 where t1.pgrq=:cxrq and t1.PGDM = t2.ID order by t2.sxh";
		Query query = getSession().createSQLQuery(sql).addScalar("key1",LongType.INSTANCE).addScalar("key2",IntegerType.INSTANCE).addScalar("yebh",ShortType.INSTANCE).addScalar("pgdm",StringType.INSTANCE).addScalar("wxys",StringType.INSTANCE)
				.addScalar("pgfeng",IntegerType.INSTANCE).addScalar("qdflag",StringType.INSTANCE).addScalar("zxhsid",StringType.INSTANCE).addScalar("pgrq",TimestampType.INSTANCE).addScalar("jlrq",TimestampType.INSTANCE).setResultTransformer(Transformers.aliasToBean(TwZyhzPgXX.class));
		query.setDate("cxrq", cxrq);
		return query.list();
	}
	
}
