package com.his.mnis.services;

import java.util.List;

import com.his.mnis.dao.VmBqbrDao;
import com.his.mnis.entities.VmBqbr;

public class VmBqbrService {
	
	private VmBqbrDao vmBqbrDao;
	
	public void setVmBqbrDao(VmBqbrDao vmBqbrDao) {
		this.vmBqbrDao = vmBqbrDao;
	}


	public List<VmBqbr> getBrByBmid(Long keshi_id){
		return vmBqbrDao.getBrByBmid(keshi_id);
	}
	
}
