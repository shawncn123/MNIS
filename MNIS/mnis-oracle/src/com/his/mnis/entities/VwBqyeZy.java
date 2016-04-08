package com.his.mnis.entities;

/**
 * VwBqyeZy entity. @author MyEclipse Persistence Tools
 */

public class VwBqyeZy implements java.io.Serializable {

	// Fields

	private Long prmid;
	private Long key1;
	private Long key2;
	private Integer yebh;
	private String xm;
	private String xb;

	// Constructors

	/** default constructor */
	public VwBqyeZy() {
	}

	/** full constructor */
	public VwBqyeZy(Long key1, Long key2, Integer yebh, String xm, String xb) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.xm = xm;
		this.xb = xb;
	}

	// Property accessors

	public Long getPrmid() {
		return this.prmid;
	}

	public void setPrmid(Long prmid) {
		this.prmid = prmid;
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

	public Integer getYebh() {
		return this.yebh;
	}

	public void setYebh(Integer yebh) {
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

}