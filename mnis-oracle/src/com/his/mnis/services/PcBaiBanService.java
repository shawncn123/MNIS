package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.BaiBanMoBan;
import com.his.mnis.entities.VwBbMbbm;

public interface PcBaiBanService {

	/*
	 * 获取前端ip，根据ip取模版
	 */
	public List<BaiBanMoBan> getPcBaiBanMoBanByIp(String vip);
	
	/*
	 * 根据bqid，xmbm 获取相应内容
	 */
	public List<String> getPcBaiBanNeiRongByBqidXmbm(List<BaiBanMoBan> baiBanMoBans,String vip);
		
}
