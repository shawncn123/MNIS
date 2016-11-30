package com.his.mnis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.TwHulijlbiaoZd;
import com.his.mnis.entities.TwHulipingguPingguJilu;

public class TwHulijlbiaoZdDao extends BaseDao {

	public List<TwHulijlbiaoZd> getListTwHulijlbiaoZd(int bbfl){
		String hql = "from TwHulijlbiaoZd where bbfl=:bbfl and tyflag='0' order by xsxh";
		Query query = getSession().createQuery(hql);
		query.setInteger("bbfl", bbfl);
		return query.list();
	}
	
	public int saveTHuLiPingGu_JiLu(TwHulipingguPingguJilu twHulipingguPingguJilu){
		String sql = "insert into TW_HULIPINGGU_PINGGU_JILU"
				+ "(ROWKEY,KEY1,KEY2,YEBH,XMID,ZDDADA_1,ZDDADA_2,ZDDADA_3,ZDDADA_4,ZDDADA_5,BBFL,ZXHSID,PGRQ,JLRQ) "
				+ "values(:ROWKEY,:KEY1,:KEY2,:YEBH,:XMID,:ZDDADA_1,:ZDDADA_2,:ZDDADA_3,:ZDDADA_4,:ZDDADA_5,:BBFL,:ZXHSID,:PGRQ,:JLRQ)";
//		Integer vid = (Integer) getSession().save(twHulipingguPingguJilu);
//		return vid;
		Query query = getSession().createSQLQuery(sql);
		query.setLong("ROWKEY", twHulipingguPingguJilu.getRowkey());
		query.setLong("KEY1", twHulipingguPingguJilu.getKey1());
		query.setInteger("KEY2", twHulipingguPingguJilu.getKey2());
		query.setShort("YEBH", twHulipingguPingguJilu.getYebh());
		query.setString("XMID",twHulipingguPingguJilu.getXmid());
		query.setString("ZDDADA_1", twHulipingguPingguJilu.getZddada1());
		query.setString("ZDDADA_2", twHulipingguPingguJilu.getZddada2());
		query.setString("ZDDADA_3", twHulipingguPingguJilu.getZddada3());
		query.setString("ZDDADA_4", twHulipingguPingguJilu.getZddada4());
		query.setString("ZDDADA_5", twHulipingguPingguJilu.getZddada5());
		query.setBigDecimal("BBFL", twHulipingguPingguJilu.getBbfl());
		query.setString("ZXHSID", twHulipingguPingguJilu.getZxhsid());
		query.setDate("PGRQ", twHulipingguPingguJilu.getPgrq());
		query.setDate("JLRQ", twHulipingguPingguJilu.getJlrq());
		int crows = query.executeUpdate();
		return crows;
		
	}
	
	public int updateTHuLiPingGu_JiLu(TwHulipingguPingguJilu twHulipingguPingguJilu){
		String sql = "update TW_HULIPINGGU_PINGGU_JILU set ZDDADA_1=:zddata_1,ZDDADA_2=:zddata_2,"
				+ "ZDDADA_3=:zddata_3,ZDDADA_4=:zddata_4,ZDDADA_5=:zddata_5,JLRQ=:jlrq,ZXHSID=:zxhsid where ROWKEY=:rowkey";
		Query query=getSession().createSQLQuery(sql);
//		String vzdata_2 = "";
//		vzdata_2 = twHulipingguPingguJilu.getZddada2();
		query.setString("zddata_1", twHulipingguPingguJilu.getZddada1());
		query.setString("zddata_2", twHulipingguPingguJilu.getZddada2());
		query.setString("zddata_3", twHulipingguPingguJilu.getZddada3());
		query.setString("zddata_4", twHulipingguPingguJilu.getZddada4());
		query.setString("zddata_5", twHulipingguPingguJilu.getZddada5());
		query.setDate("jlrq", twHulipingguPingguJilu.getJlrq());
		query.setLong("rowkey", twHulipingguPingguJilu.getRowkey());
		query.setString("zxhsid", twHulipingguPingguJilu.getZxhsid());
		return query.executeUpdate();
	}
	
	/*
	 * 按分类、病人、日期查询出相关评估记录数据
	 */
	public List<TwHulipingguPingguJilu> getListPingguJilu(Long key1,Integer key2,Short yebh,Date pgrq,Integer bbfl){
		String hql = "from TwHulipingguPingguJilu where key1=:key1 and key2=:key2 and yebh=:yebh and bbfl=:bbfl and pgrq=:pgrq";
		Query query = getSession().createQuery(hql);
		query.setLong("key1", key1);
		query.setInteger("key2", key2);
		query.setShort("yebh", yebh);
		query.setInteger("bbfl", bbfl);
		query.setDate("pgrq", pgrq);
		return query.list();
	}
}
