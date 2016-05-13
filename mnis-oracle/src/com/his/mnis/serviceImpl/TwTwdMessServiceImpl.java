package com.his.mnis.serviceImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.his.mnis.dao.BaseDao;
import com.his.mnis.dao.TwTwdMessDao;
import com.his.mnis.entities.TwTwdMess;
import com.his.mnis.services.TwTwdMessService;

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
			Integer vkey3, Date vrq) {
		Long vjlid = twTwdMessDao.getJlidByRiQiAndKey(vkey1, vkey2, vkey3, vrq);
		System.out.println("vjlid:"+vjlid);
//		TwTwdMess twTwdMess = baseDao.getSession().load(TwTwdMess.class, vjlid);
		TwTwdMess twTwdMess = baseDao.getSession().load(TwTwdMess.class, 1);
		try {
			// 从数据库中要读取出来
			InputStream is = twTwdMess.getFilenr().getBinaryStream();
			// 在把写到一个图片格式的文件里
			String uploadFilePath = ServletActionContext.getServletContext()
					.getRealPath("WEB-INF/upload");
			String fname = uploadFilePath + "/"+ vkey1+"_" + vkey2 + "_" + vkey3 + "_" + vrq + ".jpg";
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
	}

}
