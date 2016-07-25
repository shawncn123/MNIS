package com.his.mnis.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.VwJc101Service;
import com.opensymphony.xwork2.ActionSupport;

public class VwJc101Action extends ActionSupport implements RequestAware,SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VwJc101Service vwJc101Service;
	private String vwjbz;

	public String getVwjbz() {
		return vwjbz;
	}

	public void setVwjbz(String vwjbz) {
		this.vwjbz = vwjbz;
	}

	public VwJc101Service getVwJc101Service() {
		return vwJc101Service;
	}

	public void setVwJc101Service(VwJc101Service vwJc101Service) {
		this.vwJc101Service = vwJc101Service;
	}
	
	public String getListBingrJiancByKey(){
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			request.put("bingrgeti_jiancha", vwJc101Service.getListBingrJiancByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
			request.put("action_name", "bingrGeTi_JianCha");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	/*
	 * 获取病人危急值的检查信息
	 */
	public String getListJianChaWeiJiByKey(){
		try {
			Object obj = session.get("bingrgetixingxi");
			short yeid = 0;
			if(obj != null){
				VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
				Object obj_ye =  session.get("bingrgetixingxi_yinger");
				if(obj_ye!=null){
					BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
					yeid = bingRenSessionXingXi.getYebh();
				}
				if(vwjbz.equals("1")){
					request.put("bingrgeti_jiancha", vwJc101Service.getListBingRenJiancByWjflagAndBingrKey(vwjbz, vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
				}else {
					request.put("bingrgeti_jiancha", vwJc101Service.getListBingrJiancByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
				}
				request.put("vwjbz", vwjbz);
				return SUCCESS;
				
			}else{
				return ERROR;
			}
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
