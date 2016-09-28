package com.his.mnis.dao;

import java.util.List;
import javax.persistence.ParameterMode;
import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;
import com.his.mnis.entities.VwBryz;

public class VwBryzDao extends BaseDao {
	
	/*
	 * 根据病人key1,key2值查询病人医嘱数据
	 * yzzt 1, '新开',2, '疑问'
	 */

	public List<VwBryz> getListBrYzByKey(long v_key1,int v_key2,short v_yebh){
		
		String hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh order by groupxh,xsxh,pwflag" ;
		Query query = getSession().createQuery(hql);
		query.setLong("key1", v_key1);
		query.setInteger("key2", v_key2);
		query.setShort("yebh", v_yebh);
		return query.list();
		
	}
	
	/*
	 * 根据病人key1,key2值和给定的条件值查询病人医嘱数据  String v_tiaojianstr;      //条件字符串  1, '新开',2, '疑问'
	 */
	
	public List<VwBryz> getListBrYzByKeyAndTiaoJian(long v_key1,int v_key2,short v_yebh,String v_tiaojianstr){
		
		String hql="";
		if(v_tiaojianstr.equals("1")){  //长期
			hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh and lsflag='0' order by groupxh,xsxh,pwflag";
		}
		if(v_tiaojianstr.equals("2")){  //临时
			hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh and lsflag='1' order by groupxh,xsxh,pwflag";
		}
		if(v_tiaojianstr.equals("3")){  //药品
			hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh and yzly='0' order by groupxh,xsxh,pwflag";
		}
		if(v_tiaojianstr.equals("4")){  //诊疗项目
			hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh and yzly='1' order by groupxh,xsxh,pwflag";
		}
		if(v_tiaojianstr.equals("5")){  //材料
			hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh and yzly='2' order by groupxh,xsxh,pwflag";
		}
		if(v_tiaojianstr.equals("6")){  //有效
			hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh and tzflag='0' order by groupxh,xsxh,pwflag";
		}
		if(v_tiaojianstr.equals("7")){  //停止
			hql = "from VwBryz where yzzt!='1' and yzzt!='2' and key1=:key1 and key2=:key2 and yebh=:yebh and tzflag='1' order by groupxh,xsxh,pwflag";
		}
		
		Query query = getSession().createQuery(hql);
		query.setLong("key1", v_key1);
		query.setInteger("key2", v_key2);
		query.setShort("yebh", v_yebh);
		return query.list();
		
	}
	
	/*
	 * 执行产生，生成病人医嘱数据的存储过程
	 * 
	 */
	
	public String callProcedureBrYz(long v_key1,int v_key2){
		
		ProcedureCall pc = getSession().createStoredProcedureCall("pw_bryz");
		pc.registerParameter("key1_In", long.class, ParameterMode.IN).bindValue(v_key1);
		pc.registerParameter("key2_In", int.class, ParameterMode.IN).bindValue(v_key2);
		pc.registerParameter("out_return", String.class, ParameterMode.OUT);
		pc.registerParameter("out_errortext", String.class, ParameterMode.OUT);
		String ls_return=pc.getOutputs().getOutputParameterValue("out_return").toString();
		String ls_errortext=pc.getOutputs().getOutputParameterValue("out_return").toString();
		System.out.println("out_return:" + ls_return);
		System.out.println("ls_errortext:" + ls_errortext);
		return ls_return;
		
	}
}
