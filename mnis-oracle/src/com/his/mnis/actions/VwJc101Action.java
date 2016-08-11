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

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwJc101;
import com.his.mnis.services.VwJc101Service;
import com.opensymphony.xwork2.ActionSupport;

public class VwJc101Action extends ActionSupport implements RequestAware,SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VwJc101Service vwJc101Service;
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

	public VwJc101Service getVwJc101Service() {
		return vwJc101Service;
	}

	public void setVwJc101Service(VwJc101Service vwJc101Service) {
		this.vwJc101Service = vwJc101Service;
	}
	
	public String getListBingrJiancByKey(){
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			request.put("bingrgeti_jiancha", vwJc101Service.getListBingrJiancByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
			request.put("action_name", "bingrGeTi_JianCha");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	/*
	 * 获取病人危急值的检查信息
	 */
	public String getListJianChaWeiJiByKey(){
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
					request.put("bingrgeti_jiancha", vwJc101Service.getListBingRenJiancByWjflagAndBingrKey(vwjbz, vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
				}else {
					request.put("bingrgeti_jiancha", vwJc101Service.getListBingrJiancByKey(vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid));
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
	 * 根据时间,病人Key,危急值 查询病人的相关检查信息
	 */
	public String getListBingRenJiancByDateAndWjflag() throws ParseException {
		List<VwJc101> vwJc101s;
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
			Date sqrq = sdf.parse(vsqrq );
			if(vwjbz.equals("1")){
				vwJc101s = vwJc101Service.getListBingRenJiancByDateAndWjflag(vwjbz, sqrq, vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid);
			}else {
				vwJc101s = vwJc101Service.getListBingRenJiancByDate(sqrq, vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid);
			}
//			request.put("vwjbz", vwjbz);
			JSONArray jsonArray = JSONArray.fromObject(vwJc101s);
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
