package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.TwTzzdDao;
import com.his.mnis.entities.TwTzzd;
import com.his.mnis.services.TwTzzdService;

public class TwTzzdServiceImpl implements TwTzzdService {
	
	private TwTzzdDao twTzzdDao;
	
	public TwTzzdDao getTwTzzdDao() {
		return twTzzdDao;
	}

	public void setTwTzzdDao(TwTzzdDao twTzzdDao) {
		this.twTzzdDao = twTzzdDao;
	}

	@Override
	public List<TwTzzd> getBingRenTiZhengLuRuByBingQuId(String bingqid) {
		System.out.println("test");
		return twTzzdDao.getBingRenTiZhengLuRuByBingQuId(bingqid);

	}

}
