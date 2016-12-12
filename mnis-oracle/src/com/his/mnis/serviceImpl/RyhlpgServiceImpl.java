package com.his.mnis.serviceImpl;

import com.his.mnis.dao.TwRyhlpgDao;
import com.his.mnis.dao.VwRyhlpgDao;
import com.his.mnis.entities.TwRyhlpg;
import com.his.mnis.entities.VwRyhlpg;
import com.his.mnis.services.RyhlpgService;

public class RyhlpgServiceImpl implements RyhlpgService {
	
	private VwRyhlpgDao vwRyhlpgDao;
	private TwRyhlpgDao twRyhlpgDao;

	public TwRyhlpgDao getTwRyhlpgDao() {
		return twRyhlpgDao;
	}

	public void setTwRyhlpgDao(TwRyhlpgDao twRyhlpgDao) {
		this.twRyhlpgDao = twRyhlpgDao;
	}

	public VwRyhlpgDao getVwRyhlpgDao() {
		return vwRyhlpgDao;
	}

	public void setVwRyhlpgDao(VwRyhlpgDao vwRyhlpgDao) {
		this.vwRyhlpgDao = vwRyhlpgDao;
	}

	@Override
	public VwRyhlpg getVwRyhlpgByKey1Key2(Long key1, Integer key2) {
		return vwRyhlpgDao.getVwRyhlpgByKey1Key2(key1, key2);
	}

	@Override
	public void updateTwRyhlpg(TwRyhlpg twRyhlpg) {
		twRyhlpgDao.updateTwRyhlpg(twRyhlpg);
	}

	@Override
	public TwRyhlpg getTwRyhlpgByKey1Key2(Long key1, Integer key2) {
		return vwRyhlpgDao.getTwRyhlpgByKey1Key2(key1, key2);
	}

}
