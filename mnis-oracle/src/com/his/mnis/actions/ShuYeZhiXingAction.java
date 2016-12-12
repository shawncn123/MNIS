package com.his.mnis.actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.TwBryzzx_brxx;
import com.his.mnis.entities.TwBryzzx_brxx_yzmcs_remodel;
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
		Object obj = session.get("caozuoyuan");
		if(obj != null){
			Date xzrq = new Date();
			VwRybq vwRybq = (VwRybq) obj;
			String vhsid = vwRybq.getRyid();
			System.out.println("hsid="+vhsid);
			String proc_result = shuYeZhiXingService.createMyBingRenZhiXingYiZhuByHsid(vhsid,xzrq);
			if(proc_result.equals("1")){
				return ERROR;
			}
			List<TwBryzzx_brxx> twBryzzx_brxxs = shuYeZhiXingService.getMyBingRenZhiXingYiZhuByHsidZxfl(vhsid, yzzxfl,xzrq);
			if(twBryzzx_brxxs!=null && twBryzzx_brxxs.size()>0){
				List<TwBryzzx_brxx_yzmcs_remodel> twBryzzx_brxx_yzmcs_remodels = twBryzzxService.getListBrYzzxBrxxYzmcRemodel(twBryzzx_brxxs);
				request.put("shuye_yizhu_zhixing", twBryzzx_brxx_yzmcs_remodels);
				request.put("action_name", "shuyezhixing");
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
