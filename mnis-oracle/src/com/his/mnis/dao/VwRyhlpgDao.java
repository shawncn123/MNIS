package com.his.mnis.dao;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwRyhlpg;
import com.his.mnis.entities.TwZyhzPgXX;
import com.his.mnis.entities.VwRyhlpg;

public class VwRyhlpgDao extends BaseDao {

	/*
	 * 根据key1 key2 查询病人护理评估一般信息
	 */
	 public VwRyhlpg getVwRyhlpgByKey1Key2(Long key1,Integer key2){
		 String hql = "from VwRyhlpg where key1=:key1 and key2=:key2";
		 Query query = getSession().createQuery(hql);
		 query.setLong("key1", key1);
		 query.setInteger("key2", key2);
		 VwRyhlpg vwRyhlpg = (VwRyhlpg) query.uniqueResult();
		 return vwRyhlpg;
	 }
	 /*
	  * 根据key1 key2 查询病人护理评估TwRyhlpg一般信息
	  */
	 public TwRyhlpg getTwRyhlpgByKey1Key2(Long key1,Integer key2){
		 String hql = "select t1.rowkey,t1.key1,t1.key2,t1.bah,t1.bq,t1.bqksmc,t1.chw,"
			 		+ "t1.fylb,t1.xm,t1.xb,t1.nl,t1.zy,t1.mz,t1.whcd,t2.bsgsr,t2.rytj,t2.rksj,t2.ryzd,t2.ryfs,t2.gms, "
					+ "t2.jlzhsid,t2.jlzhsxm,t2.jltime from vw_ryhlpg t1,TW_RYHLPG t2 where  t1.key1=:key1 and t1.key2=:key2 "
			 		+ " and t2.rowkey(+)=t1.rowkey";
//		 Query query = getSession().createSQLQuery(hql)
//				 .addScalar("rowkey",StringType.INSTANCE)
//				 .addScalar("key1",LongType.INSTANCE)
//				 .addScalar("key2",IntegerType.INSTANCE)
//				 .addScalar("bah",StringType.INSTANCE).addScalar("bq",StringType.INSTANCE)
//				 .addScalar("bqksmc",StringType.INSTANCE).addScalar("chw",StringType.INSTANCE)
//				 .addScalar("fylb",StringType.INSTANCE).addScalar("xm",StringType.INSTANCE)
//				 .addScalar("xb",StringType.INSTANCE).addScalar("nl",StringType.INSTANCE)
//				 .addScalar("zy",StringType.INSTANCE).addScalar("mz",StringType.INSTANCE)
//				 .addScalar("whcd",StringType.INSTANCE).addScalar("bsgsr",StringType.INSTANCE)
//				 .addScalar("rytj",StringType.INSTANCE).addScalar("rksj",TimestampType.INSTANCE)
//				 .addScalar("ryzd",StringType.INSTANCE).addScalar("ryfs",StringType.INSTANCE)
//				 .addScalar("gms",StringType.INSTANCE).addScalar("jlhsid",StringType.INSTANCE)
//				 .addScalar("jlhsxm",StringType.INSTANCE).addScalar("jltime",TimestampType.INSTANCE)
//				 .setResultTransformer(Transformers.aliasToBean(TwRyhlpg.class));
		 Query query = getSession().createSQLQuery(hql).addEntity(TwRyhlpg.class);
		 query.setLong("key1", key1);
		 query.setInteger("key2", key2);
		 TwRyhlpg twRyhlpg = (TwRyhlpg) query.uniqueResult();
		 return twRyhlpg;
	 }
}
