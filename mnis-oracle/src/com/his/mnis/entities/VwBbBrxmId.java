package com.his.mnis.entities;

/**
 * VwBbBrxmId entity. @author MyEclipse Persistence Tools
 */

public class VwBbBrxmId implements java.io.Serializable {

	// Fields

	private String bq;
	private String xmbm;

	// Constructors

	/** default constructor */
	public VwBbBrxmId() {
	}

	/** full constructor */
	public VwBbBrxmId(String bq, String xmbm) {
		this.bq = bq;
		this.xmbm = xmbm;
	}

	// Property accessors

	public String getBq() {
		return this.bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getXmbm() {
		return this.xmbm;
	}

	public void setXmbm(String xmbm) {
		this.xmbm = xmbm;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VwBbBrxmId))
			return false;
		VwBbBrxmId castOther = (VwBbBrxmId) other;

		return ((this.getBq() == castOther.getBq()) || (this.getBq() != null
				&& castOther.getBq() != null && this.getBq().equals(
				castOther.getBq())))
				&& ((this.getXmbm() == castOther.getXmbm()) || (this.getXmbm() != null
						&& castOther.getXmbm() != null && this.getXmbm()
						.equals(castOther.getXmbm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBq() == null ? 0 : this.getBq().hashCode());
		result = 37 * result
				+ (getXmbm() == null ? 0 : this.getXmbm().hashCode());
		return result;
	}

}