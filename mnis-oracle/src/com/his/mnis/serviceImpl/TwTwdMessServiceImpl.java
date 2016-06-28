package com.his.mnis.serviceImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.his.mnis.dao.BaseDao;
import com.his.mnis.dao.TwTwdMessDao;
import com.his.mnis.entities.TiWenDanRiQiDuan;
import com.his.mnis.entities.TwTwdMess;
import com.his.mnis.entities.VwBqbrZy;
import com.his.mnis.services.TwTwdMessService;
import com.opensymphony.xwork2.ActionContext;

public class TwTwdMessServiceImpl implements TwTwdMessService {

	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	private TwTwdMessDao twTwdMessDao;

	public TwTwdMessDao getTwTwdMessDao() {
		return twTwdMessDao;
	}

	public void setTwTwdMessDao(TwTwdMessDao twTwdMessDao) {
		this.twTwdMessDao = twTwdMessDao;
	}

	@Override
	public String getOutStreamOfTiWenDan(Long vkey1, Integer vkey2,
			Short vkey3, Date vrq) {
		Long vjlid = twTwdMessDao.getJlidByRiQiAndKey(vkey1, vkey2, vkey3, vrq);
		if(vjlid > 0){
			try {
				TwTwdMess twTwdMess = baseDao.getSession().load(TwTwdMess.class, vjlid);
				// 从数据库中要读取出来
				InputStream is = twTwdMess.getFilenr().getBinaryStream();
				// 在把写到一个图片格式的文件里
//			String uploadFilePath = ServletActionContext.getServletContext()
//					.getRealPath("WEB-INF/upload");
				String uploadFilePath = ServletActionContext.getServletContext()
						.getRealPath("twdimage");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
				String str_d=sdf.format(vrq);  
				String fname = uploadFilePath + "/"+ vkey1+"_" + vkey2 + "_" + vkey3 + "_" + str_d + ".jpg";
				FileOutputStream fos = new FileOutputStream(fname);
				System.out.println("filepath fname:"+fname);
				byte[] buffer = new byte[1024];
				int len = 0;
				// 从数据库中读取到指定的字节数组中
				while ((len = is.read(buffer)) != -1) {
					// 从指定的数组中读取，然后输出来,所以这里buffer好象是连接inputStream和outputStream的一个东西
					fos.write(buffer, 0, len);
				}
				return fname;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public String createTiWenDanTuPian(Long vkey1, Integer vkey2, Short vkey3,
			Date vrq) {
		
		long vjlid = twTwdMessDao.getJlidByRiQiAndKey(vkey1, vkey2, vkey3, vrq);
		if(vjlid > 0){
			return "1";
		}else{
			int insertrow = twTwdMessDao.addTwTwdMessRow(vkey1, vkey2, vkey3, vrq);
			if(insertrow > 0){
//				for(int i=0;i<10;i++){
//					try {
//						Thread.sleep(3000);
//						char checkflag = twTwdMessDao.getHandleflagFromTWTwdMess(vkey1, vkey2, vkey3, vrq);
//						if(checkflag=='1'){
//							return "1";   //1 示表成功
//						}
//						if(checkflag=='2'){
//							return "0";   //0 表示失败
//						}
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//						return "0";   //0 表示失败
//					}
//				}
//				return "0";   //0 表示失败
				return "1";   //1 示表成功
			}else{
				return "0";   //0 表示失败
			}
		}
	}

	@Override
	public List<TiWenDanRiQiDuan> getListRqBingRenTiWenJiLu(Date vdate) {

		List<TiWenDanRiQiDuan> tiWenDanRiQiDuans = new ArrayList<TiWenDanRiQiDuan>();
		
		Date maxdate = new Date();

		while (vdate.getTime() <= maxdate.getTime()) {

			TiWenDanRiQiDuan tiWenDanRiQiDuan = new TiWenDanRiQiDuan();

			Date firstDate = vdate;
			Date secondDate = new Date(firstDate.getTime() + 6 * 24 * 60 * 60
					* 1000);
			vdate = new Date(firstDate.getTime() + 7 * 24 * 60 * 60 * 1000);
			tiWenDanRiQiDuan.setDate1(firstDate);
			tiWenDanRiQiDuan.setDate2(secondDate);
			tiWenDanRiQiDuans.add(tiWenDanRiQiDuan);
		}
		return tiWenDanRiQiDuans;
	}
}
