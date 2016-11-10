package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import com.his.mnis.entities.TwTzdata;
import com.his.mnis.entities.TwTzdata_update;

public interface TwTzdataService {
/*
 * doCreateTwTzdata 插入多条体征录入项
 */
	public String doCreateTwTzdata(List<TwTzdata> twTzdatas,Long vpcid);

/*
 * 查询病人体征录入数据
 */
	public List<TwTzdata> getListTzData(long key1,Integer key2,short yebh,Date lrrq);

/*
 * 查询病人体征录入记录条数
 */
	public List<String> getListTzDataJl(long key1,Integer key2,short yebh,Date lrrq);
	
/*
 * 根据key1 key2 yebh 日期 时间点查询出该病人该日期该时间点的的体征录入数据
 */
	public List<TwTzdata_update> getListTzDataByShiJianDian(long key1,Integer key2,short yebh,Date lrrq,String sjd);
	
/*
 * 根据选择的jlid 修改相关的记录数据
 */
	public int updateTwTzdata(List<TwTzdata_update> twTzdata_updates,String czyid,String czyxm,Long pcid);
}
