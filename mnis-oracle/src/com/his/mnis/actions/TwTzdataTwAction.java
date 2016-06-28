package com.his.mnis.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

import com.his.mnis.entities.TwTzdataTw;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.TwTzdataTwService;
import com.opensymphony.xwork2.ActionSupport;

public class TwTzdataTwAction extends ActionSupport implements SessionAware,
		RequestAware {

	private String v_twlx;
	private Double v_wendu;
	private Double v_jwhwendu;
	private Short v_maibo;
	private Short v_xinlv;
	private Short v_huxi;
	private String v_rcbz; 
	private String v_time2;
	private String v_time1;
	
	private OracleSequenceMaxValueIncrementer seqGenerator;
	
	public OracleSequenceMaxValueIncrementer getSeqGenerator() {
		return seqGenerator;
	}

	public void setSeqGenerator(OracleSequenceMaxValueIncrementer seqGenerator) {
		this.seqGenerator = seqGenerator;
	}

	private TwTzdataTwService twTzdataTwService;
//    private TwTzdataTw twTzdataTw; 
    
//	public TwTzdataTw getTwTzdataTw() {
//		return twTzdataTw;
//	}
//
//	public void setTwTzdataTw(TwTzdataTw twTzdataTw) {
//		this.twTzdataTw = twTzdataTw;
//	}

	public TwTzdataTwService getTwTzdataTwService() {
		return twTzdataTwService;
	}

	public void setTwTzdataTwService(TwTzdataTwService twTzdataTwService) {
		this.twTzdataTwService = twTzdataTwService;
	}

	public String getV_time1() {
		return v_time1;
	}

	public void setV_time1(String v_time1) {
		this.v_time1 = v_time1;
	}

	public String getV_twlx() {
		return v_twlx;
	}

	public void setV_twlx(String v_twlx) {
		this.v_twlx = v_twlx;
	}

	public Double getV_wendu() {
		return v_wendu;
	}

	public void setV_wendu(Double v_wendu) {
		this.v_wendu = v_wendu;
	}

	public Double getV_jwhwendu() {
		return v_jwhwendu;
	}

	public void setV_jwhwendu(Double v_jwhwendu) {
		this.v_jwhwendu = v_jwhwendu;
	}

	public Short getV_maibo() {
		return v_maibo;
	}

	public void setV_maibo(Short v_maibo) {
		this.v_maibo = v_maibo;
	}

	public Short getV_xinlv() {
		return v_xinlv;
	}

	public void setV_xinlv(Short v_xinlv) {
		this.v_xinlv = v_xinlv;
	}

	public Short getV_huxi() {
		return v_huxi;
	}

	public void setV_huxi(Short v_huxi) {
		this.v_huxi = v_huxi;
	}

	public String getV_rcbz() {
		return v_rcbz;
	}

	public void setV_rcbz(String v_rcbz) {
		this.v_rcbz = v_rcbz;
	}

	public String getV_time2() {
		return v_time2;
	}

	public void setV_time2(String v_time2) {
		this.v_time2 = v_time2;
	}

	private Map<String,Object> session;
	private Map<String,Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

		this.session = arg0;
		
	}
	
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public String saveTiZhengLuru_TiWen(){
		
		Long v_jlid =  this.seqGenerator.nextLongValue();
		
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
//		System.out.println(vwRybq.getId());
		VwBqbrZy vwBqbrZy = (VwBqbrZy) session.get("bingrgetixingxi");
		
		TwTzdataTw twTzdataTw = new TwTzdataTw();
		twTzdataTw.setJlid(v_jlid);
		twTzdataTw.setCzyid(vwRybq.getRyid());
		twTzdataTw.setCzyxm(vwRybq.getRyxm());
		twTzdataTw.setKey1(vwBqbrZy.getKey1());
		twTzdataTw.setKey2(vwBqbrZy.getKey2());
		twTzdataTw.setYebh(0);
		twTzdataTw.setRq(new Date());
		twTzdataTw.setSj(v_time1);
		twTzdataTw.setTwTw(v_wendu);
		twTzdataTw.setTwTwJwh(v_jwhwendu);
		twTzdataTw.setTwXl(v_xinlv);
		twTzdataTw.setTwLx(v_twlx);
		twTzdataTw.setTwHx(v_huxi);
		twTzdataTw.setTwMb(v_maibo);
		twTzdataTw.setTwRcbz(v_rcbz);
		twTzdataTw.setTwRcsj(v_time2);
		twTzdataTw.setStime(new Timestamp(System.currentTimeMillis()));
		
		try {
			String proc_result = twTzdataTwService.doCreateTwTzdataTw(twTzdataTw, v_jlid);
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
}
