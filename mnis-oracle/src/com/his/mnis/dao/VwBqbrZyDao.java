package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VwBqbrZy;

public class VwBqbrZyDao extends BaseDao {

	/*
	 *查询我的病人 按病区，护士id 
	 */
	public List<VwBqbrZy> getListWoDeBingRenByBqidHsId(String bqid,String hsid){
		String ssql = "select t1.ROWKEY,t1.KEY1, t1.KEY2, t1.BQ, t1.CHW, t1.BAH, t1.XM, t1.XB, t1.NL, t1.KSID, t1.KSMC, t1.YSXM,"
				+"t1.HSXM, t1.HLDJ, t1.FYLB, t1.RYRQ, t1.JCFLAG, t1.FYLB_BOXCOLOR, t1.DQBKZT, t1.RYZD, t1.GMLS, t1.SHANSHI, t1.SSMS,"
				+"t1.YEMS, t1.ZYTSMS,t1.AQTX  from vw_bqbr_zy t1, tw_wdbr t2 "
				+ "where t1.BQ = :bq and t1.BQ = t2.bq and t2.hsid =:hsid and t1.CHW = t2.chw order by t1.JCFLAG,t1.CHW";
		Query query = getSession().createSQLQuery(ssql).addEntity(VwBqbrZy.class);
//		String ssql = "select t1 from VwBqbrZy t1,TwWdbr t2 where t1.bq = t2.bq and t2.hsid=:hsid and t1.chw = t2.chw and t1.bq=:bq order by t1.jcflag,t1.chw";
//		String ssql = "select t1 from vw_bqbr_zy t1,tw_wdbr t2 where t1.bq = t2.bq and t2.hsid=:hsid and t1.chw = t2.chw and t1.bq=:bq order by t1.jcflag,t1.chw";
//		Query query = getSession().createSQLQuery(ssql);
		query.setString("bq", bqid);
		query.setString("hsid", hsid);
		List<VwBqbrZy> vwBqbrZys = query.list();
		return vwBqbrZys;
	}
	
	/*
	 * 查询责任病人 按病区、护士姓名（按护士id更好，后期可能调整）
	 */
	public List<VwBqbrZy> getListZeRenBingRenByBqidHsxm(String bqid,String hsxm){
		String hql = "from VwBqbrZy where bq = :bq and hsxm =:hsxm order by jcflag,chw";
		Query query = getSession().createQuery(hql);
		query.setString("bq", bqid);
		query.setString("hsxm", hsxm);
		return query.list();
	}
	/*
	 * 根据病区id查询病人
	 */
	public List<VwBqbrZy> getListVwBqbrZyByBqid(String bqid){
		String hql = "from VwBqbrZy where bq = :bq order by jcflag,chw";
		Query query = getSession().createQuery(hql);
		query.setString("bq",bqid);
		return query.list();
	}
	
	/*
	 * 根据key1，key2 查询病人个体信息
	 */
	public VwBqbrZy getBingRenXingXiByKey(Long key1,Integer key2){
		String hql = "from VwBqbrZy where key1=:key1 and key2=:key2";
		Query query = getSession().createQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		return (VwBqbrZy) query.uniqueResult();
	}
}
