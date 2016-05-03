package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;

public interface VwRybqService {

	/*Auther：ShenXufeng
	 * 功能：
	 * listBingQuByCaozyId： 根据 caozyid-人员id 查询操作员病区
	 * listBingrByBingQuId：  根据病区Id，获取对应的病人信息
	 * getRenYuanIdByRenYuanDaiMa 根据人员代码(登录的操作员代码) 获取对应人员id
	 * getCaoZuoBingQuIdByRenYuanDaiMa 根据 caozyid-人员id  查到相应病区id－1.上次登录的病区ID，2.缺省病区ID，3、排第一位的病区id
	 * getBingQuMingCheng(String bqid) 根据病区id获取病区名称
	 */

	public List<VwRybq> listBingQuByCaozyId(String caozyid); 
	
	public List<VwBqbrZy> listBingrByBingQuId(String bingquid);

	public VwRybq getRenYuanIdByRenYuanDaiMa(String renYuanDaiMa);

	public String getCaoZuoBingQuIdByCaozyId(String caozyid);
	
	public String getBingQuMingCheng(String bqid);
}
