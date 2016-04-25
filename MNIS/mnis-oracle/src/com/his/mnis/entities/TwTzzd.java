package com.his.mnis.entities;

/**
 * TwTzzd entity. @author MyEclipse Persistence Tools
 */

public class TwTzzd implements java.io.Serializable {

	// Fields

	private String xmid;
	private String xmmc;
	private Short xsxh;
	private String gdflag;
	private String apflag;
	private String bzflag;
	private String bq;
	private String datatype;
	private Double numberMin;
	private Double numberMax;
	private String dw;

	// Constructors

	/** default constructor */
	public TwTzzd() {
	}

	/** minimal constructor */
	public TwTzzd(String xmmc, Short xsxh, String gdflag, String apflag,
			String bzflag, String datatype) {
		this.xmmc = xmmc;
		this.xsxh = xsxh;
		this.gdflag = gdflag;
		this.apflag = apflag;
		this.bzflag = bzflag;
		this.datatype = datatype;
	}

	/** full constructor */
	public TwTzzd(String xmmc, Short xsxh, String gdflag, String apflag,
			String bzflag, String bq, String datatype, Double numberMin,
			Double numberMax, String dw) {
		this.xmmc = xmmc;
		this.xsxh = xsxh;
		this.gdflag = gdflag;
		this.apflag = apflag;
		this.bzflag = bzflag;
		this.bq = bq;
		this.datatype = datatype;
		this.numberMin = numberMin;
		this.numberMax = numberMax;
		this.dw = dw;
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

	public String getGdflag() {
		return this.gdflag;
	}

	public void setGdflag(String gdflag) {
		this.gdflag = gdflag;
	}

	public String getApflag() {
		return this.apflag;
	}

	public void setApflag(String apflag) {
		this.apflag = apflag;
	}

	public String getBzflag() {
		return this.bzflag;
	}

	public void setBzflag(String bzflag) {
		this.bzflag = bzflag;
	}

	public String getBq() {
		return this.bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getDatatype() {
		return this.datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public Double getNumberMin() {
		return this.numberMin;
	}

	public void setNumberMin(Double numberMin) {
		this.numberMin = numberMin;
	}

	public Double getNumberMax() {
		return this.numberMax;
	}

	public void setNumberMax(Double numberMax) {
		this.numberMax = numberMax;
	}

	public String getDw() {
		return this.dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

}