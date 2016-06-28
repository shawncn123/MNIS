package com.his.mnis.entities;

public class XuanJiaoBingRenNeiRongSub {

	private String dm;
	private String mc;
	private String yjflag;   //"1" 表示已宣教 "0"表示未宣教
	private String xjnr;
	
	public String getDm() {
		return dm;
	}
	public void setDm(String dm) {
		this.dm = dm;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getYjflag() {
		return yjflag;
	}
	public void setYjflag(String yjflag) {
		this.yjflag = yjflag;
	}
	public String getXjnr() {
		return xjnr;
	}
	public void setXjnr(String xjnr) {
		this.xjnr = xjnr;
	}
	public XuanJiaoBingRenNeiRongSub(String dm, String mc, String yjflag,
			String xjnr) {
		super();
		this.dm = dm;
		this.mc = mc;
		this.yjflag = yjflag;
		this.xjnr = xjnr;
	}
	public XuanJiaoBingRenNeiRongSub() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
