package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
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
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.TwWxysPgDm;
import com.his.mnis.entities.TwZyhzPgXX;
import com.his.mnis.entities.TwZyhzpg;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.TwWxysPgService;
import com.opensymphony.xwork2.ActionSupport;

public class TwWxysPgAction extends ActionSupport implements RequestAware,SessionAware {

	private TwWxysPgService twWxysPgService;
	private String[] pgid;
	private String[] quedflag;
	private String pgrqv; 
	private String modflag;
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getModflag() {
		return modflag;
	}

	public void setModflag(String modflag) {
		this.modflag = modflag;
	}

	private OracleSequenceMaxValueIncrementer wseq_id;
	
	public OracleSequenceMaxValueIncrementer getWseq_id() {
		return wseq_id;
	}

	public void setWseq_id(OracleSequenceMaxValueIncrementer wseq_id) {
		this.wseq_id = wseq_id;
	}

	public String getPgrqv() {
		return pgrqv;
	}

	public void setPgrqv(String pgrqv) {
		this.pgrqv = pgrqv;
	}

	public String[] getPgid() {
		return pgid;
	}

	public void setPgid(String[] pgid) {
		this.pgid = pgid;
	}

	public String[] getQuedflag() {
		return quedflag;
	}

	public void setQuedflag(String[] quedflag) {
		this.quedflag = quedflag;
	}

	public TwWxysPgService getTwWxysPgService() {
		return twWxysPgService;
	}

	public void setTwWxysPgService(TwWxysPgService twWxysPgService) {
		this.twWxysPgService = twWxysPgService;
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
	
	public String getListWxysPg(){
//		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
		
		Date rq = new Date();     
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
		
			List<TwZyhzPgXX> twZyhzPgXXs = twWxysPgService.getListTwZyhzPgXX(rq,vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid);
			if(twZyhzPgXXs != null && twZyhzPgXXs.size()!=0 ){
				request.put("wxyspgb", twZyhzPgXXs);
				request.put("wxyspgbflag", "1");
				return SUCCESS;
			}else{
				Object objdm = twWxysPgService.getListWxysPgDm();
				if(objdm != null){
					List<TwWxysPgDm> twWxysPgDms = (List<TwWxysPgDm>) objdm; 
					request.put("wxyspgb", twWxysPgDms);
					request.put("wxyspgbflag", "0");
					return SUCCESS;
				}else{
					return ERROR;
				}
			}
		}
		return ERROR;
	}
	
	public String WyxsPingGuBiaoBaoCun(){
		
		Date rq = new Date();     
		Timestamp pgrq_tv = new Timestamp(rq.getTime());
//		try {
//			rq = sdf.parse(pgrqv);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
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
			TwZyhzpg  twZyhzpg = new TwZyhzpg();
			for(int i=0;i < pgid.length;i++){
				if(modflag.equals("1")){
					twZyhzpg.setRowkey(1);
				}else{
					Integer v_rowkey =  (int) this.wseq_id.nextLongValue();
					twZyhzpg.setRowkey(v_rowkey);
				}
				twZyhzpg.setJlrq(new Timestamp(System.currentTimeMillis()));
				twZyhzpg.setKey1(vwBqbrZy.getKey1());
				twZyhzpg.setKey2(vwBqbrZy.getKey2());
				twZyhzpg.setYebh(yeid);
				twZyhzpg.setPgdm(pgid[i]);
				twZyhzpg.setQdflag(quedflag[i]);
				twZyhzpg.setZxhsid(vwRybq.getRyid());
				pgrq_tv = Timestamp.valueOf(pgrqv+" 00:00:00");
				twZyhzpg.setPgrq(pgrq_tv);
				twWxysPgService.updateTwWxysPg(twZyhzpg,modflag);
			}
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "ajax-error";
			}
			return "ajax-success";
		}else{
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "ajax-error";
		}
	}
	
	/*
	 * 根据选择的日期，查询评估数据或评估元数据 for jQuery
	 */
	public String getListWxysPgforjQuery() {
		
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
		Date rq = new Date();  
		try {
			rq = sdf.parse(pgrqv);
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
			List<TwZyhzPgXX> twZyhzPgXXs = twWxysPgService.getListTwZyhzPgXX(rq,vwBqbrZy.getKey1(),vwBqbrZy.getKey2(),yeid);
			if(twZyhzPgXXs != null && twZyhzPgXXs.size()>0 ){
				JSONArray jsonArray = JSONArray.fromObject(twZyhzPgXXs);
				// JSONObject json = JSONObject.fromObject(vwBqbrZys);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8");
				try {
					response.getWriter().write(jsonArray.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
	//			request.put("wxyspgbflag", "1");
			}else{
				Object objdm = twWxysPgService.getListWxysPgDm();
				if(objdm != null){
					List<TwWxysPgDm> twWxysPgDms = (List<TwWxysPgDm>) objdm; 
					JSONArray jsonArray = JSONArray.fromObject(twWxysPgDms);
					// JSONObject json = JSONObject.fromObject(vwBqbrZys);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("text/html;charset=UTF-8");
					try {
						response.getWriter().write(jsonArray.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
	//				request.put("wxyspgbflag", "0");
				}
			}
		}
		return null;
	}
}
	
