package com.his.mnis.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.BingRenHuaYanXingXi;
import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.VwHy101Service;
import com.opensymphony.xwork2.ActionSupport;

public class VwHy101Action extends ActionSupport implements RequestAware,SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VwHy101Service vwHy101Service;
	private String vwjbz;
	private String vsqrq;

	public String getVsqrq() {
		return vsqrq;
	}

	public void setVsqrq(String vsqrq) {
		this.vsqrq = vsqrq;
	}

	public String getVwjbz() {
		return vwjbz;
	}

	public void setVwjbz(String vwjbz) {
		this.vwjbz = vwjbz;
	}

	public VwHy101Service getVwHy101Service() {
		return vwHy101Service;
	}

	public void setVwHy101Service(VwHy101Service vwHy101Service) {
		this.vwHy101Service = vwHy101Service;
	}

	public String getListBingRenHuaYanByKey(){
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
				request.put("bingrgeti_huayan", vwHy101Service.getListBingRenHuaYanByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
				return SUCCESS;
			}else{
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/*
	 * 获取病人主从表的化验信息
	 */
	public String getListHuaYanAllByKey(){
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
				request.put("bingrgeti_huayan", vwHy101Service.getListHuaYanAllByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
				request.put("vwjbz", vwjbz);
				request.put("action_name", "bingrGeTi_JianYan");
				return SUCCESS;
			}else{
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/*
	 * 获取病人危急值主从表的化验信息
	 */
	public String getListHuaYanWeiJiAllByKey(){
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
					request.put("bingrgeti_huayan", vwHy101Service.getListHuaYanWeiJiAllByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
				}else {
					request.put("bingrgeti_huayan", vwHy101Service.getListHuaYanAllByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
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
	
	/*
	 * 根据时间,病人Key,危急值 查询病人的相关化验信息
	 */
	public String getListHuaYanWeiJiByKeyDate() throws ParseException{
		List<BingRenHuaYanXingXi> bingRenHuaYanXingXis;
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
			Date sqrq = sdf.parse(vsqrq);
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			if(vwjbz.equals("1")){
				bingRenHuaYanXingXis = vwHy101Service.getListWjzHuaYanByKeyDate(sqrq, vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid);
			}else {
				bingRenHuaYanXingXis = vwHy101Service.getListBingRenHuaYanByDate(sqrq, vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid);
			}
			JSONArray jsonArray = JSONArray.fromObject(bingRenHuaYanXingXis);
			// JSONObject json = JSONObject.fromObject(vwBqbrZys);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.getWriter().write(jsonArray.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
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
