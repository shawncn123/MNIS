package com.his.mnis.services;

import java.util.List;

import com.his.mnis.entities.DaiXuanZheBingren;
import com.his.mnis.entities.MyBingRen;
import com.his.mnis.entities.TwWdbr;

public interface TwWdbrService {

	/*
	 * 根据病区操作员罗列出供选择的病人 getWdbrByCaoZuoRyIdBqId(String czyid,String bqid)
	 * 我的病人的选择保存 addWdbrWithSelect(List<TwWdbr> twWdbrs)
	 * 我的病人的查询 getWdbrByCaoZuoRyId(String czyid)
	 * 根据病区id，操作员id 查询待选择病人 
	 * 删除表数据
	 */
	
	public List<MyBingRen> getWdbrByCaoZuoRyId(String czyid);

	public List<MyBingRen> getWdbrByCaoZuoRyIdBqId(String czyid,String bqid);
	
	public String addWdbrWithSelect(List<TwWdbr> twWdbrs);
	
	public List<DaiXuanZheBingren> getDaiXuanZheBingRenByCzryIdBqId(String czyid,String bqid);
	
	public void deleteMyBingRenByCzryIdBqId(String czyid,String bqid); 
	
}
