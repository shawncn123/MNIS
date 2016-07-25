package com.his.mnis.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.TwTzdata;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.TwTzdataService;
import com.opensymphony.xwork2.ActionSupport;

public class TwTzdataAction extends ActionSupport implements RequestAware,SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TwTzdataService twTzdataService;
	

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
	private String appTime;
	
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
					if(!xiangmu.get(i).equals("TW") && v_zhi1 != null && !v_zhi1.equals("")){
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
					request.put("tizheng_luru_success", "0");
					return SUCCESS;
				}
				else{
					request.put("tizheng_luru_success", "1");
					return ERROR;
				}
			}else{
				request.put("tizheng_luru_success", "1");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.put("tizheng_luru_success", "1");
			return ERROR;
		}
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
