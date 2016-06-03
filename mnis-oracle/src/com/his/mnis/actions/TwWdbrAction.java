package com.his.mnis.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.entities.MyBingRen;
import com.his.mnis.entities.TwWdbr;
import com.his.mnis.entities.TwWdbrId;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.TwWdbrService;
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
		List<VwRybq> vwRybqs = vwRybqService
				.listBingQuByCaozyId(vwRybq.getId());
		request.put("caozuoyuan_bingqu", vwRybqs);
		List<MyBingRen> myBingRens = twWdbrService.getWdbrByCaoZuoRyId(vwRybq
				.getId());
		request.put("mybingrens", myBingRens);
		return SUCCESS;

	}

	/*
	 * 返回我的病人列表，通过病区id，caozuoyuan_id
	 */
	public String getMyBingRenByCzryIdBqId() {
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		List<MyBingRen> myBingRens = twWdbrService.getWdbrByCaoZuoRyIdBqId(
				vwRybq.getId(), bqid);
		request.put("mybingrens", myBingRens);
		return SUCCESS;
	}

	/*
	 * 返回待选择的病人列表，通过caozuoyuan_id
	 */
	public String getDaiXuanZheBingRenByCzryId() {
		VwRybq vwRybq = (VwRybq) session.get("caozuoyuan");
		System.out.println(vwRybq.getId());
		String dangqianbqid = "";
		dangqianbqid = session.get("dangqianbingqu_id").toString();
		if (dangqianbqid != "") {
			List<VwRybq> vwRybqs = vwRybqService.listBingQuByCaozyId(vwRybq
					.getId());
			System.out.println(vwRybqs);
			request.put("caozuoyuan_bingqu", vwRybqs);
			List<MyBingRen> myBingRens = twWdbrService
					.getDaiXuanZheBingRenByCzryIdBqId(vwRybq.getId(),
							dangqianbqid);
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
		List<MyBingRen> myBingRens = twWdbrService
				.getDaiXuanZheBingRenByCzryIdBqId(vwRybq.getId(), bqid);
		request.put("daixzbingrens", myBingRens);
		return SUCCESS;
	}

	public String addWdbrWithSelect(){
//		Iterator<MyBingRen> it = myBingRens.iterator(); // 获得一个迭代子  
//		while(it.hasNext()) {  
//			myBingRen = (MyBingRen) it.next(); // 得到下一个元素  
//			System.out.println(myBingRen.getChw());
//		}  
		List<TwWdbr> twWdbrs = new ArrayList<TwWdbr>();
		VwRybq vwRybq = (VwRybq)session.get("caozuoyuan");
		String dqbqid = (String) session.get("dangqianbingqu_id");
		for(int i=0;i < chw.length;i++){
			if(quedflag[i].equals("1")){
				TwWdbrId twWdbrId = new TwWdbrId();
				TwWdbr twWdbr = new TwWdbr();
				twWdbrId.setHsid(vwRybq.getId());
				twWdbrId.setBq(dqbqid);
				twWdbrId.setChw(chw[i]);
				twWdbr.setId(twWdbrId);
				twWdbrs.add(twWdbr);
				System.out.println("chw"+ i + ":" + chw[i]);
				System.out.println("quedflag" + i + ":" + quedflag[i]);
			}
		}
		twWdbrService.deleteMyBingRenByCzryIdBqId(vwRybq.getId(), dqbqid);
		twWdbrService.addWdbrWithSelect(twWdbrs);
		return SUCCESS;
		
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
