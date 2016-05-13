package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.TiWenDanRiQiDuan;

public interface TiWenDanService {
	
	/*
	 * Author:Shenxufeng
	 * 功能：
	 * getListRqBingRenTiWenJiLu   获取病人体温记录的日期时间段
	 */

	 public List<TiWenDanRiQiDuan>  getListRqBingRenTiWenJiLu();
}
