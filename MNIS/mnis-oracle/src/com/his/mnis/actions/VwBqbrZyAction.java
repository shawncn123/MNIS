package com.his.mnis.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.VwBqbrZyService;
import com.his.mnis.services.VwJbxxService;
import com.his.mnis.services.VwRybqService;
import com.opensymphony.xwork2.ActionSupport;

public class VwBqbrZyAction extends ActionSupport implements RequestAware,
		SessionAware {

	private static final long serialVersionUID = 1L;

	private String bqid;

	private VwBqbrZyService vwBqbrZyService;
	private VwJbxxService vwJbxxService;
	
	public VwJbxxService getVwJbxxService() {
		return vwJbxxService;
	}

	public void setVwJbxxService(VwJbxxService vwJbxxService) {
		this.vwJbxxService = vwJbxxService;
	}

	private Long v_key1;
	private Integer v_key2;
	
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

	public void setBqid(String bqid) {
		this.bqid = bqid;
	}

	public String getBqid() {
		return bqid;
	}

	public VwBqbrZyService getVwBqbrZyService() {
		return vwBqbrZyService;
	}

	public void setVwBqbrZyService(VwBqbrZyService vwBqbrZyService) {
		this.vwBqbrZyService = vwBqbrZyService;
	}

	private String caoZyId;

	private VwRybqService vwRybqService;

	public String getCaoZyId() {
		return caoZyId;
	}

	public void setCaoZyId(String caoZyId) {
		this.caoZyId = caoZyId;
	}

	public void setVwRybqService(VwRybqService vwRybqService) {
		this.vwRybqService = vwRybqService;
	}
	
	public VwRybqService getVwRybqService() {
		return vwRybqService;
	}

//	private String result;
//
//	public void setResult(String result) {
//		this.result = result;
//	}
//
//	public String getResult() {
//		return result;
//	}

	/*
	 * 通过病区id查询相应的病区病人列表
	 */
	public String listBingqBingrByBingqId() throws IOException {
		List<VwBqbrZy> vwBqbrZys = vwBqbrZyService
				.listBingqBingrByBingqId(bqid);
		session.put("dangqianbingqu_id", bqid);
		String bqmc = vwRybqService.getBingQuMingCheng(bqid);
		session.put("dangqianbingqu_name", bqmc);
		JSONArray jsonArray = JSONArray.fromObject(vwBqbrZys);
		// JSONObject json = JSONObject.fromObject(vwBqbrZys);
		System.out.println(jsonArray);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jsonArray.toString());
		return null;
	}
	
	/*
	 * 返回病人列表，通过session获取病区id，caozuoyuan， 再查询相应的病区病人列表，病区列表
	 */
	public String getListBingqBingrBySessionBingqId() throws IOException {
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		System.out.println(vwRybq.getId());
		String dangqianbqid = "";
		dangqianbqid = session.get("dangqianbingqu_id").toString();
		if( dangqianbqid != ""){
			List<VwRybq> vwRybqs = vwRybqService.listBingQuByCaozyId(vwRybq.getId());
			request.put("caozuoyuan_bingqu", vwRybqs);
			List<VwBqbrZy> vwBqbrZys = vwBqbrZyService.listBingqBingrByBingqId(dangqianbqid);
			request.put("bqry", vwBqbrZys);
			return SUCCESS;
		}else{
			return ERROR;
		}
			
	}
	
	/*
	 * 通过key1 key2 查询病人个体信息
	 */
	public String getBingRenXingXiByKey(){
		System.out.println("action  execute getBingRenXingXiByKey ");
		session.put("bingrgetixingxi", vwBqbrZyService.getBingRenXingXiByKey(v_key1, v_key2));
		request.put("bingren_jbxx", vwJbxxService.getBingRenJiBenXxByKey(v_key1, v_key2));
		return SUCCESS;
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
	
//	public Map<String, Object> getSession() {
//		return session;
//	}

	// public String listBingqBingr_jianka(){
	// request.put("bqry", vwBqbrZyService.listBingqBingr(bqid));
	// return SUCCESS;
	// }

}
