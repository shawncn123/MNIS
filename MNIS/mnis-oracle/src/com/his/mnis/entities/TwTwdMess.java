package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * TwTwdMess entity. @author MyEclipse Persistence Tools
 */

public class TwTwdMess implements java.io.Serializable {

	// Fields

	private Long jlid;
	private Timestamp stime;
	private Long key1;
	private Integer key2;
	private Boolean yebh;
	private Timestamp beginrq;
	private String handleflag;
	private String filetype;
	private byte[] filenr;
	private String errortext;

	// Constructors

	/** default constructor */
	public TwTwdMess() {
	}

	/** minimal constructor */
	public TwTwdMess(Timestamp stime, Long key1, Integer key2, Boolean yebh,
			Timestamp beginrq, String handleflag) {
		this.stime = stime;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.beginrq = beginrq;
		this.handleflag = handleflag;
	}

	/** full constructor */
	public TwTwdMess(Timestamp stime, Long key1, Integer key2, Boolean yebh,
			Timestamp beginrq, String handleflag, String filetype,
			byte[] filenr, String errortext) {
		this.stime = stime;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.beginrq = beginrq;
		this.handleflag = handleflag;
		this.filetype = filetype;
		this.filenr = filenr;
		this.errortext = errortext;
	}

	// Property accessors

	public Long getJlid() {
		return this.jlid;
	}

	public void setJlid(Long jlid) {
		this.jlid = jlid;
	}

	public Timestamp getStime() {
		return this.stime;
	}

	public void setStime(Timestamp stime) {
		this.stime = stime;
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

	public Boolean getYebh() {
		return this.yebh;
	}

	public void setYebh(Boolean yebh) {
		this.yebh = yebh;
	}

	public Timestamp getBeginrq() {
		return this.beginrq;
	}

	public void setBeginrq(Timestamp beginrq) {
		this.beginrq = beginrq;
	}

	public String getHandleflag() {
		return this.handleflag;
	}

	public void setHandleflag(String handleflag) {
		this.handleflag = handleflag;
	}

	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getFilenr() {
		return this.filenr;
	}

	public void setFilenr(byte[] filenr) {
		this.filenr = filenr;
	}

	public String getErrortext() {
		return this.errortext;
	}

	public void setErrortext(String errortext) {
		this.errortext = errortext;
	}

}