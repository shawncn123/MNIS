package com.his.mnis.serviceImpl;

import java.util.Date;
import java.util.List;

import com.his.mnis.dao.TwTzdataTwDao;
import com.his.mnis.entities.TwTzdataTw;
import com.his.mnis.services.TwTzdataTwService;

public class TwTzdataTwServiceImpl implements TwTzdataTwService {

	private TwTzdataTwDao twTzdataTwDao;
	
	public TwTzdataTwDao getTwTzdataTwDao() {
		return twTzdataTwDao;
	}

	public void setTwTzdataTwDao(TwTzdataTwDao twTzdataTwDao) {
		this.twTzdataTwDao = twTzdataTwDao;
	}

	@Override
	public String doCreateTwTzdataTw(TwTzdataTw twTzdataTw, Long vjlid) {

		twTzdataTwDao.doCreateTwTzdataTw(twTzdataTw);
		String proc_result = twTzdataTwDao.callProcedurePwTzdataTw(vjlid);
		if ("1".equals(proc_result)) { // 1 表示失败
			return "1";
		} else {
			return "0";
		}
	}

	@Override
	public List<TwTzdataTw> getListTzDataTw(long key1, Integer key2,
			short yebh, Date lrrq) {
		return twTzdataTwDao.getListTzDataTw(key1, key2, yebh, lrrq);
	}

	@Override
	public List<TwTzdataTw> getListTzDataTWJl(long key1, Integer key2, short yebh,
			Date lrrq) {
		return twTzdataTwDao.getListTzDataTWJl(key1, key2, yebh, lrrq);
	}

	@Override
	public TwTzdataTw getTzDataTwByJlid(long jlid) {
		return twTzdataTwDao.getTzDataTwByJlid(jlid);
	}

	@Override
	public int updateTzdataTwByJlid(TwTzdataTw twTzdataTw) {
		return twTzdataTwDao.updateTzdataTwByJlid(twTzdataTw);
	}

	
}
