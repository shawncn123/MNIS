package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxPeiYeRemodel;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.TwBryzzx_brxx;
import com.his.mnis.entities.TwBryzzx_brxx_yzmcs_remodel;
import com.his.mnis.entities.TwPeiyeczJilu;
import com.his.mnis.entities.TwSyyzbzczJilu;
import com.his.mnis.entities.VwBryzRemodel;

public interface TwBryzzxService {

	/*
	 * 根据病人key1,key2值查询病人医嘱数据
	 */
	public List<TwBryzzx> getListBrYzzxByKey(long v_key1,int v_key2,short v_yebh,Date xzrq);
	
	/*
	 * 根据病人key1,key2值和执行分类代码查询病人TwBryzzx_brxx执行数据
	 */
	
	public List<TwBryzzx_brxx> getListBrYzzxBrxxByKeyZxfldm(long v_key1,int v_key2,short v_yebh,String zxfl,Date xzrq);
	
	/*
	 * 根据病人key1,key2值和给定的条件值查询病人医嘱数据  String v_tiaojianstr;      //条件字符串
	 */
	
	public List<TwBryzzx> getListBrYzzxByKeyZxfl(long v_key1,int v_key2,short v_yebh,String vxzzxfl,Date xzrq);
	
	/*
	 * 实现同组医嘱的组合输出，重构输出数据
	 */

	public List<TwBryzzxRemodel> getListBrYzzxRemodel(List<TwBryzzx> twBryzzxs);
	
	/*
	 * 实现同组医嘱的组合输出，重构输出数据 TwBryzzx_brxx_yzmcs_remodel
	 */
	
	public List<TwBryzzx_brxx_yzmcs_remodel> getListBrYzzxBrxxYzmcRemodel(List<TwBryzzx_brxx> twBryzzx_brxxs);
	
	/*
	 * 按条件保存医嘱执行数据
	 */
	public String bingRenYzzx_baocun(Date rq,String sjd,char zxflag,long groupxh,String hsid,String hsxm,Date zxsj,String zxms,String vcrlflag,Double vcrl,String syflag);
	
	/*
	 * 根据病人key1、key2 调用存储过程生成病人执行医嘱
	 */
	public String callProcedureBrYzzx(long key1,int key2,short yebh,Date rq);
	
	/*
	 * 根据病区和日期查询输液类医嘱数据列表
	 */
	public List<TwBryzzxPeiYeRemodel> getListBrYzzxForShuYeByBqidRiqi(String bq ,Date xzrq );
	
	/*
	 * 按rowkey  查询医嘱对应一条记录
	 */
	public TwBryzzx getTwBryzzxByRowkey(String rowkey);
	
	/*
	 * 保存对象TwBryzzx
	 */
	public void updateTwPeiyeczJiluByTwPeiyeczJilu(TwPeiyeczJilu twPeiyeczJilu);
	/*
	 * 保存对象TwSyyzbzczJilu
	 */
	public void updateTwSyyzbzczJiluByTwSyyzbzczJilu(TwSyyzbzczJilu twSyyzbzczJilu);
}
