package com.his.mnis.serviceImpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.his.mnis.dao.TwBryzPeiYeDao;
import com.his.mnis.dao.TwBryzzxDao;
import com.his.mnis.dao.TwSyyzbzczJiluDao;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.TwBryzzxPeiYeRemodel;
import com.his.mnis.entities.TwBryzzxRemodel;
import com.his.mnis.entities.TwBryzzxRemodelSub;
import com.his.mnis.entities.TwBryzzx_brxx;
import com.his.mnis.entities.TwBryzzx_brxx_yzmcs_remodel;
import com.his.mnis.entities.TwPeiyeczJilu;
import com.his.mnis.entities.TwSyyzbzczJilu;
import com.his.mnis.services.TwBryzzxService;

public class TwBryzzxServiceImpl implements TwBryzzxService {

	private TwBryzzxDao twBryzzxDao;
	private TwBryzPeiYeDao twBryzPeiYeDao;
	private TwSyyzbzczJiluDao twSyyzbzczJiluDao;
	
	public TwSyyzbzczJiluDao getTwSyyzbzczJiluDao() {
		return twSyyzbzczJiluDao;
	}

	public void setTwSyyzbzczJiluDao(TwSyyzbzczJiluDao twSyyzbzczJiluDao) {
		this.twSyyzbzczJiluDao = twSyyzbzczJiluDao;
	}

	public TwBryzPeiYeDao getTwBryzPeiYeDao() {
		return twBryzPeiYeDao;
	}

	public void setTwBryzPeiYeDao(TwBryzPeiYeDao twBryzPeiYeDao) {
		this.twBryzPeiYeDao = twBryzPeiYeDao;
	}

	public TwBryzzxDao getTwBryzzxDao() {
		return twBryzzxDao;
	}
	
	public void setTwBryzzxDao(TwBryzzxDao twBryzzxDao) {
		this.twBryzzxDao = twBryzzxDao;
	}
	
	@Override
	public List<TwBryzzx> getListBrYzzxByKey(long v_key1, int v_key2,
			short v_yebh,Date xzrq) {
		String proc_result = twBryzzxDao.callProcedureBrYzzx(v_key1, v_key2,v_yebh,xzrq);
		System.out.println("proc_result:"+ proc_result);
		if ("1".equals(proc_result)) { // 1 表示失败
			return null;
		} else {
			return twBryzzxDao.getListBrYzzxByKey(v_key1, v_key2, v_yebh,xzrq);
		}
	}

