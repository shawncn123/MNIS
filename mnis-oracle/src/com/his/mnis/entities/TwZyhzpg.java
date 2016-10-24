package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * TwZyhzpg entity. @author MyEclipse Persistence Tools
 */

public class TwZyhzpg implements java.io.Serializable {

	// Fields

	private Integer rowkey;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private String pgdm;
	private String qdflag;
	private String zxhsid;
	private Timestamp pgrq;
	private Timestamp jlrq;

	// Constructors

	/** default constructor */
	public TwZyhzpg() {
	}

	/** minimal constructor */
	public TwZyhzpg(Long key1, Integer key2, Short yebh, String pgdm,
			String qdflag) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.pgdm = pgdm;
		this.qdflag = qdflag;
	}

	/** full constructor */
	public TwZyhzpg(Long key1, Integer key2, Short yebh, String pgdm,
			String qdflag, String zxhsid, Timestamp pgrq, Timestamp jlrq) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.pgdm = pgdm;
		this.qdflag = qdflag;
		this.zxhsid = zxhsid;
		this.pgrq = pgrq;
		this.jlrq = jlrq;
	}

	// Property accessors

	public Integer getRowkey() {
		return this.rowkey;
	}

	public void setRowkey(Integer rowkey) {
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

	public String getPgdm() {
		return this.pgdm;
	}

	public void setPgdm(String pgdm) {
		this.pgdm = pgdm;
	}

	public String getQdflag() {
		return this.qdflag;
	}

	public void setQdflag(String qdflag) {
		this.qdflag = qdflag;
	}

	public String getZxhsid() {
		return this.zxhsid;
	}

	public void setZxhsid(String zxhsid) {
		this.zxhsid = zxhsid;
	}

	public Timestamp getPgrq() {
		return this.pgrq;
	}

	public void setPgrq(Timestamp pgrq) {
		this.pgrq = pgrq;
	}

	public Timestamp getJlrq() {
		return this.jlrq;
	}

	public void setJlrq(Timestamp jlrq) {
		this.jlrq = jlrq;
	}

}