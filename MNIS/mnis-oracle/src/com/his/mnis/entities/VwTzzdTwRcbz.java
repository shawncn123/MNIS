package com.his.mnis.entities;

/**
 * VwTzzdTwRcbz entity. @author MyEclipse Persistence Tools
 */

public class VwTzzdTwRcbz implements java.io.Serializable {

	// Fields

	private String dm;
	private String mc;
	private Double sxh;

	// Constructors

	/** default constructor */
	public VwTzzdTwRcbz() {
	}

	/** full constructor */
	public VwTzzdTwRcbz(String mc, Double sxh) {
		this.mc = mc;
		this.sxh = sxh;
	}

	// Property accessors

	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public Double getSxh() {
		return this.sxh;
	}

	public void setSxh(Double sxh) {
		this.sxh = sxh;
	}

}