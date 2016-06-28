package com.his.mnis.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.DaiXuanZheBingren;
import com.his.mnis.entities.MyBingRen;
import com.his.mnis.entities.TwWdbr;
import com.his.mnis.entities.TwWdbrId;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.TwWdbrService;
import com.his.mnis.services.VwBqbrZyService;
import com.his.mnis.services.VwRybqService;
import com.opensymphony.xwork2.ActionSupport;

public class TwWdbrAction extends ActionSupport implements RequestAware,
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String bqid;
	private VwRybqService vwRybqService;
	private List<MyBingRen> myBingRens; 
	private MyBingRen myBingRen; 
	private String[] chw;
	private String[] quedflag;
	private TwWdbrService twWdbrService;
	private String datasaveflag;
	private List<DaiXuanZheBingren> daixzbingrens;
	private VwBqbrZyService vwBqbrZyService;

	public VwBqbrZyService getVwBqbrZyService() {
		return vwBqbrZyService;
	}

	public void setVwBqbrZyService(VwBqbrZyService vwBqbrZyService) {
		this.vwBqbrZyService = vwBqbrZyService;
	}

	public List<DaiXuanZheBingren> getDaixzbingrens() {
		return daixzbingrens;
	}

	public void setDaixzbingrens(List<DaiXuanZheBingren> daixzbingrens) {
		this.daixzbingrens = daixzbingrens;
	}

	public String getDatasaveflag() {
		return datasaveflag;
	}

	public void setDatasaveflag(String datasaveflag) {
		this.datasaveflag = datasaveflag;
	}

	public String[] getChw() {
		return chw;
	}

	public void setChw(String[] chw) {
		this.chw = chw;
	}

	public String[] getQuedflag() {
		return quedflag;
	}

	public void setQuedflag(String[] quedflag) {
		this.quedflag = quedflag;
	}

	public MyBingRen getMyBingRen() {
		return myBingRen;
	}

	public void setMyBingRen(MyBingRen myBingRen) {
		this.myBingRen = myBingRen;
	}

	public List<MyBingRen> getMyBingRens() {
		return myBingRens;
	}

	public void setMyBingRens(List<MyBingRen> myBingRens) {
		this.myBingRens = myBingRens;
	}

	public VwRybqService getVwRybqService() {
		return vwRybqService;
	}

	public void setVwRybqService(VwRybqService vwRybqService) {
		this.vwRybqService = vwRybqService;
	}

	public String getBqid() {
		return bqid;
	}

	public void setBqid(String bqid) {
		this.bqid = bqid;
	}

	public TwWdbrService getTwWdbrService() {
		return twWdbrService;
	}

	public void setTwWdbrService(TwWdbrService twWdbrService) {
		this.twWdbrService = twWdbrService;
	}

	/*
	 * 通过护士id查我的病人
	 */
	public String getMyBingRenByCzryId() {

		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		List<VwRybq> vwRybqs = vwRybqService.listBingQuByCaozyId(vwRybq.getRyid());
		request.put("caozuoyuan_bingqu", vwRybqs);
		List<MyBingRen> myBingRens = twWdbrService.getWdbrByCaoZuoRyId(vwRybq.getRyid());
		request.put("mybingrens", myBingRens);
		return SUCCESS;

	}

	/*
	 * 返回我的病人列表，通过病区id，caozuoyuan_id
	 */
	public String getMyBingRenByCzryIdBqId() {
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		List<MyBingRen> myBingRens = twWdbrService.getWdbrByCaoZuoRyIdBqId(
				vwRybq.getRyid(), bqid);
		request.put("mybingrens", myBingRens);
		return SUCCESS;
	}

	/*
	 * 返回待选择的病人列表，通过caozuoyuan_id  后面增加选择不同病区的情况
	 */
	public String getDaiXuanZheBingRenByCzryId() {
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		System.out.println(vwRybq.getRyid());
		String dangqianbqid = "";
		dangqianbqid = session.get("dangqianbingqu_id").toString();
		if (dangqianbqid != "") {
			List<VwRybq> vwRybqs = vwRybqService.listBingQuByCaozyId(vwRybq.getRyid());
			request.put("caozuoyuan_bingqu", vwRybqs);
			List<DaiXuanZheBingren> myBingRens = twWdbrService.getDaiXuanZheBingRenByCzryIdBqId(vwRybq.getRyid(),dangqianbqid);
			request.put("daixzbingrens", myBingRens);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/*
	 * 返回待选择的病人列表，通过caozuoyuan_id
	 */
	public String getDaiXuanZheBingRenByCzryIdBqId() {
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		List<DaiXuanZheBingren> myBingRens = twWdbrService
				.getDaiXuanZheBingRenByCzryIdBqId(vwRybq.getRyid(), bqid);
		request.put("daixzbingrens", myBingRens);
		return SUCCESS;
	}

	public String addWdbrWithSelect(){
		String dangqianbqid = "";
		dangqianbqid = session.get("dangqianbingqu_id").toString();
		try {
				List<TwWdbr> twWdbrs = new ArrayList<TwWdbr>();
				VwRybq vwRybq = (VwRybq)session.get("caozuoyuan");
				String dqbqid = (String) session.get("dangqianbingqu_id");
				for(int i=0;i < chw.length;i++){
					if(quedflag[i].equals("1")){
						TwWdbrId twWdbrId = new TwWdbrId();
						TwWdbr twWdbr = new TwWdbr();
						twWdbrId.setHsid(vwRybq.getRyid());
						twWdbrId.setBq(dqbqid);
						twWdbrId.setChw(chw[i]);
						twWdbr.setId(twWdbrId);
						twWdbrs.add(twWdbr);
						System.out.println("chw"+ i + ":" + chw[i]);
						System.out.println("quedflag" + i + ":" + quedflag[i]);
					}
				}
				twWdbrService.deleteMyBingRenByCzryIdBqId(vwRybq.getRyid(), dqbqid);
				twWdbrService.addWdbrWithSelect(twWdbrs);
				List<DaiXuanZheBingren> myBingRens = twWdbrService.getDaiXuanZheBingRenByCzryIdBqId(vwRybq.getRyid(),dangqianbqid);
				request.put("daixzbingrens", myBingRens);
				request.put("datasaveflag", 1);
				return SUCCESS;
		} catch (Exception e) {
			request.put("datasaveflag", 0);
			return ERROR;
		}
	}
	
	/*
	 * 返回我的病人－住院病人信息列表，通过病区id，caozuoyuan_id
	 */
	public String getMyZhuYuanBingRenByCzryIdBqId() {
		VwRybq hushi = (VwRybq) session.get("caozuoyuan");
		String vhsid = hushi.getRyid();
		String dqbqid = session.get("dangqianbingqu_id").toString();
		List<VwBqbrZy> vwBqbrZys = vwBqbrZyService.listMyBingrByBqIdHsId(dqbqid, vhsid);
		if(vwBqbrZys.size()>0){
			request.put("bqry", vwBqbrZys);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	private Map<String, Object> session;
	private Map<String, Object> request;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {

		this.request = arg0;
	}

}
