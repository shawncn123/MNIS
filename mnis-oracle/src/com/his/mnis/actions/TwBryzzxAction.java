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

import com.his.mnis.entities.BingRenSessionXingXi;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxPeiYeRemodel;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.TwPeiyeczJilu;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.entities.Zd001;
import com.his.mnis.services.TwBryzzxService;
import com.his.mnis.services.YiZhuWeiZhiXingService;
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
	private String vrq;
	private String vxzzxfl;
	private String vcrlflag;
	private Double vcrl;
	private char vzxflag;
	private String vxzrq;
	private String rowkey;
	private String peiye_qdflag;
	private String syflag;
	
	public String getSyflag() {
		return syflag;
	}

	public void setSyflag(String syflag) {
		this.syflag = syflag;
	}

	public String getPeiye_qdflag() {
		return peiye_qdflag;
	}

	public void setPeiye_qdflag(String peiye_qdflag) {
		this.peiye_qdflag = peiye_qdflag;
	}

	public String getRowkey() {
		return rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public String getVxzrq() {
		return vxzrq;
	}

	public void setVxzrq(String vxzrq) {
		this.vxzrq = vxzrq;
	}

	public char getVzxflag() {
		return vzxflag;
	}

	public void setVzxflag(char vzxflag) {
		this.vzxflag = vzxflag;
	}

	public String getVcrlflag() {
		return vcrlflag;
	}

	public void setVcrlflag(String vcrlflag) {
		this.vcrlflag = vcrlflag;
	}

	public Double getVcrl() {
		return vcrl;
	}

	public void setVcrl(Double vcrl) {
		this.vcrl = vcrl;
	}

	public String getVxzzxfl() {
		return vxzzxfl;
	}

	public void setVxzzxfl(String vxzzxfl) {
		this.vxzzxfl = vxzzxfl;
	}

	public String getVrq() {
		return vrq;
	}

	public void setVrq(String vrq) {
		this.vrq = vrq;
	}

	private TwBryzzxService twBryzzxService;
	private YiZhuWeiZhiXingService yiZhuWeiZhiXingService;

	public YiZhuWeiZhiXingService getYiZhuWeiZhiXingService() {
		return yiZhuWeiZhiXingService;
	}

	public void setYiZhuWeiZhiXingService(
			YiZhuWeiZhiXingService yiZhuWeiZhiXingService) {
		this.yiZhuWeiZhiXingService = yiZhuWeiZhiXingService;
	}

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
		
		Object object = yiZhuWeiZhiXingService.getListYiZhuZXFL();
		if(object!=null){
			List<Zd001> zd001s = (List<Zd001>) object;
			request.put("yizhuzxfl", zd001s);
		}else{
			return ERROR;
		}
		
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
				Date xzrq = new Date();
				List<TwBryzzx> twBryzzxs = twBryzzxService.getListBrYzzxByKey(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(),yeid,xzrq);
				List<TwBryzzxRemodel> twBryzzxRemodels = twBryzzxService.getListBrYzzxRemodel(twBryzzxs);
				if(twBryzzxs == null){
					return ERROR;
				}else{
					request.put("bingrGeTi_YiZhu_zhixing", twBryzzxRemodels);
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
	 * 根据病人key1,key2值,医嘱执行分类查询病人医嘱执行数据
	 */
	public String getListBryzzxByKeyZxfl(){
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
				SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
				Date xzrq = sdf.parse(vxzrq);
				List<TwBryzzx> twBryzzxs = twBryzzxService.getListBrYzzxByKeyZxfl(vwBqbrZy.getKey1(), vwBqbrZy.getKey2(),yeid, vxzzxfl,xzrq);
				if(twBryzzxs!=null && twBryzzxs.size()>0){
					List<TwBryzzxRemodel> twBryzzxRemodels = twBryzzxService.getListBrYzzxRemodel(twBryzzxs);
					JSONArray jsonArray = JSONArray.fromObject(twBryzzxRemodels);
					// JSONObject json = JSONObject.fromObject(vwBqbrZys);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("text/html;charset=UTF-8");
					try {
						response.getWriter().write(jsonArray.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return null;
	}

	/*
	 * 传入参数，执行procedure 保存医嘱执行数据
	 * Date rq, String sjd, long groupxh,
			String hsid, String hsxm, Date zxsj, String zxms
	 */
	public String bingRenYzzx_baocun(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date zxsj = new Date();
		Date rq = new Date();
		try {
			rq = sdf.parse(vrq);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
			hsid = vwRybq.getRyid();
			hsxm = vwRybq.getRyxm();
			if(syflag=="" || syflag==null){
				syflag="0";
			}
			String proc_result = twBryzzxService.bingRenYzzx_baocun(rq, vsjd,vzxflag, groupxh, hsid, hsxm, zxsj, zxms,vcrlflag,vcrl,syflag);
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
	
	/*
	 * 根据病区和日期查询输液类医嘱数据列表
	 */
	public String getListBrYzzxForPeiYe(){
		
		Object obj = session.get("caozuoyuan");
		if(obj != null){
			VwRybq vwRybq = (VwRybq) obj;
			Date xzrq = new Date();
			
//			String vxzrq = "2016-11-23";
//			SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
//			 try {
//				xzrq = sdf.parse(vxzrq);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
			
			String vbq = vwRybq.getBq();
			List<TwBryzzxPeiYeRemodel> twBryzzxPeiYeRemodels = twBryzzxService.getListBrYzzxForShuYeByBqidRiqi(vbq, xzrq);
			if(twBryzzxPeiYeRemodels == null){
				return ERROR;
			}else{
				request.put("shuye_yizhu_data", twBryzzxPeiYeRemodels);
				request.put("action_name", "peiye_saomiao");
				return SUCCESS;
			}
		}else{
			return ERROR;
		}
		
	}
	
	/*
	 * 配液确认  按rowkey
	 */
	public String peiye_querenorquxiao(){
		
		Object obj =  session.get("caozuoyuan");
		if(obj!=null){
			VwRybq vwRybq = (VwRybq) obj;
			rowkey = rowkey.replace("q", ":");
			TwBryzzx twBryzzx = twBryzzxService.getTwBryzzxByRowkey(rowkey);
			TwPeiyeczJilu twPeiyeczJilu = new TwPeiyeczJilu();
			twPeiyeczJilu.setBq(twBryzzx.getBq());
			twPeiyeczJilu.setChw(twBryzzx.getChw());
			twPeiyeczJilu.setGroupxh(twBryzzx.getGroupxh());
			twPeiyeczJilu.setKey1(twBryzzx.getKey1());
			twPeiyeczJilu.setKey2(twBryzzx.getKey2());
			twPeiyeczJilu.setPeiyhsid(vwRybq.getRyid());
			twPeiyeczJilu.setPeiyhsxm(vwRybq.getRyxm());
			twPeiyeczJilu.setPeiytime(new Timestamp(System.currentTimeMillis()));
			twPeiyeczJilu.setQdflag(peiye_qdflag);
			twPeiyeczJilu.setRowkey(rowkey);
			twPeiyeczJilu.setRq(twBryzzx.getRq());
			twPeiyeczJilu.setSjd(twBryzzx.getSjd());
			twPeiyeczJilu.setSjdtime(twBryzzx.getSjdtime());
			twPeiyeczJilu.setYebh(twBryzzx.getYebh());
			twPeiyeczJilu.setYzid(twBryzzx.getYzid());
			twPeiyeczJilu.setYzmc(twBryzzx.getYzmc());
			twPeiyeczJilu.setYzzdmc(twBryzzx.getYzzdmc());
			try {
				twBryzzxService.updateTwPeiyeczJiluByTwPeiyeczJilu(twPeiyeczJilu);
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));    //1 表示失败
			} catch (Exception e) {
				e.printStackTrace();
				try {
					inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
			}
		}
		return "ajax_return";
	}
	
	/*
	 * 根据病区和日期查询输液类医嘱数据列表 for jQuery
	 */
	public String getListBrYzzxForPeiYeforjQuery() throws ParseException{
		
		Object obj = session.get("caozuoyuan");
		if(obj != null){
			SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
			Date xzrq = sdf.parse(vxzrq);
			VwRybq vwRybq = (VwRybq) obj;
			String vbq = vwRybq.getBq();
			List<TwBryzzxPeiYeRemodel> twBryzzxPeiYeRemodels = twBryzzxService.getListBrYzzxForShuYeByBqidRiqi(vbq, xzrq);
			if(twBryzzxPeiYeRemodels!=null && twBryzzxPeiYeRemodels.size()>0){
				JSONArray jsonArray = JSONArray.fromObject(twBryzzxPeiYeRemodels);
				// JSONObject json = JSONObject.fromObject(vwBqbrZys);
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
