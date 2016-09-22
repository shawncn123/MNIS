package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.TwBryzzx;

public class ShuYeZhiXingDao extends BaseDao {

	 /*
	  * 根据护士ID,执行分类代码查询相关病人输液执行医嘱
	  */
	public List<TwBryzzx> getMyBingRenShuYeZhiXingYiZhu(String hsid,String zxfldm){

		/*
		 * 查询所有未执行医嘱
		 */
		String hql="";
		if(zxfldm.equals("00")){
			hql = "select t1.rowkey,t1.key1,t1.key2,t1.yebh,t1.rq,t1.groupxh,t1.sjd,t1.sjdtime,t1.bq,t1.chw,t1.yzid,t1.yzzdmc,"
					+ "t1.yzmc,t1.zxlb,t1.yf2mc,t1.zxflag,t1.zxtime,t1.zxhsid,t1.zxhsxm,t1.zxms,t1.zxfldm,t1.lsflag "
					+ "from TW_BRYZZX t1, vw_bqbr_zy t2,tw_wdbr t3 "
					+ "where t1.key1=t2.key1 and t1.key2=t2.key2 and t3.bq=t2.bq and t3.chw=t2.chw and t3.hsid=:hsid and t1.zxflag='0'"
					+ " order by t1.bq,t1.chw,t1.groupxh,t1.sjdtime";
		}else{
			hql = "select t1.rowkey,t1.key1,t1.key2,t1.yebh,t1.rq,t1.groupxh,t1.sjd,t1.sjdtime,t1.bq,t1.chw,t1.yzid,t1.yzzdmc,"
					+ "t1.yzmc,t1.zxlb,t1.yf2mc,t1.zxflag,t1.zxtime,t1.zxhsid,t1.zxhsxm,t1.zxms,t1.zxfldm,t1.lsflag "
					+ "from TW_BRYZZX t1, vw_bqbr_zy t2,tw_wdbr t3 "
					+ "where t1.key1=t2.key1 and t1.key2=t2.key2 and t3.bq=t2.bq and t3.chw=t2.chw and t3.hsid=:hsid and t1.zxflag='0' and t1.zxfldm=:zxfldm"
					+ " order by t1.bq,t1.chw,t1.groupxh,t1.sjdtime";
		}
		Query query = getSession().createSQLQuery(hql).addEntity(TwBryzzx.class);
		query.setString("hsid", hsid);
		if(!zxfldm.equals("00")){
			query.setString("zxfldm", zxfldm);
		}
		return query.list();
	}
	
}
