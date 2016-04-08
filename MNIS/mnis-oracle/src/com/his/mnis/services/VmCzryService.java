package com.his.mnis.services;

import com.his.mnis.dao.VmCzryDao;
import com.his.mnis.entities.VmCzry;

public class VmCzryService {
	private VmCzryDao vmCzryDao;

	public void setVmCzryDao(VmCzryDao vmCzryDao) {
		this.vmCzryDao = vmCzryDao;
	}
	
	public VmCzry checkCzry(String yonghuming,String renyuan_bianma){
		System.out.println("checkCzry");
		return vmCzryDao.getVmCzryByName(yonghuming, renyuan_bianma);
	}
}
