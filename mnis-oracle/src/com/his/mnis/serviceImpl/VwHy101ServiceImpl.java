package com.his.mnis.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.his.mnis.dao.VwHy1011Dao;
import com.his.mnis.dao.VwHy101Dao;
import com.his.mnis.entities.BingRenHuaYanXingXi;
import com.his.mnis.entities.VwHy101;
import com.his.mnis.entities.VwHy1011;
import com.his.mnis.services.VwHy101Service;

public class VwHy101ServiceImpl implements VwHy101Service {
	
	private VwHy101Dao vwHy101Dao;
	private VwHy1011Dao vwHy1011Dao;

	public VwHy1011Dao getVwHy1011Dao() {
		return vwHy1011Dao;
	}

	public void setVwHy1011Dao(VwHy1011Dao vwHy1011Dao) {
		this.vwHy1011Dao = vwHy1011Dao;
	}

	public VwHy101Dao getVwHy101Dao() {
		return vwHy101Dao;
	}

	public void setVwHy101Dao(VwHy101Dao vwHy101Dao) {
		this.vwHy101Dao = vwHy101Dao;
	}

	@Override
	public List<VwHy101> getListBingRenHuaYanByKey(Long key1, Integer key2,Short key3) {
		return vwHy101Dao.getListBingRenHuaYanByKey(key1, key2, key3);
	}

	@Override
	public List<VwHy101> getListHuaYanDanByShenqysAndKey(String sqysid,
			Long key1, Integer key2,Short key3) {
		return vwHy101Dao.getListHuaYanDanByShenqysAndKey(sqysid, key1, key2,key3);
	}

