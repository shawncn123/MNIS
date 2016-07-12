package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwBqyeZy;
import com.his.mnis.services.VwBqyeZyService;
import com.opensymphony.xwork2.ActionSupport;

public class VwBqYeZyAction extends ActionSupport implements RequestAware,
		SessionAware {

	private VwBqyeZyService vwBqyeZyService;
	public VwBqyeZyService getVwBqyeZyService() {
		return vwBqyeZyService;
	}

	public void setVwBqyeZyService(VwBqyeZyService vwBqyeZyService) {
		this.vwBqyeZyService = vwBqyeZyService;
	}

	private Map<String,Object> request;
	private Map<String,Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session =  arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	
	/*
	 * 根据病人key查询相关婴儿信息
	 */
	public String getListBingrYingr(){
		VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
		long vkey1 = vwBqbrZy.getKey1();
		int vkey2 = vwBqbrZy.getKey2();
		List<VwBqyeZy> vwBqyeZies = vwBqyeZyService.getListBingrYingr(vkey1, vkey2);
		if(vwBqyeZies.size()>0 && vwBqyeZies!=null){
			request.put("bingrenyinger", vwBqyeZies);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
}
