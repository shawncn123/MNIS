package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import com.his.mnis.entities.TwTzdataTw;

public interface TwTzdataTwService {
	
	public String doCreateTwTzdataTw(TwTzdataTw twTzdataTw,Long vjlid);
	
	/*
	 * 查询病人体征体温录入数据
	 */
	public List<TwTzdataTw> getListTzDataTw(long key1,Integer key2,short yebh,Date lrrq);
	
	/*
	 * 查询病人体征录入记录条数
	 */
		public List<TwTzdataTw> getListTzDataTWJl(long key1,Integer key2,short yebh,Date lrrq);
		
	/*
	 * 按jlid查询病人体征体温录入数据
	 */
		public TwTzdataTw getTzDataTwByJlid(long jlid);
	
	/*
	 * 按jlid修改患者体温录入数据
	 */
	public int updateTzdataTwByJlid(TwTzdataTw twTzdataTw);
	
}
