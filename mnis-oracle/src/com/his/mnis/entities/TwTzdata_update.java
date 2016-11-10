package com.his.mnis.entities;

import java.sql.Timestamp;

public class TwTzdata_update {

	private Long jlid;
	private String xmid;
	private String value1;
	private String value2;
	private String bz;
	private String xmmc;
	private String dw;
	private String bzflag;
	private String sj;
	private Long pcid;
	private Timestamp stime;
	
	public Timestamp getStime() {
		return stime;
	}
	public void setStime(Timestamp stime) {
		this.stime = stime;
	}
	public Long getPcid() {
		return pcid;
	}
	public void setPcid(Long pcid) {
		this.pcid = pcid;
	}
	public String getSj() {
		return sj;
	}
	public void setSj(String sj) {
		this.sj = sj;
	}
	public Long getJlid() {
		return jlid;
	}
	public void setJlid(Long jlid) {
		this.jlid = jlid;
	}
	public String getXmid() {
		return xmid;
	}
	public void setXmid(String xmid) {
		this.xmid = xmid;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getBzflag() {
		return bzflag;
	}
	public void setBzflag(String bzflag) {
		this.bzflag = bzflag;
	}
	
	public TwTzdata_update() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TwTzdata_update(Long jlid, String xmid, String value1,
			String value2, String bz, String xmmc, String dw, String bzflag,
			String sj, Long pcid, Timestamp stime) {
		super();
		this.jlid = jlid;
		this.xmid = xmid;
		this.value1 = value1;
		this.value2 = value2;
		this.bz = bz;
		this.xmmc = xmmc;
		this.dw = dw;
		this.bzflag = bzflag;
		this.sj = sj;
		this.pcid = pcid;
		this.stime = stime;
	}
	
	
	
	
}
