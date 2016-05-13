package com.his.mnis.serviceImpl;

import com.his.mnis.dao.TwTzdataDao;
import com.his.mnis.entities.TwTzdata;
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
	public String doCreateTwTzdata(TwTzdata twTzdata, Long vpcid) {
		
		twTzdataDao.doCreateTwTzdata(twTzdata);
		String proc_result = twTzdataDao.callProcedurePwTzdata(vpcid);
		if ("1".equals(proc_result)) { // 1 表示失败
			return "1";
		} else {
			return "0";
		}
	}

}
