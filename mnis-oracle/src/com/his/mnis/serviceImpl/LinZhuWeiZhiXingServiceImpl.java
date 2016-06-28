package com.his.mnis.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.his.mnis.dao.LinZhuWeiZhiXingDao;
import com.his.mnis.dao.TwWdbrDao;
import com.his.mnis.entities.LinZhuWeiZhiXingRemodel;
import com.his.mnis.entities.MyBingRen;
import com.his.mnis.entities.TwBryzzx;
import com.his.mnis.entities.VwBryz;
import com.his.mnis.entities.VwBryzRemodelSub;
import com.his.mnis.services.LinZhuWeiZhiXingService;
import com.his.mnis.services.TwWdbrService;
import com.his.mnis.services.VwBryzService;

public class LinZhuWeiZhiXingServiceImpl implements LinZhuWeiZhiXingService {
	
	private VwBryzService vwBryzService;
	private TwWdbrService twWdbrService;
	private LinZhuWeiZhiXingDao linZhuWeiZhiXingDao;
	private TwWdbrDao twWdbrDao;
	
	public TwWdbrDao getTwWdbrDao() {
		return twWdbrDao;
	}

	public void setTwWdbrDao(TwWdbrDao twWdbrDao) {
		this.twWdbrDao = twWdbrDao;
	}

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
	public List<TwBryzzx> getListMyBingRenWeiZxlz(String hsid) {

		List<TwBryzzx> twBryzzx = linZhuWeiZhiXingDao.getWeiWanChengLinzByHsId(hsid);
		return twBryzzx;
		
	}
	
	private LinZhuWeiZhiXingRemodel linZhuWeiZhiXingRemodel;
	private VwBryzRemodelSub vwBryzRemodelSub;
	private List<VwBryzRemodelSub> vwBryzRemodelSubs;
	private List<LinZhuWeiZhiXingRemodel> linZhuWeiZhiXingRemodels;
	private List<MyBingRen> myBingRens;

	public List<MyBingRen> getMyBingRens() {
		return myBingRens;
	}

	public void setMyBingRens(List<MyBingRen> myBingRens) {
		this.myBingRens = myBingRens;
	}

	public LinZhuWeiZhiXingRemodel getLinZhuWeiZhiXingRemodel() {
		return linZhuWeiZhiXingRemodel;
	}

	public void setLinZhuWeiZhiXingRemodel(
			LinZhuWeiZhiXingRemodel linZhuWeiZhiXingRemodel) {
		this.linZhuWeiZhiXingRemodel = linZhuWeiZhiXingRemodel;
	}

	public VwBryzRemodelSub getVwBryzRemodelSub() {
		return vwBryzRemodelSub;
	}

	public void setVwBryzRemodelSub(VwBryzRemodelSub vwBryzRemodelSub) {
		this.vwBryzRemodelSub = vwBryzRemodelSub;
	}

	public List<VwBryzRemodelSub> getVwBryzRemodelSubs() {
		return vwBryzRemodelSubs;
	}

	public void setVwBryzRemodelSubs(List<VwBryzRemodelSub> vwBryzRemodelSubs) {
		this.vwBryzRemodelSubs = vwBryzRemodelSubs;
	}

	public List<LinZhuWeiZhiXingRemodel> getLinZhuWeiZhiXingRemodels() {
		return linZhuWeiZhiXingRemodels;
	}

	public void setLinZhuWeiZhiXingRemodels(
			List<LinZhuWeiZhiXingRemodel> linZhuWeiZhiXingRemodels) {
		this.linZhuWeiZhiXingRemodels = linZhuWeiZhiXingRemodels;
	}

