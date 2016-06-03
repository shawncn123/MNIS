package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.ShuYeZhiXingDao;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.services.ShuYeZhiXingService;

public class ShuYeZhiXingServiceImpl implements ShuYeZhiXingService {

	private ShuYeZhiXingDao shuYeZhiXingDao;
	
	public ShuYeZhiXingDao getShuYeZhiXingDao() {
		return shuYeZhiXingDao;
	}

	public void setShuYeZhiXingDao(ShuYeZhiXingDao shuYeZhiXingDao) {
		this.shuYeZhiXingDao = shuYeZhiXingDao;
	}

	@Override
	public List<TwBryzzx> getMyBingRenZhiXingYiZhuByHsidZxfl(String hsid,
			String zxfldm) {
		
		return shuYeZhiXingDao.getMyBingRenShuYeZhiXingYiZhu(hsid, zxfldm);
		
	}

}
