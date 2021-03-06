package com.his.mnis.serviceImpl;

import java.util.Date;
import java.util.List;

import com.his.mnis.dao.VwJc101Dao;
import com.his.mnis.entities.VwJc101;
import com.his.mnis.services.VwJc101Service;

public class VwJc101ServiceImpl implements VwJc101Service {
	
	private VwJc101Dao vwJc101Dao;

	public VwJc101Dao getVwJc101Dao() {
		return vwJc101Dao;
	}

	public void setVwJc101Dao(VwJc101Dao vwJc101Dao) {
		this.vwJc101Dao = vwJc101Dao;
	}

	@Override
	public List<VwJc101> getListBingrJiancByKey(Long key1, Integer key2,Short key3) {
		return vwJc101Dao.getListBingrJiancByKey(key1, key2, key3);
	}

	@Override
	public List<VwJc101> getListBingrJiancByYishengIdAndBingrKey(String sqysid,
			Long key1, Integer key2,Short key3) {
		return vwJc101Dao.getListBingrJiancByYishengIdAndBingrKey(sqysid, key1, key2, key3);
	}

	@Override
	public List<VwJc101> getListBingRenJiancByDate(Date sqrq1, Date sqrq2,
			Long key1, Integer key2,Short key3) {
		return vwJc101Dao.getListBingRenHuaYanByDate(sqrq1, sqrq2, key1, key2, key3);
	}

}
