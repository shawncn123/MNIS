package com.his.mnis.entities;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TwTzdata entity. @author MyEclipse Persistence Tools
 */

public class TwTzdata implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long jlid;
	private Timestamp stime;
	private String czyid;
	private String czyxm;
	private Long pcid;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private Date rq;
	private String sj;
	private String xmid;
	private String value1;
	private String value2;
	private String bz;

	// Constructors

	/** default constructor */
	public TwTzdata() {
	}

	/** minimal constructor */
	public TwTzdata(Timestamp stime, String czyid, Long pcid, Long key1,
			Integer key2, Short yebh, Date rq, String sj, String xmid) {
		this.stime = stime;
		this.czyid = czyid;
		this.pcid = pcid;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.rq = rq;
		this.sj = sj;
		this.xmid = xmid;
	}

	/** full constructor */
	public TwTzdata(Timestamp stime, String czyid, String czyxm, Long pcid,
			Long key1, Integer key2, Short yebh, Date rq, String sj,
			String xmid, String value1, String value2, String bz) {
		this.stime = stime;
		this.czyid = czyid;
		this.czyxm = czyxm;
		this.pcid = pcid;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.rq = rq;
		this.sj = sj;
		this.xmid = xmid;
		this.value1 = value1;
		this.value2 = value2;
		this.bz = bz;
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

	public String getCzyid() {
		return this.czyid;
	}

	public void setCzyid(String czyid) {
		this.czyid = czyid;
	}

	public String getCzyxm() {
		return this.czyxm;
	}

	public void setCzyxm(String czyxm) {
		this.czyxm = czyxm;
	}

	public Long getPcid() {
		return this.pcid;
	}

	public void setPcid(Long pcid) {
		this.pcid = pcid;
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

	public Date getRq() {
		return this.rq;
	}

	public void setRq(Date rq) {
		this.rq = rq;
	}

	public String getSj() {
		return this.sj;
	}

	public void setSj(String sj) {
		this.sj = sj;
	}

	public String getXmid() {
		return this.xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public String getValue1() {
		return this.value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return this.value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}