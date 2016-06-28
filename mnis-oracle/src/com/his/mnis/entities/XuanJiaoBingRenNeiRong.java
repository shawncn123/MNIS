package com.his.mnis.entities;

import java.util.List;

public class XuanJiaoBingRenNeiRong {

	private String fldm;
	private String flmc;
	private List<XuanJiaoBingRenNeiRongSub> xuanJiaoBingRenNeiRongSubs;
	public String getFldm() {
		return fldm;
	}
	public void setFldm(String fldm) {
		this.fldm = fldm;
	}
	public String getFlmc() {
		return flmc;
	}
	public void setFlmc(String flmc) {
		this.flmc = flmc;
	}
	public List<XuanJiaoBingRenNeiRongSub> getXuanJiaoBingRenNeiRongSubs() {
		return xuanJiaoBingRenNeiRongSubs;
	}
	public void setXuanJiaoBingRenNeiRongSubs(
			List<XuanJiaoBingRenNeiRongSub> xuanJiaoBingRenNeiRongSubs) {
		this.xuanJiaoBingRenNeiRongSubs = xuanJiaoBingRenNeiRongSubs;
	}
	public XuanJiaoBingRenNeiRong(String fldm, String flmc,
			List<XuanJiaoBingRenNeiRongSub> xuanJiaoBingRenNeiRongSubs) {
		super();
		this.fldm = fldm;
		this.flmc = flmc;
		this.xuanJiaoBingRenNeiRongSubs = xuanJiaoBingRenNeiRongSubs;
	}
	public XuanJiaoBingRenNeiRong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
