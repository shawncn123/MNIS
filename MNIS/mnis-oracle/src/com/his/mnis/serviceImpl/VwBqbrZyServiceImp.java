package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.VwBqbrZyDao;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.VwBqbrZyService;

public class VwBqbrZyServiceImp implements VwBqbrZyService {
	
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

}
