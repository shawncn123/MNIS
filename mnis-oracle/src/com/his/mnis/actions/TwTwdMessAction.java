package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.TiWenDanRiQiDuan;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.TwTwdMessService;
import com.opensymphony.xwork2.ActionSupport;

public class TwTwdMessAction extends ActionSupport implements RequestAware,SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TwTwdMessService twTwdMessService;
	private String datestring;
	
	public String getDatestring() {
		return datestring;
	}

	public void setDatestring(String datestring) {
		this.datestring = datestring;
	}

	public TwTwdMessService getTwTwdMessService() {
		return twTwdMessService;
	}

	public void setTwTwdMessService(TwTwdMessService twTwdMessService) {
		this.twTwdMessService = twTwdMessService;
	}

	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	//  此方法好想没用上，需检查
	public String getTwTwdMessFile(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date date = null;
		try {
			date = sdf.parse(datestring);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
		String fname = twTwdMessService.getOutStreamOfTiWenDan(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), (short)0, date);
		try {
			inputStream = new ByteArrayInputStream(fname.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return "ajax_file";
	}
/*
 * 判断是否有生成的体温单，没有就插入数据生成
 */
	
	public String checkTiWenDanShengCheng() throws IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date date = null;
		if(datestring.equals("") || datestring == null){
			inputStream = new ByteArrayInputStream("nodate".getBytes("UTF-8"));
			return "ajax_filename";
		}
		try {
			date = sdf.parse(datestring);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			String checkflag = twTwdMessService.createTiWenDanTuPian(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, date);
			if(checkflag.equals("1")){
				System.out.println("体温单insert success!");
				inputStream = new ByteArrayInputStream("insertsuccess".getBytes("UTF-8"));
				return "ajax_filename";
			}else{
				inputStream = new ByteArrayInputStream("insertfail".getBytes("UTF-8"));
				return "ajax_filename";
			}
		}else{
			inputStream = new ByteArrayInputStream("insertfail".getBytes("UTF-8"));
			return "ajax_filename";
		}
	}
/*
 * 查出显示
 */
	public String getTiWenDantupian() throws IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date date = null;
		if(datestring.equals("") || datestring == null){
			inputStream = new ByteArrayInputStream("nodate".getBytes("UTF-8"));
			return "ajax_filename";
		}
		try {
			date = sdf.parse(datestring);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			for(int i=0;i<5;i++){
				String fname = twTwdMessService.getOutStreamOfTiWenDan(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, date);
				if(fname!=null){
					inputStream = new ByteArrayInputStream(fname.getBytes("UTF-8"));
					return "ajax_filename";
				}else{
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			inputStream = new ByteArrayInputStream("fail".getBytes("UTF-8"));
			return "ajax_filename";
		}else{
			inputStream = new ByteArrayInputStream("fail".getBytes("UTF-8"));
			return "ajax_filename";
		}
	}
	
	/*
	 * 获取病人体温单时间段
	 */
	public String getTiWenDanShiJianDuan() throws ParseException{
		Object obj = session.get("bingrgetixingxi");
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			String sdate1 = vwBqbrZy.getRyrq();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			Date v_date1 = sdf.parse(sdate1); 
			List<TiWenDanRiQiDuan> tiWenDanRiQiDuans = twTwdMessService.getListRqBingRenTiWenJiLu(v_date1);
			if(tiWenDanRiQiDuans.size()>0 && tiWenDanRiQiDuans!=null){
				request.put("BingrenTiWenJiLu_shijianduan", tiWenDanRiQiDuans);
				request.put("action_name", "bingrgeti_TiWenDan");
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
