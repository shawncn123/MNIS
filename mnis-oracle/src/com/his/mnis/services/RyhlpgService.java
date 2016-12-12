package com.his.mnis.services;

import com.his.mnis.entities.TwRyhlpg;
import com.his.mnis.entities.VwRyhlpg;

public interface RyhlpgService {

	/*
	 * 取住院处录入的相关护理数据
	 */
	public VwRyhlpg getVwRyhlpgByKey1Key2(Long key1,Integer key2);
	
	/*
	 * 取相关护理数据
	 */
	public TwRyhlpg getTwRyhlpgByKey1Key2(Long key1,Integer key2);
	/*
	 * 保存入院护理评估一般资料录入数据
	 */
	public void updateTwRyhlpg(TwRyhlpg twRyhlpg);
}
