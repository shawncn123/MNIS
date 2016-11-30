package com.his.mnis.entities;

import java.math.BigDecimal;

/**
 * TwHulijlbiaoZd1 entity. @author MyEclipse Persistence Tools
 */

public class TwHulijlbiaoZd1 implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private BigDecimal keyValue;
	private String keyName;
	private BigDecimal zdid;
	private String xmid;
	private BigDecimal bbfl;

	// Constructors

	/** default constructor */
	public TwHulijlbiaoZd1() {
	}

	/** minimal constructor */
	public TwHulijlbiaoZd1(BigDecimal keyValue, String keyName, String xmid,
			BigDecimal bbfl) {
		this.keyValue = keyValue;
		this.keyName = keyName;
		this.xmid = xmid;
		this.bbfl = bbfl;
	}

	/** full constructor */
	public TwHulijlbiaoZd1(BigDecimal keyValue, String keyName,
			BigDecimal zdid, String xmid, BigDecimal bbfl) {
		this.keyValue = keyValue;
		this.keyName = keyName;
		this.zdid = zdid;
		this.xmid = xmid;
		this.bbfl = bbfl;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getKeyValue() {
		return this.keyValue;
	}

	public void setKeyValue(BigDecimal keyValue) {
		this.keyValue = keyValue;
	}

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public BigDecimal getZdid() {
		return this.zdid;
	}

	public void setZdid(BigDecimal zdid) {
		this.zdid = zdid;
	}

	public String getXmid() {
		return this.xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public BigDecimal getBbfl() {
		return this.bbfl;
	}

	public void setBbfl(BigDecimal bbfl) {
		this.bbfl = bbfl;
	}

}