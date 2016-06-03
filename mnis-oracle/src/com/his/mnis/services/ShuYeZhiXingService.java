package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.TwBryzzx;

public interface ShuYeZhiXingService {

	/*
	 *  根据护士ID,执行分类代码查询相关病人待执行医嘱
	 */
	public List<TwBryzzx> getMyBingRenZhiXingYiZhuByHsidZxfl(String hsid,String zxfldm);
	
}
