package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.VwTzzdTwLxDao;
import com.his.mnis.entities.VwTzzdTwLx;

public class VwTzzdTwLxServiceImpl {

	private VwTzzdTwLxDao vwTzzdTwLxDao;

	public VwTzzdTwLxDao getVwTzzdTwLxDao() {
		return vwTzzdTwLxDao;
	}

	public void setVwTzzdTwLxDao(VwTzzdTwLxDao vwTzzdTwLxDao) {
		this.vwTzzdTwLxDao = vwTzzdTwLxDao;
	}
	
	public List<VwTzzdTwLx> getListsVwTzzdTwLx(){
		return vwTzzdTwLxDao.getListTwLx();
	}
}
