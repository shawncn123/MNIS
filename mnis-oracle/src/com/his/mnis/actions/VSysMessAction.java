package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VSysMessReader;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.VSysMessService;
import com.opensymphony.xwork2.ActionSupport;

public class VSysMessAction extends ActionSupport implements RequestAware,
		SessionAware {

	private String readflag;
	private int pageno;
	private int pagerows =20;
	private VSysMessService vSysMessService;
	
	public VSysMessService getvSysMessService() {
		return vSysMessService;
	}

	public void setvSysMessService(VSysMessService vSysMessService) {
		this.vSysMessService = vSysMessService;
	}

	public String getReadflag() {
		return readflag;
	}

	public void setReadflag(String readflag) {
		this.readflag = readflag;
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public String getListSysMessByRenyId(){
		try {
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			String ryid = vwRybq.getId();
			List<VSysMessReader> vSysMessReaders = vSysMessService.getListSysMessByRenyId(ryid, pageno, pagerows);
			request.put("sysmess", vSysMessReaders);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String getListSysMessByRenyIdZhuangt(){
		try {
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			String ryid = vwRybq.getId();
			List<VSysMessReader> vSysMessReaders = vSysMessService.getListSysMessByRenyIdZhuangt(ryid, pageno, pagerows,readflag);
			request.put("sysmess", vSysMessReaders);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	private Map<String,Object> request;
	private Map<String,Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
