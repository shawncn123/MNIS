package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.VSysMessReader;

public interface VSysMessService {

	/*
	 * 根据参数用户id，第几页、每页行数 查询消息记录
	 * 根据参数用户id，第几页、每页行数, 已读未读参数状态 查询消息记录
	 */
	public List<VSysMessReader> getListSysMessByRenyId(String renyid,int pageno,int pagerows);
	
	public List<VSysMessReader> getListSysMessByRenyIdZhuangt(String renyid,int pageno,int pagerows,String readflag);
	
	/*
	 * 根据消息ID 人员ID 确定消息已读
	 */
	public String queDingXiaoXiYiDu(String messid, String ryid);
	/*
	 * 查询过期未读
	 */
	public  List<VSysMessReader> getListMessageGuoQiWeiDu(String renyid,int pageno,int pagerows);
	
	/*
	 * 根据参数用户id，未读参数状态 查询消息记录数
	 */
	public int getCountSysMessByRenyIdZhuangt(String renyid);
	
}
