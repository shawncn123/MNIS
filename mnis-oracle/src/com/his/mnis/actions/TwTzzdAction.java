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

	private Map<String, Object> request;
	private Map<String, Object> session;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {

		this.request = arg0;
		
	}
	
	public String getBingRenTiZhengLuRuByBingQuId(){
	
		try {
			VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
//			VwBqbrZy vwBqbrZy = vwBqbrZyService.getBingRenXingXiByKey(v_key1,v_key2);
//			request.put("bingrgetixingxi", vwBqbrZy);
			
			List<TwTzzd> twTzzds = twTzzdService.getBingRenTiZhengLuRuByBingQuId(vwBqbrZy.getBq());
			
			request.put("bingr_tizheng_luruxiang", twTzzds);
			
			List<VwTzzdTwLx> vwTzzdTwLxs = vwTzzdTwLxServiceImpl.getListsVwTzzdTwLx();
			
			request.put("tiwen_leixing", vwTzzdTwLxs);
			
			List<VwTzzdTwRcbz> vwTzzdTwRcbzs = vwTzzdTwRcbzServiceImpl.getListsVwTzzdTwRcbz();
			
			request.put("tiwen_rcbz", vwTzzdTwRcbzs);
			
			return SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
