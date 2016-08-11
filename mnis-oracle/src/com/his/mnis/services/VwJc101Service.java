package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import com.his.mnis.entities.VwJc101;

public interface VwJc101Service {
	/*
	 * 根据病人key值查询病人相关检查信息
	 */
	public List<VwJc101> getListBingrJiancByKey(Long key1,Integer key2,Short key3);
	/*
	 * 根据申请医生ID,病人Key查询病人的相关检查信息
	 */
	public List<VwJc101> getListBingrJiancByYishengIdAndBingrKey(String sqysid,Long key1,Integer key2,Short key3);
	/*
	 * 根据时间,病人Key查询病人的相关检查信息
	 */
	public List<VwJc101> getListBingRenJiancByDate(Date sqrq,Long key1,Integer key2,Short key3);
	/*
	 * 根据时间,病人Key,危急值 查询病人的相关检查信息
	 */
	public List<VwJc101> getListBingRenJiancByDateAndWjflag(String wjbz,Date sqrq,Long key1,Integer key2,Short key3);
	/*
	 * 根据危急值,病人Key查询病人的相关检查信息
	 */
	public List<VwJc101> getListBingRenJiancByWjflagAndBingrKey(String wjbz,Long key1,Integer key2,Short key3);
}
