package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.TwTzdata;

public interface TwTzdataService {
/*
 * doCreateTwTzdata 插入多条体征录入项
 */
	public String doCreateTwTzdata(List<TwTzdata> twTzdatas,Long vpcid);
}
