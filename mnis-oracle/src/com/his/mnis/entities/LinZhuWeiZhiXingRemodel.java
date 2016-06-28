package com.his.mnis.entities;

import java.sql.Timestamp;
import java.util.List;

/**
 * VwBryz entity. @author MyEclipse Persistence Tools
 */

public class LinZhuWeiZhiXingRemodel implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Fields
	private Long yzxh;
	private Long key1;
	private Integer key2;
	private Short yebh;
	private String chw;
	private Long groupxh;
	private Long xsxh;
	private String yzzt;
	private Timestamp kstime;
	private String lsflag;
	private String yzly;
	private String tzflag;
	private String lb;
	private List<VwBryzRemodelSub> vwBryzRemodelSubs;
	private String yf2mc;
	private String zxsjms;
	private String yf1mc;
	private String yszt;
	private String pwflag;
	private Long pwyzxh;
	private String ysxm;
	private Timestamp tztime;
	private String bgflag;

	// Constructors

	/** default constructor */
	public LinZhuWeiZhiXingRemodel() {
	}

	/** minimal constructor */
	public LinZhuWeiZhiXingRemodel(Long key1, Integer key2, Short yebh, String chw,Long groupxh, Long xsxh,
			String lsflag, String yzly, String tzflag, String lb,
			String pwflag, String bgflag) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.chw = chw;
		this.groupxh = groupxh;
		this.xsxh = xsxh;
		this.lsflag = lsflag;
		this.yzly = yzly;
		this.tzflag = tzflag;
		this.lb = lb;
		this.pwflag = pwflag;
		this.bgflag = bgflag;
	}

	/** full constructor */
	public LinZhuWeiZhiXingRemodel(Long key1, Integer key2, Short yebh, String chw, Long groupxh, Long xsxh,
			String yzzt, Timestamp kstime, String lsflag, String yzly,
			String tzflag, String lb, List<VwBryzRemodelSub> vwBryzRemodelSubs, String yf2mc,
			String zxsjms, String yf1mc, String yszt, String pwflag,
			Long pwyzxh, String ysxm, Timestamp tztime, String resulttext,
			String bgflag) {
		this.key1 = key1;
		this.key2 = key2;
		this.yebh = yebh;
		this.chw = chw;
		this.groupxh = groupxh;
		this.xsxh = xsxh;
		this.yzzt = yzzt;
		this.kstime = kstime;
		this.lsflag = lsflag;
		this.yzly = yzly;
		this.tzflag = tzflag;
		this.lb = lb;
		this.vwBryzRemodelSubs = vwBryzRemodelSubs;
		this.yf2mc = yf2mc;
		this.zxsjms = zxsjms;
		this.yf1mc = yf1mc;
		this.yszt = yszt;
		this.pwflag = pwflag;
		this.pwyzxh = pwyzxh;
		this.ysxm = ysxm;
		this.tztime = tztime;
		this.bgflag = bgflag;
	}

	// Property accessors

	public Long getYzxh() {
		return this.yzxh;
	}

	public void setYzxh(Long yzxh) {
		this.yzxh = yzxh;
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

	public Long getGroupxh() {
		return this.groupxh;
	}

	public void setGroupxh(Long groupxh) {
		this.groupxh = groupxh;
	}

	public Long getXsxh() {
		return this.xsxh;
	}

	public void setXsxh(Long xsxh) {
		this.xsxh = xsxh;
	}

	public String getYzzt() {
		return this.yzzt;
	}

	public void setYzzt(String yzzt) {
		this.yzzt = yzzt;
	}

	public Timestamp getKstime() {
		return this.kstime;
	}

	public void setKstime(Timestamp kstime) {
		this.kstime = kstime;
	}

	public String getLsflag() {
		return this.lsflag;
	}

	public void setLsflag(String lsflag) {
		this.lsflag = lsflag;
	}

	public String getYzly() {
		return this.yzly;
	}

	public void setYzly(String yzly) {
		this.yzly = yzly;
	}

	public String getTzflag() {
		return this.tzflag;
	}

	public void setTzflag(String tzflag) {
		this.tzflag = tzflag;
	}

	public String getLb() {
		return this.lb;
	}

	public void setLb(String lb) {
		this.lb = lb;
	}

	public List<VwBryzRemodelSub> getVwBryzRemodelSubs() {
		return this.vwBryzRemodelSubs;
	}

	public void setVwBryzRemodelSubs(List<VwBryzRemodelSub> vwBryzRemodelSubs) {
		this.vwBryzRemodelSubs = vwBryzRemodelSubs;
	}

	public String getYf2mc() {
		return this.yf2mc;
	}

	public void setYf2mc(String yf2mc) {
		this.yf2mc = yf2mc;
	}

	public String getZxsjms() {
		return this.zxsjms;
	}

	public void setZxsjms(String zxsjms) {
		this.zxsjms = zxsjms;
	}

	public String getYf1mc() {
		return this.yf1mc;
	}

	public void setYf1mc(String yf1mc) {
		this.yf1mc = yf1mc;
	}

	public String getYszt() {
		return this.yszt;
	}

	public void setYszt(String yszt) {
		this.yszt = yszt;
	}

	public String getPwflag() {
		return this.pwflag;
	}

	public void setPwflag(String pwflag) {
		this.pwflag = pwflag;
	}

	public Long getPwyzxh() {
		return this.pwyzxh;
	}

	public void setPwyzxh(Long pwyzxh) {
		this.pwyzxh = pwyzxh;
	}

	public String getYsxm() {
		return this.ysxm;
	}

	public void setYsxm(String ysxm) {
		this.ysxm = ysxm;
	}

	public Timestamp getTztime() {
		return this.tztime;
	}

	public void setTztime(Timestamp tztime) {
		this.tztime = tztime;
	}

	public String getBgflag() {
		return this.bgflag;
	}

	public void setBgflag(String bgflag) {
		this.bgflag = bgflag;
	}

	public String getChw() {
		return chw;
	}

	public void setChw(String chw) {
		this.chw = chw;
	}

}