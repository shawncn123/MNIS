package com.his.mnis.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.his.mnis.dao.TwHulijlbiaoZdDao;
import com.his.mnis.entities.HulijlLeiOutput;
import com.his.mnis.entities.HulijlLeiOutputForUpdate;
import com.his.mnis.entities.TwHulijlbiaoZd;
import com.his.mnis.entities.TwHulijlbiaoZd1;
import com.his.mnis.entities.TwHulipingguPingguJilu;
import com.his.mnis.services.TwHulijlbiaoZdService;

public class TwHulijlbiaoZdServiceImpl implements TwHulijlbiaoZdService {
	
	private TwHulijlbiaoZdDao twHulijlbiaoZdDao;

	public TwHulijlbiaoZdDao getTwHulijlbiaoZdDao() {
		return twHulijlbiaoZdDao;
	}

	public void setTwHulijlbiaoZdDao(TwHulijlbiaoZdDao twHulijlbiaoZdDao) {
		this.twHulijlbiaoZdDao = twHulijlbiaoZdDao;
	}

	@Override
	public List<TwHulijlbiaoZd> getListTwHulijlbiaoZd(int bbfl) {
		return twHulijlbiaoZdDao.getListTwHulijlbiaoZd(bbfl);
	}

	@Override
	public List<HulijlLeiOutput> rebuildHuliLeiOutput(
			List<TwHulijlbiaoZd> twHulijlbiaoZds,
			List<TwHulijlbiaoZd1> twHulijlbiaoZd1s) {
		
		List<HulijlLeiOutput> hulijlLeiOutputs = new ArrayList<>();
		for(int i=0;i<twHulijlbiaoZds.size();i++){
			TwHulijlbiaoZd twHulijlbiaoZd = twHulijlbiaoZds.get(i);
			HulijlLeiOutput hulijlLeiOutput = new HulijlLeiOutput();
			hulijlLeiOutput.setBbfl(twHulijlbiaoZd.getBbfl());
			hulijlLeiOutput.setDw(twHulijlbiaoZd.getDw());
			hulijlLeiOutput.setDw1(twHulijlbiaoZd.getDw1());
			hulijlLeiOutput.setDw2(twHulijlbiaoZd.getDw2());
			hulijlLeiOutput.setDw3(twHulijlbiaoZd.getDw3());
			hulijlLeiOutput.setDw4(twHulijlbiaoZd.getDw4());
			hulijlLeiOutput.setLength(twHulijlbiaoZd.getLength());
			hulijlLeiOutput.setLength1(twHulijlbiaoZd.getLength1());
			hulijlLeiOutput.setLength2(twHulijlbiaoZd.getLength2());
			hulijlLeiOutput.setLength3(twHulijlbiaoZd.getLength3());
			hulijlLeiOutput.setLength4(twHulijlbiaoZd.getLength4());
			hulijlLeiOutput.setSubname1(twHulijlbiaoZd.getSubname1());
			hulijlLeiOutput.setSubname2(twHulijlbiaoZd.getSubname2());
			hulijlLeiOutput.setSubname3(twHulijlbiaoZd.getSubname3());
			hulijlLeiOutput.setSubname4(twHulijlbiaoZd.getSubname4());
			hulijlLeiOutput.setTyflag("0");
			hulijlLeiOutput.setXmid(twHulijlbiaoZd.getXmid());
			hulijlLeiOutput.setXmmc(twHulijlbiaoZd.getXmmc());
			hulijlLeiOutput.setXsxh((short)i);
			hulijlLeiOutput.setZdtype(twHulijlbiaoZd.getZdtype());
			hulijlLeiOutput.setZdtype1(twHulijlbiaoZd.getZdtype1());
			hulijlLeiOutput.setZdtype2(twHulijlbiaoZd.getZdtype2());
			hulijlLeiOutput.setZdtype3(twHulijlbiaoZd.getZdtype3());
			hulijlLeiOutput.setZdtype4(twHulijlbiaoZd.getZdtype4());
			hulijlLeiOutput.setZimokuai(twHulijlbiaoZd.getZimokuai());
			
			if(twHulijlbiaoZd.getZdtype()!=null){
				if(twHulijlbiaoZd.getZdtype().equals("1")){
					List<TwHulijlbiaoZd1> twHulijlbiaoZd1s_s = new ArrayList<>();
					for(int j=0;j<twHulijlbiaoZd1s.size();j++){
						TwHulijlbiaoZd1 twHulijlbiaoZd1 = twHulijlbiaoZd1s.get(j);
						System.out.println(twHulijlbiaoZd.getXmid()+"");
						System.out.println(twHulijlbiaoZd1.getXmid()+"");
						System.out.println(twHulijlbiaoZd1.getZdid()+"");
						int vzdid = twHulijlbiaoZd1.getZdid().intValue();
						if(twHulijlbiaoZd.getXmid().equals(twHulijlbiaoZd1.getXmid()) && vzdid==1){
							twHulijlbiaoZd1s_s.add(twHulijlbiaoZd1);
						}
					}
					hulijlLeiOutput.setListstr(twHulijlbiaoZd1s_s);
				}
			}
			if(twHulijlbiaoZd.getZdtype1()!=null){
				if(twHulijlbiaoZd.getZdtype1().equals("1")){
					List<TwHulijlbiaoZd1> twHulijlbiaoZd1s_s1 = new ArrayList<>();
					for(int j=0;j<twHulijlbiaoZd1s.size();j++){
						TwHulijlbiaoZd1 twHulijlbiaoZd1_1 = twHulijlbiaoZd1s.get(j);
						if(twHulijlbiaoZd.getXmid().equals(twHulijlbiaoZd1_1.getXmid()) && twHulijlbiaoZd1_1.getZdid().equals(2)){
							twHulijlbiaoZd1s_s1.add(twHulijlbiaoZd1_1);
						}
					}
					hulijlLeiOutput.setListstr_1(twHulijlbiaoZd1s_s1);
				}
			}
			if(twHulijlbiaoZd.getZdtype2()!=null){
				if(twHulijlbiaoZd.getZdtype2().equals("1")){
					List<TwHulijlbiaoZd1> twHulijlbiaoZd1s_s2 = new ArrayList<>();
					for(int j=0;j<twHulijlbiaoZd1s.size();j++){
						TwHulijlbiaoZd1 twHulijlbiaoZd1 = twHulijlbiaoZd1s.get(j);
						if(twHulijlbiaoZd.getXmid().equals(twHulijlbiaoZd1.getXmid()) && twHulijlbiaoZd1.getZdid().equals(3)){
							twHulijlbiaoZd1s_s2.add(twHulijlbiaoZd1);
						}
					}
					hulijlLeiOutput.setListstr_2(twHulijlbiaoZd1s_s2);
				}
			}
			if(twHulijlbiaoZd.getZdtype3()!=null){
				if(twHulijlbiaoZd.getZdtype3().equals("1")){
					List<TwHulijlbiaoZd1> twHulijlbiaoZd1s_s = new ArrayList<>();
					for(int j=0;j<twHulijlbiaoZd1s.size();j++){
						TwHulijlbiaoZd1 twHulijlbiaoZd1 = twHulijlbiaoZd1s.get(j);
						if(twHulijlbiaoZd.getXmid().equals(twHulijlbiaoZd1.getXmid()) && twHulijlbiaoZd1.getZdid().equals(4)){
							twHulijlbiaoZd1s_s.add(twHulijlbiaoZd1);
						}
					}
					hulijlLeiOutput.setListstr_3(twHulijlbiaoZd1s_s);
				}
			}
			if(twHulijlbiaoZd.getZdtype4()!=null){
				if(twHulijlbiaoZd.getZdtype4().equals("1")){
					List<TwHulijlbiaoZd1> twHulijlbiaoZd1s_s = new ArrayList<>();
					for(int j=0;j<twHulijlbiaoZd1s.size();j++){
						TwHulijlbiaoZd1 twHulijlbiaoZd1 = twHulijlbiaoZd1s.get(j);
						if(twHulijlbiaoZd.getXmid().equals(twHulijlbiaoZd1.getXmid()) && twHulijlbiaoZd1.getZdid().equals(5)){
							twHulijlbiaoZd1s_s.add(twHulijlbiaoZd1);
						}
					}
					hulijlLeiOutput.setListstr_4(twHulijlbiaoZd1s_s);
				}
			}
			hulijlLeiOutputs.add(hulijlLeiOutput);
		}
		return hulijlLeiOutputs;
	}

