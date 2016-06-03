package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.VwBqbrZy;

public interface VwBqbrZyService {
	
	/*
	 * Author:Shenxufeng
	 * 功能：
	 * 获取病区病人列表   listBingqBingr     bingqbm-病区编码
	 * 获取病人个体信息   getBingRenXingXiByKey   
	 * 根据病区id，护士姓名查询相关责任病人 listZeRenBingrByBqIdHsXm 
	 * 根据病区id，护士id查询相关我的病人 listMyBingrByBqIdHsId
	 */

	public List<VwBqbrZy> listMyBingrByBqIdHsId(String bingqbm,String hsid);
	
	public List<VwBqbrZy> listZeRenBingrByBqIdHsXm(String bingqbm,String hsxm);
	
	public List<VwBqbrZy> listBingqBingrByBingqId(String bingqbm);
	
	public VwBqbrZy getBingRenXingXiByKey(Long v_key1,Integer v_key2);

	public VwBqbrZy getBingRenXingXiByWanDai(String wandaixx);
}
