package com.his.mnis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzx_brxx;

public class ShuYeZhiXingDao extends BaseDao {

	 /*
	  * 根据护士ID,执行分类代码查询相关病人输液执行医嘱
	  */
	public List<TwBryzzx_brxx> getMyBingRenShuYeZhiXingYiZhu(String hsid,String zxfldm,Date xzrq){

		/*
		 * 查询所有未执行医嘱
		 */
		String hql="";
		if(zxfldm.equals("00")){
			hql = "select t1.rowkey,t1.key1,t1.key2,t1.yebh,t1.rq,t1.groupxh,t1.sjd,t1.sjdtime,t1.bq,t1.chw,t1.yzid,t1.yzzdmc,"
					+ "t1.yzmc,t1.zxlb,t1.yf2mc,t1.zxflag,t1.zxtime,t1.zxhsid,t1.zxhsxm,t1.zxms,t1.zxfldm,t1.lsflag,t1.yzfsh,t1.crlflag,t1.crl,"
					+ "t2.bah,t2.xm,t2.xb,t2.nl,t4.czfl,t1.syflag"
					+ " from TW_BRYZZX t1, vw_bqbr_zy t2,tw_wdbr t3,TW_SYYZBZCZ_JILU t4 "
					+ "where t3.hsid=:hsid and t3.chw=t2.chw and t3.bq=t2.bq and t1.key1=t2.key1 and t1.key2=t2.key2 and t1.rq=:xzrq  and t4.rowkey(+)=t1.rowkey "
//					+ " and (zxflag!='1' or czfl='' or czfl is null)"
//					+ " and (zxflag!='1' or (zxfldm='01' and (czfl='1' or czfl is null))) "
					+ " and zxflag!='1'"
					+ " order by t1.bq,t1.chw,t1.groupxh,t1.sjdtime";
		}else{
			hql = "select t1.rowkey,t1.key1,t1.key2,t1.yebh,t1.rq,t1.groupxh,t1.sjd,t1.sjdtime,t1.bq,t1.chw,t1.yzid,t1.yzzdmc,"
					+ "t1.yzmc,t1.zxlb,t1.yf2mc,t1.zxflag,t1.zxtime,t1.zxhsid,t1.zxhsxm,t1.zxms,t1.zxfldm,t1.lsflag,t1.yzfsh,t1.crlflag,t1.crl, "
					+ "t2.bah,t2.xm,t2.xb,t2.nl,t4.czfl,t1.syflag"
					+ " from TW_BRYZZX t1, vw_bqbr_zy t2,tw_wdbr t3,TW_SYYZBZCZ_JILU t4 "
					+ "where t3.bq=t2.bq and t3.chw=t2.chw and t3.hsid=:hsid and t1.zxfldm=:zxfldm and t1.key1=t2.key1 and t1.key2=t2.key2 and t1.rq=:xzrq and t4.rowkey(+)=t1.rowkey"
//					+ " and (zxflag!='1' or czfl='' or czfl is null)"
//					+ " and (zxflag!='1' or (zxfldm='01' and (czfl='1' or czfl is null))) "
					+ " and zxflag!='1'"
					+ " order by t1.bq,t1.chw,t1.groupxh,t1.sjdtime";
		}
		
		Query query = getSession().createSQLQuery(hql).addScalar("rowkey",StringType.INSTANCE)
			.addScalar("key1",LongType.INSTANCE).addScalar("key2",IntegerType.INSTANCE)
			.addScalar("yebh",ShortType.INSTANCE).addScalar("rq",TimestampType.INSTANCE)
			.addScalar("groupxh",LongType.INSTANCE).addScalar("sjd",StringType.INSTANCE)
			.addScalar("sjdtime",TimestampType.INSTANCE).addScalar("bq",StringType.INSTANCE)
			.addScalar("chw",StringType.INSTANCE).addScalar("yzid",StringType.INSTANCE)
			.addScalar("yzzdmc",StringType.INSTANCE).addScalar("yzmc",StringType.INSTANCE)
			.addScalar("zxlb",StringType.INSTANCE).addScalar("yf2mc",StringType.INSTANCE)
			.addScalar("zxflag",StringType.INSTANCE).addScalar("zxtime",TimestampType.INSTANCE)
			.addScalar("zxhsid",StringType.INSTANCE).addScalar("zxhsxm",StringType.INSTANCE)
			.addScalar("zxms",StringType.INSTANCE).addScalar("zxfldm",StringType.INSTANCE)
			.addScalar("lsflag",StringType.INSTANCE).addScalar("yzfsh",LongType.INSTANCE)
			.addScalar("crlflag",StringType.INSTANCE).addScalar("crl",DoubleType.INSTANCE)
			.addScalar("bah",StringType.INSTANCE).addScalar("xm",StringType.INSTANCE)
			.addScalar("xb",StringType.INSTANCE).addScalar("nl",StringType.INSTANCE)
			.addScalar("czfl",StringType.INSTANCE).addScalar("syflag",StringType.INSTANCE)
			.setResultTransformer(Transformers.aliasToBean(TwBryzzx_brxx.class));
		
//		Query query = getSession().createSQLQuery(hql).addEntity(TwBryzzx.class);
		query.setString("hsid", hsid);
		query.setDate("xzrq", xzrq);
		if(!zxfldm.equals("00")){
			query.setString("zxfldm", zxfldm);
		}
		return query.list();
	}
	
}
