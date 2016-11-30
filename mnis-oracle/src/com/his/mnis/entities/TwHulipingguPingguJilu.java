package com.his.mnis.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * TwHulipingguPingguJilu entity. @author MyEclipse Persistence Tools
 */

public class TwHulipingguPingguJilu implements java.io.Serializable {

	// Fields

	private Long rowkey;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private String xmid;
	private String zddada1;
	private String zddada2;
	private String zddada3;
	private String zddada4;
	private String zddada5;
	private BigDecimal bbfl;
	private String zxhsid;
	private Timestamp pgrq;
	private Timestamp jlrq;

	// Constructors

	/** default constructor */
	public TwHulipingguPingguJilu() {
	}

	/** minimal constructor */
	public TwHulipingguPingguJilu(Long key1, Integer key2, Short yebh,
			String xmid, BigDecimal bbfl) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.xmid = xmid;
		this.bbfl = bbfl;
	}

	/** full constructor */
	public TwHulipingguPingguJilu(Long key1, Integer key2, Short yebh,
			String xmid, String zddada1, String zddada2, String zddada3,
			String zddada4, String zddada5, BigDecimal bbfl, String zxhsid,
			Timestamp pgrq, Timestamp jlrq) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.xmid = xmid;
		this.zddada1 = zddada1;
		this.zddada2 = zddada2;
		this.zddada3 = zddada3;
		this.zddada4 = zddada4;
		this.zddada5 = zddada5;
		this.bbfl = bbfl;
		this.zxhsid = zxhsid;
		this.pgrq = pgrq;
		this.jlrq = jlrq;
	}

	// Property accessors

	public Long getRowkey() {
		return this.rowkey;
	}

	public void setRowkey(Long rowkey) {
		this.rowkey = rowkey;
	}

	public Long getKey1() {
		return this.key1;
	}

	public void setKey1(Long key1) {
		this.key1 = key1;
	}

	public Integer getKey2() {
		return this.key2;
	}

	public void setKey2(Integer key2) {
		this.key2 = key2;
	}

	public Short getYebh() {
		return this.yebh;
	}

	public void setYebh(Short yebh) {
		this.yebh = yebh;
	}

	public String getXmid() {
		return this.xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public String getZddada1() {
		return this.zddada1;
	}

	public void setZddada1(String zddada1) {
		this.zddada1 = zddada1;
	}

	public String getZddada2() {
		return this.zddada2;
	}

	public void setZddada2(String zddada2) {
		this.zddada2 = zddada2;
	}

	public String getZddada3() {
		return this.zddada3;
	}

	public void setZddada3(String zddada3) {
		this.zddada3 = zddada3;
	}

	public String getZddada4() {
		return this.zddada4;
	}

	public void setZddada4(String zddada4) {
		this.zddada4 = zddada4;
	}

	public String getZddada5() {
		return this.zddada5;
	}

	public void setZddada5(String zddada5) {
		this.zddada5 = zddada5;
	}

	public BigDecimal getBbfl() {
		return this.bbfl;
	}

	public void setBbfl(BigDecimal bbfl) {
		this.bbfl = bbfl;
	}

	public String getZxhsid() {
		return this.zxhsid;
	}

	public void setZxhsid(String zxhsid) {
		this.zxhsid = zxhsid;
	}

	public Timestamp getPgrq() {
		return this.pgrq;
	}

	public void setPgrq(Timestamp pgrq) {
		this.pgrq = pgrq;
	}

	public Timestamp getJlrq() {
		return this.jlrq;
	}

	public void setJlrq(Timestamp jlrq) {
		this.jlrq = jlrq;
	}

}