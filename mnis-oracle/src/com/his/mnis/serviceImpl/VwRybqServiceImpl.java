package com.his.mnis.serviceImpl;

import java.util.List;

import com.his.mnis.dao.RyBqDefaultDao;
import com.his.mnis.dao.VwBqbrZyDao;
import com.his.mnis.dao.VwRybqDao;
import com.his.mnis.entities.RybqDefault;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.entities.VwRybq;
import com.his.mnis.services.VwRybqService;

public class VwRybqServiceImpl implements VwRybqService {

	/*Auther：ShenXufeng
	 * 功能：
	 * listBingQuByCaozyId： 根据 caozyid-人员id 查询操作员病区
	 * listBingrByCaozyId： 根据caozyid-人员id 获取相应病区Id 查到相应病区id－1.上次登录的病区ID，2.缺省病区ID，3、排第一位的病区id，然后获取对应的病人信息
	 * getBingQuMingCheng(String bqid) 根据病区id获取病区名称
	 */
	
	private RyBqDefaultDao ryBqDefaultDao;
	
	private VwRybqDao vwRybqDao;
	
	private VwBqbrZyDao vwBqbrZyDao;
	
	public void setVwBqbrZyDao(VwBqbrZyDao vwBqbrZyDao) {
		this.vwBqbrZyDao = vwBqbrZyDao;
	}
	
	

	public void setRyBqDefaultDao(RyBqDefaultDao ryBqDefaultDao) {
		this.ryBqDefaultDao = ryBqDefaultDao;
	}
	
	public void setVwRybqDao(VwRybqDao vwRybqDao) {
		this.vwRybqDao = vwRybqDao;
	}
	
	@Override
	public List<VwBqbrZy> listBingrByBingQuId(String bingquid) {

//		4.操作员id加病区ID取出病人列表
		return vwBqbrZyDao.getListVwBqbrZyByBqid(bingquid);
		
//		return null;
	}

	@Override
	public List<VwRybq> listBingQuByCaozyId(String caozyid) {

		return vwRybqDao.getListBingQu(caozyid);
	}
	
	
//	根据人员代码(登录的操作员代码) 获取对应人员id
	@Override
	public VwRybq getRenYuanIdByRenYuanDaiMa(String renYuanDaiMa) {
		return vwRybqDao.getRenYuanIdByCaozyDaiMa(renYuanDaiMa);
	}

//	根据人员代码(登录的操作员代码) 获取对应操作病区id
	@Override
	public String getCaoZuoBingQuIdByCaozyId(String caozyid) {
		
		String bqId;
		
//		1.是否有上次退出病区记录
		RybqDefault ryBqDefault = ryBqDefaultDao.getRyBqDefaultById(caozyid);
		
		if(ryBqDefault == null){
//		2.是否有缺省病区id
			VwRybq vwRybq = vwRybqDao.getDefaultBingQuByCaozyId(caozyid);
			if(vwRybq == null){
//		3.最后取第一条病区记录
				List<VwRybq> vwRyBqs = vwRybqDao.getListBingQu(caozyid);
			    if(vwRyBqs != null){
			    	bqId = vwRyBqs.get(0).getBq();
			    }else{
			    	return null;
			    }
			}else{
				bqId = vwRybq.getBq();
			}
		}else {
			bqId = ryBqDefault.getBq();
		}
		System.out.println(bqId.toString());
		return bqId;
	}


/*
 * (non-Javadoc)
 * @see com.his.mnis.services.VwRybqService#getBingQuMingCheng(java.lang.String)
 */
	@Override
	public String getBingQuMingCheng(String bqid) {
		
		return vwRybqDao.getBingQuMingCheng(bqid);
		
	}



	@Override
	public String callProcedurePW_Identify(String czydm, String mima) {
		return vwRybqDao.callProcedurePW_Identify(czydm, mima);
	}

}
