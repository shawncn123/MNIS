package com.his.mnis.entities;

import java.math.BigDecimal;
import java.util.List;

/**
 * TwHulijlbiaoZd entity. @author MyEclipse Persistence Tools
 */

public class HulijlLeiOutputForUpdate implements java.io.Serializable {

	// Fields

	private String xmid;
	private String xmmc;
	private Short xsxh;
	private String zdtype;
	private BigDecimal length;
	private String dw;
	private List<TwHulijlbiaoZd1> liststr;
	private String subname1;
	private String zdtype1;
	private BigDecimal length1;
	private String dw1;
	private List<TwHulijlbiaoZd1> liststr_1;
	private String subname2;
	private String zdtype2;
	private BigDecimal length2;
	private String dw2;
	private List<TwHulijlbiaoZd1> liststr_2;
	private String subname3;
	private String zdtype3;
	private BigDecimal length3;
	private String dw3;
	private List<TwHulijlbiaoZd1> liststr_3;
	private String subname4;
	private String zdtype4;
	private BigDecimal length4;
	private String dw4;
	private List<TwHulijlbiaoZd1> liststr_4;
	private String zimokuai;
	private BigDecimal bbfl;
//	暂时做为标志标志判断 0－－新插入数据 ，1－－修改数据
	private String tyflag;  
	private Long rowkey;
	private String zddata_1;
	private String zddata_2;
	private String zddata_3;
	private String zddata_4;
	private String zddata_5;

	// Constructors

	/** default constructor */
	public HulijlLeiOutputForUpdate() {
	}

	/** minimal constructor */
	public HulijlLeiOutputForUpdate(String xmmc, Short xsxh, String zdtype,
			BigDecimal bbfl, String tyflag) {
		this.xmmc = xmmc;
		this.xsxh = xsxh;
		this.zdtype = zdtype;
		this.bbfl = bbfl;
		this.tyflag = tyflag;
	}

	public HulijlLeiOutputForUpdate(String xmid, String xmmc, Short xsxh,
			String zdtype, BigDecimal length, String dw,
			List<TwHulijlbiaoZd1> liststr, String subname1, String zdtype1,
			BigDecimal length1, String dw1, List<TwHulijlbiaoZd1> liststr_1,
			String subname2, String zdtype2, BigDecimal length2, String dw2,
			List<TwHulijlbiaoZd1> liststr_2, String subname3, String zdtype3,
			BigDecimal length3, String dw3, List<TwHulijlbiaoZd1> liststr_3,
			String subname4, String zdtype4, BigDecimal length4, String dw4,
			List<TwHulijlbiaoZd1> liststr_4, String zimokuai, BigDecimal bbfl,
			String tyflag, Long rowkey, String zddata_1, String zddata_2,
			String zddata_3, String zddata_4, String zddata_5) {
		super();
		this.xmid = xmid;
		this.xmmc = xmmc;
		this.xsxh = xsxh;
		this.zdtype = zdtype;
		this.length = length;
		this.dw = dw;
		this.liststr = liststr;
		this.subname1 = subname1;
		this.zdtype1 = zdtype1;
		this.length1 = length1;
		this.dw1 = dw1;
		this.liststr_1 = liststr_1;
		this.subname2 = subname2;
		this.zdtype2 = zdtype2;
		this.length2 = length2;
		this.dw2 = dw2;
		this.liststr_2 = liststr_2;
		this.subname3 = subname3;
		this.zdtype3 = zdtype3;
		this.length3 = length3;
		this.dw3 = dw3;
		this.liststr_3 = liststr_3;
		this.subname4 = subname4;
		this.zdtype4 = zdtype4;
		this.length4 = length4;
		this.dw4 = dw4;
		this.liststr_4 = liststr_4;
		this.zimokuai = zimokuai;
		this.bbfl = bbfl;
		this.tyflag = tyflag;
		this.rowkey = rowkey;
		this.zddata_1 = zddata_1;
		this.zddata_2 = zddata_2;
		this.zddata_3 = zddata_3;
		this.zddata_4 = zddata_4;
		this.zddata_5 = zddata_5;
	}

	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public Short getXsxh() {
		return xsxh;
	}

	public void setXsxh(Short xsxh) {
		this.xsxh = xsxh;
	}

	public String getZdtype() {
		return zdtype;
	}

	public void setZdtype(String zdtype) {
		this.zdtype = zdtype;
	}

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public List<TwHulijlbiaoZd1> getListstr() {
		return liststr;
	}

	public void setListstr(List<TwHulijlbiaoZd1> liststr) {
		this.liststr = liststr;
	}

