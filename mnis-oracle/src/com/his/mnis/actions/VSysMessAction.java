package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VSysMessReader;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.VSysMessService;
import com.opensymphony.xwork2.ActionSupport;

public class VSysMessAction extends ActionSupport implements RequestAware,
		SessionAware {

	private String readflag;
	private int pageno;
	private int pagerows =20;
	private VSysMessService vSysMessService;
	private String messid;
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getMessid() {
		return messid;
	}

	public void setMessid(String messid) {
		this.messid = messid;
	}

	public VSysMessService getvSysMessService() {
		return vSysMessService;
	}

	public void setvSysMessService(VSysMessService vSysMessService) {
		this.vSysMessService = vSysMessService;
	}

	public String getReadflag() {
		return readflag;
	}

	public void setReadflag(String readflag) {
		this.readflag = readflag;
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public String getListSysMessByRenyId(){
		Object obj = session.get("caozuoyuan");
		if(obj != null){
			try {
				VwRybq vwRybq = (VwRybq) obj;
				String ryid = vwRybq.getRyid();
				List<VSysMessReader> vSysMessReaders = vSysMessService.getListSysMessByRenyId(ryid, pageno, pagerows);
				List<VSysMessReader> vSysMessReaderWeiDus = vSysMessService.getListSysMessByRenyIdZhuangt(ryid, pageno, pagerows,"0");
				List<VSysMessReader> vSysMessReaderGuoQiWeiDus = vSysMessService.getListMessageGuoQiWeiDu(ryid, pageno, pagerows);
				request.put("sysmess", vSysMessReaders);
				request.put("sysmessweidu", vSysMessReaderWeiDus);
				request.put("sysmessguoqiweidu", vSysMessReaderGuoQiWeiDus);
				request.put("action_name", "mymessage?pageno=1");
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}
	public String getListSysMessByRenyIdZhuangt(){
		try {
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			String ryid = vwRybq.getRyid();
			List<VSysMessReader> vSysMessReaders = vSysMessService.getListSysMessByRenyIdZhuangt(ryid, pageno, pagerows,readflag);
			request.put("sysmess", vSysMessReaders);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String queDingXiaoXiYiDu(){
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		String ryid = vwRybq.getRyid();
		try {
			String zxzt = vSysMessService.queDingXiaoXiYiDu(messid, ryid);
			if(zxzt.equals("0")){   //0 表示成功
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			}else{
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
			return "ajax-success";
		} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return ERROR;
		}
	}
	
	public String getCountWeiDuXiaoXi(){
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		String ryid = vwRybq.getRyid();
		int wdcount = vSysMessService.getCountSysMessByRenyIdZhuangt(ryid);
		String scount = wdcount + "";
		inputStream = new StringBufferInputStream(scount); 
		return "ajax_wdxxcount";
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
