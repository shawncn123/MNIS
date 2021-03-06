package com.his.mnis.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.VwRybqService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class VwRybqAction extends ActionSupport implements RequestAware,
	SessionAware,Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VwRybq vwRybq;
	private VwRybqService vwRybqService;
	
	private String yonghu_name; //人员代码 (登录的操作员代码)
	private String mima;
	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

	private String bqid; //病区id

	public String getYonghu_name() {
		return yonghu_name;
	}

	public void setYonghu_name(String yonghu_name) {
		this.yonghu_name = yonghu_name;
	}

	public VwRybqService getVwRybqService() {
		return vwRybqService;
	}
	
	public void setVwRybqService(VwRybqService vwRybqService) {
		this.vwRybqService = vwRybqService;
	}

	
	/*
	 * 根据人员ID获取对应病区
	 */
	public String getListBingQuByRenYuanId() {
		//request.put("listbingqu", value)
			return SUCCESS;
	}
	/*
	 * 根据人员代码(登录的操作员代码) 获取对应人员id, 病人列表,当前操作病区id
	 */
	public String getRenYuanIdByRenYuanDaiMa() {
		try {
			String vryid = vwRybqService.callProcedurePW_Identify(yonghu_name, mima);
			if(vryid=="1"){
				request.put("login_check", "1");
				return ERROR;
			}else{
			vwRybq = vwRybqService.getRenYuanIdByRenYuanDaiMa(vryid);
			session.put("caozuoyuan", vwRybq);
			String bqid = vwRybqService.getCaoZuoBingQuIdByCaozyId(vwRybq.getRyid());
			session.put("dangqianbingqu_id", bqid);
			request.put("bqry", vwRybqService.listBingrByBingQuId(bqid));
			List<VwRybq> vwRybqs = vwRybqService.listBingQuByCaozyId(vwRybq.getRyid());
			for (int i = 0; i < vwRybqs.size(); i++) {
				if(vwRybqs.get(i).getBq().contains(bqid)){
					session.put("dangqianbingqu_name", vwRybqs.get(i).getBqmc());
				}
			}
			request.put("caozuoyuan_bingqu", vwRybqs);
			request.put("action_name", "brlbshuaxin");
			request.put("login_check", "0");
			return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.put("login_check", "1");
			return ERROR;
		}
	}

	/*
	 * 根据人员ID,查到相应病区id－1.上次登录的病区ID，2.缺省病区ID，3、排第一位的病区id，然后获取对应的病人信息
	 */
	public String getListBingqBingrByRenYuanId() {
		
		return SUCCESS;
}
	
	/*
	 * 查询当前操作员，当前病区的病人信息
	 */
	public String getListBingqBingrBySession() {
		Object obj = session.get("dangqianbingqu_id");
		if(obj!=null){
			String bqid = (String)obj;
			vwRybq = (VwRybq) session.get("caozuoyuan");
			List<VwRybq> vwRybqs = vwRybqService.listBingQuByCaozyId(vwRybq.getRyid());
			request.put("caozuoyuan_bingqu", vwRybqs);
			request.put("bqry", vwRybqService.listBingrByBingQuId(bqid));
			request.put("action_name", "brlbshuaxin");
			return SUCCESS;
		}else{
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
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
