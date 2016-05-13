package com.his.mnis.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.his.mnis.dao.TwTzdataTwDao;
import com.his.mnis.entities.TiWenDanRiQiDuan;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.TiWenDanService;
import com.opensymphony.xwork2.ActionContext;

public class TiWenDanServiceImpl implements TiWenDanService, RequestAware,
		SessionAware {

	private TiWenDanRiQiDuan tiWenDanRiQiDuan;

	public TiWenDanRiQiDuan getTiWenDanRiQiDuan() {
		return tiWenDanRiQiDuan;
	}

	public void setTiWenDanRiQiDuan(TiWenDanRiQiDuan tiWenDanRiQiDuan) {
		this.tiWenDanRiQiDuan = tiWenDanRiQiDuan;
	}

	private List<TiWenDanRiQiDuan> tiWenDanRiQiDuans;

	public List<TiWenDanRiQiDuan> getTiWenDanRiQiDuans() {
		return tiWenDanRiQiDuans;
	}

	public void setTiWenDanRiQiDuans(List<TiWenDanRiQiDuan> tiWenDanRiQiDuans) {
		this.tiWenDanRiQiDuans = tiWenDanRiQiDuans;
	}

	private TwTzdataTwDao twTzdataTwDao;

	public TwTzdataTwDao getTwTzdataTwDao() {
		return twTzdataTwDao;
	}

	public void setTwTzdataTwDao(TwTzdataTwDao twTzdataTwDao) {
		this.twTzdataTwDao = twTzdataTwDao;
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

	@Override
	public List<TiWenDanRiQiDuan> getListRqBingRenTiWenJiLu() {

		tiWenDanRiQiDuans = new ArrayList<TiWenDanRiQiDuan>();
//		 VwBqbrZy vwBqbrZy1 = (VwBqbrZy) session.get("bingrgetixingxi");
//		 System.out.println(vwBqbrZy1);
		
		Map<String, Object> session_test = ActionContext.getContext()
				.getSession();
		VwBqbrZy vwBqbrZy = (VwBqbrZy) session_test.get("bingrgetixingxi");

		Date date1 = twTzdataTwDao.getMinRqTwTzdataTw(vwBqbrZy.getKey1(),
				vwBqbrZy.getKey2(), (short) 0).getRq();
		Date maxdate = twTzdataTwDao.getMaxRqTwTzdataTw(vwBqbrZy.getKey1(),
				vwBqbrZy.getKey2(), (short) 0).getRq();

		while (date1.getTime() <= maxdate.getTime()) {

			tiWenDanRiQiDuan = new TiWenDanRiQiDuan();

			Date firstDate = date1;
			// DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date secondDate = new Date(firstDate.getTime() + 6 * 24 * 60 * 60
					* 1000);
			date1 = new Date(firstDate.getTime() + 7 * 24 * 60 * 60 * 1000);
			tiWenDanRiQiDuan.setDate1(firstDate);
			tiWenDanRiQiDuan.setDate2(secondDate);

			tiWenDanRiQiDuans.add(tiWenDanRiQiDuan);

		}
		return tiWenDanRiQiDuans;
	}

	
}
