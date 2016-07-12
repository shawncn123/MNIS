package com.his.mnis.entities;

/**
 * VwHy1011 entity. @author MyEclipse Persistence Tools
 */

public class VwHy1011 implements java.io.Serializable {

	// Fields

	private Long yzxh;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private String sqdh;
	private Long sxh;
	private String yzid;
	private String yzmc;
	private String yszt;
	private String wjflag;

	// Constructors

	/** default constructor */
	public VwHy1011() {
	}

	/** minimal constructor */
	public VwHy1011(String wjflag) {
		this.wjflag = wjflag;
	}

	/** full constructor */
	public VwHy1011(Long key1, Integer key2, Short yebh, String sqdh, Long sxh,
			String yzid, String yzmc, String yszt, String wjflag) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.sqdh = sqdh;
		this.sxh = sxh;
		this.yzid = yzid;
		this.yzmc = yzmc;
		this.yszt = yszt;
		this.wjflag = wjflag;
	}

	// Property accessors

	public Long getYzxh() {
		return this.yzxh;
	}

	public void setYzxh(Long yzxh) {
		this.yzxh = yzxh;
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

	public String getSqdh() {
		return this.sqdh;
	}

	public void setSqdh(String sqdh) {
		this.sqdh = sqdh;
	}

	public Long getSxh() {
		return this.sxh;
	}

	public void setSxh(Long sxh) {
		this.sxh = sxh;
	}

	public String getYzid() {
		return this.yzid;
	}

	public void setYzid(String yzid) {
		this.yzid = yzid;
	}

	public String getYzmc() {
		return this.yzmc;
	}

	public void setYzmc(String yzmc) {
		this.yzmc = yzmc;
	}

	public String getYszt() {
		return this.yszt;
	}

	public void setYszt(String yszt) {
		this.yszt = yszt;
	}

	public String getWjflag() {
		return this.wjflag;
	}

	public void setWjflag(String wjflag) {
		this.wjflag = wjflag;
	}

}