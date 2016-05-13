package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.TwTzzd;

public interface TwTzzdService {
	
	/*
	 * Author:Shenxufeng
	 * 功能：
	 * 获取病人有哪些可以录入的体征项目   getBingRenTiZhengLuRuByBingQuId    
	 */

	public List<TwTzzd> getBingRenTiZhengLuRuByBingQuId(String bingqid);
}
