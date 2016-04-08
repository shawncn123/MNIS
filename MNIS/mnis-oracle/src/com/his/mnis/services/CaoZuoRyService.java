package com.his.mnis.services;

import com.his.mnis.entities.CaoZuoRy;

public interface CaoZuoRyService {

	/*
	 * Auther:Shenxufeng
	 * 功能：
	 * 登录验证  checkCzry    caozydm-登录的操作员代码
	 * 修改工作相关病区记录   updateBqId
	 */
	
	public CaoZuoRy checkCzry(String caozydm,String caozymm);
	
	public void updateBqId(String caozyid,String bingqbm);
	
}
