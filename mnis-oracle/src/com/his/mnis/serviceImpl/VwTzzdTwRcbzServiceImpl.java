package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.VwTzzdTwRcbzDao;
import com.his.mnis.entities.VwTzzdTwRcbz;

public class VwTzzdTwRcbzServiceImpl {

	private VwTzzdTwRcbzDao vwTzzdTwRcbzDao;

	public VwTzzdTwRcbzDao getVwTzzdTwRcbzDao() {
		return vwTzzdTwRcbzDao;
	}

	public void setVwTzzdTwRcbzDao(VwTzzdTwRcbzDao vwTzzdTwRcbzDao) {
		this.vwTzzdTwRcbzDao = vwTzzdTwRcbzDao;
	}
	
	public List<VwTzzdTwRcbz> getListsVwTzzdTwRcbz(){
		return vwTzzdTwRcbzDao.getListVwTzzdTwRcbz();
	}
}
