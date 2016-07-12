package com.his.mnis.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.his.mnis.dao.PcBaiBanDao;
import com.his.mnis.entities.BaiBanMoBan;
import com.his.mnis.entities.VwBbMbbm;
import com.his.mnis.services.PcBaiBanService;
import com.his.mnis.utils.ConvertRGBToHEXUtil;
import com.his.mnis.utils.GetIP;

public class PcBaiBanServiceImpl implements PcBaiBanService {
	
	private PcBaiBanDao pcBaiBanDao;
	private ConvertRGBToHEXUtil convertRGBToHEXUtil;

	public ConvertRGBToHEXUtil getConvertRGBToHEXUtil() {
		return convertRGBToHEXUtil;
	}

	public void setConvertRGBToHEXUtil(ConvertRGBToHEXUtil convertRGBToHEXUtil) {
		this.convertRGBToHEXUtil = convertRGBToHEXUtil;
	}

	public PcBaiBanDao getPcBaiBanDao() {
		return pcBaiBanDao;
	}

	public void setPcBaiBanDao(PcBaiBanDao pcBaiBanDao) {
		this.pcBaiBanDao = pcBaiBanDao;
	}

	@Override
	public List<BaiBanMoBan> getPcBaiBanMoBanByIp(String vip) {
		
		List<BaiBanMoBan> baiBanMoBans = new ArrayList<BaiBanMoBan>();
		
		List<VwBbMbbm> vwBbMbbms = pcBaiBanDao.getListPcBaiBanXiangMuByIP(vip);
		
		for(int i=0;i<vwBbMbbms.size();i++){
			
			BaiBanMoBan baiBanMoBan = new BaiBanMoBan();
			
			VwBbMbbm vwBbMbbm = vwBbMbbms.get(i);
			
			Long vrgb_title = vwBbMbbm.getTitleColor();
			int r = (int) (vrgb_title % 256);
			int g = (int) ((vrgb_title/256) % 256);
			int b = (int) ((vrgb_title/256/256) % 256);
			String rgbvalue_title = convertRGBToHEXUtil.convertRGBToHex(r, g, b);
			System.out.println("rgbvalue_title hex: "+rgbvalue_title);
			
			Long vrgb_neirong = vwBbMbbm.getNrColor();
			int r1 = (int) (vrgb_neirong % 256);
			int g1 = (int) ((vrgb_neirong/256) % 256);
			int b1 = (int) ((vrgb_neirong/256/256) % 256);
			String rgbvalue_neirong = convertRGBToHEXUtil.convertRGBToHex(r1, g1, b1);
			System.out.println("rgbvalue_title hex: "+rgbvalue_neirong);
			
			baiBanMoBan.setXmbm(vwBbMbbm.getXmbm());
			baiBanMoBan.setMbbm(vwBbMbbm.getMbbm());
			baiBanMoBan.setXmmc(vwBbMbbm.getXmmc());
			baiBanMoBan.setDataly(vwBbMbbm.getDataly());
			baiBanMoBan.setYwlx(vwBbMbbm.getYwlx());
			baiBanMoBan.setBrflag(vwBbMbbm.getBrflag());
			baiBanMoBan.setTitleVisible(vwBbMbbm.getTitleVisible());
			baiBanMoBan.setTitleText(vwBbMbbm.getTitleText());
			baiBanMoBan.setTitleAlignment(vwBbMbbm.getTitleAlignment());
			baiBanMoBan.setTitleBorder(vwBbMbbm.getTitleBorder());
			baiBanMoBan.setTitleColor(rgbvalue_title);
			baiBanMoBan.setTitleFontFace(vwBbMbbm.getTitleFontFace());
			baiBanMoBan.setTitleFontHeight(vwBbMbbm.getTitleFontHeight());
			baiBanMoBan.setTitleFontBold(vwBbMbbm.getTitleFontBold());
			baiBanMoBan.setTitleFontItalic(vwBbMbbm.getNrFontItalic());
			baiBanMoBan.setTitleFontUnderline(vwBbMbbm.getTitleFontUnderline());
			baiBanMoBan.setTitleFontStrikethrough(vwBbMbbm.getTitleFontStrikethrough());
			baiBanMoBan.setTitleX(vwBbMbbm.getTitleX());
			baiBanMoBan.setTitleY(vwBbMbbm.getTitleY());
			baiBanMoBan.setTitleWidth(vwBbMbbm.getTitleWidth());
			baiBanMoBan.setTitleHeight(vwBbMbbm.getTitleHeight());
			baiBanMoBan.setNrAlignment(vwBbMbbm.getNrAlignment());
			baiBanMoBan.setNrBorder(vwBbMbbm.getNrBorder());
			baiBanMoBan.setNrColor(rgbvalue_neirong);
			baiBanMoBan.setNrFontFace(vwBbMbbm.getNrFontFace());
			baiBanMoBan.setNrFontHeight(vwBbMbbm.getNrFontHeight());
			baiBanMoBan.setNrFontBold(vwBbMbbm.getNrFontBold());
			baiBanMoBan.setNrFontItalic(vwBbMbbm.getNrFontItalic());
			baiBanMoBan.setNrFontUnderline(vwBbMbbm.getNrFontUnderline());
			baiBanMoBan.setNrFontStrikethrough(vwBbMbbm.getNrFontStrikethrough());
			baiBanMoBan.setNrX(vwBbMbbm.getNrX());
			baiBanMoBan.setNrY(vwBbMbbm.getNrY());
			baiBanMoBan.setNrWidth(vwBbMbbm.getNrWidth());
			baiBanMoBan.setNrHeight(vwBbMbbm.getNrHeight());
			baiBanMoBans.add(baiBanMoBan);
		}
		return baiBanMoBans;
	}

	@Override
	public List<String> getPcBaiBanNeiRongByBqidXmbm(List<BaiBanMoBan> baiBanMoBans,String vip) {
		
		List<String> listneirongs = new ArrayList<String>();
		String vbqid = pcBaiBanDao.getBqidByIP(vip);
		for(int i=0;i<baiBanMoBans.size();i++){
			String vxmvm = baiBanMoBans.get(i).getXmbm();
			String vneirong  = pcBaiBanDao.callProcedurePWGethlxmnrByBqidXmbm(vbqid, vxmvm);
			listneirongs.add(vneirong);
		}
		return listneirongs;
	}

}
