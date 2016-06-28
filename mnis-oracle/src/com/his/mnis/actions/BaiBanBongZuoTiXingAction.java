package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.BaiBanBongZuoTiXingService;
import com.opensymphony.xwork2.ActionSupport;

public class BaiBanBongZuoTiXingAction extends ActionSupport implements
		RequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BaiBanBongZuoTiXingService baiBanBongZuoTiXingService;
	
	public BaiBanBongZuoTiXingService getBaiBanBongZuoTiXingService() {
		return baiBanBongZuoTiXingService;
	}

	public void setBaiBanBongZuoTiXingService(
			BaiBanBongZuoTiXingService baiBanBongZuoTiXingService) {
		this.baiBanBongZuoTiXingService = baiBanBongZuoTiXingService;
	}
	/*
	 * 从我的病人获取床位为参数查询相关项目相关内容
	 */
	
	public String chaListXiangMuNeiRong(){
		
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		String vbqid = (String) session.get("dangqianbingqu_id");
		if(vwRybq!=null && vbqid!=null){
			String vczyid = vwRybq.getRyid();
			List<String> czytxs = baiBanBongZuoTiXingService.chaListXiangMuNeiRongByCzyId(vczyid, vbqid);
			List<String> chwtxs = baiBanBongZuoTiXingService.chaListXiangMuNeiRongByChw(vczyid, vbqid);
			if((czytxs!=null && czytxs.size()>0) || (chwtxs!=null && chwtxs.size()>0)){
				if(czytxs.size()>0){
					request.put("czybbtxs", czytxs);
				}
				if(chwtxs.size()>0){
					request.put("chwbbtxs", chwtxs);
				}
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
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
