package com.his.mnis.entities;

import java.sql.Timestamp;
import java.util.List;

/**
 * TwBryzzx entity. @author MyEclipse Persistence Tools
 */

public class TwBryzzxRemodel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rowkey;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private Timestamp rq;
	private Long groupxh;
	private String lsflag;
//	private String sjd;
//	private Timestamp sjdtime;
	private String bq;
	private String chw;
	private String yzid;
	private String yzzdmc;
	private List<String> yzmcs;
	private String zxlb;
	private String yf2mc;
//	private String zxflag;
//	private Timestamp zxtime;
//	private String zxhsid;
//	private String zxhsxm;
//	private String zxms;
	private List<TwBryzzxRemodelSub> twBryzzxRemodelSubs;

	// Constructors

	/** default constructor */
	public TwBryzzxRemodel() {
	}

	/** minimal constructor */
	public TwBryzzxRemodel(Long key1, Integer key2, Short yebh, Long groupxh,String zxlb) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.groupxh = groupxh;
		this.zxlb = zxlb;
	}

	/** full constructor */

	public TwBryzzxRemodel(String rowkey, Long key1, Integer key2, Short yebh,
			Timestamp rq, Long groupxh, String bq, String chw, String yzid,
			String yzzdmc, List<String> yzmcs, String zxlb, String yf2mc,String lsflag,
			List<TwBryzzxRemodelSub> twBryzzxRemodelSubs) {
		super();
		this.rowkey = rowkey;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.rq = rq;
		this.groupxh = groupxh;
		this.bq = bq;
		this.chw = chw;
		this.yzid = yzid;
		this.yzzdmc = yzzdmc;
		this.yzmcs = yzmcs;
		this.zxlb = zxlb;
		this.yf2mc = yf2mc;
		this.lsflag = lsflag;
		this.twBryzzxRemodelSubs = twBryzzxRemodelSubs;
	}

	// Property accessors

	public String getLsflag() {
		return this.lsflag;
	}

	public void setLsflag(String lsflag) {
		this.lsflag = lsflag;
	}
	
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

	public List<String> getYzmcs() {
		return this.yzmcs;
	}

	public void setYzmcs(List<String> yzmcs) {
		this.yzmcs = yzmcs;
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

	public List<TwBryzzxRemodelSub> getTwBryzzxRemodelSubs() {
		return twBryzzxRemodelSubs;
	}

	public void setTwBryzzxRemodelSubs(List<TwBryzzxRemodelSub> twBryzzxRemodelSubs) {
		this.twBryzzxRemodelSubs = twBryzzxRemodelSubs;
	}

}