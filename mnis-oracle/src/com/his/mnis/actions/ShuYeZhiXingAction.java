package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.ShuYeZhiXingService;
import com.his.mnis.services.TwBryzzxService;
import com.opensymphony.xwork2.ActionSupport;

public class ShuYeZhiXingAction extends ActionSupport implements RequestAware,
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ShuYeZhiXingService shuYeZhiXingService;
	private TwBryzzxService twBryzzxService;
	public ShuYeZhiXingService getShuYeZhiXingService() {
		return shuYeZhiXingService;
	}

	public void setShuYeZhiXingService(ShuYeZhiXingService shuYeZhiXingService) {
		this.shuYeZhiXingService = shuYeZhiXingService;
	}

	public TwBryzzxService getTwBryzzxService() {
		return twBryzzxService;
	}

	public void setTwBryzzxService(TwBryzzxService twBryzzxService) {
		this.twBryzzxService = twBryzzxService;
	}

	private String yzzxfl;
	
	public String getYzzxfl() {
		return yzzxfl;
	}

	public void setYzzxfl(String yzzxfl) {
		this.yzzxfl = yzzxfl;
	}
/*
 * 根据护士id和医嘱执行分类（01表输液）查询我们的病人输液未执行医嘱
 */
	public String getMyBingRenZhiXingYiZhuByHsidZxfl(){
		
		/*先给医嘱执行分类 yzzxfl 赋值 ‘01’*/
		yzzxfl="01";
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		String vhsid = vwRybq.getRyid();
		System.out.println("hsid="+vhsid);
		String proc_result = shuYeZhiXingService.createMyBingRenZhiXingYiZhuByHsid(vhsid);
		if(proc_result.equals("1")){
			return ERROR;
		}
		List<TwBryzzx> twBryzzxs = shuYeZhiXingService.getMyBingRenZhiXingYiZhuByHsidZxfl(vhsid, yzzxfl);
		if(twBryzzxs!=null && twBryzzxs.size()>0){
			List<TwBryzzxRemodel> twBryzzxRemodels = twBryzzxService.getListBrYzzxRemodel(twBryzzxs);
			request.put("shuye_yizhu_zhixing", twBryzzxRemodels);
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