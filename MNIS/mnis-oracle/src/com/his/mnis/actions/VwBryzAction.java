package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.his.mnis.entities.VwBryz;
import com.his.mnis.entities.VwBryzRemodel;
import com.his.mnis.services.VwBryzService;
import com.opensymphony.xwork2.ActionSupport;

public class VwBryzAction extends ActionSupport implements RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long v_key1;
	private int v_key2;
	private short v_yebh;
	private String v_tiaojianstr;
	private VwBryzService vwBryzService;
	private List<VwBryz> vwBryzs;

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

	public String getV_tiaojianstr() {
		return v_tiaojianstr;
	}

	public void setV_tiaojianstr(String v_tiaojianstr) {
		this.v_tiaojianstr = v_tiaojianstr;
	}

	/*
	 * 根据病人key1,key2值查询病人医嘱数据
	 */
	public String getListBrYzByKey(){
		vwBryzs = vwBryzService.getListBrYzByKey(v_key1, v_key2, v_yebh);
		List<VwBryzRemodel> vwBryzRemodels = vwBryzService.getListBrYzRemodel(vwBryzs);
		System.out.println("action_yizhu:"+vwBryzRemodels);
		if(vwBryzs == null){
			return ERROR;
		}else{
			request.put("bingrGeTi_YiZhu", vwBryzRemodels);
			return SUCCESS;
		}
	}
	
	/*
	 * 根据病人key1,key2值和给定的条件值查询病人医嘱数据  String v_tiaojianstr;      //条件字符串
	 */
	
	public String getListBrYzByKeyAndTiaoJian(){
		
		List<VwBryz> vwBryzs = vwBryzService.getListBrYzByKeyAndTiaoJian(v_key1, v_key2, v_yebh, v_tiaojianstr);
		if(vwBryzs == null){
			return ERROR;
		}else{
			request.put("bingrGeTi_YiZhu", vwBryzs);
			return SUCCESS;
		}
		
	}
	
	private Map<String,Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	public VwBryzService getVwBryzService() {
		return vwBryzService;
	}

	public void setVwBryzService(VwBryzService vwBryzService) {
		this.vwBryzService = vwBryzService;
	}

}
