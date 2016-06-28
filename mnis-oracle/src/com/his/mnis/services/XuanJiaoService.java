package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.TwXjDm;
import com.his.mnis.entities.TwXjYw;
import com.his.mnis.entities.VwXjFl;
import com.his.mnis.entities.XuanJiaoBingRenNeiRong;

public interface XuanJiaoService {

	/*
	 * 取出宣教分类信息
	 */
	public List<VwXjFl> getListXuanJiaoFenLei();
	/*
	 * 取出所有宣教内容
	 */
	public List<TwXjDm> getListXuanJiaoNeiRong();
	
	/*
	 * 根据宣教代码取出相应宣教内容
	 */
	public List<TwXjDm> getListXjNrByDaiMa(String fldm);
	
	/*
	 * 宣教确定
	 */
	public int addXuanJiaoQueDing(TwXjYw twXjYw);
	
	/*
	 * 获取已对病人做了宣教的内容
	 */
	public List<TwXjYw> getListXjYwByBingrKey(long key1,int key2,short yebh);
	
	/*
	 * 重构病人宣教输出对象list
	 */
	public List<XuanJiaoBingRenNeiRong> getListXuanJiaoBingRenNeiRong(List<VwXjFl> vwXjFls,List<TwXjDm> twXjDms,List<TwXjYw> twXjYws);
}
