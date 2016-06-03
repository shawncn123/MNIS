package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.LinZhuWeiZhiXingDao;
import com.his.mnis.entities.MyBingRen;
import com.his.mnis.entities.VwBryz;
import com.his.mnis.services.LinZhuWeiZhiXingService;
import com.his.mnis.services.TwWdbrService;
import com.his.mnis.services.VwBryzService;

public class LinZhuWeiZhiXingServiceImpl implements LinZhuWeiZhiXingService {
	
	private VwBryzService vwBryzService;
	private TwWdbrService twWdbrService;
	private LinZhuWeiZhiXingDao linZhuWeiZhiXingDao;

	public LinZhuWeiZhiXingDao getLinZhuWeiZhiXingDao() {
		return linZhuWeiZhiXingDao;
	}

	public void setLinZhuWeiZhiXingDao(LinZhuWeiZhiXingDao linZhuWeiZhiXingDao) {
		this.linZhuWeiZhiXingDao = linZhuWeiZhiXingDao;
	}

	public TwWdbrService getTwWdbrService() {
		return twWdbrService;
	}

	public void setTwWdbrService(TwWdbrService twWdbrService) {
		this.twWdbrService = twWdbrService;
	}

	public VwBryzService getVwBryzService() {
		return vwBryzService;
	}

	public void setVwBryzService(VwBryzService vwBryzService) {
		this.vwBryzService = vwBryzService;
	}

	@Override
	public String createMyBingRenYiZhu(String hsid) {

		List<MyBingRen> myBingRens = twWdbrService.getWdbrByCaoZuoRyId(hsid);
		for(int i=1; i < myBingRens.size(); i++){
			MyBingRen myBingRen = myBingRens.get(i);
			long vkey1 = myBingRen.getKey1();
			int vkey2 = myBingRen.getKey2();
			String proc_result = vwBryzService.callProcedureBrYz(vkey1, vkey2);
			if(proc_result.equals("1")){
				return "1";
			}
		}
		return "0";
	}

	@Override
	public List<VwBryz> getListMyBingRenWeiZxlz(String hsid) {

		List<VwBryz> vwBryzs = linZhuWeiZhiXingDao.getWeiWanChengLinzByHsId(hsid);
		return vwBryzs;
		
	}

}
