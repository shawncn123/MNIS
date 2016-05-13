package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VmBmry;
import com.his.mnis.services.VmBmryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VmBmryAction extends ActionSupport implements SessionAware,RequestAware,
		ModelDriven<VmBmry> {
	
	private VmBmryService vmBmryService;
	
	public void setVmBmryService(VmBmryService vmBmryService) {
		this.vmBmryService = vmBmryService;
	}
	
	public String test(){
		System.out.println("tetsttt!");
		vmBmryService.test();
		request.put("czybumeng",vmBmryService.test());
		System.out.println(model);
		return SUCCESS;
	}

	private Map<String, Object> session;
	private Map<String, Object> request;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session =  arg0;
	}

	private VmBmry model;
	
	@Override
	public VmBmry getModel() {
		if(model==null){
			model=new VmBmry();
		}
		return model;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		
		this.request = arg0;
		
	}

}
