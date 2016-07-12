package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * VwBqyeZy entity. @author MyEclipse Persistence Tools
 */

public class VwBqyeZy implements java.io.Serializable {

	// Fields

	private String rowkey;
	private Long key1;
	private Long key2;
	private Short yebh;
	private String xm;
	private String xb;
	private Timestamp cstime;
	private Double shengao;
	private Double tizhong;

	// Constructors

	/** default constructor */
	public VwBqyeZy() {
	}

	/** minimal constructor */
	public VwBqyeZy(Long key1, Long key2, Short yebh) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
	}

	/** full constructor */
	public VwBqyeZy(Long key1, Long key2, Short yebh, String xm, String xb,
			Timestamp cstime, Double shengao, Double tizhong) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.xm = xm;
		this.xb = xb;
		this.cstime = cstime;
		this.shengao = shengao;
		this.tizhong = tizhong;
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

	public Long getKey2() {
		return this.key2;
	}

	public void setKey2(Long key2) {
		this.key2 = key2;
	}

	public Short getYebh() {
		return this.yebh;
	}

	public void setYebh(Short yebh) {
		this.yebh = yebh;
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

	public Timestamp getCstime() {
		return this.cstime;
	}

	public void setCstime(Timestamp cstime) {
		this.cstime = cstime;
	}

	public Double getShengao() {
		return this.shengao;
	}

	public void setShengao(Double shengao) {
		this.shengao = shengao;
	}

	public Double getTizhong() {
		return this.tizhong;
	}

	public void setTizhong(Double tizhong) {
		this.tizhong = tizhong;
	}

}