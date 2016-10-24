package com.his.mnis.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.entities.Zd001;
import com.his.mnis.services.ShuYeZhiXingService;
import com.his.mnis.services.TwBryzzxService;
import com.his.mnis.services.YiZhuWeiZhiXingService;
import com.opensymphony.xwork2.ActionSupport;

public class YiZhuWeiZhiXingAction extends ActionSupport implements
		RequestAware,SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String vxzzxfl;
	private String vxzrq;
	public String getVxzrq() {
		return vxzrq;
	}

	public void setVxzrq(String vxzrq) {
		this.vxzrq = vxzrq;
	}

	private ShuYeZhiXingService shuYeZhiXingService;
	private TwBryzzxService twBryzzxService;
	
	public String getVxzzxfl() {
		return vxzzxfl;
	}
	
	public void setVxzzxfl(String vxzzxfl) {
		this.vxzzxfl = vxzzxfl;
	}
	
	public TwBryzzxService getTwBryzzxService() {
		return twBryzzxService;
	}

	public void setTwBryzzxService(TwBryzzxService twBryzzxService) {
		this.twBryzzxService = twBryzzxService;
	}

	public ShuYeZhiXingService getShuYeZhiXingService() {
		return shuYeZhiXingService;
	}

	public void setShuYeZhiXingService(ShuYeZhiXingService shuYeZhiXingService) {
		this.shuYeZhiXingService = shuYeZhiXingService;
	}

	private YiZhuWeiZhiXingService yiZhuWeiZhiXingService;
	
	public YiZhuWeiZhiXingService getYiZhuWeiZhiXingService() {
		return yiZhuWeiZhiXingService;
	}

	public void setYiZhuWeiZhiXingService(
			YiZhuWeiZhiXingService yiZhuWeiZhiXingService) {
		this.yiZhuWeiZhiXingService = yiZhuWeiZhiXingService;
	}

	public String getListYiZhuZhiXingFenLei(){
		Object object = yiZhuWeiZhiXingService.getListYiZhuZXFL();
		if(object!=null){
			List<Zd001> zd001s = (List<Zd001>) object;
			request.put("yizhuzxfl", zd001s);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/*
	 * 根据护士id和医嘱执行分类，查询我的病人未执行医嘱
	 */
		public String getListWeiZhiXingYiZhuByHsidZxfl() throws ParseException{
			
			Object obj = session.get("caozuoyuan");
			if(obj != null){
				VwRybq vwRybq = (VwRybq) obj;
				String vhsid = vwRybq.getRyid();
				String proc_result = shuYeZhiXingService.createMyBingRenZhiXingYiZhuByHsid(vhsid);
				if(proc_result.equals("1")){
					return ERROR;
				}
				SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
				Date xzrq = sdf.parse(vxzrq);
				List<TwBryzzx> twBryzzxs = shuYeZhiXingService.getMyBingRenZhiXingYiZhuByHsidZxfl(vhsid, vxzzxfl,xzrq);
				if(twBryzzxs!=null && twBryzzxs.size()>0){
					List<TwBryzzxRemodel> twBryzzxRemodels = twBryzzxService.getListBrYzzxRemodel(twBryzzxs);
					request.put("yizhu_weizhixing", twBryzzxRemodels);
					String actname = "yizhuweizhixing?vxzzxfl=" + vxzzxfl;
					request.put("action_name", actname);
					return SUCCESS;
				}else{
					return ERROR;
				}
			}else{
				return ERROR;
			}
		}
		
		/*
		 * 根据护士id和医嘱执行分类，查询我的病人未执行医嘱 for jQuery
		 */
		public String getListWeiZhiXingYiZhuByHsidZxflforjQuery() throws ParseException{
			
			Object obj = session.get("caozuoyuan");
			if(obj != null){
				VwRybq vwRybq = (VwRybq) obj;
				String vhsid = vwRybq.getRyid();
				String proc_result = shuYeZhiXingService.createMyBingRenZhiXingYiZhuByHsid(vhsid);
				if(proc_result.equals("1")){
					return ERROR;
				}
				SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
				Date xzrq = sdf.parse(vxzrq);
				List<TwBryzzx> twBryzzxs = shuYeZhiXingService.getMyBingRenZhiXingYiZhuByHsidZxfl(vhsid, vxzzxfl,xzrq);
				if(twBryzzxs!=null && twBryzzxs.size()>0){
					List<TwBryzzxRemodel> twBryzzxRemodels = twBryzzxService.getListBrYzzxRemodel(twBryzzxs);
					JSONArray jsonArray = JSONArray.fromObject(twBryzzxRemodels);
					// JSONObject json = JSONObject.fromObject(vwBqbrZys);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("text/html;charset=UTF-8");
					try {
						response.getWriter().write(jsonArray.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return null;
		}
		
		/*
		 * 获取医嘱执行分类，根据护士id查询我的病人全部未执行医嘱
		 */
		
		public String getListAllWeiZhiXingYiZhuByHsid(){
			
			Object object = yiZhuWeiZhiXingService.getListYiZhuZXFL();
			if(object!=null){
				List<Zd001> zd001s = (List<Zd001>) object;
				request.put("yizhuzxfl", zd001s);
			}else{
				return ERROR;
			}
			
			Object obj = session.get("caozuoyuan");
			if(obj != null){
				VwRybq vwRybq = (VwRybq) obj;
				String vhsid = vwRybq.getRyid();
				String proc_result = shuYeZhiXingService.createMyBingRenZhiXingYiZhuByHsid(vhsid);
				if(proc_result.equals("1")){
					return ERROR;
				}
				Date xzrq = new Date();
				List<TwBryzzx> twBryzzxs = shuYeZhiXingService.getMyBingRenZhiXingYiZhuByHsidZxfl(vhsid, "00",xzrq);
				if(twBryzzxs!=null && twBryzzxs.size()>0){
					List<TwBryzzxRemodel> twBryzzxRemodels = twBryzzxService.getListBrYzzxRemodel(twBryzzxs);
					request.put("yizhu_weizhixing", twBryzzxRemodels);
					String actname = "allyizhuweizhixing?vxzzxfl=00";
					request.put("action_name", actname);
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
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
