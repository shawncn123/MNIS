package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.TwTzzd;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwTzzdTwLx;
import com.his.mnis.entities.VwTzzdTwRcbz;
import com.his.mnis.serviceImpl.VwTzzdTwLxServiceImpl;
import com.his.mnis.serviceImpl.VwTzzdTwRcbzServiceImpl;
import com.his.mnis.services.TwTzzdService;
import com.his.mnis.services.VwBqbrZyService;
import com.opensymphony.xwork2.ActionSupport;

public class TwTzzdAction extends ActionSupport implements RequestAware,SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long v_key1;
	private Integer v_key2;
	private String tizheng_luru_success;

	public String getTizheng_luru_success() {
		return tizheng_luru_success;
	}

	public void setTizheng_luru_success(String tizheng_luru_success) {
		this.tizheng_luru_success = tizheng_luru_success;
	}

	private TwTzzdService twTzzdService;
	private VwBqbrZyService vwBqbrZyService;
	private VwTzzdTwLxServiceImpl vwTzzdTwLxServiceImpl;
	private VwTzzdTwRcbzServiceImpl vwTzzdTwRcbzServiceImpl;
	
	public VwTzzdTwRcbzServiceImpl getVwTzzdTwRcbzServiceImpl() {
		return vwTzzdTwRcbzServiceImpl;
	}

	public void setVwTzzdTwRcbzServiceImpl(
			VwTzzdTwRcbzServiceImpl vwTzzdTwRcbzServiceImpl) {
		this.vwTzzdTwRcbzServiceImpl = vwTzzdTwRcbzServiceImpl;
	}

	public VwTzzdTwLxServiceImpl getVwTzzdTwLxServiceImpl() {
		return vwTzzdTwLxServiceImpl;
	}

	public void setVwTzzdTwLxServiceImpl(VwTzzdTwLxServiceImpl vwTzzdTwLxServiceImpl) {
		this.vwTzzdTwLxServiceImpl = vwTzzdTwLxServiceImpl;
	}
	
	public Long getV_key1() {
		return v_key1;
	}

	public void setV_key1(Long v_key1) {
		this.v_key1 = v_key1;
	}

	public Integer getV_key2() {
		return v_key2;
	}

	public void setV_key2(Integer v_key2) {
		this.v_key2 = v_key2;
	}

	public TwTzzdService getTwTzzdService() {
		return twTzzdService;
	}

	public void setTwTzzdService(TwTzzdService twTzzdService) {
		this.twTzzdService = twTzzdService;
	}
	
	public VwBqbrZyService getVwBqbrZyService() {
		return vwBqbrZyService;
	}

	public void setVwBqbrZyService(VwBqbrZyService vwBqbrZyService) {
		this.vwBqbrZyService = vwBqbrZyService;
	}

	public String getBingRenTiZhengLuRuByBingQuId(){
		request.put("tizheng_luru_success", tizheng_luru_success);
		try {
			Object obj = session.get("bingrgetixingxi");
			if(obj!=null){
				VwBqbrZy vwBqbrZy = (VwBqbrZy)obj; 
				List<TwTzzd> twTzzds = twTzzdService.getBingRenTiZhengLuRuByBingQuId(vwBqbrZy.getBq());
				
				request.put("bingr_tizheng_luruxiang", twTzzds);
				
				List<VwTzzdTwLx> vwTzzdTwLxs = vwTzzdTwLxServiceImpl.getListsVwTzzdTwLx();
				
				request.put("tiwen_leixing", vwTzzdTwLxs);
				
				List<VwTzzdTwRcbz> vwTzzdTwRcbzs = vwTzzdTwRcbzServiceImpl.getListsVwTzzdTwRcbz();
				
				request.put("tiwen_rcbz", vwTzzdTwRcbzs);
				String action_str = "tizhengluru?v_key1=" + vwBqbrZy.getKey1().toString() + "&v_key2=" + vwBqbrZy.getKey2().toString();
				request.put("action_name", action_str);
				return SUCCESS;
			}else{
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	private Map<String, Object> request;
	private Map<String, Object> session;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
