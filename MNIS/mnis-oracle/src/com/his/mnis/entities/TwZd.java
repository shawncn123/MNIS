package com.his.mnis.entities;

/**
 * TwZd entity. @author MyEclipse Persistence Tools
 */

public class TwZd implements java.io.Serializable {

	// Fields

	private String dm;
	private String fl;
	private String mc;
	private Integer sxh;

	// Constructors

	/** default constructor */
	public TwZd() {
	}

	/** minimal constructor */
	public TwZd(String fl, String mc) {
		this.fl = fl;
		this.mc = mc;
	}

	/** full constructor */
	public TwZd(String fl, String mc, Integer sxh) {
		this.fl = fl;
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

	public String getFl() {
		return this.fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public Integer getSxh() {
		return this.sxh;
	}

	public void setSxh(Integer sxh) {
		this.sxh = sxh;
	}

}