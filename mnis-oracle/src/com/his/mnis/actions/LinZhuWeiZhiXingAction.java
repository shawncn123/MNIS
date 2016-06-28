package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.LinZhuWeiZhiXingRemodel;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.VwBryz;
import com.his.mnis.entities.VwBryzRemodel;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.LinZhuWeiZhiXingService;
import com.his.mnis.services.TwBryzzxService;
import com.opensymphony.xwork2.ActionSupport;

public class LinZhuWeiZhiXingAction extends ActionSupport implements
		RequestAware, SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinZhuWeiZhiXingService linZhuWeiZhiXingService;
	private TwBryzzxService twBryzzxService;

	public TwBryzzxService getTwBryzzxService() {
		return twBryzzxService;
	}

	public void setTwBryzzxService(TwBryzzxService twBryzzxService) {
		this.twBryzzxService = twBryzzxService;
	}

	public LinZhuWeiZhiXingService getLinZhuWeiZhiXingService() {
		return linZhuWeiZhiXingService;
	}

	public void setLinZhuWeiZhiXingService(
			LinZhuWeiZhiXingService linZhuWeiZhiXingService) {
		this.linZhuWeiZhiXingService = linZhuWeiZhiXingService;
	}

	public String getListMyBingRenWeiZxlz(){
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		String vhsid = vwRybq.getRyid();
		String proc_result = linZhuWeiZhiXingService.createMyBingRenYiZhu(vhsid);
		if(proc_result.equals("1")){
			return ERROR;
		}
		List<TwBryzzx> twBryzzxs = linZhuWeiZhiXingService.getListMyBingRenWeiZxlz(vhsid);
//		List<LinZhuWeiZhiXingRemodel> linZhuWeiZhiXingRemodels = linZhuWeiZhiXingService.getListBrYzRemodel(vwBryzs, vhsid);
//		request.put("linZhu_WeiZhiXing", linZhuWeiZhiXingRemodels);
		if(twBryzzxs!=null && twBryzzxs.size()>0){
			List<TwBryzzxRemodel> twBryzzxRemodels = twBryzzxService.getListBrYzzxRemodel(twBryzzxs);
			request.put("linZhu_WeiZhiXing", twBryzzxRemodels);
			return SUCCESS;
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
