package com.his.mnis.entities;

/**
 * TwWdbrId entity. @author MyEclipse Persistence Tools
 */

public class TwWdbrId implements java.io.Serializable {

	// Fields

	private String hsid;
	private String bq;
	private String chw;

	// Constructors

	/** default constructor */
	public TwWdbrId() {
	}

	/** full constructor */
	public TwWdbrId(String hsid, String bq, String chw) {
		this.hsid = hsid;
		this.bq = bq;
		this.chw = chw;
	}

	// Property accessors

	public String getHsid() {
		return this.hsid;
	}

	public void setHsid(String hsid) {
		this.hsid = hsid;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TwWdbrId))
			return false;
		TwWdbrId castOther = (TwWdbrId) other;

		return ((this.getHsid() == castOther.getHsid()) || (this.getHsid() != null
				&& castOther.getHsid() != null && this.getHsid().equals(
				castOther.getHsid())))
				&& ((this.getBq() == castOther.getBq()) || (this.getBq() != null
						&& castOther.getBq() != null && this.getBq().equals(
						castOther.getBq())))
				&& ((this.getChw() == castOther.getChw()) || (this.getChw() != null
						&& castOther.getChw() != null && this.getChw().equals(
						castOther.getChw())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHsid() == null ? 0 : this.getHsid().hashCode());
		result = 37 * result + (getBq() == null ? 0 : this.getBq().hashCode());
		result = 37 * result
				+ (getChw() == null ? 0 : this.getChw().hashCode());
		return result;
	}

}