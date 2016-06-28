package com.his.mnis.entities;

import java.util.Date;

/**
 * TwXjYw entity. @author MyEclipse Persistence Tools
 */

public class TwXjYw implements java.io.Serializable {

	// Fields

	private String id;
	private Date stime;
	private Date rq;
	private String xjdmid;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private String bq;
	private String chw;
	private String xjhsid;
	private String xjhsxm;
	private String bz;

	// Constructors

	/** default constructor */
	public TwXjYw() {
	}

	/** minimal constructor */
	public TwXjYw(Date stime, Date rq, String xjdmid, Long key1, Integer key2,
			Short yebh) {
		this.stime = stime;
		this.rq = rq;
		this.xjdmid = xjdmid;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
	}

	/** full constructor */
	public TwXjYw(Date stime, Date rq, String xjdmid, Long key1, Integer key2,
			Short yebh, String bq, String chw, String xjhsid, String xjhsxm,
			String bz) {
		this.stime = stime;
		this.rq = rq;
		this.xjdmid = xjdmid;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.bq = bq;
		this.chw = chw;
		this.xjhsid = xjhsid;
		this.xjhsxm = xjhsxm;
		this.bz = bz;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStime() {
		return this.stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Date getRq() {
		return this.rq;
	}

	public void setRq(Date rq) {
		this.rq = rq;
	}

	public String getXjdmid() {
		return this.xjdmid;
	}

	public void setXjdmid(String xjdmid) {
		this.xjdmid = xjdmid;
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

	public String getBq() {
		return this.bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getChw() {
		return this.chw;
	}

	public void setChw(String chw) {
		this.chw = chw;
	}

	public String getXjhsid() {
		return this.xjhsid;
	}

	public void setXjhsid(String xjhsid) {
		this.xjhsid = xjhsid;
	}

	public String getXjhsxm() {
		return this.xjhsxm;
	}

	public void setXjhsxm(String xjhsxm) {
		this.xjhsxm = xjhsxm;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}