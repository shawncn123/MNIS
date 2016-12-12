package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * TwPeiyeczJilu entity. @author MyEclipse Persistence Tools
 */

public class TwPeiyeczJilu implements java.io.Serializable {

	// Fields

	private String rowkey;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private Timestamp rq;
	private Long groupxh;
	private String sjd;
	private Timestamp sjdtime;
	private String bq;
	private String chw;
	private String yzid;
	private String yzzdmc;
	private String yzmc;
	private String peiyhsid;
	private String peiyhsxm;
	private Timestamp peiytime;
	private String qdflag;
	private String xm;
	private String xb;
	private String nl;
	private String bah;

	// Constructors

	/** default constructor */
	public TwPeiyeczJilu() {
	}

	/** minimal constructor */
	public TwPeiyeczJilu(String rowkey, Long key1, Integer key2, Short yebh,
			Long groupxh, String sjd, String qdflag) {
		this.rowkey = rowkey;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.groupxh = groupxh;
		this.sjd = sjd;
		this.qdflag = qdflag;
	}

	/** full constructor */
	public TwPeiyeczJilu(String rowkey, Long key1, Integer key2, Short yebh,
			Timestamp rq, Long groupxh, String sjd, Timestamp sjdtime,
			String bq, String chw, String yzid, String yzzdmc, String yzmc,
			String peiyhsid, String peiyhsxm, Timestamp peiytime,
			String qdflag, String xm, String xb, String nl, String bah) {
		this.rowkey = rowkey;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.rq = rq;
		this.groupxh = groupxh;
		this.sjd = sjd;
		this.sjdtime = sjdtime;
		this.bq = bq;
		this.chw = chw;
		this.yzid = yzid;
		this.yzzdmc = yzzdmc;
		this.yzmc = yzmc;
		this.peiyhsid = peiyhsid;
		this.peiyhsxm = peiyhsxm;
		this.peiytime = peiytime;
		this.qdflag = qdflag;
		this.xm = xm;
		this.xb = xb;
		this.nl = nl;
		this.bah = bah;
	}

	// Property accessors

	public String getRowkey() {
		return this.rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public Long getKey1() {
		return this.key1;
	}

	public void setKey1(Long key1) {
		this.key1 = key1;
	}

	public Integer getKey2() {
		return this.key2;
	}

	public void setKey2(Integer key2) {
		this.key2 = key2;
	}

	public Short getYebh() {
		return this.yebh;
	}

	public void setYebh(Short yebh) {
		this.yebh = yebh;
	}

	public Timestamp getRq() {
		return this.rq;
	}

	public void setRq(Timestamp rq) {
		this.rq = rq;
	}

	public Long getGroupxh() {
		return this.groupxh;
	}

	public void setGroupxh(Long groupxh) {
		this.groupxh = groupxh;
	}

	public String getSjd() {
		return this.sjd;
	}

	public void setSjd(String sjd) {
		this.sjd = sjd;
	}

	public Timestamp getSjdtime() {
		return this.sjdtime;
	}

	public void setSjdtime(Timestamp sjdtime) {
		this.sjdtime = sjdtime;
	}

	public String getBq() {
		return this.bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getChw() {
		return this.chw;
	}

	public void setChw(String chw) {
		this.chw = chw;
	}

	public String getYzid() {
		return this.yzid;
	}

	public void setYzid(String yzid) {
		this.yzid = yzid;
	}

	public String getYzzdmc() {
		return this.yzzdmc;
	}

	public void setYzzdmc(String yzzdmc) {
		this.yzzdmc = yzzdmc;
	}

	public String getYzmc() {
		return this.yzmc;
	}

	public void setYzmc(String yzmc) {
		this.yzmc = yzmc;
	}

	public String getPeiyhsid() {
		return this.peiyhsid;
	}

	public void setPeiyhsid(String peiyhsid) {
		this.peiyhsid = peiyhsid;
	}

	public String getPeiyhsxm() {
		return this.peiyhsxm;
	}

	public void setPeiyhsxm(String peiyhsxm) {
		this.peiyhsxm = peiyhsxm;
	}

	public Timestamp getPeiytime() {
		return this.peiytime;
	}

	public void setPeiytime(Timestamp peiytime) {
		this.peiytime = peiytime;
	}

	public String getQdflag() {
		return this.qdflag;
	}

	public void setQdflag(String qdflag) {
		this.qdflag = qdflag;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getNl() {
		return this.nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public String getBah() {
		return this.bah;
	}

	public void setBah(String bah) {
		this.bah = bah;
	}

}