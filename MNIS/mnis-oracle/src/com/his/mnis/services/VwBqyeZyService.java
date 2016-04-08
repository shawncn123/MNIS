package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.VwBqyeZy;

public interface VwBqyeZyService {
	
	/*
	 * Author:Shenxufeng
	 * 功能：
	 * 获取病人婴儿列表   listBingrYingr     
	 * 					key1,       --number(18)  中联:病人id number(18) rhhis:zyh number(10)
	 * 					key2,       --number(5)   中联:主页id number(5) rhhis:1
	 * 
	 */

	public List<VwBqyeZy> listBingrYingr(Float key1,Float key2);
}
