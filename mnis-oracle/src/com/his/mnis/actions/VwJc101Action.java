package com.his.mnis.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.his.mnis.services.VwJc101Service;
import com.opensymphony.xwork2.ActionSupport;

public class VwJc101Action extends ActionSupport implements RequestAware {
	
	private long v_key1;
	private int v_key2;
	private short v_yebh;
	private VwJc101Service vwJc101Service;
	
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

	public VwJc101Service getVwJc101Service() {
		return vwJc101Service;
	}

	public void setVwJc101Service(VwJc101Service vwJc101Service) {
		this.vwJc101Service = vwJc101Service;
	}
	
	public String getListBingrJiancByKey(){
		request.put("bingrgeti_jiancha", vwJc101Service.getListBingrJiancByKey(v_key1, v_key2, v_yebh));
		return SUCCESS;
	}

	private Map<String,Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {

		this.request = arg0;
	}

}
