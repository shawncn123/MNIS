package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.VwBryz;

public interface LinZhuWeiZhiXingService {

	/*
	 * 根据病人护士id生成相关病人医嘱
	 */
	public String createMyBingRenYiZhu(String hsid);
	
	/*
	 * 根据护士id查询我的病人未执行临嘱
	 */
	public List<VwBryz> getListMyBingRenWeiZxlz(String hsid);
	
}
