package com.his.mnis.entities;

import java.sql.Timestamp;
import java.util.List;

/**
 * TwBryzzx entity. @author MyEclipse Persistence Tools
 */

public class TwBryzzx_brxx_yzmcs_remodel implements java.io.Serializable {

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
	private String bah;
	private String xm;
	private String xb;
	private String nl;
	private String yzid;
	private String yzzdmc;
	private String yzmc;
	private List<String> yzmcs;
	private String zxlb;
	private String yf2mc;
	private String zxflag;
	private Timestamp zxtime;
	private String zxhsid;
	private String zxhsxm;
	private String zxms;
	private String zxfldm;
	private String lsflag;
	private Long yzfsh;
	private String crlflag;
	private Double crl;
	private String czfl;
	private String syflag;
	
	// Constructors

	/** default constructor */
	public TwBryzzx_brxx_yzmcs_remodel() {
	}

	/** minimal constructor */
	public TwBryzzx_brxx_yzmcs_remodel(Long key1, Integer key2, Short yebh, Long groupxh,
			String sjd, String zxlb, String zxflag, String lsflag,
			String crlflag) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.groupxh = groupxh;
		this.sjd = sjd;
		this.zxlb = zxlb;
		this.zxflag = zxflag;
		this.lsflag = lsflag;
		this.crlflag = crlflag;
	}

	public TwBryzzx_brxx_yzmcs_remodel(String rowkey, Long key1, Integer key2,
			Short yebh, Timestamp rq, Long groupxh, String sjd,
			Timestamp sjdtime, String bq, String chw, String bah, String xm,
			String xb, String nl, String yzid, String yzzdmc, String yzmc,
			List<String> yzmcs, String zxlb, String yf2mc, String zxflag,
			Timestamp zxtime, String zxhsid, String zxhsxm, String zxms,
			String zxfldm, String lsflag, Long yzfsh, String crlflag,
			Double crl, String czfl, String syflag) {
		super();
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
		this.bah = bah;
		this.xm = xm;
		this.xb = xb;
		this.nl = nl;
		this.yzid = yzid;
		this.yzzdmc = yzzdmc;
		this.yzmc = yzmc;
		this.yzmcs = yzmcs;
		this.zxlb = zxlb;
		this.yf2mc = yf2mc;
		this.zxflag = zxflag;
		this.zxtime = zxtime;
		this.zxhsid = zxhsid;
		this.zxhsxm = zxhsxm;
		this.zxms = zxms;
		this.zxfldm = zxfldm;
		this.lsflag = lsflag;
		this.yzfsh = yzfsh;
		this.crlflag = crlflag;
		this.crl = crl;
		this.czfl = czfl;
		this.syflag = syflag;
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

	public String getZxlb() {
		return this.zxlb;
	}

	public void setZxlb(String zxlb) {
		this.zxlb = zxlb;
	}

	public String getYf2mc() {
		return this.yf2mc;
	}

	public void setYf2mc(String yf2mc) {
		this.yf2mc = yf2mc;
	}

	public String getZxflag() {
		return this.zxflag;
	}

	public void setZxflag(String zxflag) {
		this.zxflag = zxflag;
	}

	public Timestamp getZxtime() {
		return this.zxtime;
	}

	public void setZxtime(Timestamp zxtime) {
		this.zxtime = zxtime;
	}

	public String getZxhsid() {
		return this.zxhsid;
	}

	public void setZxhsid(String zxhsid) {
		this.zxhsid = zxhsid;
	}

	public String getZxhsxm() {
		return this.zxhsxm;
	}

	public void setZxhsxm(String zxhsxm) {
		this.zxhsxm = zxhsxm;
	}

	public String getZxms() {
		return this.zxms;
	}

	public void setZxms(String zxms) {
		this.zxms = zxms;
	}

	public String getZxfldm() {
		return this.zxfldm;
	}

	public void setZxfldm(String zxfldm) {
		this.zxfldm = zxfldm;
	}

	public String getLsflag() {
		return this.lsflag;
	}

	public void setLsflag(String lsflag) {
		this.lsflag = lsflag;
	}

	public Long getYzfsh() {
		return this.yzfsh;
	}

	public void setYzfsh(Long yzfsh) {
		this.yzfsh = yzfsh;
	}

	public String getCrlflag() {
		return this.crlflag;
	}

	public void setCrlflag(String crlflag) {
		this.crlflag = crlflag;
	}

	public Double getCrl() {
		return this.crl;
	}

	public void setCrl(Double crl) {
		this.crl = crl;
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

	public List<String> getYzmcs() {
		return yzmcs;
	}

	public void setYzmcs(List<String> yzmcs) {
		this.yzmcs = yzmcs;
	}

	public String getCzfl() {
		return czfl;
	}

	public void setCzfl(String czfl) {
		this.czfl = czfl;
	}

	public String getSyflag() {
		return syflag;
	}

	public void setSyflag(String syflag) {
		this.syflag = syflag;
	}

}