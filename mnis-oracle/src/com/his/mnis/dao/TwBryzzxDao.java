package com.his.mnis.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzx_brxx;
import com.his.mnis.entities.TwPeiyeczJilu;

public class TwBryzzxDao extends BaseDao {

	/*
	 * 根据病人key1,key2值和执行分类代码查询病人TwBryzzx_brxx执行数据
	 */

	public List<TwBryzzx_brxx> getListBrYzzxBrxxByKeyZxfldm(long v_key1,int v_key2,short v_yebh, String zxfl,Date xzrq ){
		
		String hql="";
		if(zxfl.equals("00")){
			hql = "select t1.rowkey,t1.key1,t1.key2,t1.yebh,t1.rq,t1.groupxh,t1.sjd,t1.sjdtime,t1.bq,t1.chw,t1.yzid,t1.yzzdmc,"
					+ "t1.yzmc,t1.zxlb,t1.yf2mc,t1.zxflag,t1.zxtime,t1.zxhsid,t1.zxhsxm,t1.zxms,t1.zxfldm,t1.lsflag,t1.yzfsh,t1.crlflag,t1.crl,"
					+ "t2.bah,t2.xm,t2.xb,t2.nl,t4.czfl,t1.syflag"
					+ " from TW_BRYZZX t1, vw_bqbr_zy t2,TW_SYYZBZCZ_JILU t4 "
					+ " where t1.key1=:key1 and t1.key2=:key2 and t1.yebh=:yebh and t1.key1=t2.key1 and t1.key2=t2.key2 and t1.rq=:xzrq  and t4.rowkey(+)=t1.rowkey "
					+ " order by t1.bq,t1.chw,t1.groupxh,t1.sjdtime";
		}else{
			hql = "select t1.rowkey,t1.key1,t1.key2,t1.yebh,t1.rq,t1.groupxh,t1.sjd,t1.sjdtime,t1.bq,t1.chw,t1.yzid,t1.yzzdmc,"
					+ "t1.yzmc,t1.zxlb,t1.yf2mc,t1.zxflag,t1.zxtime,t1.zxhsid,t1.zxhsxm,t1.zxms,t1.zxfldm,t1.lsflag,t1.yzfsh,t1.crlflag,t1.crl, "
					+ "t2.bah,t2.xm,t2.xb,t2.nl,t4.czfl,t1.syflag"
					+ " from TW_BRYZZX t1, vw_bqbr_zy t2,TW_SYYZBZCZ_JILU t4 "
					+ "where t1.key1=:key1 and t1.key2=:key2 and t1.yebh=:yebh and t1.key1=t2.key1 and t1.key2=t2.key2 and t1.zxfldm=:zxfldm and t1.rq=:xzrq and t4.rowkey(+)=t1.rowkey"
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
		query.setLong("key1", v_key1);
		query.setInteger("key2", v_key2);
		query.setShort("yebh", (short)(0));
		query.setDate("xzrq", xzrq);
		if(!zxfl.equals("00")){
			query.setString("zxfldm", zxfl);
		}
		return query.list();
		
	}
	/*
	 * 根据病人key1,key2值查询病人医嘱执行数据
	 */
	
	public List<TwBryzzx> getListBrYzzxByKey(long v_key1,int v_key2,short v_yebh,Date xzrq){
		
		String hql = "from TwBryzzx where key1=:key1 and key2=:key2 and yebh=:yebh  and rq=:xzrq order by groupxh,sjdtime";
		Query query = getSession().createQuery(hql);
		query.setLong("key1", v_key1);
		query.setInteger("key2", v_key2);
		query.setShort("yebh", (short)(0));
		query.setDate("xzrq", xzrq);
		return query.list();
		
	}
	/*
	 * 根据病人key1,key2值和执行分类代码查询病人医嘱执行数据
	 */
	public List<TwBryzzx> getListBrYzzxByKeyZxfldm(long v_key1,int v_key2,short v_yebh, String zxfl,Date xzrq ){
		String hql="";
		if(zxfl.equals("00")){
			hql = "from TwBryzzx where key1=:key1 and key2=:key2 and yebh=:yebh  and rq=:xzrq order by groupxh,sjdtime";
		}else{
			hql = "from TwBryzzx where key1=:key1 and key2=:key2 and yebh=:yebh and zxfldm=:zxfl  and rq=:xzrq order by groupxh,sjdtime";
		}
		Query query = getSession().createQuery(hql);
		if(zxfl.equals("00")){
			query.setLong("key1", v_key1);
			query.setInteger("key2", v_key2);
			query.setShort("yebh", v_yebh);
			query.setDate("xzrq", xzrq);
		}else{
			query.setLong("key1", v_key1);
			query.setInteger("key2", v_key2);
			query.setShort("yebh", v_yebh);
			query.setString("zxfl", zxfl);
			query.setDate("xzrq", xzrq);
		}
		return query.list();
		
	}

	/*
	 * 执行产生，病人医嘱执行数据的存储过程
	 * 
	 */
	
	public String callProcedureBrYzzx(long v_key1,int v_key2,short v_yebh,Date rq){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ProcedureCall pc = getSession().createStoredProcedureCall("pw_bryzzx_sc");
		pc.registerParameter("key1_In", long.class, ParameterMode.IN).bindValue(v_key1);
		pc.registerParameter("key2_In", int.class, ParameterMode.IN).bindValue(v_key2);
		pc.registerParameter("yebh_In", short.class, ParameterMode.IN).bindValue(v_yebh);
		pc.registerParameter("rq_In", Date.class, ParameterMode.IN).bindValue(rq);
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		String ls_errortext=pc.getOutputs().getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		System.out.println("ls_errortext:" + ls_errortext);
		return ls_return;
		
	}
	
	/*
	 * 执行保存医嘱执行的数据的存储过程
	 */
	
	public String callProcedureBrYzzx_baocun(Date rq,String sjd,char zxflag,long groupxh,String hsid,String hsxm,Date zxsj,String zxms,String crlflag,Double crl,String syflag){
		
		ProcedureCall pc = getSession().createStoredProcedureCall("pw_bryz_zx");
		pc.registerParameter("rq_In", Date.class, ParameterMode.IN).bindValue(rq);
		pc.registerParameter("groupxh_In", Long.class, ParameterMode.IN).bindValue(groupxh);
		pc.registerParameter("sjd_In", String.class, ParameterMode.IN).bindValue(sjd);
		pc.registerParameter("zxflag_In", char.class, ParameterMode.IN).bindValue(zxflag);
		pc.registerParameter("zxhsid_In", String.class, ParameterMode.IN).bindValue(hsid);
		pc.registerParameter("zxhsxm_In", String.class, ParameterMode.IN).bindValue(hsxm);
		pc.registerParameter("zxtime_In", Date.class, ParameterMode.IN).bindValue(zxsj);
		pc.registerParameter("zxms_In", String.class, ParameterMode.IN).bindValue(zxms);
		pc.registerParameter("crlflag_In", String.class, ParameterMode.IN).bindValue(crlflag);
		pc.registerParameter("crl_In", Double.class, ParameterMode.IN).bindValue(crl);
		pc.registerParameter("syflag_In", String.class, ParameterMode.IN).bindValue(syflag);
		
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		String ls_errortext=pc.getOutputs().getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		System.out.println("ls_errortext:" + ls_errortext);
		return ls_return;
		
	}
	
	/*
	 * 根据病区和日期查询输液类医嘱数据列表
	 */
	public List<TwPeiyeczJilu> getListBrYzzxForShuYeByBqidRiqi(String bq ,Date xzrq ){
//		dm 01 表示输液类 
//		String hql = "from TwBryzzx where zxfldm='01' and bq=:bq and rq=:xzrq order by chw, groupxh,sjdtime";
//		String sql = "select t1.ROWKEY,t1.key1,t1.key2,t1.yebh,t1.rq,t1.groupxh,t1.sjd,t1.sjdtime,t1.bq,t1.chw,"
//				+ "t1.yzid,t1.yzzdmc,t1.yzmc,t2.PEIYHSID,t2.PEIYHSXM,t2.PEIYTIME,t2.QDFLAG"
//				+ " from TW_BRYZZX t1 left join TW_PEIYECZ_JILU t2 on t1.ROWKEY = t2.ROWKEY where t1.zxfldm='01' and t1.bq=:bq and t1.rq=:xzrq order by t1.chw, t1.groupxh,t1.sjdtime";
		
		String sql = "select t1.ROWKEY,t1.key1,t1.key2,t1.yebh,t1.rq,t1.groupxh,t1.sjd,t1.sjdtime,t1.bq,t1.chw,"
				+ "t1.yzid,t1.yzzdmc,t1.yzmc,t2.PEIYHSID,t2.PEIYHSXM,t2.PEIYTIME,t2.QDFLAG,t3.bah,t3.xm,t3.nl,t3.xb"
				+ " from TW_BRYZZX t1,TW_PEIYECZ_JILU t2,vw_bqbr_zy t3 where t1.zxfldm='01' and t1.bq=:bq and t1.rq=:xzrq "
				+ " and t1.key1=t3.key1 and t1.key2=t3.key2 and t2.rowkey(+)=t1.rowkey order by t1.chw, t1.groupxh,t1.sjdtime";

//		Query query = getSession().createSQLQuery(sql).addScalar("rowkey",StringType.INSTANCE).addScalar("key1",LongType.INSTANCE)
//				.addScalar("key2",IntegerType.INSTANCE).addScalar("yebh",ShortType.INSTANCE)
//				.addScalar("rq",TimestampType.INSTANCE).addScalar("groupxh",IntegerType.INSTANCE)
//				.addScalar("sjd",StringType.INSTANCE).addScalar("sjdtime",TimestampType.INSTANCE)
//				.addScalar("bq",StringType.INSTANCE).addScalar("chw",StringType.INSTANCE)
//				.addScalar("yzid",StringType.INSTANCE).addScalar("yzzdmc",StringType.INSTANCE)
//				.addScalar("yzmc",StringType.INSTANCE).addScalar("PEIYHSID",StringType.INSTANCE)
//				.addScalar("PEIYHSXM",StringType.INSTANCE).addScalar("PEIYTIME",TimestampType.INSTANCE)
//				.addScalar("QDFLAG",StringType.INSTANCE)
//				.setResultTransformer(Transformers.aliasToBean(TwPeiyeczJilu.class));
		
		Query query = getSession().createSQLQuery(sql).addEntity(TwPeiyeczJilu.class);
		query.setString("bq", bq);
		query.setDate("xzrq", xzrq);
		List<TwPeiyeczJilu> twPeiyeczJilus = query.list();
		return twPeiyeczJilus;
		
	}
	
	/*
	 * 按rowkey  查询医嘱对应一条记录
	 */
	public TwBryzzx getTwBryzzxByRowkey(String rowkey){
		String hql = " from TwBryzzx where rowkey=:rowkey";
		Query query = getSession().createQuery(hql);
		query.setString("rowkey", rowkey);
		TwBryzzx twBryzzx = (TwBryzzx) query.uniqueResult();
		return twBryzzx;
	}
	
	/*
	 * 保存对象TwBryzzx
	 */
//	public void updateTwPeiyeczJiluByTwPeiyeczJilu(TwPeiyeczJilu twPeiyeczJilu){
//		getSession().saveOrUpdate(twPeiyeczJilu);
//	}
}
