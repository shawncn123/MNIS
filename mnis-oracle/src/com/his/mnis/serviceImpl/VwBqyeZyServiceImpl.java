package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.VwBqYeZyDao;
import com.his.mnis.entities.VwBqyeZy;
import com.his.mnis.services.VwBqyeZyService;

public class VwBqyeZyServiceImpl implements VwBqyeZyService {
	
	private VwBqYeZyDao vwBqYeZyDao;

	public VwBqYeZyDao getVwBqYeZyDao() {
		return vwBqYeZyDao;
	}

	public void setVwBqYeZyDao(VwBqYeZyDao vwBqYeZyDao) {
		this.vwBqYeZyDao = vwBqYeZyDao;
	}

	@Override
	public List<VwBqyeZy> getListBingrYingr(long key1, int key2) {
		List<VwBqyeZy> vwBqyeZies = vwBqYeZyDao.getListBqYeByKey(key1, key2);
		if(vwBqyeZies.size()>0 && vwBqyeZies!=null){
			return vwBqyeZies;
		}else{
			return null;
		}
	}
}
