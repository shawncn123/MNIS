package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.TwXjDm;
import com.his.mnis.entities.TwXjYw;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.entities.VwXjFl;
import com.his.mnis.entities.XuanJiaoBingRenNeiRong;
import com.his.mnis.services.XuanJiaoService;
import com.opensymphony.xwork2.ActionSupport;

public class XuanJiaoAction extends ActionSupport implements RequestAware,
		SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private XuanJiaoService xuanJiaoService;
	private String xjdmid;
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getXjdmid() {
		return xjdmid;
	}

	public void setXjdmid(String xjdmid) {
		this.xjdmid = xjdmid;
	}

	public XuanJiaoService getXuanJiaoService() {
		return xuanJiaoService;
	}

	public void setXuanJiaoService(XuanJiaoService xuanJiaoService) {
		this.xuanJiaoService = xuanJiaoService;
	}

	/*
	 * 获取宣教分类和相关宣教内容
	 */
	public String getListXuanJiaoNeiRong(){
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			List<VwXjFl> vwXjFls = xuanJiaoService.getListXuanJiaoFenLei();
			List<TwXjDm> twXjDms = xuanJiaoService.getListXuanJiaoNeiRong();
			List<TwXjYw> twXjYws = xuanJiaoService.getListXjYwByBingrKey(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid);
			if(vwXjFls.size()>0 && twXjDms.size() > 0 ){
				request.put("xuanjiaofl", vwXjFls);
				List<XuanJiaoBingRenNeiRong> xuanJiaoBingRenNeiRongs = xuanJiaoService.getListXuanJiaoBingRenNeiRong(vwXjFls, twXjDms, twXjYws);
				request.put("brxuanjiaonr", xuanJiaoBingRenNeiRongs);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}
	/*
	 * 根据分类代码获取相关分类宣教内容
	 */
	public String getListXjNrByDaiMa(String fldm){
		List<TwXjDm> twXjDms = xuanJiaoService.getListXjNrByDaiMa(fldm);
		if(twXjDms.size()>0){
			request.put("xuanjiaonrbyfl", twXjDms);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/*
	 * 保存确定宣教的数据
	 */
	public String addXuanJiaoQueDing(){
		TwXjYw twXjYw = new TwXjYw();
		Date dttime = new Date();
//		Date dtdate = new Date();
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
		twXjYw.setBq(vwBqbrZy.getBq());
		twXjYw.setBz("");
		twXjYw.setChw(vwBqbrZy.getChw());
		twXjYw.setKey1(vwBqbrZy.getKey1());
		twXjYw.setKey2(vwBqbrZy.getKey2());
		twXjYw.setRq(dttime);
		twXjYw.setStime(dttime);
		twXjYw.setXjdmid(xjdmid);
		twXjYw.setXjhsid(vwRybq.getRyid());
		twXjYw.setXjhsxm(vwRybq.getRyxm());
		twXjYw.setYebh((short)0);
		
		try {
			int res = xuanJiaoService.addXuanJiaoQueDing(twXjYw);
			if(res==1){
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			}else{
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
			return "ajax-success";
		} catch (Exception e) {
			e.printStackTrace();
			return "ajax-error";
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
