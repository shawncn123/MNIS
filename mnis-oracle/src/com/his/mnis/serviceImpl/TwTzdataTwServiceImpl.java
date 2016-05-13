package com.his.mnis.serviceImpl;

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
}
