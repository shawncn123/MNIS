package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzx_brxx;

public interface ShuYeZhiXingService {

	/*
	 * 根据病人护士id生成相关病人执行医嘱
	 */
	public String createMyBingRenZhiXingYiZhuByHsid(String hsid,Date rq);
	
	/*
	 *  根据护士ID,执行分类代码查询相关病人待执行医嘱
	 */
	public List<TwBryzzx_brxx> getMyBingRenZhiXingYiZhuByHsidZxfl(String hsid,String zxfldm,Date xzrq);
	
}