	public String getSubname1() {
		return subname1;
	}

	public void setSubname1(String subname1) {
		this.subname1 = subname1;
	}

	public String getZdtype1() {
		return zdtype1;
	}

	public void setZdtype1(String zdtype1) {
		this.zdtype1 = zdtype1;
	}

	public BigDecimal getLength1() {
		return length1;
	}

	public void setLength1(BigDecimal length1) {
		this.length1 = length1;
	}

	public String getDw1() {
		return dw1;
	}

	public void setDw1(String dw1) {
		this.dw1 = dw1;
	}

	public List<TwHulijlbiaoZd1> getListstr_1() {
		return liststr_1;
	}

	public void setListstr_1(List<TwHulijlbiaoZd1> liststr_1) {
		this.liststr_1 = liststr_1;
	}

	public String getSubname2() {
		return subname2;
	}

	public void setSubname2(String subname2) {
		this.subname2 = subname2;
	}

	public String getZdtype2() {
		return zdtype2;
	}

	public void setZdtype2(String zdtype2) {
		this.zdtype2 = zdtype2;
	}

	public BigDecimal getLength2() {
		return length2;
	}

	public void setLength2(BigDecimal length2) {
		this.length2 = length2;
	}

	public String getDw2() {
		return dw2;
	}

	public void setDw2(String dw2) {
		this.dw2 = dw2;
	}

	public List<TwHulijlbiaoZd1> getListstr_2() {
		return liststr_2;
	}

	public void setListstr_2(List<TwHulijlbiaoZd1> liststr_2) {
		this.liststr_2 = liststr_2;
	}

	public String getSubname3() {
		return subname3;
	}

	public void setSubname3(String subname3) {
		this.subname3 = subname3;
	}

	public String getZdtype3() {
		return zdtype3;
	}

	public void setZdtype3(String zdtype3) {
		this.zdtype3 = zdtype3;
	}

	public BigDecimal getLength3() {
		return length3;
	}

	public void setLength3(BigDecimal length3) {
		this.length3 = length3;
	}

	public String getDw3() {
		return dw3;
	}

	public void setDw3(String dw3) {
		this.dw3 = dw3;
	}

	public List<TwHulijlbiaoZd1> getListstr_3() {
		return liststr_3;
	}

	public void setListstr_3(List<TwHulijlbiaoZd1> liststr_3) {
		this.liststr_3 = liststr_3;
	}

	public String getSubname4() {
		return subname4;
	}

	public void setSubname4(String subname4) {
		this.subname4 = subname4;
	}

	public String getZdtype4() {
		return zdtype4;
	}

	public void setZdtype4(String zdtype4) {
		this.zdtype4 = zdtype4;
	}

	public BigDecimal getLength4() {
		return length4;
	}

	public void setLength4(BigDecimal length4) {
		this.length4 = length4;
	}

	public String getDw4() {
		return dw4;
	}

	public void setDw4(String dw4) {
		this.dw4 = dw4;
	}

	public List<TwHulijlbiaoZd1> getListstr_4() {
		return liststr_4;
	}

	public void setListstr_4(List<TwHulijlbiaoZd1> liststr_4) {
		this.liststr_4 = liststr_4;
	}

	public String getZimokuai() {
		return zimokuai;
	}

	public void setZimokuai(String zimokuai) {
		this.zimokuai = zimokuai;
	}

	public BigDecimal getBbfl() {
		return bbfl;
	}

	public void setBbfl(BigDecimal bbfl) {
		this.bbfl = bbfl;
	}

	public String getTyflag() {
		return tyflag;
	}

	public void setTyflag(String tyflag) {
		this.tyflag = tyflag;
	}

	public Long getRowkey() {
		return rowkey;
	}

	public void setRowkey(Long rowkey) {
		this.rowkey = rowkey;
	}

	public String getZddata_1() {
		return zddata_1;
	}

	public void setZddata_1(String zddata_1) {
		this.zddata_1 = zddata_1;
	}

	public String getZddata_2() {
		return zddata_2;
	}

	public void setZddata_2(String zddata_2) {
		this.zddata_2 = zddata_2;
	}

	public String getZddata_3() {
		return zddata_3;
	}

	public void setZddata_3(String zddata_3) {
		this.zddata_3 = zddata_3;
	}

	public String getZddata_4() {
		return zddata_4;
	}

	public void setZddata_4(String zddata_4) {
		this.zddata_4 = zddata_4;
	}

	public String getZddata_5() {
		return zddata_5;
	}

	public void setZddata_5(String zddata_5) {
		this.zddata_5 = zddata_5;
	}

	
	
}