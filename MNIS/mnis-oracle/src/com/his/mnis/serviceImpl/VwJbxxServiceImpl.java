package com.his.mnis.serviceImpl;

import com.his.mnis.dao.VwJbxxDao;
import com.his.mnis.entities.VwJbxx;
import com.his.mnis.services.VwJbxxService;

public class VwJbxxServiceImpl implements VwJbxxService {
	
	private VwJbxxDao vwJbxxDao;
	
	public VwJbxxDao getVwJbxxDao() {
		return vwJbxxDao;
	}

	public void setVwJbxxDao(VwJbxxDao vwJbxxDao) {
		this.vwJbxxDao = vwJbxxDao;
	}

	@Override
	public VwJbxx getBingRenJiBenXxByKey(Long key1, Integer key2) {
		
		return vwJbxxDao.getBingRenJiBenXxByKey(key1, key2);
		
	}

}
