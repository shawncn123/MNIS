package com.his.mnis.entities;

/**
 * RybqDefault entity. @author MyEclipse Persistence Tools
 */

public class RybqDefault implements java.io.Serializable {

	// Fields

	private String ryid;
	private String bq;

	// Constructors

	/** default constructor */
	public RybqDefault() {
	}

	/** full constructor */
	public RybqDefault(String bq) {
		this.bq = bq;
	}

	// Property accessors

	public String getRyid() {
		return this.ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getBq() {
		return this.bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

}