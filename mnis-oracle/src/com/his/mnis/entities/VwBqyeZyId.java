package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * VwBqyeZyId entity. @author MyEclipse Persistence Tools
 */

public class VwBqyeZyId implements java.io.Serializable {

	// Fields

	private String rowkey;
	private Long key1;
	private Long key2;
	private Short yebh;
	private String xm;
	private String xb;
	private Timestamp cstime;
	private Double shengao;
	private Double tizhong;

	// Constructors

	/** default constructor */
	public VwBqyeZyId() {
	}

	/** minimal constructor */
	public VwBqyeZyId(Long key1, Long key2, Short yebh) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
	}

	/** full constructor */
	public VwBqyeZyId(String rowkey, Long key1, Long key2, Short yebh,
			String xm, String xb, Timestamp cstime, Double shengao,
			Double tizhong) {
		this.rowkey = rowkey;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.xm = xm;
		this.xb = xb;
		this.cstime = cstime;
		this.shengao = shengao;
		this.tizhong = tizhong;
	}

	// Property accessors

	public String getRowkey() {
		return this.rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public Long getKey1() {
		return this.key1;
	}

	public void setKey1(Long key1) {
		this.key1 = key1;
	}

	public Long getKey2() {
		return this.key2;
	}

	public void setKey2(Long key2) {
		this.key2 = key2;
	}

	public Short getYebh() {
		return this.yebh;
	}

	public void setYebh(Short yebh) {
		this.yebh = yebh;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public Timestamp getCstime() {
		return this.cstime;
	}

	public void setCstime(Timestamp cstime) {
		this.cstime = cstime;
	}

	public Double getShengao() {
		return this.shengao;
	}

	public void setShengao(Double shengao) {
		this.shengao = shengao;
	}

	public Double getTizhong() {
		return this.tizhong;
	}

	public void setTizhong(Double tizhong) {
		this.tizhong = tizhong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VwBqyeZyId))
			return false;
		VwBqyeZyId castOther = (VwBqyeZyId) other;

		return ((this.getRowkey() == castOther.getRowkey()) || (this
				.getRowkey() != null && castOther.getRowkey() != null && this
				.getRowkey().equals(castOther.getRowkey())))
				&& ((this.getKey1() == castOther.getKey1()) || (this.getKey1() != null
						&& castOther.getKey1() != null && this.getKey1()
						.equals(castOther.getKey1())))
				&& ((this.getKey2() == castOther.getKey2()) || (this.getKey2() != null
						&& castOther.getKey2() != null && this.getKey2()
						.equals(castOther.getKey2())))
				&& ((this.getYebh() == castOther.getYebh()) || (this.getYebh() != null
						&& castOther.getYebh() != null && this.getYebh()
						.equals(castOther.getYebh())))
				&& ((this.getXm() == castOther.getXm()) || (this.getXm() != null
						&& castOther.getXm() != null && this.getXm().equals(
						castOther.getXm())))
				&& ((this.getXb() == castOther.getXb()) || (this.getXb() != null
						&& castOther.getXb() != null && this.getXb().equals(
						castOther.getXb())))
				&& ((this.getCstime() == castOther.getCstime()) || (this
						.getCstime() != null && castOther.getCstime() != null && this
						.getCstime().equals(castOther.getCstime())))
				&& ((this.getShengao() == castOther.getShengao()) || (this
						.getShengao() != null && castOther.getShengao() != null && this
						.getShengao().equals(castOther.getShengao())))
				&& ((this.getTizhong() == castOther.getTizhong()) || (this
						.getTizhong() != null && castOther.getTizhong() != null && this
						.getTizhong().equals(castOther.getTizhong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRowkey() == null ? 0 : this.getRowkey().hashCode());
		result = 37 * result
				+ (getKey1() == null ? 0 : this.getKey1().hashCode());
		result = 37 * result
				+ (getKey2() == null ? 0 : this.getKey2().hashCode());
		result = 37 * result
				+ (getYebh() == null ? 0 : this.getYebh().hashCode());
		result = 37 * result + (getXm() == null ? 0 : this.getXm().hashCode());
		result = 37 * result + (getXb() == null ? 0 : this.getXb().hashCode());
		result = 37 * result
				+ (getCstime() == null ? 0 : this.getCstime().hashCode());
		result = 37 * result
				+ (getShengao() == null ? 0 : this.getShengao().hashCode());
		result = 37 * result
				+ (getTizhong() == null ? 0 : this.getTizhong().hashCode());
		return result;
	}

}