	@Override
	public List<BingRenHuaYanXingXi> getListBingRenHuaYanByDate(Date sqrq,Long key1, Integer key2,Short key3) {
		
		List<BingRenHuaYanXingXi> bingRenHuaYanXingXis = new ArrayList<>();
		List<VwHy101> vwHy101s = vwHy101Dao.getListBingRenHuaYanByDate(sqrq, key1, key2,key3);
		if(vwHy101s.size()>0){
			for(int i=0; i<vwHy101s.size();i++){
				BingRenHuaYanXingXi bingRenHuaYanXingXi = new BingRenHuaYanXingXi();
				List<VwHy1011> vwHy1011s = null;
				String vsqdh = vwHy101s.get(i).getSqdh();
				try {
					vwHy1011s = vwHy1011Dao.getListBingrHuayChongb(vsqdh);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String wjpd="0";
				for(int j=0; j<vwHy1011s.size();j++){
					wjpd = vwHy1011s.get(j).getWjflag();
					if(wjpd.equals("1")){
						bingRenHuaYanXingXi.setWjflag(wjpd);
						break;
					}
				}
				bingRenHuaYanXingXi.setSqdh(vwHy101s.get(i).getSqdh());
				bingRenHuaYanXingXi.setKey1(vwHy101s.get(i).getKey1());
				bingRenHuaYanXingXi.setKey2(vwHy101s.get(i).getKey2());
				bingRenHuaYanXingXi.setYebh(vwHy101s.get(i).getYebh());
				bingRenHuaYanXingXi.setJjflag(vwHy101s.get(i).getJjflag());
				bingRenHuaYanXingXi.setSqrq(vwHy101s.get(i).getSqrq());
				bingRenHuaYanXingXi.setSqsj(vwHy101s.get(i).getSqsj());
				bingRenHuaYanXingXi.setBq(vwHy101s.get(i).getBq());
				bingRenHuaYanXingXi.setChw(vwHy101s.get(i).getChw());
				bingRenHuaYanXingXi.setBah(vwHy101s.get(i).getBah());
				bingRenHuaYanXingXi.setXm(vwHy101s.get(i).getXm());
				bingRenHuaYanXingXi.setXb(vwHy101s.get(i).getXb());
				bingRenHuaYanXingXi.setNl(vwHy101s.get(i).getNl());
				bingRenHuaYanXingXi.setSqysid(vwHy101s.get(i).getSqysid());
				bingRenHuaYanXingXi.setSqysxm(vwHy101s.get(i).getSqysxm());
				bingRenHuaYanXingXi.setSqksid(vwHy101s.get(i).getSqksid());
				bingRenHuaYanXingXi.setSqksmc(vwHy101s.get(i).getSqksmc());
				bingRenHuaYanXingXi.setCzksid(vwHy101s.get(i).getCzksid());
				bingRenHuaYanXingXi.setCzksmc(vwHy101s.get(i).getCzksmc());
				bingRenHuaYanXingXi.setBbmc(vwHy101s.get(i).getBbmc());
				bingRenHuaYanXingXi.setXmms(vwHy101s.get(i).getXmms());
				bingRenHuaYanXingXi.setZxflag(vwHy101s.get(i).getZxflag());
				bingRenHuaYanXingXi.setBgbz(vwHy101s.get(i).getBgbz());
				bingRenHuaYanXingXi.setVwHy1011s(vwHy1011s);
				bingRenHuaYanXingXis.add(bingRenHuaYanXingXi);
			}
			return bingRenHuaYanXingXis;
		}
		return null;
	}

	@Override
	public List<BingRenHuaYanXingXi> getListHuaYanAllByKey(Long key1,
			Integer key2, Short key3) {
		List<BingRenHuaYanXingXi> bingRenHuaYanXingXis = new ArrayList<>();
		List<VwHy101> vwHy101s = vwHy101Dao.getListBingRenHuaYanByKey(key1, key2,key3);
		if(vwHy101s.size()>0){
			for(int i=0; i<vwHy101s.size();i++){
				BingRenHuaYanXingXi bingRenHuaYanXingXi = new BingRenHuaYanXingXi();
				List<VwHy1011> vwHy1011s = null;
				String vsqdh = vwHy101s.get(i).getSqdh();
				try {
					vwHy1011s = vwHy1011Dao.getListBingrHuayChongb(vsqdh);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String wjpd="0";
				for(int j=0; j<vwHy1011s.size();j++){
					wjpd = vwHy1011s.get(j).getWjflag();
					if(wjpd.equals("1")){
						bingRenHuaYanXingXi.setWjflag(wjpd);
						break;
					}
				}
				bingRenHuaYanXingXi.setSqdh(vwHy101s.get(i).getSqdh());
				bingRenHuaYanXingXi.setKey1(vwHy101s.get(i).getKey1());
				bingRenHuaYanXingXi.setKey2(vwHy101s.get(i).getKey2());
				bingRenHuaYanXingXi.setYebh(vwHy101s.get(i).getYebh());
				bingRenHuaYanXingXi.setJjflag(vwHy101s.get(i).getJjflag());
				bingRenHuaYanXingXi.setSqrq(vwHy101s.get(i).getSqrq());
				bingRenHuaYanXingXi.setSqsj(vwHy101s.get(i).getSqsj());
				bingRenHuaYanXingXi.setBq(vwHy101s.get(i).getBq());
				bingRenHuaYanXingXi.setChw(vwHy101s.get(i).getChw());
				bingRenHuaYanXingXi.setBah(vwHy101s.get(i).getBah());
				bingRenHuaYanXingXi.setXm(vwHy101s.get(i).getXm());
				bingRenHuaYanXingXi.setXb(vwHy101s.get(i).getXb());
				bingRenHuaYanXingXi.setNl(vwHy101s.get(i).getNl());
				bingRenHuaYanXingXi.setSqysid(vwHy101s.get(i).getSqysid());
				bingRenHuaYanXingXi.setSqysxm(vwHy101s.get(i).getSqysxm());
				bingRenHuaYanXingXi.setSqksid(vwHy101s.get(i).getSqksid());
				bingRenHuaYanXingXi.setSqksmc(vwHy101s.get(i).getSqksmc());
				bingRenHuaYanXingXi.setCzksid(vwHy101s.get(i).getCzksid());
				bingRenHuaYanXingXi.setCzksmc(vwHy101s.get(i).getCzksmc());
				bingRenHuaYanXingXi.setBbmc(vwHy101s.get(i).getBbmc());
				bingRenHuaYanXingXi.setXmms(vwHy101s.get(i).getXmms());
				bingRenHuaYanXingXi.setZxflag(vwHy101s.get(i).getZxflag());
				bingRenHuaYanXingXi.setBgbz(vwHy101s.get(i).getBgbz());
				bingRenHuaYanXingXi.setVwHy1011s(vwHy1011s);
				bingRenHuaYanXingXis.add(bingRenHuaYanXingXi);
			}
			return bingRenHuaYanXingXis;
		}
		return null;
	}

	@Override
	public List<BingRenHuaYanXingXi> getListHuaYanWeiJiAllByKey(Long key1,
			Integer key2, Short key3) {
		List<BingRenHuaYanXingXi> bingRenHuaYanXingXis = new ArrayList<>();
		List<VwHy101> vwHy101s = vwHy101Dao.getListBingRenHuaYanByKey(key1, key2, key3);
		System.out.println("vwHy101s.size():" + vwHy101s.size());
		if(vwHy101s.size()>0){
			for(int i=0; i<vwHy101s.size();i++){
				BingRenHuaYanXingXi bingRenHuaYanXingXi = new BingRenHuaYanXingXi();
				List<VwHy1011> vwHy1011s = null;
				String vsqdh = vwHy101s.get(i).getSqdh();
				try {
					vwHy1011s = vwHy1011Dao.getListBingrHuayChongb(vsqdh);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//判断从表是否有危急值的记录，如果有，则添加到list中
				String wjpd = "0";
				for(int j=0; j<vwHy1011s.size();j++){
					wjpd = vwHy1011s.get(j).getWjflag();
					if(wjpd.equals("1")){
						bingRenHuaYanXingXi.setSqdh(vwHy101s.get(i).getSqdh());
						bingRenHuaYanXingXi.setKey1(vwHy101s.get(i).getKey1());
						bingRenHuaYanXingXi.setKey2(vwHy101s.get(i).getKey2());
						bingRenHuaYanXingXi.setYebh(vwHy101s.get(i).getYebh());
						bingRenHuaYanXingXi.setJjflag(vwHy101s.get(i).getJjflag());
						bingRenHuaYanXingXi.setSqrq(vwHy101s.get(i).getSqrq());
						bingRenHuaYanXingXi.setSqsj(vwHy101s.get(i).getSqsj());
						bingRenHuaYanXingXi.setBq(vwHy101s.get(i).getBq());
						bingRenHuaYanXingXi.setChw(vwHy101s.get(i).getChw());
						bingRenHuaYanXingXi.setBah(vwHy101s.get(i).getBah());
						bingRenHuaYanXingXi.setXm(vwHy101s.get(i).getXm());
						bingRenHuaYanXingXi.setXb(vwHy101s.get(i).getXb());
						bingRenHuaYanXingXi.setNl(vwHy101s.get(i).getNl());
						bingRenHuaYanXingXi.setSqysid(vwHy101s.get(i).getSqysid());
						bingRenHuaYanXingXi.setSqysxm(vwHy101s.get(i).getSqysxm());
						bingRenHuaYanXingXi.setSqksid(vwHy101s.get(i).getSqksid());
						bingRenHuaYanXingXi.setSqksmc(vwHy101s.get(i).getSqksmc());
						bingRenHuaYanXingXi.setCzksid(vwHy101s.get(i).getCzksid());
						bingRenHuaYanXingXi.setCzksmc(vwHy101s.get(i).getCzksmc());
						bingRenHuaYanXingXi.setBbmc(vwHy101s.get(i).getBbmc());
						bingRenHuaYanXingXi.setXmms(vwHy101s.get(i).getXmms());
						bingRenHuaYanXingXi.setZxflag(vwHy101s.get(i).getZxflag());
						bingRenHuaYanXingXi.setBgbz(vwHy101s.get(i).getBgbz());
						bingRenHuaYanXingXi.setWjflag(wjpd);
						bingRenHuaYanXingXi.setVwHy1011s(vwHy1011s);
						bingRenHuaYanXingXis.add(bingRenHuaYanXingXi);
						break;
					}
				}
			}
			return bingRenHuaYanXingXis;
		}
		return null;
	}

	@Override
	public List<BingRenHuaYanXingXi> getListWjzHuaYanByKeyDate(Date sqrq, Long key1, Integer key2, Short key3) {
		List<BingRenHuaYanXingXi> bingRenHuaYanXingXis = new ArrayList<>();
		List<VwHy101> vwHy101s = vwHy101Dao.getListBingRenHuaYanByDate(sqrq, key1, key2, key3);
		System.out.println("vwHy101s.size():" + vwHy101s.size());
		if(vwHy101s.size()>0){
			for(int i=0; i<vwHy101s.size();i++){
				BingRenHuaYanXingXi bingRenHuaYanXingXi = new BingRenHuaYanXingXi();
				List<VwHy1011> vwHy1011s = null;
				String vsqdh = vwHy101s.get(i).getSqdh();
				try {
					vwHy1011s = vwHy1011Dao.getListBingrHuayChongb(vsqdh);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//判断从表是否有危急值的记录，如果有，则添加到list中
				String wjpd = "0";
				for(int j=0; j<vwHy1011s.size();j++){
					wjpd = vwHy1011s.get(j).getWjflag();
					if(wjpd.equals("1")){
						bingRenHuaYanXingXi.setSqdh(vwHy101s.get(i).getSqdh());
						bingRenHuaYanXingXi.setKey1(vwHy101s.get(i).getKey1());
						bingRenHuaYanXingXi.setKey2(vwHy101s.get(i).getKey2());
						bingRenHuaYanXingXi.setYebh(vwHy101s.get(i).getYebh());
						bingRenHuaYanXingXi.setJjflag(vwHy101s.get(i).getJjflag());
						bingRenHuaYanXingXi.setSqrq(vwHy101s.get(i).getSqrq());
						bingRenHuaYanXingXi.setSqsj(vwHy101s.get(i).getSqsj());
						bingRenHuaYanXingXi.setBq(vwHy101s.get(i).getBq());
						bingRenHuaYanXingXi.setChw(vwHy101s.get(i).getChw());
						bingRenHuaYanXingXi.setBah(vwHy101s.get(i).getBah());
						bingRenHuaYanXingXi.setXm(vwHy101s.get(i).getXm());
						bingRenHuaYanXingXi.setXb(vwHy101s.get(i).getXb());
						bingRenHuaYanXingXi.setNl(vwHy101s.get(i).getNl());
						bingRenHuaYanXingXi.setSqysid(vwHy101s.get(i).getSqysid());
						bingRenHuaYanXingXi.setSqysxm(vwHy101s.get(i).getSqysxm());
						bingRenHuaYanXingXi.setSqksid(vwHy101s.get(i).getSqksid());
						bingRenHuaYanXingXi.setSqksmc(vwHy101s.get(i).getSqksmc());
						bingRenHuaYanXingXi.setCzksid(vwHy101s.get(i).getCzksid());
						bingRenHuaYanXingXi.setCzksmc(vwHy101s.get(i).getCzksmc());
						bingRenHuaYanXingXi.setBbmc(vwHy101s.get(i).getBbmc());
						bingRenHuaYanXingXi.setXmms(vwHy101s.get(i).getXmms());
						bingRenHuaYanXingXi.setZxflag(vwHy101s.get(i).getZxflag());
						bingRenHuaYanXingXi.setBgbz(vwHy101s.get(i).getBgbz());
						bingRenHuaYanXingXi.setWjflag(wjpd);
						bingRenHuaYanXingXi.setVwHy1011s(vwHy1011s);
						bingRenHuaYanXingXis.add(bingRenHuaYanXingXi);
						break;
					}
				}
			}
			return bingRenHuaYanXingXis;
		}
		return null;
	}
}
