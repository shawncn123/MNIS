package com.his.mnis.entities;

/**
 * TwXjDm entity. @author MyEclipse Persistence Tools
 */

public class TwXjDm implements java.io.Serializable {

	// Fields

	private String id;
	private String dm;
	private String mc;
	private String fldm;
	private String tyflag;
	private String xjnr;

	// Constructors

	/** default constructor */
	public TwXjDm() {
	}

	/** minimal constructor */
	public TwXjDm(String dm, String mc, String fldm, String tyflag) {
		this.dm = dm;
		this.mc = mc;
		this.fldm = fldm;
		this.tyflag = tyflag;
	}

	/** full constructor */
	public TwXjDm(String dm, String mc, String fldm, String tyflag, String xjnr) {
		this.dm = dm;
		this.mc = mc;
		this.fldm = fldm;
		this.tyflag = tyflag;
		this.xjnr = xjnr;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getFldm() {
		return this.fldm;
	}

	public void setFldm(String fldm) {
		this.fldm = fldm;
	}

	public String getTyflag() {
		return this.tyflag;
	}

	public void setTyflag(String tyflag) {
		this.tyflag = tyflag;
	}

	public String getXjnr() {
		return this.xjnr;
	}

	public void setXjnr(String xjnr) {
		this.xjnr = xjnr;
	}

}