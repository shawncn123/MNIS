package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.VwBqbrZyDao;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.VwBqbrZyService;

public class VwBqbrZyServiceImpl implements VwBqbrZyService {
	
	private VwBqbrZyDao vwBqbrZyDao;
	

	public VwBqbrZyDao getVwBqbrZyDao() {
		return vwBqbrZyDao;
	}

	public void setVwBqbrZyDao(VwBqbrZyDao vwBqbrZyDao) {
		this.vwBqbrZyDao = vwBqbrZyDao;
	}
	
	@Override
	public List<VwBqbrZy> listBingqBingrByBingqId(String bingqbm) {
		
		return vwBqbrZyDao.getListVwBqbrZyByBqid(bingqbm);
	}

	@Override
	public VwBqbrZy getBingRenXingXiByKey(Long key1, Integer key2) {
		
		return vwBqbrZyDao.getBingRenXingXiByKey(key1, key2);
		
	}

}
