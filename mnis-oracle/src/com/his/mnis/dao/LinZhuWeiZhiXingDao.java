package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;

import com.his.mnis.entities.VwBryz;

public class LinZhuWeiZhiXingDao extends BaseDao {

	/*
	 * 通过护士id查询相关（我的病人）相关未完成临嘱  lsflag='1' 表临嘱   tzflag=0表有效 zxflag=0 表未执行
	 */
	public List<VwBryz> getWeiWanChengLinzByHsId(String hsid){
		String hql = "select t1.yzxh,t1.key1,t2.key2,t1.yebh,t1,groupxh,t1.xsxh,t1.yzzt,t1.kstime,t1.lsflag,t1.yzly,t1.tzflag,t1.lb,t1.yzmc,t1.dcyl,t1.yf2mc,t1.zxsjms,t1.yf1mc,"
				+ "t1.yszt,t1.pwflag,t1.pwyzxh,t1.ysxm,t1.tztime,t1.resulttext,t1.bgflag "
				+ "from vw_bryz t1,vw_bqbr_zy t2,tw_wdbr t3 "
				+ "where t1.key1=t2.key1 and t1.key2=t2.key2 and t3.bq=t2.bq and t3.chw=t2.chw and t3.hsid=:hsid and t1.lsflag='1' and t1.tzflag=0 and t1.zxflag=0 "
				+ "order by t3.bq,t3.chw,t1.tztime";
		Query query = getSession().createSQLQuery(hql).addEntity(VwBryz.class);
		query.setString("hsid", hsid);
		return query.list();
	}
	
}
