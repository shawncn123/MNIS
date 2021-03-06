package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import com.his.mnis.entities.BingRenHuaYanXingXi;
import com.his.mnis.entities.VwHy101;

public interface VwHy101Service {
	
	/*
	 * 根据病人key值查询病人的化验单主表信息
	 */
	public List<VwHy101> getListBingRenHuaYanByKey(Long key1,Integer key2,Short key3);
	/*
	 * 根据申请医生ID,病人Key查询病人的化验单主表信息
	 */
	public List<VwHy101> getListHuaYanDanByShenqysAndKey(String sqysid,Long key1,Integer key2,Short key3);
	/*
	 * 根据时间段,病人Key查询病人的化验单主、从表信息
	 */
	public List<BingRenHuaYanXingXi> getListBingRenHuaYanByDate(Date sqrq,Long key1,Integer key2,Short key3);
	
	/*
	 * 根据病人key值查询病人的化验单主、从表信息
	 */
	public List<BingRenHuaYanXingXi> getListHuaYanAllByKey(Long key1,Integer key2,Short key3);
	
	/*
	 * 根据病人key值查询病人的危急值的化验单主、从表信息
	 */
	public List<BingRenHuaYanXingXi> getListHuaYanWeiJiAllByKey(Long key1,Integer key2,Short key3);
	
	/*
	 * 根据病人key值，时间段 查询病人的危机值化验单主、从表信息
	 */
	public List<BingRenHuaYanXingXi> getListWjzHuaYanByKeyDate(Date sqrq,Long key1,Integer key2,Short key3);
}
