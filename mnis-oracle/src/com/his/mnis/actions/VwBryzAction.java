package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwBryz;
import com.his.mnis.entities.VwBryzRemodel;
import com.his.mnis.services.VwBryzService;
import com.opensymphony.xwork2.ActionSupport;

public class VwBryzAction extends ActionSupport implements RequestAware,SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long v_key1;
	private int v_key2;
	private short v_yebh;
	private String fl;
	private VwBryzService vwBryzService;
	private List<VwBryz> vwBryzs;

	public String getFl() {
		return fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public List<VwBryz> getVwBryzs() {
		return vwBryzs;
	}

	public void setVwBryzs(List<VwBryz> vwBryzs) {
		this.vwBryzs = vwBryzs;
	}

	public long getV_key1() {
		return v_key1;
	}

	public void setV_key1(long v_key1) {
		this.v_key1 = v_key1;
	}

	public int getV_key2() {
		return v_key2;
	}

	public void setV_key2(int v_key2) {
		this.v_key2 = v_key2;
	}

	public short getV_yebh() {
		return v_yebh;
	}

	public void setV_yebh(short v_yebh) {
		this.v_yebh = v_yebh;
	}

	/*
	 * 根据病人key1,key2值查询病人医嘱数据
	 */
	public String getListBrYzByKey(){
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			vwBryzs = vwBryzService.getListBrYzByKey(vwBqbrZy.getKey1(), vwBqbrZy.getKey2() , yeid);
			List<VwBryzRemodel> vwBryzRemodels = vwBryzService.getListBrYzRemodel(vwBryzs);
			if(vwBryzs == null){
				return ERROR;
			}else{
				request.put("bingrGeTi_YiZhu", vwBryzRemodels);
				request.put("action_name", "bingrGeTi_YiZhuBen");
				return SUCCESS;
			}
		}else{
			return ERROR;
		}
	}
	
	/*
	 * 根据病人key1,key2值和给定的条件值查询病人医嘱数据  String v_tiaojianstr;      //条件字符串
	 */
	
	public String getListBrYzByKeyAndTiaoJian(){
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
				List<VwBryz> vwBryzs = vwBryzService.getListBrYzByKeyAndTiaoJian(vwBqbrZy.getKey1(), vwBqbrZy.getKey2() , yeid,fl);
				if(vwBryzs == null){
					return ERROR;
				}else{
					List<VwBryzRemodel> vwBryzRemodels = vwBryzService.getListBrYzRemodel(vwBryzs);
					request.put("bingrGeTi_YiZhu", vwBryzRemodels);
					request.put("action_name", "bingrGeTi_YiZhuBen");
					return SUCCESS;
				}
			}else{
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
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
	
	public VwBryzService getVwBryzService() {
		return vwBryzService;
	}

	public void setVwBryzService(VwBryzService vwBryzService) {
		this.vwBryzService = vwBryzService;
	}


}
