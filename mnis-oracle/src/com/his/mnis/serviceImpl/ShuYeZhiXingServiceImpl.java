package com.his.mnis.serviceImpl;

import java.util.Date;
import java.util.List;

import com.his.mnis.dao.ShuYeZhiXingDao;
import com.his.mnis.entities.MyBingRen;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzx_brxx;
import com.his.mnis.services.ShuYeZhiXingService;
import com.his.mnis.services.TwBryzzxService;
import com.his.mnis.services.TwWdbrService;

public class ShuYeZhiXingServiceImpl implements ShuYeZhiXingService {

	private ShuYeZhiXingDao shuYeZhiXingDao;
	private TwWdbrService twWdbrService;
	private TwBryzzxService twBryzzxService;
	
	public TwBryzzxService getTwBryzzxService() {
		return twBryzzxService;
	}

	public void setTwBryzzxService(TwBryzzxService twBryzzxService) {
		this.twBryzzxService = twBryzzxService;
	}

	public TwWdbrService getTwWdbrService() {
		return twWdbrService;
	}

	public void setTwWdbrService(TwWdbrService twWdbrService) {
		this.twWdbrService = twWdbrService;
	}

	public ShuYeZhiXingDao getShuYeZhiXingDao() {
		return shuYeZhiXingDao;
	}

	public void setShuYeZhiXingDao(ShuYeZhiXingDao shuYeZhiXingDao) {
		this.shuYeZhiXingDao = shuYeZhiXingDao;
	}

	@Override
	public List<TwBryzzx_brxx> getMyBingRenZhiXingYiZhuByHsidZxfl(String hsid,
			String zxfldm,Date xzrq) {
		
		return shuYeZhiXingDao.getMyBingRenShuYeZhiXingYiZhu(hsid, zxfldm,xzrq);
		
	}

	@Override
	public String createMyBingRenZhiXingYiZhuByHsid(String hsid,Date rq) {
		List<MyBingRen> myBingRens = twWdbrService.getWdbrByCaoZuoRyId(hsid);
		for(int i=1; i < myBingRens.size(); i++){
			MyBingRen myBingRen = myBingRens.get(i);
			long vkey1 = myBingRen.getKey1();
			int vkey2 = myBingRen.getKey2();
			String proc_result = twBryzzxService.callProcedureBrYzzx(vkey1, vkey2, (short)0,rq);
			if(proc_result.equals("1")){
				return "1";
			}
		}
		return "0";
	}

}
