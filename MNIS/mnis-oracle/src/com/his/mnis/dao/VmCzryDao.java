package com.his.mnis.dao;

import org.hibernate.Query;

import com.his.mnis.entities.VmCzry;

public class VmCzryDao extends BaseDao {

	private String yonghuming;
	private String renyuan_bianma;

	public String getYonghuming() {
		return yonghuming;
	}

	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}

	public String getRenyuan_bianma() {
		return renyuan_bianma;
	}

	public void setRenyuan_bianma(String renyuan_bianma) {
		this.renyuan_bianma = renyuan_bianma;
	}

	public VmCzry getVmCzryByName(String yonghuming,String renyuan_bianma) {
		System.out.println("getVmCzryByName");
		String hql = "from VmCzry e where e.yonghuming=:yonghuming and renyuan_bianma=:renyuan_bianma";
		Query query = getSession().createQuery(hql);
		query.setString("yonghuming",yonghuming);
		query.setString("renyuan_bianma",renyuan_bianma);
		
		return (VmCzry) query.uniqueResult();
	}

}
