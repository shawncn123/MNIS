package com.his.mnis.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.VwJc101Service;
import com.opensymphony.xwork2.ActionSupport;

public class VwJc101Action extends ActionSupport implements RequestAware,SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VwJc101Service vwJc101Service;

	public VwJc101Service getVwJc101Service() {
		return vwJc101Service;
	}

	public void setVwJc101Service(VwJc101Service vwJc101Service) {
		this.vwJc101Service = vwJc101Service;
	}
	
	public String getListBingrJiancByKey(){
		VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
		request.put("bingrgeti_jiancha", vwJc101Service.getListBingrJiancByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),(short)(0)));
		return SUCCESS;
	}

	private Map<String,Object> request;
	private Map<String,Object> session;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {

		this.request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
