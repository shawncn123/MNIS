package com.his.mnis.entities;

import java.sql.Timestamp;
import java.util.List;

/**
 * TwBryzzx entity. @author MyEclipse Persistence Tools
 */

public class TwBryzzxPeiYeRemodel implements java.io.Serializable {

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
	private List<String> yzmcs;
	private String yf2mc;
	private String bzflag;
	
	public TwBryzzxPeiYeRemodel() {
		super();
	}

	public TwBryzzxPeiYeRemodel(String rowkey, Long key1, Integer key2,
			Short yebh, Timestamp rq, Long groupxh, String sjd,
			Timestamp sjdtime, String bq, String chw, String yzid,
			String yzzdmc, String yzmc, List<String> yzmcs, String yf2mc,
			String bzflag) {
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
		this.yzid = yzid;
		this.yzzdmc = yzzdmc;
		this.yzmc = yzmc;
		this.yzmcs = yzmcs;
		this.yf2mc = yf2mc;
		this.bzflag = bzflag;
	}

	public String getRowkey() {
		return rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

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

	public Short getYebh() {
		return yebh;
	}

	public void setYebh(Short yebh) {
		this.yebh = yebh;
	}

	public Timestamp getRq() {
		return rq;
	}

	public void setRq(Timestamp rq) {
		this.rq = rq;
	}

	public Long getGroupxh() {
		return groupxh;
	}

	public void setGroupxh(Long groupxh) {
		this.groupxh = groupxh;
	}

	public String getSjd() {
		return sjd;
	}

	public void setSjd(String sjd) {
		this.sjd = sjd;
	}

	public Timestamp getSjdtime() {
		return sjdtime;
	}

	public void setSjdtime(Timestamp sjdtime) {
		this.sjdtime = sjdtime;
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

	public String getYzid() {
		return yzid;
	}

	public void setYzid(String yzid) {
		this.yzid = yzid;
	}

	public String getYzzdmc() {
		return yzzdmc;
	}

	public void setYzzdmc(String yzzdmc) {
		this.yzzdmc = yzzdmc;
	}

	public String getYzmc() {
		return yzmc;
	}

	public void setYzmc(String yzmc) {
		this.yzmc = yzmc;
	}

	public List<String> getYzmcs() {
		return yzmcs;
	}

	public void setYzmcs(List<String> yzmcs) {
		this.yzmcs = yzmcs;
	}

	public String getYf2mc() {
		return yf2mc;
	}

	public void setYf2mc(String yf2mc) {
		this.yf2mc = yf2mc;
	}

	public String getBzflag() {
		return bzflag;
	}

	public void setBzflag(String bzflag) {
		this.bzflag = bzflag;
	}

	
}