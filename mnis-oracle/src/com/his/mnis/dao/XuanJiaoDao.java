package com.his.mnis.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.TwXjDm;
import com.his.mnis.entities.TwXjYw;
import com.his.mnis.entities.VwXjFl;

public class XuanJiaoDao extends HibernateDaoSupport {

	private BaseDao baseDao;
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/*
	 * 取出宣教分类信息
	 */
	public List<VwXjFl> getListXuanJiaoFenLei(){
		String hql="from VwXjFl order by sxh";
		Query query = baseDao.getSession().createQuery(hql);
		return query.list();
	}
	
	/*
	 * 取出所有宣教内容
	 */
	public List<TwXjDm> getListXuanJiaoNeiRong(){
		String hql = "from TwXjDm where tyflag=0";
		Query query = baseDao.getSession().createQuery(hql);
		return query.list();
	}
	
	/*
	 * 根据宣教分类代码取出相应宣教内容
	 */
	public List<TwXjDm> getListXjNrByDaiMa(String fldm){
		String hql = "from TwXjDm where tyflag=0 where fldm=:fldm";
		Query query = baseDao.getSession().createQuery(hql);
		query.setString("fldm", fldm);
		return query.list();
	}
	
	/*
	 * 保存护士所做宣教数据
	 */
	public int addXuanJiaoYeWu(TwXjYw twXjYw){
		String sql = "select ID from TW_XJ_YW where KEY1=:vkey1 and KEY2=:vkey2 and YEBH=:vyebh and xjdmid=:vxjdmid";
		Query query = baseDao.getSession().createSQLQuery(sql);
		query.setLong("vkey1", twXjYw.getKey1());
		query.setInteger("vkey2", twXjYw.getKey2());
		query.setShort("vyebh", twXjYw.getYebh());
		query.setString("vxjdmid", twXjYw.getXjdmid());
		String vid = (String) query.uniqueResult();
		if(vid==null){
			String sql1 = "insert into TW_XJ_YW(id,stime,rq,xjdmid,key1,key2,yebh,bq,chw,xjhsid,xjhsxm,bz)"
					+ " values(seq_xjid.nextval,sysdate,sysdate,:vxjdmid,:vkey1,:vkey2,:vyebh,:vbq,:vchw,:vxjhsid,:vxjhsxm,'')";
			Query query1 = baseDao.getSession().createSQLQuery(sql1);
			query1.setString("vxjdmid", twXjYw.getXjdmid());
			query1.setLong("vkey1", twXjYw.getKey1());
			query1.setInteger("vkey2", twXjYw.getKey2());
			query1.setShort("vyebh", twXjYw.getYebh());
			query1.setString("vbq", twXjYw.getBq());
			query1.setString("vchw", twXjYw.getChw());
			query1.setString("vxjhsid", twXjYw.getXjhsid());
			query1.setString("vxjhsxm", twXjYw.getXjhsxm());
			int rerows = query1.executeUpdate();
			if(rerows>0){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 1;
		}
	}
	
	/*
	 * 获取已对病人做了宣教的内容
	 */
	public List<TwXjYw> getListXjYwByBingrKey(long key1,int key2,short yebh){
		String hql = "from TwXjYw where key1=:vkey1 and key2=:vkey2 and yebh=:vyebh";
		Query query = baseDao.getSession().createQuery(hql);
		query.setLong("vkey1", key1);
		query.setInteger("vkey2", key2);
		query.setShort("vyebh", yebh);
		return query.list();
	}
}
