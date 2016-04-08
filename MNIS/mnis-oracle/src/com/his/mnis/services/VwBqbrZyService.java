package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.VwBqbrZy;

public interface VwBqbrZyService {
	
	/*
	 * Author:Shenxufeng
	 * 功能：
	 * 获取病区病人列表   listBingqBingr     bingqbm-病区编码
	 * 
	 */

	public List<VwBqbrZy> listBingqBingrByBingqId(String bingqbm);
}
