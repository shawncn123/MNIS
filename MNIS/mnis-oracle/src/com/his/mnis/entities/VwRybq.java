package com.his.mnis.entities;

/**
 * VwRybq entity. @author MyEclipse Persistence Tools
 */

public class VwRybq implements java.io.Serializable {

	// Fields

	private String rowkey;
	private String id;
	private String rydm;
	private String ryxm;
	private String bq;
	private String bqmc;
	private String defualtflag;

	// Constructors

	/** default constructor */
	public VwRybq() {
	}

	/** full constructor */
	public VwRybq(String id, String rydm, String ryxm, String bq, String bqmc,
			String defualtflag) {
		this.id = id;
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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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