package com.his.mnis.actions;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.TiWenDanService;
import com.opensymphony.xwork2.ActionSupport;

public class TiWenDanAction extends ActionSupport implements RequestAware,
		SessionAware {

	private TiWenDanService tiWenDanService;
	
	public TiWenDanService getTiWenDanService() {
		return tiWenDanService;
	}

	public void setTiWenDanService(TiWenDanService tiWenDanService) {
		this.tiWenDanService = tiWenDanService;
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

	public String getTiWenDanShiJianDuan(){
//		VwBqbrZy vwBqbrZy1 = (VwBqbrZy) session.get("bingrgetixingxi");
//		System.out.println(vwBqbrZy1);
		
		//暂时屏蔽
//		try {
//			request.put("BingrenTiWenJiLu_shijianduan", tiWenDanService.getListRqBingRenTiWenJiLu());
//			return SUCCESS;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ERROR;
//		}
		
		return SUCCESS;
		
	}
}
