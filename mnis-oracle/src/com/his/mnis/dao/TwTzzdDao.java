package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.TwTzzd;

public class TwTzzdDao extends BaseDao {

	private String bqid;

	public String getBqid() {
		return bqid;
	}

	public void setBqid(String bqid) {
		this.bqid = bqid;
	}
	
	public List<TwTzzd> getBingRenTiZhengLuRuByBingQuId(String bqid){
		
//		String hql = "from TwTzzd where gdflag='1' or (	gdflag='0' and (bq is null or :bq in bq" + ",)) Order by xsxh";
		String hql = "from TwTzzd where gdflag='1' or bq is null or bq like :bq Order by xsxh";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.setString("bq", "%"+bqid + ",%");
		return query.list();
				
	}
	
}
