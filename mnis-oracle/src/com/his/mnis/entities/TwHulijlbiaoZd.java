package com.his.mnis.entities;

import java.math.BigDecimal;

/**
 * TwHulijlbiaoZd entity. @author MyEclipse Persistence Tools
 */

public class TwHulijlbiaoZd implements java.io.Serializable {

	// Fields

	private String xmid;
	private String xmmc;
	private Short xsxh;
	private String zdtype;
	private BigDecimal length;
	private String dw;
	private String subname1;
	private String zdtype1;
	private BigDecimal length1;
	private String dw1;
	private String subname2;
	private String zdtype2;
	private BigDecimal length2;
	private String dw2;
	private String subname3;
	private String zdtype3;
	private BigDecimal length3;
	private String dw3;
	private String subname4;
	private String zdtype4;
	private BigDecimal length4;
	private String dw4;
	private String zimokuai;
	private BigDecimal bbfl;
	private String tyflag;

	// Constructors

	/** default constructor */
	public TwHulijlbiaoZd() {
	}

	/** minimal constructor */
	public TwHulijlbiaoZd(String xmmc, Short xsxh, String zdtype,
			BigDecimal bbfl, String tyflag) {
		this.xmmc = xmmc;
		this.xsxh = xsxh;
		this.zdtype = zdtype;
		this.bbfl = bbfl;
		this.tyflag = tyflag;
	}

	/** full constructor */
	public TwHulijlbiaoZd(String xmmc, Short xsxh, String zdtype,
			BigDecimal length, String dw, String subname1, String zdtype1,
			BigDecimal length1, String dw1, String subname2, String zdtype2,
			BigDecimal length2, String dw2, String subname3, String zdtype3,
			BigDecimal length3, String dw3, String subname4, String zdtype4,
			BigDecimal length4, String dw4, String zimokuai, BigDecimal bbfl,
			String tyflag) {
		this.xmmc = xmmc;
		this.xsxh = xsxh;
		this.zdtype = zdtype;
		this.length = length;
		this.dw = dw;
		this.subname1 = subname1;
		this.zdtype1 = zdtype1;
		this.length1 = length1;
		this.dw1 = dw1;
		this.subname2 = subname2;
		this.zdtype2 = zdtype2;
		this.length2 = length2;
		this.dw2 = dw2;
		this.subname3 = subname3;
		this.zdtype3 = zdtype3;
		this.length3 = length3;
		this.dw3 = dw3;
		this.subname4 = subname4;
		this.zdtype4 = zdtype4;
		this.length4 = length4;
		this.dw4 = dw4;
		this.zimokuai = zimokuai;
		this.bbfl = bbfl;
		this.tyflag = tyflag;
	}

	// Property accessors

	public String getXmid() {
		return this.xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public String getXmmc() {
		return this.xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public Short getXsxh() {
		return this.xsxh;
	}

	public void setXsxh(Short xsxh) {
		this.xsxh = xsxh;
	}

	public String getZdtype() {
		return this.zdtype;
	}

	public void setZdtype(String zdtype) {
		this.zdtype = zdtype;
	}

	public BigDecimal getLength() {
		return this.length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public String getDw() {
		return this.dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getSubname1() {
		return this.subname1;
	}

	public void setSubname1(String subname1) {
		this.subname1 = subname1;
	}

	public String getZdtype1() {
		return this.zdtype1;
	}

	public void setZdtype1(String zdtype1) {
		this.zdtype1 = zdtype1;
	}

	public BigDecimal getLength1() {
		return this.length1;
	}

	public void setLength1(BigDecimal length1) {
		this.length1 = length1;
	}

	public String getDw1() {
		return this.dw1;
	}

	public void setDw1(String dw1) {
		this.dw1 = dw1;
	}

	public String getSubname2() {
		return this.subname2;
	}

	public void setSubname2(String subname2) {
		this.subname2 = subname2;
	}

	public String getZdtype2() {
		return this.zdtype2;
	}

	public void setZdtype2(String zdtype2) {
		this.zdtype2 = zdtype2;
	}

	public BigDecimal getLength2() {
		return this.length2;
	}

	public void setLength2(BigDecimal length2) {
		this.length2 = length2;
	}

	public String getDw2() {
		return this.dw2;
	}

	public void setDw2(String dw2) {
		this.dw2 = dw2;
	}

	public String getSubname3() {
		return this.subname3;
	}

	public void setSubname3(String subname3) {
		this.subname3 = subname3;
	}

	public String getZdtype3() {
		return this.zdtype3;
	}

	public void setZdtype3(String zdtype3) {
		this.zdtype3 = zdtype3;
	}

	public BigDecimal getLength3() {
		return this.length3;
	}

	public void setLength3(BigDecimal length3) {
		this.length3 = length3;
	}

	public String getDw3() {
		return this.dw3;
	}

	public void setDw3(String dw3) {
		this.dw3 = dw3;
	}

	public String getSubname4() {
		return this.subname4;
	}

	public void setSubname4(String subname4) {
		this.subname4 = subname4;
	}

	public String getZdtype4() {
		return this.zdtype4;
	}

	public void setZdtype4(String zdtype4) {
		this.zdtype4 = zdtype4;
	}

	public BigDecimal getLength4() {
		return this.length4;
	}

	public void setLength4(BigDecimal length4) {
		this.length4 = length4;
	}

	public String getDw4() {
		return this.dw4;
	}

	public void setDw4(String dw4) {
		this.dw4 = dw4;
	}

	public String getZimokuai() {
		return this.zimokuai;
	}

	public void setZimokuai(String zimokuai) {
		this.zimokuai = zimokuai;
	}

	public BigDecimal getBbfl() {
		return this.bbfl;
	}

	public void setBbfl(BigDecimal bbfl) {
		this.bbfl = bbfl;
	}

	public String getTyflag() {
		return this.tyflag;
	}

	public void setTyflag(String tyflag) {
		this.tyflag = tyflag;
	}

}