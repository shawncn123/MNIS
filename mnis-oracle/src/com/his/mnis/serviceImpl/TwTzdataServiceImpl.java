package com.his.mnis.serviceImpl;

import java.util.List;

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

}
