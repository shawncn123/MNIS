package com.his.mnis.entities;

import java.sql.Timestamp;

/**
 * Zd001 entity. @author MyEclipse Persistence Tools
 */

public class Zd001 implements java.io.Serializable {

	// Fields

	private String id;
	private String fl;
	private String dm;
	private String mc;
	private String shrm;
	private Integer sxh;
	private String sjdmid;
	private String bz;
	private String bz1;
	private String bz2;
	private String bz3;
	private String bz4;
	private String bz5;
	private String lockflag;
	private String defaultflag;
	private String customflag;
	private String bym;
	private String dcflag;
	private Byte treelevel;
	private Timestamp qyrq;
	private String tyflag;
	private Timestamp tyrq;

	// Constructors

	/** default constructor */
	public Zd001() {
	}

	/** minimal constructor */
	public Zd001(String fl, String dm, String mc, String lockflag,
			String defaultflag, String customflag, String dcflag,
			Byte treelevel, String tyflag) {
		this.fl = fl;
		this.dm = dm;
		this.mc = mc;
		this.lockflag = lockflag;
		this.defaultflag = defaultflag;
		this.customflag = customflag;
		this.dcflag = dcflag;
		this.treelevel = treelevel;
		this.tyflag = tyflag;
	}

	/** full constructor */
	public Zd001(String fl, String dm, String mc, String shrm, Integer sxh,
			String sjdmid, String bz, String bz1, String bz2, String bz3,
			String bz4, String bz5, String lockflag, String defaultflag,
			String customflag, String bym, String dcflag, Byte treelevel,
			Timestamp qyrq, String tyflag, Timestamp tyrq) {
		this.fl = fl;
		this.dm = dm;
		this.mc = mc;
		this.shrm = shrm;
		this.sxh = sxh;
		this.sjdmid = sjdmid;
		this.bz = bz;
		this.bz1 = bz1;
		this.bz2 = bz2;
		this.bz3 = bz3;
		this.bz4 = bz4;
		this.bz5 = bz5;
		this.lockflag = lockflag;
		this.defaultflag = defaultflag;
		this.customflag = customflag;
		this.bym = bym;
		this.dcflag = dcflag;
		this.treelevel = treelevel;
		this.qyrq = qyrq;
		this.tyflag = tyflag;
		this.tyrq = tyrq;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFl() {
		return this.fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getShrm() {
		return this.shrm;
	}

	public void setShrm(String shrm) {
		this.shrm = shrm;
	}

	public Integer getSxh() {
		return this.sxh;
	}

	public void setSxh(Integer sxh) {
		this.sxh = sxh;
	}

	public String getSjdmid() {
		return this.sjdmid;
	}

	public void setSjdmid(String sjdmid) {
		this.sjdmid = sjdmid;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getBz1() {
		return this.bz1;
	}

	public void setBz1(String bz1) {
		this.bz1 = bz1;
	}

	public String getBz2() {
		return this.bz2;
	}

	public void setBz2(String bz2) {
		this.bz2 = bz2;
	}

	public String getBz3() {
		return this.bz3;
	}

	public void setBz3(String bz3) {
		this.bz3 = bz3;
	}

	public String getBz4() {
		return this.bz4;
	}

	public void setBz4(String bz4) {
		this.bz4 = bz4;
	}

	public String getBz5() {
		return this.bz5;
	}

	public void setBz5(String bz5) {
		this.bz5 = bz5;
	}

	public String getLockflag() {
		return this.lockflag;
	}

	public void setLockflag(String lockflag) {
		this.lockflag = lockflag;
	}

	public String getDefaultflag() {
		return this.defaultflag;
	}

	public void setDefaultflag(String defaultflag) {
		this.defaultflag = defaultflag;
	}

	public String getCustomflag() {
		return this.customflag;
	}

	public void setCustomflag(String customflag) {
		this.customflag = customflag;
	}

	public String getBym() {
		return this.bym;
	}

	public void setBym(String bym) {
		this.bym = bym;
	}

	public String getDcflag() {
		return this.dcflag;
	}

	public void setDcflag(String dcflag) {
		this.dcflag = dcflag;
	}

	public Byte getTreelevel() {
		return this.treelevel;
	}

	public void setTreelevel(Byte treelevel) {
		this.treelevel = treelevel;
	}

	public Timestamp getQyrq() {
		return this.qyrq;
	}

	public void setQyrq(Timestamp qyrq) {
		this.qyrq = qyrq;
	}

	public String getTyflag() {
		return this.tyflag;
	}

	public void setTyflag(String tyflag) {
		this.tyflag = tyflag;
	}

	public Timestamp getTyrq() {
		return this.tyrq;
	}

	public void setTyrq(Timestamp tyrq) {
		this.tyrq = tyrq;
	}

}