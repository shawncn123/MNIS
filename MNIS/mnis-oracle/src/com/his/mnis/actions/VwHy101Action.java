package com.his.mnis.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.his.mnis.services.VwHy101Service;
import com.opensymphony.xwork2.ActionSupport;

public class VwHy101Action extends ActionSupport implements RequestAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long v_key1;
	private int v_key2;
	private short v_yebh;
	private VwHy101Service vwHy101Service;

	public long getV_key1() {
		return v_key1;
	}

	public void setV_key1(long v_key1) {
		this.v_key1 = v_key1;
	}

	public int getV_key2() {
		return v_key2;
	}

	public void setV_key2(int v_key2) {
		this.v_key2 = v_key2;
	}

	public short getV_yebh() {
		return v_yebh;
	}

	public void setV_yebh(short v_yebh) {
		this.v_yebh = v_yebh;
	}

	public VwHy101Service getVwHy101Service() {
		return vwHy101Service;
	}

	public void setVwHy101Service(VwHy101Service vwHy101Service) {
		this.vwHy101Service = vwHy101Service;
	}

	public String getListBingRenHuaYanByKey(){
		request.put("bingrgeti_huayan", vwHy101Service.getListBingRenHuaYanByKey(v_key1,v_key2,v_yebh));
		return SUCCESS;
	}
	
	private Map<String,Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
