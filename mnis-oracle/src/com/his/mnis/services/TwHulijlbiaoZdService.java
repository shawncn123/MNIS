package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import com.his.mnis.entities.HulijlLeiOutput;
import com.his.mnis.entities.HulijlLeiOutputForUpdate;
import com.his.mnis.entities.TwHulijlbiaoZd;
import com.his.mnis.entities.TwHulijlbiaoZd1;
import com.his.mnis.entities.TwHulipingguPingguJilu;

public interface TwHulijlbiaoZdService {

	public List<TwHulijlbiaoZd> getListTwHulijlbiaoZd(int bbfl);
	
	/*
	 * 按分类、病人、日期查询出相关评估记录数据
	 */
	public List<TwHulipingguPingguJilu> getListPingguJilu(Long key1,Integer key2,Short yebh,Date pgrq,Integer bbfl);
	
	/*
	 * 重构输出的护理表结构数据
	 */
	public List<HulijlLeiOutput> rebuildHuliLeiOutput(List<TwHulijlbiaoZd> twHulijlbiaoZds,List<TwHulijlbiaoZd1> twHulijlbiaoZd1s);
	
	/*
	 * 护理评估－评估部分保存
	 */
	public int saveHuLiPingGu_JiLu_List(List<TwHulipingguPingguJilu> twHulipingguPingguJilus);
	
	/*
	 * 护理评估－评估部分修改保存
	 */
	public int updateHuLiPingGu_JiLu_List(List<TwHulipingguPingguJilu> twHulipingguPingguJilus);
	
	/*
	 * 重构输出保存的评估记录数据
	 */
	public List<HulijlLeiOutputForUpdate> rebuildHulijlLeiOutputForUpdate(List<HulijlLeiOutput> hulijlLeiOutputs,List<TwHulipingguPingguJilu> twHulipingguPingguJilus);
}