	@Override
	public List<LinZhuWeiZhiXingRemodel> getListBrYzRemodel(List<VwBryz> vwBryzs,String hsid) {
		long v_groupxh = 0L;
		
		myBingRens = twWdbrDao.getMyBingRenByCzryId(hsid);
		linZhuWeiZhiXingRemodels = new ArrayList<LinZhuWeiZhiXingRemodel>();
		for (int i = 0; i < vwBryzs.size(); i++) {
			vwBryzRemodelSub = new VwBryzRemodelSub();
			if (vwBryzs.get(i).getGroupxh() == v_groupxh) {
				String v_yzmc = vwBryzs.get(i).getYzmc();
				String v_dcyl = vwBryzs.get(i).getDcyl();
				String v_resulttext = vwBryzs.get(i).getResulttext();
				
				vwBryzRemodelSub.setYzmc(v_yzmc);
				vwBryzRemodelSub.setDcyl(v_dcyl);
				vwBryzRemodelSub.setResulttext(v_resulttext);
				
				vwBryzRemodelSubs.add(vwBryzRemodelSub);
			} else {
				System.out.println("groupxh_bt:"
						+ vwBryzs.get(i).getGroupxh().toString());
				
				v_groupxh = vwBryzs.get(i).getGroupxh();
				
				if (i > 0) {
					linZhuWeiZhiXingRemodel.setVwBryzRemodelSubs(vwBryzRemodelSubs);
					linZhuWeiZhiXingRemodels.add(linZhuWeiZhiXingRemodel);
//					for(int sl1=0;sl1 < vwBryzRemodels.size();sl1++){
//						System.out.println(sl1+":"+vwBryzRemodels.get(sl1).getYf1mc());
//					}
					vwBryzRemodelSubs = new ArrayList<VwBryzRemodelSub>();
				}
				
				if(i==0){
					vwBryzRemodelSubs = new ArrayList<VwBryzRemodelSub>();
				}
				
				linZhuWeiZhiXingRemodel = new LinZhuWeiZhiXingRemodel();
				System.out.println(linZhuWeiZhiXingRemodel);
				linZhuWeiZhiXingRemodel.setKey1(vwBryzs.get(i).getKey1());
				linZhuWeiZhiXingRemodel.setKey2(vwBryzs.get(i).getKey2());
				linZhuWeiZhiXingRemodel.setYebh(vwBryzs.get(i).getYebh());
				for(int x=0;x<myBingRens.size();x++){
					MyBingRen myBingRen = myBingRens.get(x);
					long key1_tmp = myBingRen.getKey1();
					int key2_tmp = myBingRen.getKey2();
					if(key1_tmp==vwBryzs.get(i).getKey1()&&key2_tmp==vwBryzs.get(i).getKey2()){
						linZhuWeiZhiXingRemodel.setChw(myBingRen.getChw());
						break;
					}
				}
				linZhuWeiZhiXingRemodel.setGroupxh(vwBryzs.get(i).getGroupxh());
				linZhuWeiZhiXingRemodel.setXsxh(vwBryzs.get(i).getXsxh());
				linZhuWeiZhiXingRemodel.setYzzt(vwBryzs.get(i).getYzzt());
				linZhuWeiZhiXingRemodel.setKstime(vwBryzs.get(i).getKstime());
				linZhuWeiZhiXingRemodel.setLsflag(vwBryzs.get(i).getLsflag());
				linZhuWeiZhiXingRemodel.setYzly(vwBryzs.get(i).getYzly());
				linZhuWeiZhiXingRemodel.setTzflag(vwBryzs.get(i).getTzflag());
				linZhuWeiZhiXingRemodel.setLb(vwBryzs.get(i).getLb());
				linZhuWeiZhiXingRemodel.setYf2mc(vwBryzs.get(i).getYf2mc());
				linZhuWeiZhiXingRemodel.setZxsjms(vwBryzs.get(i).getZxsjms());
				linZhuWeiZhiXingRemodel.setYf1mc(vwBryzs.get(i).getYf1mc());
				System.out.println("yf1mc："+vwBryzs.get(i).getYf1mc());
				linZhuWeiZhiXingRemodel.setYszt(vwBryzs.get(i).getYszt());
				linZhuWeiZhiXingRemodel.setPwflag(vwBryzs.get(i).getPwflag());
				linZhuWeiZhiXingRemodel.setPwyzxh(vwBryzs.get(i).getPwyzxh());
				linZhuWeiZhiXingRemodel.setYsxm(vwBryzs.get(i).getYsxm());
				linZhuWeiZhiXingRemodel.setTztime(vwBryzs.get(i).getTztime());
//				linZhuWeiZhiXingRemodel.setResulttext(vwBryzs.get(i).getResulttext());
				linZhuWeiZhiXingRemodel.setBgflag(vwBryzs.get(i).getBgflag());

				vwBryzRemodelSub.setDcyl(vwBryzs.get(i).getDcyl());
				vwBryzRemodelSub.setYzmc(vwBryzs.get(i).getYzmc());
				System.out.println("yzmc："+vwBryzs.get(i).getYzmc());
				System.out.println("dcyl："+vwBryzs.get(i).getDcyl());
				vwBryzRemodelSubs.add(vwBryzRemodelSub);
				for(int sl2=0;sl2 < linZhuWeiZhiXingRemodels.size();sl2++){
					System.out.println("222"+sl2+":"+linZhuWeiZhiXingRemodels.get(sl2).getYf1mc());
				}
			}
		}
		linZhuWeiZhiXingRemodel.setVwBryzRemodelSubs(vwBryzRemodelSubs);
		linZhuWeiZhiXingRemodels.add(linZhuWeiZhiXingRemodel);
		return linZhuWeiZhiXingRemodels;
	}

}
