package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.TwHulijlbiaoZd1Dao;
import com.his.mnis.entities.TwHulijlbiaoZd1;
import com.his.mnis.services.TwHulijlbiaoZd1Service;

public class TwHulijlbiaoZd1ServiceImpl implements TwHulijlbiaoZd1Service {

	private TwHulijlbiaoZd1Dao twHulijlbiaoZd1Dao;
	
	public TwHulijlbiaoZd1Dao getTwHulijlbiaoZd1Dao() {
		return twHulijlbiaoZd1Dao;
	}

	public void setTwHulijlbiaoZd1Dao(TwHulijlbiaoZd1Dao twHulijlbiaoZd1Dao) {
		this.twHulijlbiaoZd1Dao = twHulijlbiaoZd1Dao;
	}

	@Override
	public List<TwHulijlbiaoZd1> getListTwHulijlbiaoZd1(int bbfl) {
		return twHulijlbiaoZd1Dao.getListTwHulijlbiaoZd1(bbfl);
	}

}
