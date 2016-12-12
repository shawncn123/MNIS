package com.his.mnis.dao;

import java.util.Date;

import org.hibernate.Query;

import com.his.mnis.entities.TwTwdMess;

public class TwTwdMessDao extends BaseDao {
	
	private TwTwdMess twTwdMess;

	public TwTwdMess getTwTwdMess() {
		return twTwdMess;
	}

	public void setTwTwdMess(TwTwdMess twTwdMess) {
		this.twTwdMess = twTwdMess;
	}

	public Long getJlidByRiQiAndKey(Long vkey1,Integer vkey2,Short vkey3,Date vrq){
		
		String hql = "select jlid from TW_TWD_MESS where handleflag='1' and beginrq=:v_rq and key1=:v_key1 and key2=:v_key2 and yebh=:v_key3 ";
		Query query = getSession().createSQLQuery(hql);
		query.setDate("v_rq", vrq);
		query.setLong("v_key1", vkey1);
		query.setInteger("v_key2", vkey2);
		query.setShort("v_key3", vkey3);
		if(query.uniqueResult() == null){
			String hql2 = "delete from TwTwdMess where beginrq=:v_rq and key1=:v_key1 and key2=:v_key2 and yebh=:v_key3";
			Query query2 = getSession().createQuery(hql2);
			query2.setDate("v_rq", vrq);
			query2.setLong("v_key1", vkey1);
			query2.setInteger("v_key2", vkey2);
			query2.setShort("v_key3", vkey3);
			query2.executeUpdate();
			return (long) 0;
		}else{
			Object obj = query.uniqueResult();
			return  Long.parseLong(obj.toString());		
//			return  (Long) query.uniqueResult();		
		}
	}
	
	/*
	 * 给TW_twd_mess插入数据让后台程序生成体温单图片
	 */
	public int addTwTwdMessRow(Long vkey1,Integer vkey2,Short vkey3,Date vbeginrq){
		
		String sqlstring = "insert into tw_twd_mess(jlid,stime,key1,key2,yebh,beginrq,handleflag) values(wseq_id.nextval,sysdate,:vkey1,:vkey2,:vkey3,:vbeginrq,'0')";
		Query query = getSession().createSQLQuery(sqlstring);
		query.setLong("vkey1", vkey1);
		query.setInteger("vkey2", vkey2);
		query.setShort("vkey3", vkey3);
		query.setDate("vbeginrq", vbeginrq);
		return query.executeUpdate();
	}
	
	/*
	 * 给TW_twd_mess 数据update 让后台程序生成体温单图片
	 */
	public int updateTwTwdMessRow(Long vkey1,Integer vkey2,Short vkey3,Date vbeginrq){
		
		String sqlstring = "update tw_twd_mess set handleflag='0' where beginrq=:vbeginrq and key1=:vkey1 and key2=:vkey2 and yebh=:vkey3";
		Query query = getSession().createSQLQuery(sqlstring);
		query.setLong("vkey1", vkey1);
		query.setInteger("vkey2", vkey2);
		query.setShort("vkey3", vkey3);
		query.setDate("vbeginrq", vbeginrq);
		return query.executeUpdate();
	}
	
	/*
	 * 取handleflag 数据判断体温单图片生成状态 0 等待处理 1 处理成功 2 处理错误
	 */
	public char getHandleflagFromTWTwdMess(Long vkey1,Integer vkey2,Short vkey3,Date vbeginrq){
		String sql1 = "select handleflag from tw_twd_mess where beginrq=:vbeginrq and key1=:vkey1 and key2=:vkey2 and yebh=:vkey3";
		Query query = getSession().createSQLQuery(sql1);
		query.setLong("vkey1", vkey1);
		query.setInteger("vkey2", vkey2);
		query.setShort("vkey3", vkey3);
		query.setDate("vbeginrq", vbeginrq);
		return (char) query.uniqueResult();
	}
	
	/*
	 * 根据key值取出体温记录的时间最小值
	 */
	public Date getMinDateByKey(Long vkey1,Integer vkey2,Short vkey3){
		String sql1 = "select min(rq) from tw_bq304 where key1=:vkey1 and key2=:vkey2 and key3=:vkey3";
		Query query = getSession().createSQLQuery(sql1);
		query.setLong("vkey1", vkey1);
		query.setInteger("vkey2", vkey2);
		query.setShort("vkey3", vkey3);
		return (Date) query.uniqueResult();
	}
	/*
	 * 根据key值取出体温记录的时间最大值
	 */
	public Date getMaxDateByKey(Long vkey1,Integer vkey2,Short vkey3){
		String sql1 = "select max(rq) from tw_bq304 where key1=:vkey1 and key2=:vkey2 and key3=:vkey3";
		Query query = getSession().createSQLQuery(sql1);
		query.setLong("vkey1", vkey1);
		query.setInteger("vkey2", vkey2);
		query.setShort("vkey3", vkey3);
		return (Date) query.uniqueResult();
	}
	
	public int deleteTwTwdMessRowByJlid(Long jlid){
		
		String sqlstring = "delete tw_twd_mess where jlid=:jlid";
		Query query = getSession().createSQLQuery(sqlstring);
		query.setLong("jlid", jlid);
		return query.executeUpdate();
	}
}