	@Override
	public List<TwBryzzx> getListBrYzzxByKeyZxfl(long v_key1,
			int v_key2, short v_yebh, String vxzzxfl,Date xzrq) {
		return twBryzzxDao.getListBrYzzxByKeyZxfldm(v_key1, v_key2, v_yebh, vxzzxfl,xzrq);
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

	/*
	 * (non-Javadoc)
	 * @see com.his.mnis.services.TwBryzzxService#getListBrYzzxRemodel(java.util.List)
	 * twBryzzxRemodels  存放多个同组医嘱
	 * twBryzzxRemodelSub 存放医嘱的执行时间点
	 * twBryzzxRemodelSubs 存放同组医嘱系列执行时间点
	 */
	@Override
	public List<TwBryzzxRemodel> getListBrYzzxRemodel(List<TwBryzzx> twBryzzxs) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		long v_groupxh = 0L;
		Timestamp vrq = Timestamp.valueOf("1990-01-01 00:00:00");
		twBryzzxRemodels = new ArrayList<TwBryzzxRemodel>();
		for(int i=0;i < twBryzzxs.size(); i++){
			twBryzzxRemodelSub = new TwBryzzxRemodelSub();
//			zrq = twBryzzxs.get(i).getRq();
			if(twBryzzxs.get(i).getGroupxh() == v_groupxh && twBryzzxs.get(i).getRq().equals(vrq)){
//			if(twBryzzxs.get(i).getGroupxh() == v_groupxh){
				String vsjd = twBryzzxs.get(i).getSjd();
				String vzxflag = twBryzzxs.get(i).getZxflag();
				Date vsjdtime = twBryzzxs.get(i).getSjdtime();
				String vrowkey = twBryzzxs.get(i).getRowkey();
				String vcrlflag = twBryzzxs.get(i).getCrlflag();
			    Double vcrl =  twBryzzxs.get(i).getCrl();
				vrowkey = vrowkey.replace(":", "q");
				
				twBryzzxRemodelSub.setSjd(vsjd);
				twBryzzxRemodelSub.setSjdtime(vsjdtime);
				twBryzzxRemodelSub.setZxflag(vzxflag);
				twBryzzxRemodelSub.setRowkey(vrowkey);
				twBryzzxRemodelSub.setCrlflag(vcrlflag);
				twBryzzxRemodelSub.setCrl(vcrl);
				
				twBryzzxRemodelSubs.add(twBryzzxRemodelSub);
			}else{
				v_groupxh = twBryzzxs.get(i).getGroupxh();
				vrq = twBryzzxs.get(i).getRq();
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
				twBryzzxRemodel.setLsflag(twBryzzxs.get(i).getLsflag());
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
				String rowkeytmp = twBryzzxs.get(i).getRowkey();
				rowkeytmp = rowkeytmp.replace(":", "q");
				twBryzzxRemodelSub.setRowkey(rowkeytmp);
				twBryzzxRemodelSub.setCrlflag(twBryzzxs.get(i).getCrlflag());
				twBryzzxRemodelSub.setCrl(twBryzzxs.get(i).getCrl());
				twBryzzxRemodelSubs.add(twBryzzxRemodelSub);
			}
		}
		twBryzzxRemodel.setTwBryzzxRemodelSubs(twBryzzxRemodelSubs);
		twBryzzxRemodels.add(twBryzzxRemodel);
		return twBryzzxRemodels;
	}

	@Override
	public String bingRenYzzx_baocun(Date rq, String sjd,char zxflag, long groupxh,
			String hsid, String hsxm, Date zxsj, String zxms,String vcrlflag,Double vcrl,String syflag) {

		return twBryzzxDao.callProcedureBrYzzx_baocun(rq, sjd,zxflag, groupxh, hsid, hsxm, zxsj, zxms,vcrlflag,vcrl,syflag);
	}

	@Override
	public String callProcedureBrYzzx(long key1, int key2, short yebh, Date rq) {
		String proc_result = twBryzzxDao.callProcedureBrYzzx(key1, key2, yebh,rq);
		return proc_result; // 1 表示失败 
	}

