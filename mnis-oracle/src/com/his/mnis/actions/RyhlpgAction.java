package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.TwRyhlpg;
import com.his.mnis.entities.TwTzdata;
import com.his.mnis.entities.TwZyhzpg;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.entities.VwRyhlpg;
import com.his.mnis.services.RyhlpgService;
import com.opensymphony.xwork2.ActionSupport;

public class RyhlpgAction extends ActionSupport implements RequestAware,
		SessionAware {

	private static final long serialVersionUID = 1L;
	private RyhlpgService ryhlpgService;
	
	private String xm;
	private String xb;
	private String nl;
	private String bqksmc;
	private String chw;
	private String zy;
	private String mz;
	private String whcd;
	private String bsgsr;
	private String rksj;
	private String rytj;
	private String fylb;
	private String ryfs;
	private String bah;
	private String bq;
	private String rowkey;
	private InputStream inputStream;
	

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getRowkey() {
		return rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public String getBah() {
		return bah;
	}

	public void setBah(String bah) {
		this.bah = bah;
	}

	public String getBq() {
		return bq;
	}

	public void setBq(String bq) {
		this.bq = bq;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public String getBqksmc() {
		return bqksmc;
	}

	public void setBqksmc(String bqksmc) {
		this.bqksmc = bqksmc;
	}

	public String getChw() {
		return chw;
	}

	public void setChw(String chw) {
		this.chw = chw;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getBsgsr() {
		return bsgsr;
	}

	public void setBsgsr(String bsgsr) {
		this.bsgsr = bsgsr;
	}

	public String getRksj() {
		return rksj;
	}

	public void setRksj(String rksj) {
		this.rksj = rksj;
	}

	public String getRytj() {
		return rytj;
	}

	public void setRytj(String rytj) {
		this.rytj = rytj;
	}

	public String getFylb() {
		return fylb;
	}

	public void setFylb(String fylb) {
		this.fylb = fylb;
	}

	public String getRyfs() {
		return ryfs;
	}

	public void setRyfs(String ryfs) {
		this.ryfs = ryfs;
	}

	public RyhlpgService getRyhlpgService() {
		return ryhlpgService;
	}

	public void setRyhlpgService(RyhlpgService ryhlpgService) {
		this.ryhlpgService = ryhlpgService;
	}

	public String getListVwRyhlpg(){
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			VwRyhlpg vwRyhlpg = ryhlpgService.getVwRyhlpgByKey1Key2(vwBqbrZy.getKey1(), vwBqbrZy.getKey2());
			TwRyhlpg twRyhlpg = ryhlpgService.getTwRyhlpgByKey1Key2(vwBqbrZy.getKey1(), vwBqbrZy.getKey2());
			request.put("bingren_hulipinggu", twRyhlpg);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String saveRyhlpg(){
		Date rq = new Date();     
		Timestamp pgrq_tv = new Timestamp(rq.getTime());
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			TwRyhlpg  twRyhlpg = new TwRyhlpg();
			twRyhlpg.setBah(bah);
			twRyhlpg.setBq(bq);
			twRyhlpg.setBqksmc(bqksmc);
			twRyhlpg.setBsgsr(bsgsr);
			twRyhlpg.setChw(chw);
			twRyhlpg.setFylb(fylb);
			twRyhlpg.setGms("");
			twRyhlpg.setJltime(pgrq_tv);
			twRyhlpg.setJlzhsid(vwRybq.getRyid());
			twRyhlpg.setJlzhsxm(vwRybq.getRyxm());
			twRyhlpg.setKey1(vwBqbrZy.getKey1());
			twRyhlpg.setKey2(vwBqbrZy.getKey2());
			twRyhlpg.setMz(mz);
			twRyhlpg.setNl(nl);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			Date vrksj = sdf.parse(rksj);
			twRyhlpg.setRksj(Timestamp.valueOf(rksj+":00"));
			twRyhlpg.setRowkey(rowkey);
			twRyhlpg.setRyfs(ryfs);
			twRyhlpg.setRytj(rytj);
			twRyhlpg.setRyzd("");
			twRyhlpg.setWhcd(whcd);
			twRyhlpg.setXb(xb);
			twRyhlpg.setXm(xm);
			twRyhlpg.setZy(zy);
			ryhlpgService.updateTwRyhlpg(twRyhlpg);
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "ajax-error";
			}
			return "ajax-success";
		}else{
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "ajax-error";
		}
	}
	
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
