package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.his.mnis.services.VmBqbrService;
import com.opensymphony.xwork2.ActionSupport;

public class VmBqbrAction extends ActionSupport implements RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long keshi_id;
//	Long keshi_id_long = Long.parseLong(k); 或 
	
	private VmBqbrService vmBqbrService;

	public void setKeshi_id(Long keshi_id) {
		this.keshi_id = keshi_id;
	}
	
	public void setVmBqbrService(VmBqbrService vmBqbrService) {
		this.vmBqbrService = vmBqbrService;
	}
	
	public String getbqry() throws UnsupportedEncodingException {

		request.put("bqry", vmBqbrService.getBrByBmid(keshi_id));
		return SUCCESS;
	}
	

	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request =  arg0;
	}

}
