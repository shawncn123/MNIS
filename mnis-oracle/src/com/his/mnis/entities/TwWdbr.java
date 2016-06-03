package com.his.mnis.entities;

/**
 * TwWdbr entity. @author MyEclipse Persistence Tools
 */

public class TwWdbr implements java.io.Serializable {

	// Fields

	private TwWdbrId id;

	// Constructors

	/** default constructor */
	public TwWdbr() {
	}

	/** full constructor */
	public TwWdbr(TwWdbrId id) {
		this.id = id;
	}

	// Property accessors

	public TwWdbrId getId() {
		return this.id;
	}

	public void setId(TwWdbrId id) {
		this.id = id;
	}

}