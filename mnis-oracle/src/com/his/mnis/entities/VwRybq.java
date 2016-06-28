package com.his.mnis.entities;

/**
 * VwRybq entity. @author MyEclipse Persistence Tools
 */

public class VwRybq implements java.io.Serializable {

	// Fields

	private String rowkey;
	private String ryid;
	private String rydm;
	private String ryxm;
	private String bq;
	private String bqmc;
	private String defualtflag;

	// Constructors

	/** default constructor */
	public VwRybq() {
	}

	/** minimal constructor */
	public VwRybq(String rydm) {
		this.rydm = rydm;
	}

	/** full constructor */
	public VwRybq(String ryid, String rydm, String ryxm, String bq,
			String bqmc, String defualtflag) {
		this.ryid = ryid;
		this.rydm = rydm;
		this.ryxm = ryxm;
		this.bq = bq;
		this.bqmc = bqmc;
		this.defualtflag = defualtflag;
	}

	// Property accessors

	public String getRowkey() {
		return this.rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public String getRyid() {
		return this.ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getRydm() {
		return this.rydm;
	}

	public void setRydm(String rydm) {
		this.rydm = rydm;
	}

	public String getRyxm() {
		return this.ryxm;
	}

	public void setRyxm(String ryxm) {
		this.ryxm = ryxm;
	}

	public String getBq() {
		return this.bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getBqmc() {
		return this.bqmc;
	}

	public void setBqmc(String bqmc) {
		this.bqmc = bqmc;
	}

	public String getDefualtflag() {
		return this.defualtflag;
	}

	public void setDefualtflag(String defualtflag) {
		this.defualtflag = defualtflag;
	}

}