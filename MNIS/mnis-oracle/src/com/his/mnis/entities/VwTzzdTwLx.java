package com.his.mnis.entities;

/**
 * VwTzzdTwLx entity. @author MyEclipse Persistence Tools
 */

public class VwTzzdTwLx implements java.io.Serializable {

	// Fields

	private String dm;
	private String mc;
	private String defaultflag;
	private Double sxh;

	// Constructors

	/** default constructor */
	public VwTzzdTwLx() {
	}

	/** full constructor */
	public VwTzzdTwLx(String mc, String defaultflag, Double sxh) {
		this.mc = mc;
		this.defaultflag = defaultflag;
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

	public String getDefaultflag() {
		return this.defaultflag;
	}

	public void setDefaultflag(String defaultflag) {
		this.defaultflag = defaultflag;
	}

	public Double getSxh() {
		return this.sxh;
	}

	public void setSxh(Double sxh) {
		this.sxh = sxh;
	}

}