package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.TwWdbrDao;
import com.his.mnis.entities.MyBingRen;
import com.his.mnis.entities.TwWdbr;
import com.his.mnis.services.TwWdbrService;

public class TwWdbrServiceImpl implements TwWdbrService {
	
	private TwWdbrDao twWdbrDao;

	public TwWdbrDao getTwWdbrDao() {
		return twWdbrDao;
	}

	public void setTwWdbrDao(TwWdbrDao twWdbrDao) {
		this.twWdbrDao = twWdbrDao;
	}

	@Override
	public List<MyBingRen> getWdbrByCaoZuoRyId(String czyid) {
		
		return twWdbrDao.getMyBingRenByCzryId(czyid);
		
	}

	@Override
	public String addWdbrWithSelect(List<TwWdbr> twWdbrs) {
		try {
			twWdbrDao.addTwWdbrBySelect(twWdbrs);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<MyBingRen> getWdbrByCaoZuoRyIdBqId(String czyid, String bqid) {
		
		return twWdbrDao.getMyBingRenByCzryIdBqId(czyid, bqid);
		
	}

	@Override
	public List<MyBingRen> getDaiXuanZheBingRenByCzryIdBqId(String czyid,
			String bqid) {
		return twWdbrDao.getDaiXuanZheBingRenByCzryIdBqId(czyid, bqid);
	}

	@Override
	public void deleteMyBingRenByCzryIdBqId(String czyid, String bqid) {
		twWdbrDao.deleteTwWdbrByCzryIdBqId(czyid, bqid);
	}

}
