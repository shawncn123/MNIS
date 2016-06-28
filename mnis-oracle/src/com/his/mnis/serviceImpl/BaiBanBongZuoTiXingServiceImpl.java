package com.his.mnis.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.his.mnis.dao.BaiBanGongZhuoTiXingDao;
import com.his.mnis.entities.MyBingRen;
import com.his.mnis.entities.VwBbBrxm;
import com.his.mnis.services.BaiBanBongZuoTiXingService;
import com.his.mnis.services.TwWdbrService;

public class BaiBanBongZuoTiXingServiceImpl implements
		BaiBanBongZuoTiXingService {

	private BaiBanGongZhuoTiXingDao baiBanGongZhuoTiXingDao;
	private TwWdbrService twWdbrService;
	
	public TwWdbrService getTwWdbrService() {
		return twWdbrService;
	}

	public void setTwWdbrService(TwWdbrService twWdbrService) {
		this.twWdbrService = twWdbrService;
	}

	public BaiBanGongZhuoTiXingDao getBaiBanGongZhuoTiXingDao() {
		return baiBanGongZhuoTiXingDao;
	}

	public void setBaiBanGongZhuoTiXingDao(
			BaiBanGongZhuoTiXingDao baiBanGongZhuoTiXingDao) {
		this.baiBanGongZhuoTiXingDao = baiBanGongZhuoTiXingDao;
	}

	@Override
	public List<String> chaListXiangMuNeiRongByChw(String czyid, String bqid) {
		List<VwBbBrxm> vwBbBrxms = baiBanGongZhuoTiXingDao.getListBaiBanBingRenXiangMu(bqid);
		List<MyBingRen> myBingRens = twWdbrService.getWdbrByCaoZuoRyIdBqId(czyid, bqid);
		if(vwBbBrxms.size()>0 && myBingRens.size()>0){
			List<String> chwxms = new ArrayList<>();
			for(int j=0;j<myBingRens.size();j++){
				MyBingRen myBingRen = myBingRens.get(j);
				String vchw = myBingRen.getChw();
				for(int i=0;i<vwBbBrxms.size();i++){
					VwBbBrxm vwBbBrxm = vwBbBrxms.get(i);
					String vxmbm = vwBbBrxm.getId().getXmbm();
					String chwxm = baiBanGongZhuoTiXingDao.callProcedurePwGetHlxmnrChw(bqid, vchw, vxmbm);
					if(chwxm!=null){
						chwxms.add(chwxm);
					}
				}
			}
			return chwxms;
		}else{
			return null;
		}
	}

	@Override
	public List<String> chaListXiangMuNeiRongByCzyId(String czyid, String bqid) {
		List<VwBbBrxm> vwBbBrxms = baiBanGongZhuoTiXingDao.getListBaiBanBingRenXiangMu(bqid);
		if(vwBbBrxms.size()>0){
			List<String> chwxms = new ArrayList<>();
			for(int i=0;i<vwBbBrxms.size();i++){
				VwBbBrxm vwBbBrxm = vwBbBrxms.get(i);
				String vxmbm = vwBbBrxm.getId().getXmbm();
				String chwxm = baiBanGongZhuoTiXingDao.callProcedurePWGetHlxmnrCzyid(bqid, czyid, vxmbm);
				if(chwxm!=null){
					chwxms.add(chwxm);
				}
			}
			return chwxms;
		}else{
			return null;
		}
	}

}
