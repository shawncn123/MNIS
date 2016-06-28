package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import com.his.mnis.entities.TiWenDanRiQiDuan;

public interface TwTwdMessService {

	/*
	 * 读取体温单表的blob，然后生成图片文件
	 */
	public String getOutStreamOfTiWenDan(Long vkey1,Integer vkey2,Short vkey3,Date vrq);
	
	/*
	 * 通过insert 表tw_twd_mess 一条数据自动调用后台程序生成相关体温单图片
	 */
	public String createTiWenDanTuPian(Long vkey1,Integer vkey2,Short vkey3,Date vrq);
	
	/*
	 * Author:Shenxufeng
	 * 功能：
	 * getListRqBingRenTiWenJiLu   获取病人体温记录的日期时间段
	 */

	 public List<TiWenDanRiQiDuan>  getListRqBingRenTiWenJiLu(Date vdate);
	 
}