	@Override
	public List<TwBryzzxPeiYeRemodel> getListBrYzzxForShuYeByBqidRiqi(String bq, Date xzrq) {
		
		List<TwPeiyeczJilu> twPeiyeczJilus = twBryzzxDao.getListBrYzzxForShuYeByBqidRiqi(bq, xzrq);
		List<TwBryzzxPeiYeRemodel> twBryzzxPeiYeRemodels = new ArrayList<>();
		
		for(int i=0;i<twPeiyeczJilus.size();i++){
			TwBryzzxPeiYeRemodel twBryzzxPeiYeRemodel = new TwBryzzxPeiYeRemodel();
			
			TwPeiyeczJilu twPeiyeczJilu = twPeiyeczJilus.get(i);
			twBryzzxPeiYeRemodel.setBq(twPeiyeczJilu.getBq());
			twBryzzxPeiYeRemodel.setChw(twPeiyeczJilu.getChw());
			twBryzzxPeiYeRemodel.setGroupxh(twPeiyeczJilu.getGroupxh());
			twBryzzxPeiYeRemodel.setKey1(twPeiyeczJilu.getKey1());
			twBryzzxPeiYeRemodel.setKey2(twPeiyeczJilu.getKey2());
			String vrowkey = twPeiyeczJilu.getRowkey();
			vrowkey = vrowkey.replace(":", "q");
			twBryzzxPeiYeRemodel.setRowkey(vrowkey);
			twBryzzxPeiYeRemodel.setRq(twPeiyeczJilu.getRq());
			twBryzzxPeiYeRemodel.setSjd(twPeiyeczJilu.getSjd());
			twBryzzxPeiYeRemodel.setSjdtime(twPeiyeczJilu.getSjdtime());
			twBryzzxPeiYeRemodel.setYebh(twPeiyeczJilu.getYebh());
			twBryzzxPeiYeRemodel.setYzid(twPeiyeczJilu.getYzid());
			twBryzzxPeiYeRemodel.setYzmc(twPeiyeczJilu.getYzmc());
			twBryzzxPeiYeRemodel.setBah(twPeiyeczJilu.getBah());
			twBryzzxPeiYeRemodel.setNl(twPeiyeczJilu.getNl());
			twBryzzxPeiYeRemodel.setXb(twPeiyeczJilu.getXb());
			twBryzzxPeiYeRemodel.setXm(twPeiyeczJilu.getXm());
			
			String yzmc_s = twPeiyeczJilu.getYzmc();
			
			List<String> t_yzmcs = new ArrayList<String>();
			while(yzmc_s.indexOf("||") > 0){
				String sub_yzmc = yzmc_s.substring(0, yzmc_s.indexOf("||"));
				t_yzmcs.add(sub_yzmc);
				yzmc_s = yzmc_s.substring(yzmc_s.indexOf("||") + 2);
			}
			t_yzmcs.add(yzmc_s);
			twBryzzxPeiYeRemodel.setYzmcs(t_yzmcs);
			
			twBryzzxPeiYeRemodel.setYzzdmc(twPeiyeczJilu.getYzzdmc());
			twBryzzxPeiYeRemodel.setQdflag(twPeiyeczJilu.getQdflag());
			twBryzzxPeiYeRemodels.add(twBryzzxPeiYeRemodel);
			
		}
		return twBryzzxPeiYeRemodels;
	}

	@Override
	public TwBryzzx getTwBryzzxByRowkey(String rowkey) {
		return twBryzzxDao.getTwBryzzxByRowkey(rowkey);
	}

	@Override
	public void updateTwPeiyeczJiluByTwPeiyeczJilu(TwPeiyeczJilu twPeiyeczJilu) {
//		twBryzzxDao.updateTwPeiyeczJiluByTwPeiyeczJilu(twPeiyeczJilu);
		twBryzPeiYeDao.updateTwPeiyeczJiluByTwPeiyeczJilu(twPeiyeczJilu);
	}

