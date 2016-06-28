package com.his.mnis.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.his.mnis.dao.XuanJiaoDao;
import com.his.mnis.entities.TwXjDm;
import com.his.mnis.entities.TwXjYw;
import com.his.mnis.entities.VwXjFl;
import com.his.mnis.entities.XuanJiaoBingRenNeiRong;
import com.his.mnis.entities.XuanJiaoBingRenNeiRongSub;
import com.his.mnis.services.XuanJiaoService;

public class XuanJiaoServiceImpl implements XuanJiaoService {
	
	private XuanJiaoDao xuanJiaoDao;

	public XuanJiaoDao getXuanJiaoDao() {
		return xuanJiaoDao;
	}

	public void setXuanJiaoDao(XuanJiaoDao xuanJiaoDao) {
		this.xuanJiaoDao = xuanJiaoDao;
	}

	@Override
	public List<VwXjFl> getListXuanJiaoFenLei() {
		return xuanJiaoDao.getListXuanJiaoFenLei();
	}

	@Override
	public List<TwXjDm> getListXuanJiaoNeiRong() {
		return xuanJiaoDao.getListXuanJiaoNeiRong();
	}

	@Override
	public List<TwXjDm> getListXjNrByDaiMa(String fldm) {
		return xuanJiaoDao.getListXjNrByDaiMa(fldm);
	}

	@Override
	public int addXuanJiaoQueDing(TwXjYw twXjYw) {
		return xuanJiaoDao.addXuanJiaoYeWu(twXjYw);  //1. 表成功
	}

	@Override
	public List<TwXjYw> getListXjYwByBingrKey(long key1, int key2, short yebh) {
		return xuanJiaoDao.getListXjYwByBingrKey(key1, key2, yebh);
	}

	@Override
	public List<XuanJiaoBingRenNeiRong> getListXuanJiaoBingRenNeiRong(List<VwXjFl> vwXjFls,List<TwXjDm> twXjDms,List<TwXjYw> twXjYws) {
		
		List<XuanJiaoBingRenNeiRong> xuanJiaoBingRenNeiRongs = new ArrayList<XuanJiaoBingRenNeiRong>();
		for(int i=0;i<vwXjFls.size();i++){
			XuanJiaoBingRenNeiRong xuanJiaoBingRenNeiRong = new XuanJiaoBingRenNeiRong();
			VwXjFl vwXjFl = vwXjFls.get(i);
			xuanJiaoBingRenNeiRong.setFldm(vwXjFl.getDm());
			xuanJiaoBingRenNeiRong.setFlmc(vwXjFl.getMc());
			List<XuanJiaoBingRenNeiRongSub> xuanJiaoBingRenNeiRongSubs = new ArrayList<XuanJiaoBingRenNeiRongSub>();
			for(int j=0; j<twXjDms.size(); j++){
				TwXjDm twXjDm = twXjDms.get(j);
				if(twXjDm.getFldm().equals(vwXjFl.getDm())){
					XuanJiaoBingRenNeiRongSub xuanJiaoBingRenNeiRongSub = new XuanJiaoBingRenNeiRongSub();
					xuanJiaoBingRenNeiRongSub.setDm(twXjDm.getDm());
					xuanJiaoBingRenNeiRongSub.setMc(twXjDm.getMc());
					xuanJiaoBingRenNeiRongSub.setXjnr(twXjDm.getXjnr());
					xuanJiaoBingRenNeiRongSub.setYjflag("0");
					for(int h=0;h<twXjYws.size();h++){
						TwXjYw twXjYw = twXjYws.get(h);
						if(twXjDm.getDm().equals(twXjYw.getXjdmid())){
							xuanJiaoBingRenNeiRongSub.setYjflag("1");
						}
					}
					xuanJiaoBingRenNeiRongSubs.add(xuanJiaoBingRenNeiRongSub);
				}
			}
			xuanJiaoBingRenNeiRong.setXuanJiaoBingRenNeiRongSubs(xuanJiaoBingRenNeiRongSubs);
			xuanJiaoBingRenNeiRongs.add(xuanJiaoBingRenNeiRong);
		}
		return xuanJiaoBingRenNeiRongs;
	}

}
