package com.his.mnis.entities;

public class DaiXuanZheBingren {

	private String bq;
	private String bqmc;
	private String chw;
	private String jcflag;
	private String quedflag;
	
	public DaiXuanZheBingren() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DaiXuanZheBingren(String bq, String bqmc, String chw, String jcflag,String quedflag) {
		super();
		this.bq = bq;
		this.bqmc = bqmc;
		this.chw = chw;
		this.jcflag = jcflag;
		this.setQuedflag(quedflag);
	}
	
	public String getBq() {
		return bq;
	}
	public void setBq(String bq) {
		this.bq = bq;
	}
	public String getBqmc() {
		return bqmc;
	}
	public void setBqmc(String bqmc) {
		this.bqmc = bqmc;
	}
	public String getChw() {
		return chw;
	}
	public void setChw(String chw) {
		this.chw = chw;
	}
	public String getJcflag() {
		return jcflag;
	}
	public void setJcflag(String jcflag) {
		this.jcflag = jcflag;
	}
	public String getQuedflag() {
		return quedflag;
	}
	public void setQuedflag(String quedflag) {
		this.quedflag = quedflag;
	}
	
}
