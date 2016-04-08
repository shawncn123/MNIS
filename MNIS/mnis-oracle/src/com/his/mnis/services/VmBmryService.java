package com.his.mnis.services;

import java.util.List;

import com.his.mnis.dao.VmBmryDao;
import com.his.mnis.entities.VmBmry;

public class VmBmryService {

	private VmBmryDao vmBmryDao;

	public void setVmBmryDao(VmBmryDao vmBmryDao) {
		this.vmBmryDao = vmBmryDao;
	}
	
	public List<VmBmry> getBmById(Long czy_id){
		System.out.println("bmservices");
		return vmBmryDao.getBmById(czy_id);
	}
	public List<VmBmry> test(){
		System.out.println("bmservices1");
		return vmBmryDao.test();
	}
	
}
