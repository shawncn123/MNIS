package com.his.mnis.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.his.mnis.dao.TwWxysPgDao;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.TwWxysPgDm;
import com.his.mnis.entities.TwZyhzPgXX;
import com.his.mnis.entities.TwZyhzpg;
import com.his.mnis.services.TwWxysPgService;

public class TwWxysPgServiceImpl implements TwWxysPgService {
	
	private TwWxysPgDao twWxysPgDao;
	private List<TwZyhzPgXX> twZyhzPgXXs;
	
	public List<TwZyhzPgXX> getTwZyhzPgXXs() {
		return twZyhzPgXXs;
	}

	public void setTwZyhzPgXXs(List<TwZyhzPgXX> twZyhzPgXXs) {
		this.twZyhzPgXXs = twZyhzPgXXs;
	}

	public TwWxysPgDao getTwWxysPgDao() {
		return twWxysPgDao;
	}

	public void setTwWxysPgDao(TwWxysPgDao twWxysPgDao) {
		this.twWxysPgDao = twWxysPgDao;
	}

	@Override
	public List<TwWxysPgDm> getListWxysPgDm() {
		return twWxysPgDao.getListWxysPgDm();
	}

	@Override
	public void updateTwWxysPg(TwZyhzpg twZyhzpg,String mflag) {
		twWxysPgDao.updateTwWxysPg(twZyhzpg,mflag);
	}

	@Override
	public List<TwZyhzpg> getListTwZyhzpg(Date cxrq) {
		return twWxysPgDao.getListTwZyhzpg(cxrq);
	}

	@Override
	public List<TwZyhzPgXX> getListTwZyhzPgXX(Date cxrq) {
		
		twZyhzPgXXs = new ArrayList<TwZyhzPgXX>();
		List<TwZyhzPgXX> twZyhzPgXXs = twWxysPgDao.getListTwZyhzpgXX(cxrq);
//		for(int i=0;i<listobjects.size();i++){
//			TwZyhzPgXX twZyhzPgXX = new TwZyhzPgXX();
//			twZyhzPgXX.setJlrq(listobjects.get(i));
//		}
		return twZyhzPgXXs;
	}

}
