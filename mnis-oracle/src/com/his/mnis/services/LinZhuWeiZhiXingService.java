package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.LinZhuWeiZhiXingRemodel;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.VwBryz;
import com.his.mnis.entities.VwBryzRemodel;

public interface LinZhuWeiZhiXingService {

	/*
	 * 根据病人护士id生成相关病人医嘱
	 */
	public String createMyBingRenYiZhu(String hsid);
	
	/*
	 * 根据护士id查询我的病人未执行临嘱
	 */
	public List<TwBryzzx> getListMyBingRenWeiZxlz(String hsid);
	
	/*
	 * 实现同组医嘱的组合，加上床位显示输出，重构临嘱未执行输出数据
	 */
	public List<LinZhuWeiZhiXingRemodel> getListBrYzRemodel(List<VwBryz> vwBryzs,String hsid);
	
}
