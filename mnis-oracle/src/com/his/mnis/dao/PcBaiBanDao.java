package com.his.mnis.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;

import com.his.mnis.entities.VwBbMbbm;

public class PcBaiBanDao extends BaseDao {

	/*
	 * 根据Ip取出模版项目
	 */
	public List<VwBbMbbm> getListPcBaiBanXiangMuByIP(String vip){
		String sql = "select t1.MBBM,t1.XMBM,t1.XMMC,t1.DATALY,t1.YWLX,t1.BRFLAG,t1.TITLE_VISIBLE,t1.TITLE_TEXT,t1.TITLE_ALIGNMENT,"
				+ "t1.TITLE_BORDER,t1.TITLE_COLOR,t1.TITLE_FONT_FACE,t1.TITLE_FONT_HEIGHT,t1.TITLE_FONT_BOLD,t1.TITLE_FONT_ITALIC,"
				+ "t1.TITLE_FONT_UNDERLINE,t1.TITLE_FONT_STRIKETHROUGH,t1.TITLE_X,t1.TITLE_Y,t1.TITLE_WIDTH,t1.TITLE_HEIGHT,"
				+ "t1.NR_ALIGNMENT,t1.NR_BORDER,t1.NR_COLOR,t1.NR_FONT_FACE,t1.NR_FONT_HEIGHT,t1.NR_FONT_BOLD,t1.NR_FONT_ITALIC,"
				+ "t1.NR_FONT_UNDERLINE,t1.NR_FONT_STRIKETHROUGH,t1.NR_X,t1.NR_Y,t1.NR_WIDTH,t1.NR_HEIGHT "
				+ "From vw_bb_mbbm t1, TW_HL001_bq t2 Where t2.ip=:ip and t2.mbbm=t1.mbbm";
		Query query = getSession().createSQLQuery(sql).addEntity(VwBbMbbm.class);
		query.setString("ip", vip);
		return query.list();
	}
	
	/*
	 * 调用存储过程，根据bq，xmbm 获取项目内容
	 */
	public String callProcedurePWGethlxmnrByBqidXmbm(String bqid, String xmbm) {

		ProcedureCall pc = getSession().createStoredProcedureCall("PW_Get_hlxmnr");
		pc.registerParameter("in_bq", String.class, ParameterMode.IN).bindValue(bqid);
		pc.registerParameter("in_xmbm", String.class, ParameterMode.IN).bindValue(xmbm);
		pc.registerParameter("out_nr", String.class, ParameterMode.OUT);
		Object obj = pc.getOutputs().getOutputParameterValue("out_nr");
		if(obj!=null){
			String ls_return = obj.toString();
			return ls_return;
		}else{
			return null;
		}
	}
	
	/*
	 * 根据Ip获取背景图片名称
	 */
	public String getBackImageByIP(String vip){
		String sql = "select t1.backpicture From TW_HL001 t1, TW_HL001_bq t2 Where t2.ip=:ip and t2.mbbm=t1.mbbm";
		Query query = getSession().createSQLQuery(sql);
		query.setString("ip", vip);
		return (String) query.uniqueResult();
	}
	
	/*
	 * 根据Ip获取病区id
	 */
	public String getBqidByIP(String vip){
		String sql = "select BQ From TW_HL001_BQ Where IP=:ip";
		Query query = getSession().createSQLQuery(sql);
		query.setString("ip", vip);
		return (String) query.uniqueResult();
	}
}
