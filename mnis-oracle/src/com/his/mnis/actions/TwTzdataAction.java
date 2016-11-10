package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.TwTzdata;
import com.his.mnis.entities.TwTzdataTw;
import com.his.mnis.entities.TwTzdata_update;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.TwTzdataService;
import com.his.mnis.services.TwTzdataTwService;
import com.opensymphony.xwork2.ActionSupport;

public class TwTzdataAction extends ActionSupport implements RequestAware,SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TwTzdataService twTzdataService;
	private TwTzdataTwService twTzdataTwService;
	public TwTzdataTwService getTwTzdataTwService() {
		return twTzdataTwService;
	}

	public void setTwTzdataTwService(TwTzdataTwService twTzdataTwService) {
		this.twTzdataTwService = twTzdataTwService;
	}

	private String cxRiqi;

	public String getCxRiqi() {
		return cxRiqi;
	}

	public void setCxRiqi(String cxRiqi) {
		this.cxRiqi = cxRiqi;
	}

	public TwTzdataService getTwTzdataService() {
		return twTzdataService;
	}

	public void setTwTzdataService(TwTzdataService twTzdataService) {
		this.twTzdataService = twTzdataService;
	}

	private List<String> xiangmu = new ArrayList<String>();
	private List<String> zhi1 = new ArrayList<String>();
	private List<String> zhi2 = new ArrayList<String>();
	private List<String> biaozhu = new ArrayList<String>();
	private List<String> bzflag = new ArrayList<String>();
	private List<Long> jlid = new ArrayList<Long>();
	public List<Long> getJlid() {
		return jlid;
	}

	public void setJlid(List<Long> jlid) {
		this.jlid = jlid;
	}

	private String appTime;
	private Long pcid;
	public Long getPcid() {
		return pcid;
	}

	public void setPcid(Long pcid) {
		this.pcid = pcid;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	private String res_val;  //返回数据保存结果
	
	public String getRes_val() {
		return res_val;
	}

	public void setRes_val(String res_val) {
		this.res_val = res_val;
	}

	public String getAppTime() {
		return appTime;
	}

	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	public List<String> getZhi1() {
		return zhi1;
	}

	public void setZhi1(List<String> zhi1) {
		this.zhi1 = zhi1;
	}

	public List<String> getZhi2() {
		return zhi2;
	}

	public void setZhi2(List<String> zhi2) {
		this.zhi2 = zhi2;
	}

	public List<String> getBiaozhu() {
		return biaozhu;
	}

	public void setBiaozhu(List<String> biaozhu) {
		this.biaozhu = biaozhu;
	}

	public List<String> getBzflag() {
		return bzflag;
	}

	public void setBzflag(List<String> bzflag) {
		this.bzflag = bzflag;
	}

	private TwTzdata twTzdata;
	
	private List<TwTzdata> twTzdatas;
	
	public TwTzdata getTwTzdata() {
		return twTzdata;
	}

	public void setTwTzdata(TwTzdata twTzdata) {
		this.twTzdata = twTzdata;
	}

	public List<TwTzdata> getTwTzdatas() {
		return twTzdatas;
	}

	public void setTwTzdatas(List<TwTzdata> twTzdatas) {
		this.twTzdatas = twTzdatas;
	}

	public List<String> getXiangmu() {
		return xiangmu;
	}

	public void setXiangmu(List<String> xiangmu) {
		this.xiangmu = xiangmu;
	}
	
	private OracleSequenceMaxValueIncrementer wseq_id;
	private OracleSequenceMaxValueIncrementer seqDispGenerator;
    
    /**
     * @return the seqGenerator
     */
	
    public OracleSequenceMaxValueIncrementer getSeqDispGenerator() {
		return seqDispGenerator;
	}

	public OracleSequenceMaxValueIncrementer getWseq_id() {
		return wseq_id;
	}

	public void setWseq_id(OracleSequenceMaxValueIncrementer wseq_id) {
		this.wseq_id = wseq_id;
	}

	public void setSeqDispGenerator(OracleSequenceMaxValueIncrementer seqDispGenerator) {
		this.seqDispGenerator = seqDispGenerator;
	}
	
	public String saveTiZhengLuru(){
		try {
			Long v_pcid =  this.wseq_id.nextLongValue();
			
			Object obj = session.get("bingrgetixingxi");
			short yeid = 0;
			if(obj != null){
				VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
				VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
				Object obj_ye =  session.get("bingrgetixingxi_yinger");
				if(obj_ye!=null){
					BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
					yeid = bingRenSessionXingXi.getYebh();
				}
			    List<TwTzdata> twTzdatas = new ArrayList<TwTzdata>();
				for (int i=0;i<xiangmu.size();i++) {
					Long v_jlid =  this.wseq_id.nextLongValue();
					String v_xmid = xiangmu.get(i);
					String v_zhi1 = zhi1.get(i);
					String v_zhi2 = "";
					String v_biaozhu = "";
					if(xiangmu.get(i).equals("XY")){
						v_zhi2 = zhi2.get(i);
					}
					if(bzflag.get(i).equals("1")){
						System.out.println("bz:" + biaozhu.get(i));
						v_biaozhu = biaozhu.get(i);
					}
//					if(!xiangmu.get(i).equals("TW") && v_zhi1 != null && !v_zhi1.equals("")){  下面的修改，按冗余来解决，便于修改，没有输入也有记录
					
					if(!xiangmu.get(i).equals("TW")){
						if(v_zhi1==null){
							v_zhi1="";
						}
						TwTzdata twTzdata = new TwTzdata();
						twTzdata.setJlid(v_jlid);
						twTzdata.setCzyid(vwRybq.getRyid());
						twTzdata.setCzyxm(vwRybq.getRyxm());
						twTzdata.setKey1(vwBqbrZy.getKey1());
						twTzdata.setKey2(vwBqbrZy.getKey2());
						twTzdata.setYebh(yeid);
						twTzdata.setRq(new Date());
						twTzdata.setSj(appTime);
						twTzdata.setXmid(v_xmid);
						twTzdata.setValue1(v_zhi1);	
						twTzdata.setValue2(v_zhi2);
						twTzdata.setBz(v_biaozhu);
						twTzdata.setPcid(v_pcid);
						twTzdata.setStime(new Timestamp(System.currentTimeMillis()));
						twTzdatas.add(twTzdata);
					}
				}
				res_val = twTzdataService.doCreateTwTzdata(twTzdatas, v_pcid);
				request.put("twtzdata_result", res_val);
				if(res_val.equals("0")){
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
				else{
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				}
			}else{
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "luru_update";
	}
	
	//取体征录入和体温录入数据 用于修改
	
	public String getListTzData(){
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			Date lrrq = new Date();
			Object obj1 = twTzdataService.getListTzData(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, lrrq);
			Object obj2 = twTzdataTwService.getListTzDataTw(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, lrrq);
			
			if(obj1!=null || obj2!=null){
				if(obj1!=null){
					List<TwTzdata> twTzdatas = (List<TwTzdata>) obj1;
					request.put("tzdatalist", twTzdatas);
				}else{
					request.put("tzdatalist", '0');
				}
				if(obj2!=null){
					List<TwTzdataTw> twTzdataTws = (List<TwTzdataTw>) obj2;
					request.put("tzdatatwlist", twTzdataTws);
				}else{
					request.put("tzdatatwlist", '0');
				}
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}
	
	//取体征录入记录条数 用于显示
	public String getListTzDataJl(){
		Object obj = session.get("bingrgetixingxi");
		short yeid = 0;
		if(obj != null){
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
			Object obj_ye =  session.get("bingrgetixingxi_yinger");
			if(obj_ye!=null){
				BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
				yeid = bingRenSessionXingXi.getYebh();
			}
			Date lrrq = new Date();
			Object obj1 = twTzdataService.getListTzDataJl(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, lrrq);
			Object obj2 = twTzdataTwService.getListTzDataTWJl(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, lrrq);
			
			SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
			cxRiqi = sdf.format(lrrq);
			
			request.put("tzdata_lr_rq", cxRiqi);
			if(obj1!=null || obj2!=null){
				if(obj1!=null){
					List<String> twTzdataJls = (List<String>) obj1;
					request.put("tzdatajllist", twTzdataJls);
				}else{
					request.put("tzdatajllist", '0');
				}
				if(obj2!=null){
					List<TwTzdataTw> twTzdataTwJls = (List<TwTzdataTw>) obj2;
					request.put("tzdatatwjllist", twTzdataTwJls);
				}else{
					request.put("tzdatatwjllist", '0');
				}
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}
	
	//按选取日期、时间点记录查询取出数据 用于修改
	
		public String getListTzDataByShiJianDian(){
			Object obj = session.get("bingrgetixingxi");
			short yeid = 0;
			if(obj != null){
				VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
				VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
				Object obj_ye =  session.get("bingrgetixingxi_yinger");
				if(obj_ye!=null){
					BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
					yeid = bingRenSessionXingXi.getYebh();
				}
				SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
				Date lrrq = new Date();
				try {
					lrrq = sdf.parse(cxRiqi);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				List<TwTzdata_update> twTzdata_updates = twTzdataService.getListTzDataByShiJianDian(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, lrrq, appTime);
				if(twTzdata_updates!=null){
					request.put("tzdata_upate_list", twTzdata_updates);
					return SUCCESS;
				}else{
					return ERROR;
				}
			}else{
				return ERROR;
			}
		}
	
		//保存修改的体征数据
		public String updateTwTzdata() throws UnsupportedEncodingException{
			
			Object obj = session.get("caozuoyuan");
			if(obj != null){
				VwRybq vwRybq = (VwRybq) obj;
			    List<TwTzdata_update> twTzdata_updates = new ArrayList<TwTzdata_update>();
				for (int i=0;i<xiangmu.size();i++) {
					Long v_jlid =  jlid.get(i);
					String v_xmid = xiangmu.get(i);
					String v_zhi1 = zhi1.get(i);
					String v_zhi2 = zhi2.get(i);
					String v_biaozhu = biaozhu.get(i);
//					if(!xiangmu.get(i).equals("TW") && v_zhi1 != null && !v_zhi1.equals("")){  下面的修改，按冗余来解决，便于修改，没有输入也有记录
					if(v_zhi1==null){
						v_zhi1="";
					}
					TwTzdata_update twTzdata_update = new TwTzdata_update();
					twTzdata_update.setJlid(v_jlid);
					twTzdata_update.setSj(appTime);
					twTzdata_update.setXmid(v_xmid);
					twTzdata_update.setValue1(v_zhi1);	
					twTzdata_update.setValue2(v_zhi2);
					twTzdata_update.setBz(v_biaozhu);
					twTzdata_update.setPcid(pcid);
					twTzdata_update.setStime(new Timestamp(System.currentTimeMillis()));
					twTzdata_updates.add(twTzdata_update);
				}
				String res_modi_val = twTzdataService.updateTwTzdata(twTzdata_updates, vwRybq.getRyid(),vwRybq.getRyxm(),pcid) + "";
				request.put("twtzdata_result", res_modi_val);
				if(res_modi_val.equals("0")){
						inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
				else{
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				}
			}else{
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			}
			return "data_modi";
		}
	
		/*
		 * 取体征录入记录条数 用于显示 for jQuery
		 */
		public String getListTwTzdataByRiQiforjQuery() throws ParseException{
			
			Object obj = session.get("bingrgetixingxi");
			short yeid = 0;
			if(obj != null){
				VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
				VwBqbrZy vwBqbrZy = (VwBqbrZy) obj;
				Object obj_ye =  session.get("bingrgetixingxi_yinger");
				if(obj_ye!=null){
					BingRenSessionXingXi bingRenSessionXingXi = (BingRenSessionXingXi) obj_ye;
					yeid = bingRenSessionXingXi.getYebh();
				}
				SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
				Date lrrq = sdf.parse(cxRiqi);
				Object obj1 = twTzdataService.getListTzDataJl(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(), yeid, lrrq);
				if(obj1!=null){
					List<TwTzdata> twTzdatas = (List<TwTzdata>) obj1;
					JSONArray jsonArray = JSONArray.fromObject(twTzdatas);
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
