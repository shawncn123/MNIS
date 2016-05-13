package com.his.mnis.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.his.mnis.dao.TwBryzzxDao;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.TwBryzzxRemodelSub;
import com.his.mnis.services.TwBryzzxService;

public class TwBryzzxServiceImpl implements TwBryzzxService {

	private TwBryzzxDao twBryzzxDao;
	
	public TwBryzzxDao getTwBryzzxDao() {
		return twBryzzxDao;
	}
	
	public void setTwBryzzxDao(TwBryzzxDao twBryzzxDao) {
		this.twBryzzxDao = twBryzzxDao;
	}
	
	@Override
	public List<TwBryzzx> getListBrYzzxByKey(long v_key1, int v_key2,
			short v_yebh) {
		String proc_result = twBryzzxDao.callProcedureBrYzzx(v_key1, v_key2);
		System.out.println("proc_result:"+ proc_result);
		if ("1".equals(proc_result)) { // 1 表示失败
			return null;
		} else {
			return twBryzzxDao.getListBrYzzxByKey(v_key1, v_key2, v_yebh);
		}
	}

	@Override
	public List<TwBryzzx> getListBrYzzxByKeyAndTiaoJian(long v_key1,
			int v_key2, short v_yebh, String v_tiaojianstr) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private TwBryzzxRemodelSub twBryzzxRemodelSub;
	private TwBryzzxRemodel twBryzzxRemodel;
	private List<TwBryzzxRemodelSub> twBryzzxRemodelSubs;
	private List<TwBryzzxRemodel> twBryzzxRemodels;

	public TwBryzzxRemodelSub getTwBryzzxRemodelSub() {
		return twBryzzxRemodelSub;
	}

	public void setTwBryzzxRemodelSub(TwBryzzxRemodelSub twBryzzxRemodelSub) {
		this.twBryzzxRemodelSub = twBryzzxRemodelSub;
	}

	public TwBryzzxRemodel getTwBryzzxRemodel() {
		return twBryzzxRemodel;
	}

	public void setTwBryzzxRemodel(TwBryzzxRemodel twBryzzxRemodel) {
		this.twBryzzxRemodel = twBryzzxRemodel;
	}

	public List<TwBryzzxRemodelSub> getTwBryzzxRemodelSubs() {
		return twBryzzxRemodelSubs;
	}

	public void setTwBryzzxRemodelSubs(List<TwBryzzxRemodelSub> twBryzzxRemodelSubs) {
		this.twBryzzxRemodelSubs = twBryzzxRemodelSubs;
	}

	public List<TwBryzzxRemodel> getTwBryzzxRemodels() {
		return twBryzzxRemodels;
	}

	public void setTwBryzzxRemodels(List<TwBryzzxRemodel> twBryzzxRemodels) {
		this.twBryzzxRemodels = twBryzzxRemodels;
	}

	@Override
	public List<TwBryzzxRemodel> getListBrYzzxRemodel(List<TwBryzzx> twBryzzxs) {

		long v_groupxh = 0L;
		twBryzzxRemodels = new ArrayList<TwBryzzxRemodel>();
		for(int i=0;i < twBryzzxs.size(); i++){
			twBryzzxRemodelSub = new TwBryzzxRemodelSub();
			if(twBryzzxs.get(i).getGroupxh() == v_groupxh){
				String vsjd = twBryzzxs.get(i).getSjd();
				String vzxflag = twBryzzxs.get(i).getZxflag();
				Date vsjdtime = twBryzzxs.get(i).getSjdtime();
				
				twBryzzxRemodelSub.setSjd(vsjd);
				twBryzzxRemodelSub.setSjdtime(vsjdtime);
				twBryzzxRemodelSub.setZxflag(vzxflag);
				
				twBryzzxRemodelSubs.add(twBryzzxRemodelSub);
			}else{
				v_groupxh = twBryzzxs.get(i).getGroupxh();
				if(i > 0){
					twBryzzxRemodel.setTwBryzzxRemodelSubs(twBryzzxRemodelSubs);
					twBryzzxRemodels.add(twBryzzxRemodel);
					twBryzzxRemodelSubs = new ArrayList<TwBryzzxRemodelSub>();
				}
				if(i == 0){
					twBryzzxRemodelSubs = new ArrayList<TwBryzzxRemodelSub>();
				}
				
				twBryzzxRemodel = new TwBryzzxRemodel();
				twBryzzxRemodel.setBq(twBryzzxs.get(i).getBq());
				twBryzzxRemodel.setChw(twBryzzxs.get(i).getChw());
				twBryzzxRemodel.setGroupxh(twBryzzxs.get(i).getGroupxh());
				twBryzzxRemodel.setKey1(twBryzzxs.get(i).getKey1());
				twBryzzxRemodel.setKey2(twBryzzxs.get(i).getKey2());
				twBryzzxRemodel.setRowkey(twBryzzxs.get(i).getRowkey());
				twBryzzxRemodel.setRq(twBryzzxs.get(i).getRq());
				twBryzzxRemodel.setYebh(twBryzzxs.get(i).getYebh());
				twBryzzxRemodel.setYf2mc(twBryzzxs.get(i).getYf2mc());
				String yzmc_s = twBryzzxs.get(i).getYzmc();
				
				List<String> t_yzmcs = new ArrayList<String>();
				while(yzmc_s.indexOf("||") > 0){
					String sub_yzmc = yzmc_s.substring(0, yzmc_s.indexOf("||"));
					t_yzmcs.add(sub_yzmc);
					yzmc_s = yzmc_s.substring(yzmc_s.indexOf("||") + 2);
				}
				t_yzmcs.add(yzmc_s);
				twBryzzxRemodel.setYzmcs(t_yzmcs);
				twBryzzxRemodel.setZxlb(twBryzzxs.get(i).getZxlb());
				
				twBryzzxRemodelSub.setSjd(twBryzzxs.get(i).getSjd());
				twBryzzxRemodelSub.setSjdtime(twBryzzxs.get(i).getSjdtime());
				twBryzzxRemodelSub.setZxflag(twBryzzxs.get(i).getZxflag());
				twBryzzxRemodelSubs.add(twBryzzxRemodelSub);
			}
		}
		twBryzzxRemodels.add(twBryzzxRemodel);
		return twBryzzxRemodels;
	}

	@Override
	public String bingRenYzzx_baocun(Date rq, String sjd, long groupxh,
			String hsid, String hsxm, Date zxsj, String zxms) {

		return twBryzzxDao.callProcedureBrYzzx_baocun(rq, sjd, groupxh, hsid, hsxm, zxsj, zxms);
	}


}
