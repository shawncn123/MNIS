package com.his.mnis.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.his.mnis.dao.VwBryzDao;
import com.his.mnis.entities.VwBryz;
import com.his.mnis.entities.VwBryzRemodel;
import com.his.mnis.entities.VwBryzRemodelSub;
import com.his.mnis.services.VwBryzService;

public class VwBryzServiceImpl implements VwBryzService {

	private VwBryzDao vwBryzDao;

	public VwBryzDao getVwBryzDao() {
		return vwBryzDao;
	}

	public void setVwBryzDao(VwBryzDao vwBryzDao) {
		this.vwBryzDao = vwBryzDao;
	}

	@Override
	public List<VwBryz> getListBrYzByKey(long v_key1, int v_key2, short v_yebh) {
		String proc_result = vwBryzDao.callProcedureBrYz(v_key1, v_key2);
		if ("1".equals(proc_result)) { // 1 表示失败
			return null;
		} else {
			return vwBryzDao.getListBrYzByKey(v_key1, v_key2, v_yebh);
		}
	}

	@Override
	public List<VwBryz> getListBrYzByKeyAndTiaoJian(long v_key1, int v_key2,
			short v_yebh, String v_tiaojianstr) {
		String proc_result = vwBryzDao.callProcedureBrYz(v_key1, v_key2);
		if ("1".equals(proc_result)) { // 1 表示失败
			return null;
		} else {
			return vwBryzDao.getListBrYzByKeyAndTiaoJian(v_key1, v_key2,
					v_yebh, v_tiaojianstr);
		}
	}

	private VwBryzRemodel vwBryzRemodel;
	private VwBryzRemodelSub vwBryzRemodelSub;
	private List<VwBryzRemodelSub> vwBryzRemodelSubs;
	private List<VwBryzRemodel> vwBryzRemodels;

	public VwBryzRemodel getVwBryzRemodel() {
		return vwBryzRemodel;
	}

	public void setVwBryzRemodel(VwBryzRemodel vwBryzRemodel) {
		this.vwBryzRemodel = vwBryzRemodel;
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

	public List<VwBryzRemodel> getVwBryzRemodels() {
		return vwBryzRemodels;
	}

	public void setVwBryzRemodels(List<VwBryzRemodel> vwBryzRemodels) {
		this.vwBryzRemodels = vwBryzRemodels;
	}

	@Override
	public List<VwBryzRemodel> getListBrYzRemodel(List<VwBryz> vwBryzs) {

		long v_groupxh = 0L;
		vwBryzRemodels = new ArrayList<VwBryzRemodel>();
		System.out.println("vwBryzs.size=" + vwBryzs.size());
		for (int i = 0; i < vwBryzs.size(); i++) {
			vwBryzRemodelSub = new VwBryzRemodelSub();
			if (vwBryzs.get(i).getGroupxh() == v_groupxh) {
				String v_yzmc = vwBryzs.get(i).getYzmc();
				String v_dcyl = vwBryzs.get(i).getDcyl();
				String v_resulttext = vwBryzs.get(i).getResulttext();
				
				System.out.println("groupxh:"
						+ vwBryzs.get(i).getGroupxh().toString());
				System.out.println("yzmc："+v_yzmc);
				System.out.println("dcyl："+v_dcyl);
				vwBryzRemodelSub.setYzmc(v_yzmc);
				vwBryzRemodelSub.setDcyl(v_dcyl);
				vwBryzRemodelSub.setResulttext(v_resulttext);
				
				vwBryzRemodelSubs.add(vwBryzRemodelSub);
			} else {
				System.out.println("groupxh_bt:"
						+ vwBryzs.get(i).getGroupxh().toString());
				v_groupxh = vwBryzs.get(i).getGroupxh();
				if (i > 0) {
					vwBryzRemodel.setVwBryzRemodelSubs(vwBryzRemodelSubs);
					System.out.println("iiiiiyf1mc："+vwBryzRemodel.getYf1mc());
					vwBryzRemodels.add(vwBryzRemodel);
					for(int sl1=0;sl1 < vwBryzRemodels.size();sl1++){
						System.out.println(sl1+":"+vwBryzRemodels.get(sl1).getYf1mc());
					}
					vwBryzRemodelSubs = new ArrayList<VwBryzRemodelSub>();
//					for (int j = 0; j < vwBryzRemodelSubs.size(); j++) {
//						vwBryzRemodelSubs.remove(j);
//					}
				}
				if(i==0){
					vwBryzRemodelSubs = new ArrayList<VwBryzRemodelSub>();
					
				}
				vwBryzRemodel = new VwBryzRemodel();
				System.out.println(vwBryzRemodel);
				vwBryzRemodel.setKey1(vwBryzs.get(i).getKey1());
				vwBryzRemodel.setKey2(vwBryzs.get(i).getKey2());
				vwBryzRemodel.setYebh(vwBryzs.get(i).getYebh());
				vwBryzRemodel.setGroupxh(vwBryzs.get(i).getGroupxh());
				vwBryzRemodel.setXsxh(vwBryzs.get(i).getXsxh());
				vwBryzRemodel.setYzzt(vwBryzs.get(i).getYzzt());
				vwBryzRemodel.setKstime(vwBryzs.get(i).getKstime());
				vwBryzRemodel.setLsflag(vwBryzs.get(i).getLsflag());
				vwBryzRemodel.setYzly(vwBryzs.get(i).getYzly());
				vwBryzRemodel.setTzflag(vwBryzs.get(i).getTzflag());
				vwBryzRemodel.setLb(vwBryzs.get(i).getLb());
				vwBryzRemodel.setYf2mc(vwBryzs.get(i).getYf2mc());
				vwBryzRemodel.setZxsjms(vwBryzs.get(i).getZxsjms());
				vwBryzRemodel.setYf1mc(vwBryzs.get(i).getYf1mc());
				System.out.println("yf1mc："+vwBryzs.get(i).getYf1mc());
				vwBryzRemodel.setYszt(vwBryzs.get(i).getYszt());
				vwBryzRemodel.setPwflag(vwBryzs.get(i).getPwflag());
				vwBryzRemodel.setPwyzxh(vwBryzs.get(i).getPwyzxh());
				vwBryzRemodel.setYsxm(vwBryzs.get(i).getYsxm());
				vwBryzRemodel.setTztime(vwBryzs.get(i).getTztime());
//				vwBryzRemodel.setResulttext(vwBryzs.get(i).getResulttext());
				vwBryzRemodel.setBgflag(vwBryzs.get(i).getBgflag());

				vwBryzRemodelSub.setDcyl(vwBryzs.get(i).getDcyl());
				vwBryzRemodelSub.setYzmc(vwBryzs.get(i).getYzmc());
				System.out.println("yzmc："+vwBryzs.get(i).getYzmc());
				System.out.println("dcyl："+vwBryzs.get(i).getDcyl());
				vwBryzRemodelSubs.add(vwBryzRemodelSub);
				for(int sl2=0;sl2 < vwBryzRemodels.size();sl2++){
					System.out.println("222"+sl2+":"+vwBryzRemodels.get(sl2).getYf1mc());
				}
			}
		}
		vwBryzRemodels.add(vwBryzRemodel);
		for(int sl=0;sl < vwBryzRemodels.size();sl++){
			System.out.println(sl+":"+vwBryzRemodels.get(sl).getYf1mc());
		}
		return vwBryzRemodels;
	}

}
