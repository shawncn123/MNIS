package com.his.mnis.entities;

public class MyBingRen {
	
	private Long key1;
	private Integer key2;
	private String bq;
	private String chw;
	private String bah;
	private String xm;
	private String xb;
	private String nl;
	private String ksid;
	private String ksmc;
	private String ysxm;
	private String hsxm;
	private String quedflag;
	
	public Long getKey1() {
		return key1;
	}
	public void setKey1(Long key1) {
		this.key1 = key1;
	}
	public Integer getKey2() {
		return key2;
	}
	public void setKey2(Integer key2) {
		this.key2 = key2;
	}
	public String getBq() {
		return bq;
	}
	public void setBq(String bq) {
		this.bq = bq;
	}
	public String getChw() {
		return chw;
	}
	public void setChw(String chw) {
		this.chw = chw;
	}
	public String getBah() {
		return bah;
	}
	public void setBah(String bah) {
		this.bah = bah;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}
	public String getKsid() {
		return ksid;
	}
	public void setKsid(String ksid) {
		this.ksid = ksid;
	}
	public String getKsmc() {
		return ksmc;
	}
	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}
	public String getYsxm() {
		return ysxm;
	}
	public void setYsxm(String ysxm) {
		this.ysxm = ysxm;
	}
	public String getHsxm() {
		return hsxm;
	}
	public void setHsxm(String hsxm) {
		this.hsxm = hsxm;
	}
	
	public String getQuedflag() {
		return quedflag;
	}
	public void setQuedflag(String quedflag) {
		this.quedflag = quedflag;
	}
	
	public MyBingRen(Long key1, Integer key2, String bq, String chw,
			String bah, String xm, String xb, String nl, String ksid,
			String ksmc, String ysxm, String hsxm, String quedflag) {
		super();
		this.key1 = key1;
		this.key2 = key2;
		this.bq = bq;
		this.chw = chw;
		this.bah = bah;
		this.xm = xm;
		this.xb = xb;
		this.nl = nl;
		this.ksid = ksid;
		this.ksmc = ksmc;
		this.ysxm = ysxm;
		this.hsxm = hsxm;
		this.quedflag = quedflag;
	}
	
	public MyBingRen() {
		super();
	}
  
}
