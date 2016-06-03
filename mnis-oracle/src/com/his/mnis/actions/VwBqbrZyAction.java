package com.his.mnis.actions;

import java.io.IOException;
import java.util.HashMap;
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
	private String wandaixx;
	private String brxzlx;
	
	public String getBrxzlx() {
		return brxzlx;
	}

	public void setBrxzlx(String brxzlx) {
		this.brxzlx = brxzlx;
	}

	public String getWandaixx() {
		return wandaixx;
	}

	public void setWandaixx(String wandaixx) {
		this.wandaixx = wandaixx;
	}

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

	private String result;

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}
	
	/*
	 * 通过病区id、病人类型选择查询相应的病人列表
	 */
	public String listBingRenByBqIdBrlxId() throws IOException{
		
		session.put("dangqianbingqu_id", bqid);
		String bqmc = vwRybqService.getBingQuMingCheng(bqid);
		session.put("dangqianbingqu_name", bqmc);
		
		if(brxzlx.equals("0")){
			List<VwBqbrZy> vwBqbrZys = vwBqbrZyService.listBingqBingrByBingqId(bqid);
			JSONArray jsonArray = JSONArray.fromObject(vwBqbrZys);
			// JSONObject json = JSONObject.fromObject(vwBqbrZys);
//		System.out.println(jsonArray);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(jsonArray.toString());
			return null;
		}else if (brxzlx.equals("1")) {
			VwRybq hushi = (VwRybq) session.get("caozuoyuan");
			String vhsxm = hushi.getRyxm();
			List<VwBqbrZy> vwBqbrZys = vwBqbrZyService.listZeRenBingrByBqIdHsXm(bqid, vhsxm);
			JSONArray jsonArray = JSONArray.fromObject(vwBqbrZys);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(jsonArray.toString());
			return null;
		}else if (brxzlx.equals("2")) {
			VwRybq hushi = (VwRybq) session.get("caozuoyuan");
			String vhsid = hushi.getId();
			List<VwBqbrZy> vwBqbrZys = vwBqbrZyService.listMyBingrByBqIdHsId(bqid, vhsid);
			JSONArray jsonArray = JSONArray.fromObject(vwBqbrZys);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(jsonArray.toString());
			return null;
			
		}else {
			List<VwBqbrZy> vwBqbrZys = vwBqbrZyService.listBingqBingrByBingqId(bqid);
			JSONArray jsonArray = JSONArray.fromObject(vwBqbrZys);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(jsonArray.toString());
			return null;
		}
	}

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
//		System.out.println(jsonArray);
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
		try {
			session.put("bingrgetixingxi", vwBqbrZyService.getBingRenXingXiByKey(v_key1, v_key2));
			request.put("bingren_jbxx", vwJbxxService.getBingRenJiBenXxByKey(v_key1, v_key2));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/*
	 * 通过Session 保留的key1 key2 查询病人个体信息
	 */
	public String getBingRenXingXiBySessionKey(){
		try {
			VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
			request.put("bingren_jbxx", vwJbxxService.getBingRenJiBenXxByKey(vwBqbrZy.getKey1(), vwBqbrZy.getKey2()));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/*
	 * 通过腕带扫描获取病人个体信息
	 */

	public String getBingRenXingXiByWanDai(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			VwBqbrZy vwBqbrZy = vwBqbrZyService.getBingRenXingXiByWanDai(wandaixx);
			if(vwBqbrZy != null){
			map.put("br_name", vwBqbrZy.getXm());
			map.put("br_age",vwBqbrZy.getNl());
			map.put("br_xb", vwBqbrZy.getXb());
			map.put("br_chw", vwBqbrZy.getChw());
			map.put("br_key1", vwBqbrZy.getKey1());
			map.put("br_key2", vwBqbrZy.getKey2());
			JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
			result = json.toString();
			}else{
				result = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}
