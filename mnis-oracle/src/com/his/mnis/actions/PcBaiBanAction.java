package com.his.mnis.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.his.mnis.entities.BaiBanMoBan;
import com.his.mnis.entities.VwBbMbbm;
import com.his.mnis.services.PcBaiBanService;
import com.his.mnis.utils.GetIP;
import com.opensymphony.xwork2.ActionSupport;

public class PcBaiBanAction extends ActionSupport implements RequestAware {
	
//	private GetIP getIP;
	private PcBaiBanService pcBaiBanService;

	public PcBaiBanService getPcBaiBanService() {
		return pcBaiBanService;
	}

	public void setPcBaiBanService(PcBaiBanService pcBaiBanService) {
		this.pcBaiBanService = pcBaiBanService;
	}

	public String xianShiPcBaiBanMoBan(){
	
		String vip =  ServletActionContext.getRequest().getRemoteAddr();
		System.out.println("ip address:" + vip);
		vip = "192.168.1.99";
		List<BaiBanMoBan> baiBanMoBans = pcBaiBanService.getPcBaiBanMoBanByIp(vip);
		
		JSONArray jsonArray = JSONArray.fromObject(baiBanMoBans);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String xianShiPCBaiBanNeiRong(){
		String vip =  ServletActionContext.getRequest().getRemoteAddr();
		System.out.println("ip address:" + vip);
		vip = "192.168.1.99";
		List<BaiBanMoBan> baiBanMoBans = pcBaiBanService.getPcBaiBanMoBanByIp(vip);
		List<String> neirongs = pcBaiBanService.getPcBaiBanNeiRongByBqidXmbm(baiBanMoBans, vip);
		JSONArray jsonArray = JSONArray.fromObject(neirongs);
		// JSONObject json = JSONObject.fromObject(vwBqbrZys);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private Map<String,Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
