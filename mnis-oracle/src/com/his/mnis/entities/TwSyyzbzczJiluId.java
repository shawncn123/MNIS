package com.his.mnis.entities;

/**
 * TwSyyzbzczJiluId entity. @author MyEclipse Persistence Tools
 */

public class TwSyyzbzczJiluId implements java.io.Serializable {

	// Fields

	private String rowkey;
	private String czfl;

	// Constructors

	/** default constructor */
	public TwSyyzbzczJiluId() {
	}

	/** minimal constructor */
	public TwSyyzbzczJiluId(String czfl) {
		this.czfl = czfl;
	}

	/** full constructor */
	public TwSyyzbzczJiluId(String rowkey, String czfl) {
		this.rowkey = rowkey;
		this.czfl = czfl;
	}

	// Property accessors

	public String getRowkey() {
		return this.rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public String getCzfl() {
		return this.czfl;
	}

	public void setCzfl(String czfl) {
		this.czfl = czfl;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TwSyyzbzczJiluId))
			return false;
		TwSyyzbzczJiluId castOther = (TwSyyzbzczJiluId) other;

		return ((this.getRowkey() == castOther.getRowkey()) || (this
				.getRowkey() != null && castOther.getRowkey() != null && this
				.getRowkey().equals(castOther.getRowkey())))
				&& ((this.getCzfl() == castOther.getCzfl()) || (this.getCzfl() != null
						&& castOther.getCzfl() != null && this.getCzfl()
						.equals(castOther.getCzfl())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRowkey() == null ? 0 : this.getRowkey().hashCode());
		result = 37 * result
				+ (getCzfl() == null ? 0 : this.getCzfl().hashCode());
		return result;
	}

}