	@Override
	public List<TwBryzzx_brxx_yzmcs_remodel> getListBrYzzxBrxxYzmcRemodel(
			List<TwBryzzx_brxx> twBryzzx_brxxs) {
		
		List<TwBryzzx_brxx_yzmcs_remodel> twBryzzx_brxx_yzmcs_remodels = new ArrayList<TwBryzzx_brxx_yzmcs_remodel>();
		for(int i=0;i < twBryzzx_brxxs.size(); i++){
			TwBryzzx_brxx_yzmcs_remodel twBryzzx_brxx_yzmcs_remodel = new TwBryzzx_brxx_yzmcs_remodel();
			TwBryzzx_brxx twBryzzx_brxx = twBryzzx_brxxs.get(i);
			twBryzzx_brxx_yzmcs_remodel.setBah(twBryzzx_brxx.getBah());
			twBryzzx_brxx_yzmcs_remodel.setBq(twBryzzx_brxx.getBq());
			twBryzzx_brxx_yzmcs_remodel.setChw(twBryzzx_brxx.getChw());
			twBryzzx_brxx_yzmcs_remodel.setCrl(twBryzzx_brxx.getCrl());
			twBryzzx_brxx_yzmcs_remodel.setCrlflag(twBryzzx_brxx.getCrlflag());
			twBryzzx_brxx_yzmcs_remodel.setGroupxh(twBryzzx_brxx.getGroupxh());
			twBryzzx_brxx_yzmcs_remodel.setKey1(twBryzzx_brxx.getKey1());
			twBryzzx_brxx_yzmcs_remodel.setKey2(twBryzzx_brxx.getKey2());
			twBryzzx_brxx_yzmcs_remodel.setLsflag(twBryzzx_brxx.getLsflag());
			twBryzzx_brxx_yzmcs_remodel.setNl(twBryzzx_brxx.getNl());
			String vrowkey = twBryzzx_brxx.getRowkey();
			vrowkey = vrowkey.replace(":", "q");
			twBryzzx_brxx_yzmcs_remodel.setRowkey(vrowkey);
			twBryzzx_brxx_yzmcs_remodel.setRq(twBryzzx_brxx.getRq());
			twBryzzx_brxx_yzmcs_remodel.setSjd(twBryzzx_brxx.getSjd());
			twBryzzx_brxx_yzmcs_remodel.setSjdtime(twBryzzx_brxx.getSjdtime());
			twBryzzx_brxx_yzmcs_remodel.setXb(twBryzzx_brxx.getXb());
			twBryzzx_brxx_yzmcs_remodel.setXm(twBryzzx_brxx.getXm());
			twBryzzx_brxx_yzmcs_remodel.setYebh(twBryzzx_brxx.getYebh());
			twBryzzx_brxx_yzmcs_remodel.setYf2mc(twBryzzx_brxx.getYf2mc());
			twBryzzx_brxx_yzmcs_remodel.setYzfsh(twBryzzx_brxx.getYzfsh());
			twBryzzx_brxx_yzmcs_remodel.setYzid(twBryzzx_brxx.getYzid());
			twBryzzx_brxx_yzmcs_remodel.setYzmc(twBryzzx_brxx.getYzmc());
			twBryzzx_brxx_yzmcs_remodel.setYzzdmc(twBryzzx_brxx.getYzzdmc());
			twBryzzx_brxx_yzmcs_remodel.setZxflag(twBryzzx_brxx.getZxflag());
			twBryzzx_brxx_yzmcs_remodel.setZxfldm(twBryzzx_brxx.getZxfldm());
			twBryzzx_brxx_yzmcs_remodel.setZxhsid(twBryzzx_brxx.getZxhsid());
			twBryzzx_brxx_yzmcs_remodel.setZxhsxm(twBryzzx_brxx.getZxhsxm());
			twBryzzx_brxx_yzmcs_remodel.setZxlb(twBryzzx_brxx.getZxlb());
			twBryzzx_brxx_yzmcs_remodel.setZxms(twBryzzx_brxx.getZxms());
			twBryzzx_brxx_yzmcs_remodel.setZxtime(twBryzzx_brxx.getZxtime());
			twBryzzx_brxx_yzmcs_remodel.setCzfl(twBryzzx_brxx.getCzfl());
			twBryzzx_brxx_yzmcs_remodel.setSyflag(twBryzzx_brxx.getSyflag());
			    
			List<String> t_yzmcs = new ArrayList<String>();
			String yzmc_s = twBryzzx_brxx.getYzmc();
			
			while(yzmc_s.indexOf("||") > 0){
				String sub_yzmc = yzmc_s.substring(0, yzmc_s.indexOf("||"));
				t_yzmcs.add(sub_yzmc);
				yzmc_s = yzmc_s.substring(yzmc_s.indexOf("||") + 2);
			}
			t_yzmcs.add(yzmc_s);
			twBryzzx_brxx_yzmcs_remodel.setYzmcs(t_yzmcs);
			
			twBryzzx_brxx_yzmcs_remodels.add(twBryzzx_brxx_yzmcs_remodel);
		}
		return twBryzzx_brxx_yzmcs_remodels;
	}

	@Override
	public void updateTwSyyzbzczJiluByTwSyyzbzczJilu(
			TwSyyzbzczJilu twSyyzbzczJilu) {
		twSyyzbzczJiluDao.updateTwSyyzbzczJilu(twSyyzbzczJilu);
	}

	@Override
	public List<TwBryzzx_brxx> getListBrYzzxBrxxByKeyZxfldm(long v_key1,
			int v_key2, short v_yebh, String zxfl, Date xzrq) {
		return twBryzzxDao.getListBrYzzxBrxxByKeyZxfldm(v_key1, v_key2, v_yebh, zxfl, xzrq);
	}
}
