package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.VwBqbrZyDao;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.VwBqbrZyService;

public class VwBqbrZyServiceImpl implements VwBqbrZyService {
	
	private VwBqbrZyDao vwBqbrZyDao;
	

	public VwBqbrZyDao getVwBqbrZyDao() {
		return vwBqbrZyDao;
	}

	public void setVwBqbrZyDao(VwBqbrZyDao vwBqbrZyDao) {
		this.vwBqbrZyDao = vwBqbrZyDao;
	}
	
	@Override
	public List<VwBqbrZy> listBingqBingrByBingqId(String bingqbm) {
		
		return vwBqbrZyDao.getListVwBqbrZyByBqid(bingqbm);
	}

	@Override
	public VwBqbrZy getBingRenXingXiByKey(Long key1, Integer key2) {
		
		return vwBqbrZyDao.getBingRenXingXiByKey(key1, key2);
		
	}

	@Override
	public VwBqbrZy getBingRenXingXiByWanDai(String wandaixx) {
		System.out.println("wandaixx:"+wandaixx);
		try {
//			wandaixx = "key1=23620&key2=3";
//			int k2 = wandaixx.indexOf("&KEY2");
//			System.out.println("key1:"+k2);
//			String v_key1=wandaixx.substring(5, k2);
//			System.out.println("v_key1:"+v_key1);
//			Long vkey1 = Long.parseLong(v_key1);
//			String v_key2 = wandaixx.substring(k2+6);
//			System.out.println("v_key2:"+v_key2);
//			Integer vkey2 = Integer.parseInt(v_key2);
			
			char fc = wandaixx.charAt(0);
			if(fc=='b' || fc =='B'){
				System.out.println("取第一个字符："+ fc);
				int k1 = wandaixx.indexOf("-");
				String v_key1=wandaixx.substring(1, k1);
				System.out.println("v_key1:"+v_key1);
				Long vkey1 = Long.parseLong(v_key1);
				wandaixx = wandaixx.substring(k1+1);
				System.out.println("wandaixx:"+wandaixx);
				int k2 = wandaixx.indexOf("-");
				String v_key2=wandaixx.substring(0, k2);
				Integer vkey2 = Integer.parseInt(v_key2);
				return vwBqbrZyDao.getBingRenXingXiByKey(vkey1, vkey2);
			}else{
				System.out.println("不是病人："+ fc);
				return null;
			}
//					indexOf("");
//			System.out.println("key1:"+k2);
//			String v_key1=wandaixx.substring(5, k2);
//			System.out.println("v_key1:"+v_key1);
//			Long vkey1 = Long.parseLong(v_key1);
//			String v_key2 = wandaixx.substring(k2+6);
//			System.out.println("v_key2:"+v_key2);
//			Integer vkey2 = Integer.parseInt(v_key2);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<VwBqbrZy> listMyBingrByBqIdHsId(String bingqbm, String hsid) {
		
		return vwBqbrZyDao.getListWoDeBingRenByBqidHsId(bingqbm, hsid);
	}

	@Override
	public List<VwBqbrZy> listZeRenBingrByBqIdHsXm(String bingqbm, String hsxm) {
		return vwBqbrZyDao.getListZeRenBingRenByBqidHsxm(bingqbm, hsxm);
	}

}
