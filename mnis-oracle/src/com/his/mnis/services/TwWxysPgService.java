package com.his.mnis.services;

import java.util.Date;
import java.util.List;

import com.his.mnis.entities.TwWxysPgDm;
import com.his.mnis.entities.TwZyhzPgXX;
import com.his.mnis.entities.TwZyhzpg;

public interface TwWxysPgService {

	public List<TwWxysPgDm> getListWxysPgDm();
	
	public void updateTwWxysPg(TwZyhzpg twZyhzpg,String mflag);
	
	public List<TwZyhzpg> getListTwZyhzpg(Date cxrq);
	
	public List<TwZyhzPgXX> getListTwZyhzPgXX(Date cxrq,Long key1,Integer key2,short yebh);
}
