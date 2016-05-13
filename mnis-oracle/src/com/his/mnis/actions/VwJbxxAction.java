package com.his.mnis.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.his.mnis.services.VwJbxxService;
import com.opensymphony.xwork2.ActionSupport;

public class VwJbxxAction extends ActionSupport implements RequestAware {

	
	private Long v_key1;
	private Integer v_key2;
	private VwJbxxService vwJbxxService;
	
	public VwJbxxService getVwJbxxService() {
		return vwJbxxService;
	}

	public void setVwJbxxService(VwJbxxService vwJbxxService) {
		this.vwJbxxService = vwJbxxService;
	}

	public Long getV_key1() {
		return v_key1;
	}

	public void setV_key1(Long v_key1) {
		this.v_key1 = v_key1;
	}

	public Integer getV_key2() {
		return v_key2;
	}

	public void setV_key2(Integer v_key2) {
		this.v_key2 = v_key2;
	}

	public String getBingRenJiBenXxByKey(){
		
		request.put("bingren_jbxx", vwJbxxService.getBingRenJiBenXxByKey(v_key1, v_key2));
		
		return SUCCESS;
		
	}
	private Map<String,Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {

		this.request = arg0;
	}

}
