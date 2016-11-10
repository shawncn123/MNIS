package com.his.mnis.serviceImpl;

import java.util.Date;
import java.util.List;

import com.his.mnis.dao.TwTzdataDao;
import com.his.mnis.entities.TwTzdata;
import com.his.mnis.entities.TwTzdata_update;
import com.his.mnis.services.TwTzdataService;

public class TwTzdataServiceImpl implements TwTzdataService {

	private TwTzdataDao twTzdataDao;
	
	public TwTzdataDao getTwTzdataDao() {
		return twTzdataDao;
	}

	public void setTwTzdataDao(TwTzdataDao twTzdataDao) {
		this.twTzdataDao = twTzdataDao;
	}

	@Override
	public String doCreateTwTzdata(List<TwTzdata> twTzdatas, Long vpcid) {
		
		for(int i=0;i<twTzdatas.size();i++){
			twTzdataDao.doCreateTwTzdata(twTzdatas.get(i));
		}
		String proc_result = twTzdataDao.callProcedurePwTzdata(vpcid);
		if ("1".equals(proc_result)) { // 1 表示失败
			return "1";
		} else {
			return "0";
		}
	}

	@Override
	public List<TwTzdata> getListTzData(long key1, Integer key2, short yebh,
			Date lrrq) {
		return twTzdataDao.getListTzData(key1, key2, yebh, lrrq);
	}

	@Override
	public List<String> getListTzDataJl(long key1, Integer key2, short yebh,
			Date lrrq) {
		return twTzdataDao.getListTzDataJl(key1, key2, yebh, lrrq);
	}

	@Override
	public List<TwTzdata_update> getListTzDataByShiJianDian(long key1,
			Integer key2, short yebh, Date lrrq, String sjd) {
		return twTzdataDao.getListTzDataByShiJianDian(key1, key2, yebh, lrrq, sjd);
	}

	@Override
	public int updateTwTzdata(List<TwTzdata_update> twTzdata_updates, String czyid,
			String czyxm,Long pcid) {
		
		for(int i=0;i<twTzdata_updates.size();i++){
			twTzdataDao.updateTwTzdata(twTzdata_updates.get(i), czyid, czyxm);
		}
		String proc_result = twTzdataDao.callProcedurePwTzdata(pcid);
		if ("1".equals(proc_result)) { // 1 表示失败
			return 1;
		} else {
			return 0;
		}
	}
}
