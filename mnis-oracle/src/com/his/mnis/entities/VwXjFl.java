package com.his.mnis.entities;

/**
 * VwXjFl entity. @author MyEclipse Persistence Tools
 */

public class VwXjFl implements java.io.Serializable {

	// Fields

	private String dm;
	private String mc;
	private Integer sxh;

	// Constructors

	/** default constructor */
	public VwXjFl() {
	}

	/** minimal constructor */
	public VwXjFl(String mc) {
		this.mc = mc;
	}

	/** full constructor */
	public VwXjFl(String mc, Integer sxh) {
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

	public Integer getSxh() {
		return this.sxh;
	}

	public void setSxh(Integer sxh) {
		this.sxh = sxh;
	}

}