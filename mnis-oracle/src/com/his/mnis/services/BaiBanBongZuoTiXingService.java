package com.his.mnis.services;

import java.util.List;

public interface BaiBanBongZuoTiXingService {

	/*
	 * 从我的病人获取床位为参数查询相关项目相关内容
	 */
	public List<String> chaListXiangMuNeiRongByChw(String czyid,String bqid);
	
	/*
	 * 已操作员id为参数查询相关项目相关内容
	 */
	public List<String> chaListXiangMuNeiRongByCzyId(String czyid,String bqid);
	
}
