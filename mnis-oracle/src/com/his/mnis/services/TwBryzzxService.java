package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.VwBryzRemodel;

public interface TwBryzzxService {

	/*
	 * 根据病人key1,key2值查询病人医嘱数据
	 */
	public List<TwBryzzx> getListBrYzzxByKey(long v_key1,int v_key2,short v_yebh);
	
	/*
	 * 根据病人key1,key2值和给定的条件值查询病人医嘱数据  String v_tiaojianstr;      //条件字符串
	 */
	
	public List<TwBryzzx> getListBrYzzxByKeyAndTiaoJian(long v_key1,int v_key2,short v_yebh,String v_tiaojianstr);
	
	/*
	 * 实现同组医嘱的组合输出，重构输出数据
	 */

	public List<TwBryzzxRemodel> getListBrYzzxRemodel(List<TwBryzzx> twBryzzxs);
	
	/*
	 * 按条件保存医嘱执行数据
	 */
	public String bingRenYzzx_baocun(Date rq,String sjd,long groupxh,String hsid,String hsxm,Date zxsj,String zxms);
	
}