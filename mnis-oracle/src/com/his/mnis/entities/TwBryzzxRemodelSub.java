package com.his.mnis.entities;

import java.util.Date;

public class TwBryzzxRemodelSub {
	
	private String sjd;
	private Date sjdtime;
	private String zxflag;
	private Date zxtime;
	private String zxhsid;   //执行护士id
	private String zxhsxm;   //执行护士姓名
	private String zxms;     //执行描述信息(备注)
	private String rowkey;
	private String crlflag;
    private Double crl;
	
	public Double getCrl() {
		return crl;
	}
	public void setCrl(Double crl) {
		this.crl = crl;
	}
	public String getCrlflag() {
		return crlflag;
	}
	public void setCrlflag(String crlflag) {
		this.crlflag = crlflag;
	}
	
	public String getRowkey() {
		return rowkey;
	}
	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}
	public String getSjd() {
		return sjd;
	}
	public void setSjd(String sjd) {
		this.sjd = sjd;
	}
	public Date getSjdtime() {
		return sjdtime;
	}
	public void setSjdtime(Date sjdtime) {
		this.sjdtime = sjdtime;
	}
	public String getZxflag() {
		return zxflag;
	}
	public void setZxflag(String zxflag) {
		this.zxflag = zxflag;
	}
	public Date getZxtime() {
		return zxtime;
	}
	public void setZxtime(Date zxtime) {
		this.zxtime = zxtime;
	}
	public String getZxhsid() {
		return zxhsid;
	}
	public void setZxhsid(String zxhsid) {
		this.zxhsid = zxhsid;
	}
	public String getZxhsxm() {
		return zxhsxm;
	}
	public void setZxhsxm(String zxhsxm) {
		this.zxhsxm = zxhsxm;
	}
	public String getZxms() {
		return zxms;
	}
	public void setZxms(String zxms) {
		this.zxms = zxms;
	}
	
}
