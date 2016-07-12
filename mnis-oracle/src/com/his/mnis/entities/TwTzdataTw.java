package com.his.mnis.entities;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TwTzdataTw entity. @author MyEclipse Persistence Tools
 */

public class TwTzdataTw implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long jlid;
	private Timestamp stime;
	private String czyid;
	private String czyxm;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private Date rq;
	private String sj;
	private String twLx;
	private Double twTw;
	private Double twTwJwh;
	private Short twMb;
	private Short twXl;
	private Short twHx;
	private String twRcbz;
	private String twRcsj;

	// Constructors

	/** default constructor */
	public TwTzdataTw() {
	}

	/** minimal constructor */
	public TwTzdataTw(Timestamp stime, String czyid, Long key1, Integer key2,
			Short yebh, Date rq, String sj) {
		this.stime = stime;
		this.czyid = czyid;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.rq = rq;
		this.sj = sj;
	}

	/** full constructor */
	public TwTzdataTw(Timestamp stime, String czyid, String czyxm, Long key1,
			Integer key2, Short yebh, Date rq, String sj, String twLx,
			Double twTw, Double twTwJwh, Short twMb, Short twXl, Short twHx,
			String twRcbz, String twRcsj) {
		this.stime = stime;
		this.czyid = czyid;
		this.czyxm = czyxm;
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.rq = rq;
		this.sj = sj;
		this.twLx = twLx;
		this.twTw = twTw;
		this.twTwJwh = twTwJwh;
		this.twMb = twMb;
		this.twXl = twXl;
		this.twHx = twHx;
		this.twRcbz = twRcbz;
		this.twRcsj = twRcsj;
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

	public String getTwLx() {
		return this.twLx;
	}

	public void setTwLx(String twLx) {
		this.twLx = twLx;
	}

	public Double getTwTw() {
		return this.twTw;
	}

	public void setTwTw(Double twTw) {
		this.twTw = twTw;
	}

	public Double getTwTwJwh() {
		return this.twTwJwh;
	}

	public void setTwTwJwh(Double twTwJwh) {
		this.twTwJwh = twTwJwh;
	}

	public Short getTwMb() {
		return this.twMb;
	}

	public void setTwMb(Short twMb) {
		this.twMb = twMb;
	}

	public Short getTwXl() {
		return this.twXl;
	}

	public void setTwXl(Short twXl) {
		this.twXl = twXl;
	}

	public Short getTwHx() {
		return this.twHx;
	}

	public void setTwHx(Short twHx) {
		this.twHx = twHx;
	}

	public String getTwRcbz() {
		return this.twRcbz;
	}

	public void setTwRcbz(String twRcbz) {
		this.twRcbz = twRcbz;
	}

	public String getTwRcsj() {
		return this.twRcsj;
	}

	public void setTwRcsj(String twRcsj) {
		this.twRcsj = twRcsj;
	}

}