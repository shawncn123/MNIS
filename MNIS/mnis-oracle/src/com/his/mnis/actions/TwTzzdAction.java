package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.his.mnis.entities.TwTzzd;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.TwTzzdService;
import com.his.mnis.services.VwBqbrZyService;
import com.opensymphony.xwork2.ActionSupport;

public class TwTzzdAction extends ActionSupport implements RequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long v_key1;
	private Integer v_key2;

	private TwTzzdService twTzzdService;
	private VwBqbrZyService vwBqbrZyService;

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

	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {

		this.request = arg0;
		
	}
	
	public String getBingRenTiZhengLuRuByBingQuId(){
	
		VwBqbrZy vwBqbrZy = vwBqbrZyService.getBingRenXingXiByKey(v_key1,v_key2);
		
		request.put("bingrgetixingxi", vwBqbrZy);
		
		List<TwTzzd> twTzzds = twTzzdService.getBingRenTiZhengLuRuByBingQuId(vwBqbrZy.getBq());
		
		request.put("bingr_tizheng_luruxiang", twTzzds);
		
		return SUCCESS;
	
	}
}
