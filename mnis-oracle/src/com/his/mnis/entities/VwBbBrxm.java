package com.his.mnis.entities;

/**
 * VwBbBrxm entity. @author MyEclipse Persistence Tools
 */

public class VwBbBrxm implements java.io.Serializable {

	// Fields

	private VwBbBrxmId id;

	// Constructors

	/** default constructor */
	public VwBbBrxm() {
	}

	/** full constructor */
	public VwBbBrxm(VwBbBrxmId id) {
		this.id = id;
	}

	// Property accessors

	public VwBbBrxmId getId() {
		return this.id;
	}

	public void setId(VwBbBrxmId id) {
		this.id = id;
	}

}