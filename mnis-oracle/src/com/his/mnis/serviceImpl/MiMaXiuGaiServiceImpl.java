package com.his.mnis.serviceImpl;

import com.his.mnis.dao.MiMaXiuGaiDao;
import com.his.mnis.dao.VwRybqDao;
import com.his.mnis.services.MiMaXiuGaiService;

public class MiMaXiuGaiServiceImpl implements MiMaXiuGaiService {

	private VwRybqDao vwRybqDao;
	private MiMaXiuGaiDao miMaXiuGaiDao;
	
	public MiMaXiuGaiDao getMiMaXiuGaiDao() {
		return miMaXiuGaiDao;
	}

	public void setMiMaXiuGaiDao(MiMaXiuGaiDao miMaXiuGaiDao) {
		this.miMaXiuGaiDao = miMaXiuGaiDao;
	}

	public VwRybqDao getVwRybqDao() {
		return vwRybqDao;
	}

	public void setVwRybqDao(VwRybqDao vwRybqDao) {
		this.vwRybqDao = vwRybqDao;
	}

	

	@Override
	public String huShiXiuGaiMiMa(String czydm, String oldpass, String newpass) {
		// 验证旧密码是否正确
		String check =  vwRybqDao.callProcedurePW_Identify(czydm, oldpass);
		if(check.equals("1")){
			return "oldpasserror";
		}else{
			//修改密码
			String vrs = miMaXiuGaiDao.callProcedureModifyPassWord(czydm, oldpass, newpass);
			if(vrs.equals("0")){
				return "0";
			}else{
				return "1";
			}
		}
	}
}
