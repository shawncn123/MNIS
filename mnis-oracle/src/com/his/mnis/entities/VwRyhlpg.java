package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * VwRyhlpg entity. @author MyEclipse Persistence Tools
 */

public class VwRyhlpg implements java.io.Serializable {

	// Fields

	private String rowkey;
	private Long key1;
	private Integer key2;
	private Long bah;
	private String bq;
	private String bqksmc;
	private String chw;
	private String fylb;
	private String xm;
	private String xb;
	private String nl;
	private String zy;
	private String mz;
	private String whcd;
	private String rytj;
	private Timestamp rksj;
	private String ryzd;
	private String gms;

	// Constructors

	/** default constructor */
	public VwRyhlpg() {
	}

	/** minimal constructor */
	public VwRyhlpg(String rowkey, Long key1, Integer key2) {
		this.rowkey = rowkey;
		this.key1 = key1;
		this.key2 = key2;
	}

	/** full constructor */
	public VwRyhlpg(String rowkey, Long key1, Integer key2, Long bah,
			String bq, String bqksmc, String chw, String fylb, String xm,
			String xb, String nl, String zy, String mz, String whcd,
			String rytj, Timestamp rksj, String ryzd, String gms) {
		this.rowkey = rowkey;
		this.key1 = key1;
		this.key2 = key2;
		this.bah = bah;
		this.bq = bq;
		this.bqksmc = bqksmc;
		this.chw = chw;
		this.fylb = fylb;
		this.xm = xm;
		this.xb = xb;
		this.nl = nl;
		this.zy = zy;
		this.mz = mz;
		this.whcd = whcd;
		this.rytj = rytj;
		this.rksj = rksj;
		this.ryzd = ryzd;
		this.gms = gms;
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

	public Long getBah() {
		return this.bah;
	}

	public void setBah(Long bah) {
		this.bah = bah;
	}

	public String getBq() {
		return this.bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getBqksmc() {
		return this.bqksmc;
	}

	public void setBqksmc(String bqksmc) {
		this.bqksmc = bqksmc;
	}

	public String getChw() {
		return this.chw;
	}

	public void setChw(String chw) {
		this.chw = chw;
	}

	public String getFylb() {
		return this.fylb;
	}

	public void setFylb(String fylb) {
		this.fylb = fylb;
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

	public String getZy() {
		return this.zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getMz() {
		return this.mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getWhcd() {
		return this.whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getRytj() {
		return this.rytj;
	}

	public void setRytj(String rytj) {
		this.rytj = rytj;
	}

	public Timestamp getRksj() {
		return this.rksj;
	}

	public void setRksj(Timestamp rksj) {
		this.rksj = rksj;
	}

	public String getRyzd() {
		return this.ryzd;
	}

	public void setRyzd(String ryzd) {
		this.ryzd = ryzd;
	}

	public String getGms() {
		return this.gms;
	}

	public void setGms(String gms) {
		this.gms = gms;
	}

}