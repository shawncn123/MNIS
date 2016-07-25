package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.TwBryzzxService;
import com.opensymphony.xwork2.ActionSupport;

public class TwBryzzxAction extends ActionSupport implements RequestAware,SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vsjd;
	private long groupxh;
	private String hsid;
	private String hsxm;
	private String zxms;
	private TwBryzzxService twBryzzxService;

	public String getVsjd() {
		return vsjd;
	}

	public void setVsjd(String vsjd) {
		this.vsjd = vsjd;
	}

	public long getGroupxh() {
		return groupxh;
	}

	public void setGroupxh(long groupxh) {
		this.groupxh = groupxh;
	}

	public String getHsid() {
		return hsid;
	}

	public void setHsid(String hsid) {
		this.hsid = hsid;
	}

	public String getHsxm() {
		return hsxm;
	}

	public void setHsxm(String hsxm) {
		this.hsxm = hsxm;
	}

	public String getZxms() {
		return zxms;
	}

	public void setZxms(String zxms) {
		this.zxms = zxms;
	}

	public TwBryzzxService getTwBryzzxService() {
		return twBryzzxService;
	}

	public void setTwBryzzxService(TwBryzzxService twBryzzxService) {
		this.twBryzzxService = twBryzzxService;
	}

	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	/*
	 * 根据病人key1,key2值查询病人医嘱执行数据
	 */
	public String getListBryzzxByKey(){
		try {
			Object obj = session.get("bingrgetixingxi");
			short yeid = 0;
			if(obj != null){
				VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
				Object obj_ye =  session.get("bingrgetixingxi_yinger");
				if(obj_ye!=null){
					BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
					yeid = bingRenSessionXingXi.getYebh();
				}
				List<TwBryzzx> twBryzzxs = twBryzzxService.getListBrYzzxByKey(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(),yeid);
				List<TwBryzzxRemodel> twBryzzxRemodels = twBryzzxService.getListBrYzzxRemodel(twBryzzxs);
				if(twBryzzxs == null){
					return ERROR;
				}else{
					request.put("bingrGeTi_YiZhu_zhixing", twBryzzxRemodels);
					request.put("test_request", "test");
					request.put("action_name", "bingrGeTi_YiZhuZhiXing");
					return SUCCESS;
				}
			}else{
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/*
	 * 传入参数，执行procedure 保存医嘱执行数据
	 * Date rq, String sjd, long groupxh,
			String hsid, String hsxm, Date zxsj, String zxms
	 */
	public String bingRenYzzx_baocun(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date zxsj = new Date();
		Date rq = new Date();
		try {
			rq = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			hsid = vwRybq.getRyid();
			hsxm = vwRybq.getRyxm();
			String proc_result = twBryzzxService.bingRenYzzx_baocun(rq, vsjd, groupxh, hsid, hsxm, zxsj, zxms);
			if(proc_result.equals("1")){
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));    //1 表示失败
			}else{
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		
		return "ajax_return";
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
