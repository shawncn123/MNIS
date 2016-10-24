package com.his.mnis.entities;

/**
 * TwWxysPgDm entity. @author MyEclipse Persistence Tools
 */

public class TwWxysPgDm implements java.io.Serializable {

	// Fields

	private String id;
	private String wxys;
	private Integer pgfeng;
	private String tyflag;
	private Integer sxh;

	// Constructors

	/** default constructor */
	public TwWxysPgDm() {
	}

	/** minimal constructor */
	public TwWxysPgDm(String tyflag) {
		this.tyflag = tyflag;
	}

	/** full constructor */
	public TwWxysPgDm(String wxys, Integer pgfeng, String tyflag, Integer sxh) {
		this.wxys = wxys;
		this.pgfeng = pgfeng;
		this.tyflag = tyflag;
		this.sxh = sxh;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWxys() {
		return this.wxys;
	}

	public void setWxys(String wxys) {
		this.wxys = wxys;
	}

	public Integer getPgfeng() {
		return this.pgfeng;
	}

	public void setPgfeng(Integer pgfeng) {
		this.pgfeng = pgfeng;
	}

	public String getTyflag() {
		return this.tyflag;
	}

	public void setTyflag(String tyflag) {
		this.tyflag = tyflag;
	}

	public Integer getSxh() {
		return this.sxh;
	}

	public void setSxh(Integer sxh) {
		this.sxh = sxh;
	}

}