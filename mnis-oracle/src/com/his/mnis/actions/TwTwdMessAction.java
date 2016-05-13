package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.TwTwdMessService;
import com.opensymphony.xwork2.ActionSupport;

public class TwTwdMessAction extends ActionSupport implements RequestAware,SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TwTwdMessService twTwdMessService;
	
	public TwTwdMessService getTwTwdMessService() {
		return twTwdMessService;
	}

	public void setTwTwdMessService(TwTwdMessService twTwdMessService) {
		this.twTwdMessService = twTwdMessService;
	}

	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public String getTwTwdMessFile(){
		System.out.println("action e");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date date = null;
		try {
			date = sdf.parse("2016.05.05");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
		String fname = twTwdMessService.getOutStreamOfTiWenDan(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), 0, date);
		System.out.println(fname);
		inputStream = new StringBufferInputStream(fname); 
		return "ajax_file";
	}

	private Map<String,Object> request;
	private Map<String,Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
}
