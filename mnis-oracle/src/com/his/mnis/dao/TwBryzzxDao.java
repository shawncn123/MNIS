package com.his.mnis.dao;

import java.text.SimpleDateFormat;
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
import org.hibernate.type.TimestampType;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwPeiyeczJilu;

public class TwBryzzxDao extends BaseDao {

	/*
	 * 根据病人key1,key2值查询病人医嘱执行数据
	 */

	public List<TwBryzzx> getListBrYzzxByKey(long v_key1,int v_key2,short v_yebh,Date xzrq){
		
//		String hql = "from TwBryzzx where key1=:key1 and key2=:key2 and yebh=:yebh and zxflag='0' order by groupxh,sjdtime";
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
//		if(zxfl.equals("00")){
//		 hql = "from TwBryzzx where key1=:key1 and key2=:key2 and yebh=:yebh and zxflag='0' order by groupxh,sjdtime";
//		}else{
//			hql = "from TwBryzzx where key1=:key1 and key2=:key2 and yebh=:yebh and zxflag='0' and zxfldm=:zxfl order by groupxh,sjdtime";
//		}
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
//		Date rq = new Date();
		ProcedureCall pc = getSession().createStoredProcedureCall("pw_bryzzx_sc");
		pc.registerParameter("key1_In", long.class, ParameterMode.IN).bindValue(v_key1);
		pc.registerParameter("key2_In", int.class, ParameterMode.IN).bindValue(v_key2);
		pc.registerParameter("yebh_In", short.class, ParameterMode.IN).bindValue(v_yebh);
//		try {
//			rq = sdf.parse(sdf.format(new Date()));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
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
		String sql = "select t1.ROWKEY,t1.key1,t1.key2,t1.yebh,t1.rq,t1.groupxh,t1.sjd,t1.sjdtime,t1.bq,t1.chw,"
				+ "t1.yzid,t1.yzzdmc,t1.yzmc,t2.PEIYHSID,t2.PEIYHSXM,t2.PEIYTIME,t2.QDFLAG"
				+ " from TW_BRYZZX t1 left join TW_PEIYECZ_JILU t2 on t1.ROWKEY = t2.ROWKEY where t1.zxfldm='01' and t1.bq=:bq and t1.rq=:xzrq order by t1.chw, t1.groupxh,t1.sjdtime";

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
