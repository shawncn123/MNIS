package com.his.mnis.serviceImpl;

import java.util.Date;
import java.util.List;

import com.his.mnis.dao.VwHy101Dao;
import com.his.mnis.entities.VwHy101;
import com.his.mnis.services.VwHy101Service;

public class VwHy101ServiceImpl implements VwHy101Service {
	
	private VwHy101Dao vwHy101Dao;

	public VwHy101Dao getVwHy101Dao() {
		return vwHy101Dao;
	}

	public void setVwHy101Dao(VwHy101Dao vwHy101Dao) {
		this.vwHy101Dao = vwHy101Dao;
	}

	@Override
	public List<VwHy101> getListBingRenHuaYanByKey(Long key1, Integer key2,Short key3) {
		return vwHy101Dao.getListBingRenHuaYanByKey(key1, key2,key3);
	}

	@Override
	public List<VwHy101> getListHuaYanDanByShenqysAndKey(String sqysid,
			Long key1, Integer key2,Short key3) {
		return vwHy101Dao.getListHuaYanDanByShenqysAndKey(sqysid, key1, key2,key3);
	}

	@Override
	public List<VwHy101> getListBingRenHuaYanByDate(Date sqrq1, Date sqrq2,
			Long key1, Integer key2,Short key3) {
		return vwHy101Dao.getListBingRenHuaYanByDate(sqrq1, sqrq2, key1, key2,key3);
	}

}
