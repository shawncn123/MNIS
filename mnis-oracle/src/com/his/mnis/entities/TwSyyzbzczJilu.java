package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * TwSyyzbzczJilu entity. @author MyEclipse Persistence Tools
 */

public class TwSyyzbzczJilu implements java.io.Serializable {

	// Fields

	private TwSyyzbzczJiluId id;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private Timestamp rq;
	private Long groupxh;
	private String sjd;
	private Timestamp sjdtime;
	private String bq;
	private String chw;
	private String yzid;
	private String yzzdmc;
	private String yzmc;
	private String pazhsid;
	private String pazhsxm;
	private Timestamp paztime;

	// Constructors

	/** default constructor */
	public TwSyyzbzczJilu() {
	}

	/** minimal constructor */
	public TwSyyzbzczJilu(TwSyyzbzczJiluId id, Long key1, Integer key2,
			Short yebh, Long groupxh, String sjd) {
		this.id = id;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.groupxh = groupxh;
		this.sjd = sjd;
	}

	/** full constructor */
	public TwSyyzbzczJilu(TwSyyzbzczJiluId id, Long key1, Integer key2,
			Short yebh, Timestamp rq, Long groupxh, String sjd,
			Timestamp sjdtime, String bq, String chw, String yzid,
			String yzzdmc, String yzmc, String pazhsid, String pazhsxm,
			Timestamp paztime) {
		this.id = id;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.rq = rq;
		this.groupxh = groupxh;
		this.sjd = sjd;
		this.sjdtime = sjdtime;
		this.bq = bq;
		this.chw = chw;
		this.yzid = yzid;
		this.yzzdmc = yzzdmc;
		this.yzmc = yzmc;
		this.pazhsid = pazhsid;
		this.pazhsxm = pazhsxm;
		this.paztime = paztime;
	}

	// Property accessors

	public TwSyyzbzczJiluId getId() {
		return this.id;
	}

	public void setId(TwSyyzbzczJiluId id) {
		this.id = id;
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

	public Timestamp getRq() {
		return this.rq;
	}

	public void setRq(Timestamp rq) {
		this.rq = rq;
	}

	public Long getGroupxh() {
		return this.groupxh;
	}

	public void setGroupxh(Long groupxh) {
		this.groupxh = groupxh;
	}

	public String getSjd() {
		return this.sjd;
	}

	public void setSjd(String sjd) {
		this.sjd = sjd;
	}

	public Timestamp getSjdtime() {
		return this.sjdtime;
	}

	public void setSjdtime(Timestamp sjdtime) {
		this.sjdtime = sjdtime;
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

	public String getYzid() {
		return this.yzid;
	}

	public void setYzid(String yzid) {
		this.yzid = yzid;
	}

	public String getYzzdmc() {
		return this.yzzdmc;
	}

	public void setYzzdmc(String yzzdmc) {
		this.yzzdmc = yzzdmc;
	}

	public String getYzmc() {
		return this.yzmc;
	}

	public void setYzmc(String yzmc) {
		this.yzmc = yzmc;
	}

	public String getPazhsid() {
		return this.pazhsid;
	}

	public void setPazhsid(String pazhsid) {
		this.pazhsid = pazhsid;
	}

	public String getPazhsxm() {
		return this.pazhsxm;
	}

	public void setPazhsxm(String pazhsxm) {
		this.pazhsxm = pazhsxm;
	}

	public Timestamp getPaztime() {
		return this.paztime;
	}

	public void setPaztime(Timestamp paztime) {
		this.paztime = paztime;
	}

}