package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * VSysMessReader entity. @author MyEclipse Persistence Tools
 */

public class VSysMessReader implements java.io.Serializable {

	// Fields

	private Long messid;
	private String ryid;
	private String ryxm;
	private String popupflag;
	private String readflag;
	private Timestamp readtime;
	private String apptype;
	private String subject;
	private String messtext;
	private Short fjcount;
	private String czyid;
	private String czyxm;
	private Timestamp createrq;
	private Timestamp createtime;
	private Timestamp lastmodifytime;
	private Timestamp sendtime;
	private Timestamp validendtime;
	private String qcwdflag;

	// Constructors

	/** default constructor */
	public VSysMessReader() {
	}

	/** minimal constructor */
	public VSysMessReader(String ryid, String ryxm, String popupflag,
			String readflag, String apptype, Short fjcount, Timestamp createrq,
			Timestamp createtime) {
		this.ryid = ryid;
		this.ryxm = ryxm;
		this.popupflag = popupflag;
		this.readflag = readflag;
		this.apptype = apptype;
		this.fjcount = fjcount;
		this.createrq = createrq;
		this.createtime = createtime;
	}

	/** full constructor */
	public VSysMessReader(String ryid, String ryxm, String popupflag,
			String readflag, Timestamp readtime, String apptype,
			String subject, String messtext, Short fjcount, String czyid,
			String czyxm, Timestamp createrq, Timestamp createtime,
			Timestamp lastmodifytime, Timestamp sendtime,
			Timestamp validendtime, String qcwdflag) {
		this.ryid = ryid;
		this.ryxm = ryxm;
		this.popupflag = popupflag;
		this.readflag = readflag;
		this.readtime = readtime;
		this.apptype = apptype;
		this.subject = subject;
		this.messtext = messtext;
		this.fjcount = fjcount;
		this.czyid = czyid;
		this.czyxm = czyxm;
		this.createrq = createrq;
		this.createtime = createtime;
		this.lastmodifytime = lastmodifytime;
		this.sendtime = sendtime;
		this.validendtime = validendtime;
		this.qcwdflag = qcwdflag;
	}

	// Property accessors

	public Long getMessid() {
		return this.messid;
	}

	public void setMessid(Long messid) {
		this.messid = messid;
	}

	public String getRyid() {
		return this.ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getRyxm() {
		return this.ryxm;
	}

	public void setRyxm(String ryxm) {
		this.ryxm = ryxm;
	}

	public String getPopupflag() {
		return this.popupflag;
	}

	public void setPopupflag(String popupflag) {
		this.popupflag = popupflag;
	}

	public String getReadflag() {
		return this.readflag;
	}

	public void setReadflag(String readflag) {
		this.readflag = readflag;
	}

	public Timestamp getReadtime() {
		return this.readtime;
	}

	public void setReadtime(Timestamp readtime) {
		this.readtime = readtime;
	}

	public String getApptype() {
		return this.apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMesstext() {
		return this.messtext;
	}

	public void setMesstext(String messtext) {
		this.messtext = messtext;
	}

	public Short getFjcount() {
		return this.fjcount;
	}

	public void setFjcount(Short fjcount) {
		this.fjcount = fjcount;
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

	public Timestamp getCreaterq() {
		return this.createrq;
	}

	public void setCreaterq(Timestamp createrq) {
		this.createrq = createrq;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getLastmodifytime() {
		return this.lastmodifytime;
	}

	public void setLastmodifytime(Timestamp lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}

	public Timestamp getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}

	public Timestamp getValidendtime() {
		return this.validendtime;
	}

	public void setValidendtime(Timestamp validendtime) {
		this.validendtime = validendtime;
	}

	public String getQcwdflag() {
		return this.qcwdflag;
	}

	public void setQcwdflag(String qcwdflag) {
		this.qcwdflag = qcwdflag;
	}

}