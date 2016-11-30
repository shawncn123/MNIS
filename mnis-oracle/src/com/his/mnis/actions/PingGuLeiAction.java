package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.HulijlLeiOutput;
import com.his.mnis.entities.HulijlLeiOutputForUpdate;
import com.his.mnis.entities.TwHulijlbiaoZd;
import com.his.mnis.entities.TwHulijlbiaoZd1;
import com.his.mnis.entities.TwHulipingguPingguJilu;
import com.his.mnis.entities.TwZyhzpg;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.TwHulijlbiaoZd1Service;
import com.his.mnis.services.TwHulijlbiaoZdService;
import com.opensymphony.xwork2.ActionSupport;

public class PingGuLeiAction extends ActionSupport implements RequestAware,
		SessionAware {
	
	private TwHulijlbiaoZdService twHulijlbiaoZdService;
	private TwHulijlbiaoZd1Service twHulijlbiaoZd1Service;
	private String[] xmid;
	private String[] neirong1;
	private String[] neirong2;
	private String[] neirong3;
	private String[] neirong4;
	private String[] neirong5;
	private Long[] rowkey;

	public Long[] getRowkey() {
		return rowkey;
	}

	public void setRowkey(Long[] rowkey) {
		this.rowkey = rowkey;
	}

	private String pgrq;
	
	public String getPgrq() {
		return pgrq;
	}

	public void setPgrq(String pgrq) {
		this.pgrq = pgrq;
	}

	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	private OracleSequenceMaxValueIncrementer wseq_id;
	
	public OracleSequenceMaxValueIncrementer getWseq_id() {
		return wseq_id;
	}

	public void setWseq_id(OracleSequenceMaxValueIncrementer wseq_id) {
		this.wseq_id = wseq_id;
	}

	public String[] getXmid() {
		return xmid;
	}

	public void setXmid(String[] xmid) {
		this.xmid = xmid;
	}

	public String[] getNeirong1() {
		return neirong1;
	}

	public void setNeirong1(String[] neirong1) {
		this.neirong1 = neirong1;
	}

	public String[] getNeirong2() {
		return neirong2;
	}

	public void setNeirong2(String[] neirong2) {
		this.neirong2 = neirong2;
	}

	public String[] getNeirong3() {
		return neirong3;
	}

	public void setNeirong3(String[] neirong3) {
		this.neirong3 = neirong3;
	}

	public String[] getNeirong4() {
		return neirong4;
	}

	public void setNeirong4(String[] neirong4) {
		this.neirong4 = neirong4;
	}

	public String[] getNeirong5() {
		return neirong5;
	}

	public void setNeirong5(String[] neirong5) {
		this.neirong5 = neirong5;
	}

	private int bbfl;
	
	public int getBbfl() {
		return bbfl;
	}

	public void setBbfl(int bbfl) {
		this.bbfl = bbfl;
	}

	public TwHulijlbiaoZdService getTwHulijlbiaoZdService() {
		return twHulijlbiaoZdService;
	}

	public void setTwHulijlbiaoZdService(TwHulijlbiaoZdService twHulijlbiaoZdService) {
		this.twHulijlbiaoZdService = twHulijlbiaoZdService;
	}

	public TwHulijlbiaoZd1Service getTwHulijlbiaoZd1Service() {
		return twHulijlbiaoZd1Service;
	}

	public void setTwHulijlbiaoZd1Service(
			TwHulijlbiaoZd1Service twHulijlbiaoZd1Service) {
		this.twHulijlbiaoZd1Service = twHulijlbiaoZd1Service;
	}

	public String getTwHulijlbiaoZd(){
		
		Date vpgrq = new Date();
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			Object obj1 = twHulijlbiaoZdService.getListTwHulijlbiaoZd(bbfl);
			Object obj2 = twHulijlbiaoZd1Service.getListTwHulijlbiaoZd1(bbfl);
			Object obj3 = twHulijlbiaoZdService.getListPingguJilu(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, vpgrq, bbfl);
			if(obj1!=null){
				List<TwHulijlbiaoZd> twHulijlbiaoZds = (List<TwHulijlbiaoZd>) obj1;
				List<TwHulijlbiaoZd1> twHulijlbiaoZd1s = new ArrayList<>();
				if(obj2!=null){
					twHulijlbiaoZd1s = (List<TwHulijlbiaoZd1>) obj2;
				}
				List<HulijlLeiOutput> hulijlLeiOutputs = twHulijlbiaoZdService.rebuildHuliLeiOutput(twHulijlbiaoZds, twHulijlbiaoZd1s);
				if(obj3!=null){
					List<TwHulipingguPingguJilu> twHulipingguPingguJilus = (List<TwHulipingguPingguJilu>) obj3;
					if(twHulipingguPingguJilus.size() > 0){
						List<HulijlLeiOutputForUpdate> hulijlLeiOutputForUpdates = twHulijlbiaoZdService.rebuildHulijlLeiOutputForUpdate(hulijlLeiOutputs, twHulipingguPingguJilus);
						request.put("hulipinggu_data", hulijlLeiOutputForUpdates);
					}else{
						request.put("hulipinggu_data", hulijlLeiOutputs);
					}
				}else{
					request.put("hulipinggu_data", hulijlLeiOutputs);
				}
			}
		}
		return SUCCESS;
	}
	
	public String saveTHuLiPingGu_JiLu(){
//		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
//		Date vpgrq = new Date();
//		try {
//			vpgrq = sdf.parse(pgrq);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			List<TwHulipingguPingguJilu> twHulipingguPingguJilus = new ArrayList<>();
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			for(int i=0;i < xmid.length;i++){
				TwHulipingguPingguJilu  twHulipingguPingguJilu = new TwHulipingguPingguJilu();
				Long v_rowkey = this.wseq_id.nextLongValue();
				twHulipingguPingguJilu.setBbfl(new BigDecimal(bbfl));
				twHulipingguPingguJilu.setJlrq(new Timestamp(System.currentTimeMillis()));
				twHulipingguPingguJilu.setKey1(vwBqbrZy.getKey1());
				twHulipingguPingguJilu.setKey2(vwBqbrZy.getKey2());
				twHulipingguPingguJilu.setPgrq(Timestamp.valueOf(pgrq+" 00:00:00"));
				twHulipingguPingguJilu.setRowkey(v_rowkey);
				twHulipingguPingguJilu.setXmid(xmid[i]);
				twHulipingguPingguJilu.setYebh(yeid);
				twHulipingguPingguJilu.setZddada1(neirong1[i]);
				twHulipingguPingguJilu.setZddada2(neirong2[i]);
				twHulipingguPingguJilu.setZddada3(neirong3[i]);
				twHulipingguPingguJilu.setZddada4(neirong4[i]);
				twHulipingguPingguJilu.setZddada5(neirong5[i]);
				twHulipingguPingguJilu.setZxhsid(vwRybq.getRyid());
				
//				pgrq_tv = Timestamp.valueOf(pgrqv+" 00:00:00");
//				twZyhzpg.setPgrq(pgrq_tv);
				twHulipingguPingguJilus.add(twHulipingguPingguJilu);
			}
			int vsaverow = twHulijlbiaoZdService.saveHuLiPingGu_JiLu_List(twHulipingguPingguJilus);
			if(vsaverow==1){
				try {
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else{
				try {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}else{
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return "ajax-success";
	}

	public String updateTHuLiPingGu_JiLu(){
		Date rq = new Date();     
		Timestamp pgrq_tv = new Timestamp(rq.getTime());
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			List<TwHulipingguPingguJilu> twHulipingguPingguJilus = new ArrayList<>();
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			for(int i=0;i < xmid.length;i++){
				TwHulipingguPingguJilu  twHulipingguPingguJilu = new TwHulipingguPingguJilu();
//				twHulipingguPingguJilu.setBbfl(new BigDecimal(bbfl));
				twHulipingguPingguJilu.setJlrq(new Timestamp(System.currentTimeMillis()));
//				twHulipingguPingguJilu.setKey1(vwBqbrZy.getKey1());
//				twHulipingguPingguJilu.setKey2(vwBqbrZy.getKey2());
//				twHulipingguPingguJilu.setPgrq(new Timestamp(System.currentTimeMillis()));
				twHulipingguPingguJilu.setRowkey(rowkey[i]);
//				twHulipingguPingguJilu.setXmid(xmid[i]);
//				twHulipingguPingguJilu.setYebh(yeid);
				twHulipingguPingguJilu.setZddada1(neirong1[i]);
				twHulipingguPingguJilu.setZddada2(neirong2[i]);
				twHulipingguPingguJilu.setZddada3(neirong3[i]);
				twHulipingguPingguJilu.setZddada4(neirong4[i]);
				twHulipingguPingguJilu.setZddada5(neirong5[i]);
				twHulipingguPingguJilu.setZxhsid(vwRybq.getRyid());
				
//				pgrq_tv = Timestamp.valueOf(pgrqv+" 00:00:00");
//				twZyhzpg.setPgrq(pgrq_tv);
				twHulipingguPingguJilus.add(twHulipingguPingguJilu);
			}
			int vsaverow = twHulijlbiaoZdService.updateHuLiPingGu_JiLu_List(twHulipingguPingguJilus);
			if(vsaverow==1){
				try {
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else{
				try {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}else{
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return "ajax-success";
	}
	
	public String getListHulijlLeiOutputForUpdate(){
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		Date vpgrq = new Date();
		try {
			vpgrq = sdf.parse(pgrq);
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
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			Object obj1 = twHulijlbiaoZdService.getListTwHulijlbiaoZd(bbfl);
			Object obj2 = twHulijlbiaoZd1Service.getListTwHulijlbiaoZd1(bbfl);
			if(obj1!=null){
				List<TwHulijlbiaoZd> twHulijlbiaoZds = (List<TwHulijlbiaoZd>) obj1;
				List<TwHulijlbiaoZd1> twHulijlbiaoZd1s = new ArrayList<>();
				if(obj2!=null){
					twHulijlbiaoZd1s = (List<TwHulijlbiaoZd1>) obj2;
				}
				List<HulijlLeiOutput> hulijlLeiOutputs = twHulijlbiaoZdService.rebuildHuliLeiOutput(twHulijlbiaoZds, twHulijlbiaoZd1s);
				JSONArray jsonArray = JSONArray.fromObject(hulijlLeiOutputs);
				Object obj3 = twHulijlbiaoZdService.getListPingguJilu(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, vpgrq, bbfl);
				if(obj3 != null){
					List<TwHulipingguPingguJilu> twHulipingguPingguJilus =  (List<TwHulipingguPingguJilu>) obj3;
					if(twHulipingguPingguJilus.size() > 0){
						List<HulijlLeiOutputForUpdate> hulijlLeiOutputForUpdates = twHulijlbiaoZdService.rebuildHulijlLeiOutputForUpdate(hulijlLeiOutputs, twHulipingguPingguJilus);
						jsonArray = JSONArray.fromObject(hulijlLeiOutputForUpdates);
					}
				}
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
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
