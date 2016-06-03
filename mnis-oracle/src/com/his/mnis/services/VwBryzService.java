package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.VwBryz;
import com.his.mnis.entities.VwBryzRemodel;

public interface VwBryzService {
	
	/*
	 * 根据病人key1、key2 调用存储过程生成病人医嘱
	 */
	public String callProcedureBrYz(long key1,int key2);
	
	/*
	 * 根据护士id查询 护士相关的 病人未执行临嘱
	 */

	public List<VwBryz> getListWeiZxlzByHsId(String hsid);
	
	/*
	 * 根据病人key1,key2值查询病人医嘱数据
	 */
	public List<VwBryz> getListBrYzByKey(long v_key1,int v_key2,short v_yebh);
	
	/*
	 * 根据病人key1,key2值和给定的条件值查询病人医嘱数据  String v_tiaojianstr;      //条件字符串
	 */
	
	public List<VwBryz> getListBrYzByKeyAndTiaoJian(long v_key1,int v_key2,short v_yebh,String v_tiaojianstr);
	
	/*
	 * 实现同组医嘱的组合输出，重构输出数据
	 */

	public List<VwBryzRemodel> getListBrYzRemodel(List<VwBryz> vwBryzs);
}