	@Override
	public int saveHuLiPingGu_JiLu_List(
			List<TwHulipingguPingguJilu> twHulipingguPingguJilus) {
		int vcheck = 1;
		for(int i=0; i<twHulipingguPingguJilus.size(); i++){
			TwHulipingguPingguJilu twHulipingguPingguJilu = twHulipingguPingguJilus.get(i);
			int vrowid = twHulijlbiaoZdDao.saveTHuLiPingGu_JiLu(twHulipingguPingguJilu);
			if(vrowid<1){
				vcheck = 0;
			}
		}
		return vcheck;
	}

	@Override
	public List<HulijlLeiOutputForUpdate> rebuildHulijlLeiOutputForUpdate(
			List<HulijlLeiOutput> hulijlLeiOutputs,
			List<TwHulipingguPingguJilu> twHulipingguPingguJilus) {
		
		List<HulijlLeiOutputForUpdate> hulijlLeiOutputForUpdates = new ArrayList<>();
		for(int i=0;i<hulijlLeiOutputs.size();i++){
			HulijlLeiOutputForUpdate hulijlLeiOutputForUpdate = new HulijlLeiOutputForUpdate();
			HulijlLeiOutput hulijlLeiOutput = hulijlLeiOutputs.get(i);
			hulijlLeiOutputForUpdate.setBbfl(hulijlLeiOutput.getBbfl());
			hulijlLeiOutputForUpdate.setDw(hulijlLeiOutput.getDw());
			hulijlLeiOutputForUpdate.setDw1(hulijlLeiOutput.getDw1());
			hulijlLeiOutputForUpdate.setDw2(hulijlLeiOutput.getDw2());
			hulijlLeiOutputForUpdate.setDw3(hulijlLeiOutput.getDw3());
			hulijlLeiOutputForUpdate.setDw4(hulijlLeiOutput.getDw4());
			hulijlLeiOutputForUpdate.setLength(hulijlLeiOutput.getLength());
			hulijlLeiOutputForUpdate.setLength1(hulijlLeiOutput.getLength1());
			hulijlLeiOutputForUpdate.setLength2(hulijlLeiOutput.getLength2());
			hulijlLeiOutputForUpdate.setLength3(hulijlLeiOutput.getLength3());
			hulijlLeiOutputForUpdate.setLength4(hulijlLeiOutput.getLength4());
			hulijlLeiOutputForUpdate.setListstr(hulijlLeiOutput.getListstr());
			hulijlLeiOutputForUpdate.setListstr_1(hulijlLeiOutput.getListstr_1());
			hulijlLeiOutputForUpdate.setListstr_2(hulijlLeiOutput.getListstr_2());
			hulijlLeiOutputForUpdate.setListstr_3(hulijlLeiOutput.getListstr_3());
			hulijlLeiOutputForUpdate.setListstr_4(hulijlLeiOutput.getListstr_4());
			hulijlLeiOutputForUpdate.setSubname1(hulijlLeiOutput.getSubname1());
			hulijlLeiOutputForUpdate.setSubname2(hulijlLeiOutput.getSubname2());
			hulijlLeiOutputForUpdate.setSubname3(hulijlLeiOutput.getSubname3());
			hulijlLeiOutputForUpdate.setSubname4(hulijlLeiOutput.getSubname4());
//			hulijlLeiOutputForUpdate.setTyflag(hulijlLeiOutput.getTyflag());
			hulijlLeiOutputForUpdate.setTyflag("1");
			hulijlLeiOutputForUpdate.setXmid(hulijlLeiOutput.getXmid());
			hulijlLeiOutputForUpdate.setXmmc(hulijlLeiOutput.getXmmc());
			hulijlLeiOutputForUpdate.setXsxh(hulijlLeiOutput.getXsxh());
			hulijlLeiOutputForUpdate.setZdtype(hulijlLeiOutput.getZdtype());
			hulijlLeiOutputForUpdate.setZdtype1(hulijlLeiOutput.getZdtype1());
			hulijlLeiOutputForUpdate.setZdtype2(hulijlLeiOutput.getZdtype2());
			hulijlLeiOutputForUpdate.setZdtype3(hulijlLeiOutput.getZdtype3());
			hulijlLeiOutputForUpdate.setZdtype4(hulijlLeiOutput.getZdtype4());
			hulijlLeiOutputForUpdate.setZimokuai(hulijlLeiOutput.getZimokuai());
			for(int j=0;j<twHulipingguPingguJilus.size();j++){
				TwHulipingguPingguJilu twHulipingguPingguJilu = twHulipingguPingguJilus.get(j);
				if(hulijlLeiOutput.getXmid().equals(twHulipingguPingguJilu.getXmid())){
					hulijlLeiOutputForUpdate.setRowkey(twHulipingguPingguJilu.getRowkey());
					hulijlLeiOutputForUpdate.setZddata_1(twHulipingguPingguJilu.getZddada1());
					hulijlLeiOutputForUpdate.setZddata_2(twHulipingguPingguJilu.getZddada2());
					hulijlLeiOutputForUpdate.setZddata_3(twHulipingguPingguJilu.getZddada3());
					hulijlLeiOutputForUpdate.setZddata_4(twHulipingguPingguJilu.getZddada4());
					hulijlLeiOutputForUpdate.setZddata_5(twHulipingguPingguJilu.getZddada5());
				}
			}
			hulijlLeiOutputForUpdates.add(hulijlLeiOutputForUpdate);
		}
		return hulijlLeiOutputForUpdates;
	}

	@Override
	public List<TwHulipingguPingguJilu> getListPingguJilu(Long key1,
			Integer key2, Short yebh, Date pgrq, Integer bbfl) {
		return twHulijlbiaoZdDao.getListPingguJilu(key1, key2, yebh, pgrq, bbfl);
	}

	@Override
	public int updateHuLiPingGu_JiLu_List(
			List<TwHulipingguPingguJilu> twHulipingguPingguJilus) {
		
		int vcheck = 1;
		for(int i=0; i<twHulipingguPingguJilus.size(); i++){
			TwHulipingguPingguJilu twHulipingguPingguJilu = twHulipingguPingguJilus.get(i);
			int vrowid = twHulijlbiaoZdDao.updateTHuLiPingGu_JiLu(twHulipingguPingguJilu);
			if(vrowid<1){
				vcheck = 0;
			}
		}
		return vcheck;
	}

}
