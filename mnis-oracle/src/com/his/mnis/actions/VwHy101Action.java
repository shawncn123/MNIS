package com.his.mnis.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.VwHy101Service;
import com.opensymphony.xwork2.ActionSupport;

public class VwHy101Action extends ActionSupport implements RequestAware,SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VwHy101Service vwHy101Service;
	private String vwjbz;

	public String getVwjbz() {
		return vwjbz;
	}

	public void setVwjbz(String vwjbz) {
		this.vwjbz = vwjbz;
	}

	public VwHy101Service getVwHy101Service() {
		return vwHy101Service;
	}

	public void setVwHy101Service(VwHy101Service vwHy101Service) {
		this.vwHy101Service = vwHy101Service;
	}

	public String getListBingRenHuaYanByKey(){
		try {
			VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
//		request.put("bingrgeti_huayan", vwHy101Service.getListBingRenHuaYanByKey(v_key1,v_key2,v_yebh));
			request.put("bingrgeti_huayan", vwHy101Service.getListBingRenHuaYanByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),(short)(0)));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/*
	 * 获取病人主从表的化验信息
	 */
	public String getListHuaYanAllByKey(){
		System.out.println("wjzfl1:"+vwjbz);
		try {
			VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
			request.put("bingrgeti_huayan", vwHy101Service.getListHuaYanAllByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),(short)(0)));
			request.put("vwjbz", vwjbz);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/*
	 * 获取病人危急值主从表的化验信息
	 */
	public String getListHuaYanWeiJiAllByKey(){
		System.out.println("wjzfl:"+vwjbz);
		try {
			VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
			if(vwjbz.equals("1")){
				request.put("bingrgeti_huayan", vwHy101Service.getListHuaYanWeiJiAllByKey(vwjbz, vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),(short)(0)));
			}else {
				request.put("bingrgeti_huayan", vwHy101Service.getListHuaYanAllByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),(short)(0)));
			}
			request.put("vwjbz", vwjbz);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
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
