package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.Zd001Dao;
import com.his.mnis.entities.Zd001;
import com.his.mnis.services.YiZhuWeiZhiXingService;

public class YiZhuWeiZhiXingServiceImpl implements YiZhuWeiZhiXingService {

	private Zd001Dao zd001Dao;
	
	public Zd001Dao getZd001Dao() {
		return zd001Dao;
	}

	public void setZd001Dao(Zd001Dao zd001Dao) {
		this.zd001Dao = zd001Dao;
	}

	@Override
	public List<Zd001> getListYiZhuZXFL() {
		
		return zd001Dao.getListYiZhuZXFL();
	}

}
