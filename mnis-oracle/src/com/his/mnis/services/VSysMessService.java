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
	
}
