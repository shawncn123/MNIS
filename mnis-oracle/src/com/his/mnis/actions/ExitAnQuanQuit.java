package com.his.mnis.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ExitAnQuanQuit extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String AnQuanQuit(){
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session1 = request.getSession();  
		session1.invalidate();  
		return SUCCESS;
	}
	private Map<String,Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
