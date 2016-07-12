package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.MiMaXiuGaiService;
import com.opensymphony.xwork2.ActionSupport;

public class MiMaXiuGaiAction extends ActionSupport implements SessionAware  {

	private MiMaXiuGaiService miMaXiuGaiService;
	
	private String voldpass;
	private String vnewpass;
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getVoldpass() {
		return voldpass;
	}

	public void setVoldpass(String voldpass) {
		this.voldpass = voldpass;
	}

	public String getVnewpass() {
		return vnewpass;
	}

	public void setVnewpass(String vnewpass) {
		this.vnewpass = vnewpass;
	}

	public MiMaXiuGaiService getMiMaXiuGaiService() {
		return miMaXiuGaiService;
	}

	public void setMiMaXiuGaiService(MiMaXiuGaiService miMaXiuGaiService) {
		this.miMaXiuGaiService = miMaXiuGaiService;
	}

	public String huShiXiuGaiMiMa() throws UnsupportedEncodingException{
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		String vreturn = miMaXiuGaiService.huShiXiuGaiMiMa(vwRybq.getRydm(), voldpass, vnewpass);
		if(vreturn.equals("0")){
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		}else if(vreturn.equals("oldpasserror")){
			inputStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
		}else{
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}
		return "ajax_mima";
	}
	
	private Map<String,Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	
}
