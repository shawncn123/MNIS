package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.VwBqbrZy;

public interface VwBqbrZyService {
	
	/*
	 * Author:Shenxufeng
	 * 功能：
	 * 获取病区病人列表   listBingqBingr     bingqbm-病区编码
	 * 获取病人个体信息   getBingRenXingXiByKey    
	 */

	public List<VwBqbrZy> listBingqBingrByBingqId(String bingqbm);
	
	public VwBqbrZy getBingRenXingXiByKey(Long v_key1,Integer v_key2);

	public VwBqbrZy getBingRenXingXiByWanDai(String wandaixx);
}
