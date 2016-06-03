package com.his.mnis.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.his.mnis.entities.MyBingRen;
import com.his.mnis.entities.TwWdbr;

public class TwWdbrDao extends HibernateDaoSupport {

	/*
	 * 根据护士ID、病区ID查询 查询指定病区下的我的病人 getMyBingRenByCzryIdBqId(String caozryId,String bqid)
	 * 保存护士选择的我的病人
	 * 根据操作员id查询我的病人 getMyBingRenByCzryId(String caozryId)
	 * truncate TwWdbr 的数据
	 * 
	 * 根据护士ID、病区ID查询 查询获取供选择的病人列表（包含已选择的我的病人的状态）
	 */
	
	private BaseDao basedao;

	public BaseDao getBasedao() {
		return basedao;
	}

	public void setBasedao(BaseDao basedao) {
		this.basedao = basedao;
	}

	public List<MyBingRen> getMyBingRenByCzryId(String caozryId){
		
		String hql = "select t1.key1,t1.key2, t1.bq,t1.chw,t1.bah,t1.xm,t1.xb,t1.nl,t1.ksid,t1.ksmc,t1.ysxm,t1.hsxm from VwBqbrZy t1, TwWdbr t2 where t1.chw = t2.chw and t1.ksid = t2.bq and t2.hsid = :czyid";
		Query query = basedao.getSession().createQuery(hql);
		query.setString("hsid", caozryId);
		List listresult = query.list();
		List<MyBingRen> myBingrens = new ArrayList<MyBingRen>();
		
		Iterator iter = listresult.iterator();  
        while(iter.hasNext()){  
        	Object[] obj = (Object[])iter.next();
        	MyBingRen myBingRen = new MyBingRen();
        	myBingRen.setKey1((Long) obj[0]);
        	myBingRen.setKey2((Integer) obj[1]);
        	myBingRen.setBq((String) obj[2]);
        	myBingRen.setChw((String) obj[3]);
        	myBingRen.setBah((String) obj[4]);
        	myBingRen.setXm((String) obj[5]);
        	myBingRen.setXb((String) obj[6]);
        	myBingRen.setNl((String) obj[7]);
        	myBingRen.setKsid((String) obj[8]);
        	myBingRen.setKsmc((String) obj[9]);
        	myBingRen.setYsxm((String) obj[10]);
        	myBingRen.setHsxm((String) obj[11]);
        	myBingrens.add(myBingRen);
        	
        }
		return myBingrens;
	}
	
public List<MyBingRen> getMyBingRenByCzryIdBqId(String caozryId,String bqid){
		
		String hql = "select t1.key1,t1.key2, t1.bq,t1.chw,t1.bah,t1.xm,t1.xb,t1.nl,t1.ksid,t1.ksmc,t1.ysxm,t1.hsxm from VwBqbrZy t1, TwWdbr t2 where t1.chw = t2.chw and t1.ksid = t2.bq and t2.hsid = :czyid and t2.bq=:bqid";
		Query query = basedao.getSession().createQuery(hql);
		query.setString("hsid", caozryId);
		query.setString("bqid", bqid);
		List listresult = query.list();
		List<MyBingRen> myBingrens = new ArrayList<MyBingRen>();
		
		Iterator iter = listresult.iterator();  
        while(iter.hasNext()){  
        	Object[] obj = (Object[])iter.next();
        	MyBingRen myBingRen = new MyBingRen();
        	myBingRen.setKey1((Long) obj[0]);
        	myBingRen.setKey2((Integer) obj[1]);
        	myBingRen.setBq((String) obj[2]);
        	myBingRen.setChw((String) obj[3]);
        	myBingRen.setBah((String) obj[4]);
        	myBingRen.setXm((String) obj[5]);
        	myBingRen.setXb((String) obj[6]);
        	myBingRen.setNl((String) obj[7]);
        	myBingRen.setKsid((String) obj[8]);
        	myBingRen.setKsmc((String) obj[9]);
        	myBingRen.setYsxm((String) obj[10]);
        	myBingRen.setHsxm((String) obj[11]);
        	myBingrens.add(myBingRen);
        }
		return myBingrens;
	}

public List<MyBingRen> getDaiXuanZheBingRenByCzryIdBqId(String caozryId,String bqid){
	System.out.println(caozryId);
	System.out.println(bqid);
	String hql = "select t1.key1,t1.key2, t1.bq,t1.chw,t1.bah,t1.xm,t1.xb,t1.nl,t1.ksid,t1.ksmc,t1.ysxm,t1.hsxm,t2.chw t2_chw from vw_bqbr_zy t1 left join (select * from tw_wdbr where hsid = :czyid and bq=:bqid) t2 on (t1.chw = t2.chw and t1.bq = t2.bq) where t1.bq=:t1_bqid order by t1.jcflag,t1.chw";
	Query query = basedao.getSession().createSQLQuery(hql);
	query.setString("czyid", caozryId);
	query.setString("bqid", bqid);
	query.setString("t1_bqid", bqid);
	List listresult = query.list();
	List<MyBingRen> myBingrens = new ArrayList<MyBingRen>();
	
	Iterator iter = listresult.iterator();  
	while(iter.hasNext()){  
		Object[] obj = (Object[])iter.next();
		MyBingRen myBingRen = new MyBingRen();
		myBingRen.setKey1(Long.valueOf(obj[0].toString()).longValue());
		myBingRen.setKey2(Integer.valueOf(obj[1].toString()).intValue());
		myBingRen.setBq((String) obj[2]);
		myBingRen.setChw((String) obj[3]);
		myBingRen.setBah((String) obj[4]);
		myBingRen.setXm((String) obj[5]);
		myBingRen.setXb((String) obj[6]);
		myBingRen.setNl((String) obj[7]);
		myBingRen.setKsid((String) obj[8]);
		myBingRen.setKsmc((String) obj[9]);
		myBingRen.setYsxm((String) obj[10]);
		myBingRen.setHsxm((String) obj[11]);
		if(obj[12] != null){
			myBingRen.setQuedflag("1");
		}else{
			myBingRen.setQuedflag("0");
		}
		myBingrens.add(myBingRen);
	}
	return myBingrens;
}
	
	public void addTwWdbrBySelect(List<TwWdbr> twWdbrs){
		
		Iterator<TwWdbr> iter = twWdbrs.iterator(); 
		
		while(iter.hasNext()){       
		     
			this.getHibernateTemplate().save(iter.next());
			
		}       
	}
	
	public void deleteTwWdbrByCzryIdBqId(String czyid, String bqid){
		String sql="delete from TwWdbr where hsid=:czyid and bq=:bqid";
		Query query = basedao.getSession().createQuery(sql);
		query.setString("czyid", czyid);
		query.setString("bqid", bqid);
		query.executeUpdate();
	}
}
