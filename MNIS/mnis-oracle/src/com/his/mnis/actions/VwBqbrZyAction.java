package com.his.mnis.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.VwBqbrZyService;
import com.his.mnis.services.VwRybqService;
import com.opensymphony.xwork2.ActionSupport;

public class VwBqbrZyAction extends ActionSupport implements RequestAware,SessionAware{

	private static final long serialVersionUID = 1L;
	
	private String bqid;
	
	private VwBqbrZyService vwBqbrZyService;
	
	public void setBqid(String bqid) {
		this.bqid = bqid;
	}
	public String getBqid() {
		return bqid;
	}
	
	public VwBqbrZyService getVwBqbrZyService() {
		return vwBqbrZyService;
	}
	public void setVwBqbrZyService(VwBqbrZyService vwBqbrZyService) {
		this.vwBqbrZyService = vwBqbrZyService;
	}
	private String caoZyId;
	
	private VwRybqService vwRybqService;
	
	public String getCaoZyId() {
		return caoZyId;
	}
	public void setCaoZyId(String caoZyId) {
		this.caoZyId = caoZyId;
	}
	
	public void setVwRybqService(VwRybqService vwRybqService) {
		this.vwRybqService = vwRybqService;
	}
	
	private String result;
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return result;
	}
	
	/*
	 * 通过病区id查询相应的病区病人列表
	 */
	public String listBingqBingrByBingqId() throws IOException{
		List<VwBqbrZy> vwBqbrZys = vwBqbrZyService.listBingqBingrByBingqId(bqid);
		session.put("dangqianbingqu_id", bqid);
		
		 JSONArray jsonArray = JSONArray.fromObject(vwBqbrZys);  
//		 JSONObject json = JSONObject.fromObject(vwBqbrZys);  
	     System.out.println( jsonArray);  
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jsonArray.toString());
	     
//		result = json.toString();
		return null;
		
	}
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		
		this.request =  arg0;
		
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		
		this.session = arg0;
		
	}
	
//	public String listBingqBingr_jianka(){
//		request.put("bqry", vwBqbrZyService.listBingqBingr(bqid));
//		return SUCCESS;
//	}
	
}
