package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * VwJc101 entity. @author MyEclipse Persistence Tools
 */

public class VwJc101 implements java.io.Serializable {

	// Fields

	private String sqdh;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private Long yzxh;
	private Timestamp sqrq;
	private Timestamp sqsj;
	private Long bq;
	private String chw;
	private Long bah;
	private String xm;
	private String xb;
	private String nl;
	private String yzid;
	private String yzmc;
	private String jcbwmc;
	private String sqysid;
	private String sqysxm;
	private Long sqksid;
	private String sqksmc;
	private Long czksid;
	private String czksmc;
	private String zxflag;
	private String writereport;
	private String bgrq;

	// Constructors

	/** default constructor */
	public VwJc101() {
	}

	/** minimal constructor */
	public VwJc101(Long yzxh) {
		this.yzxh = yzxh;
	}

	/** full constructor */
	public VwJc101(Long key1, Integer key2, Short yebh, Long yzxh,
			Timestamp sqrq, Timestamp sqsj, Long bq, String chw, Long bah,
			String xm, String xb, String nl, String yzid, String yzmc,
			String jcbwmc, String sqysid, String sqysxm, Long sqksid,
			String sqksmc, Long czksid, String czksmc, String zxflag,
			String writereport, String bgrq) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.yzxh = yzxh;
		this.sqrq = sqrq;
		this.sqsj = sqsj;
		this.bq = bq;
		this.chw = chw;
		this.bah = bah;
		this.xm = xm;
		this.xb = xb;
		this.nl = nl;
		this.yzid = yzid;
		this.yzmc = yzmc;
		this.jcbwmc = jcbwmc;
		this.sqysid = sqysid;
		this.sqysxm = sqysxm;
		this.sqksid = sqksid;
		this.sqksmc = sqksmc;
		this.czksid = czksid;
		this.czksmc = czksmc;
		this.zxflag = zxflag;
		this.writereport = writereport;
		this.bgrq = bgrq;
	}

	// Property accessors

	public String getSqdh() {
		return this.sqdh;
	}

	public void setSqdh(String sqdh) {
		this.sqdh = sqdh;
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

	public Long getYzxh() {
		return this.yzxh;
	}

	public void setYzxh(Long yzxh) {
		this.yzxh = yzxh;
	}

	public Timestamp getSqrq() {
		return this.sqrq;
	}

	public void setSqrq(Timestamp sqrq) {
		this.sqrq = sqrq;
	}

	public Timestamp getSqsj() {
		return this.sqsj;
	}

	public void setSqsj(Timestamp sqsj) {
		this.sqsj = sqsj;
	}

	public Long getBq() {
		return this.bq;
	}

	public void setBq(Long bq) {
		this.bq = bq;
	}

	public String getChw() {
		return this.chw;
	}

	public void setChw(String chw) {
		this.chw = chw;
	}

	public Long getBah() {
		return this.bah;
	}

	public void setBah(Long bah) {
		this.bah = bah;
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

	public String getNl() {
		return this.nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public String getYzid() {
		return this.yzid;
	}

	public void setYzid(String yzid) {
		this.yzid = yzid;
	}

	public String getYzmc() {
		return this.yzmc;
	}

	public void setYzmc(String yzmc) {
		this.yzmc = yzmc;
	}

	public String getJcbwmc() {
		return this.jcbwmc;
	}

	public void setJcbwmc(String jcbwmc) {
		this.jcbwmc = jcbwmc;
	}

	public String getSqysid() {
		return this.sqysid;
	}

	public void setSqysid(String sqysid) {
		this.sqysid = sqysid;
	}

	public String getSqysxm() {
		return this.sqysxm;
	}

	public void setSqysxm(String sqysxm) {
		this.sqysxm = sqysxm;
	}

	public Long getSqksid() {
		return this.sqksid;
	}

	public void setSqksid(Long sqksid) {
		this.sqksid = sqksid;
	}

	public String getSqksmc() {
		return this.sqksmc;
	}

	public void setSqksmc(String sqksmc) {
		this.sqksmc = sqksmc;
	}

	public Long getCzksid() {
		return this.czksid;
	}

	public void setCzksid(Long czksid) {
		this.czksid = czksid;
	}

	public String getCzksmc() {
		return this.czksmc;
	}

	public void setCzksmc(String czksmc) {
		this.czksmc = czksmc;
	}

	public String getZxflag() {
		return this.zxflag;
	}

	public void setZxflag(String zxflag) {
		this.zxflag = zxflag;
	}

	public String getWritereport() {
		return this.writereport;
	}

	public void setWritereport(String writereport) {
		this.writereport = writereport;
	}

	public String getBgrq() {
		return this.bgrq;
	}

	public void setBgrq(String bgrq) {
		this.bgrq = bgrq;
	}

}