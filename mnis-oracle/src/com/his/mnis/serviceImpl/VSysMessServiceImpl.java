package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.VSysMessDao;
import com.his.mnis.entities.VSysMessReader;
import com.his.mnis.services.VSysMessService;

public class VSysMessServiceImpl implements VSysMessService {

	private VSysMessDao vSysMessDao;
	
	public VSysMessDao getvSysMessDao() {
		return vSysMessDao;
	}

	public void setvSysMessDao(VSysMessDao vSysMessDao) {
		this.vSysMessDao = vSysMessDao;
	}

	@Override
	public List<VSysMessReader> getListSysMessByRenyId(String renyid,
			int pageno, int pagerows) {
		
		return vSysMessDao.getListSysMessByRenyId(renyid, pageno, pagerows);
		
	}

	@Override
	public List<VSysMessReader> getListSysMessByRenyIdZhuangt(String renyid,
			int pageno, int pagerows, String readflag) {
		return vSysMessDao.getListSysMessByRenyIdZhuangt(renyid, pageno, pagerows, readflag);
	}

	@Override
	public String queDingXiaoXiYiDu(String messid, String ryid) {
		return vSysMessDao.queDingXiaoXiYiDu(messid, ryid);
	}

	@Override
	public List<VSysMessReader> getListMessageGuoQiWeiDu(String renyid,
			int pageno, int pagerows) {
		return vSysMessDao.getListSysMessByRenyIdGcwd(renyid, pageno, pagerows);
	}

	@Override
	public int getCountSysMessByRenyIdZhuangt(String renyid) {
		
		return vSysMessDao.getCountSysMessByRenyIdZhuangt(renyid);
	}

	@Override
	public int getCountsSysMessByRenyId(String renyid) {
		return vSysMessDao.getCountsSysMessByRenyId(renyid);
	}

	@Override
	public int getCountsGuoQiSysMessByRenyId(String renyid) {
		return vSysMessDao.getCountsGuoQiSysMessByRenyId(renyid);
	}

}
