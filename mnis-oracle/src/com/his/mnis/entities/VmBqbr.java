package com.his.mnis.entities;
// default package

import java.sql.Timestamp;


/**
 * VmBqbr entity. @author MyEclipse Persistence Tools
 */

public class VmBqbr  implements java.io.Serializable {


    // Fields    

     private Double id;
     private Double paixu;
     private Double paixu2;
     private String leixing;
     private Long bingren_id;
     private Integer zhuye_id;
     private Long mengzheng_hao;
     private Long zhuyuan_hao;
     private String xingming;
     private String xingbie;
     private String nianling;
     private String keshi;
     private Long keshi_id;
     private String zhuyuan_yishi;
     private Short bingan_zhuangtai;
     private String zhuanghao;
     private String huli_dengji;
     private String feibie;
     private Timestamp ruyuan_riq;
     private Timestamp chuyuan_riqi;
     private String bingren_leixing;
     private Short zhuangtai;
     private Short xianlei;
     private String jiuzheng_kahao;
     private Double lujing_zhuangtai;
     private Double zhuyuan_tianshu;
     private Short xingshenger_xuhao;
     private String danbingzhong;
     private Long yingerkeshi_id;
     private Long yingerbingqu_id;
     private Long bingqu_id;


    // Constructors

    /** default constructor */
    public VmBqbr() {
    }

	/** minimal constructor */
    public VmBqbr(Long bingren_id, Integer zhuye_id) {
        this.bingren_id = bingren_id;
        this.zhuye_id = zhuye_id;
    }
    
    /** full constructor */
    public VmBqbr(Double paixu, Double paixu2, String leixing, Long bingren_id, Integer zhuye_id, Long mengzheng_hao, Long zhuyuan_hao, String xingming, String xingbie, String nianling, String keshi, Long keshi_id, String zhuyuan_yishi, Short bingan_zhuangtai, String zhuanghao, String huli_dengji, String feibie, Timestamp ruyuan_riq, Timestamp chuyuan_riqi, String bingren_leixing, Short zhuangtai, Short xianlei, String jiuzheng_kahao, Double lujing_zhuangtai, Double zhuyuan_tianshu, Short xingshenger_xuhao, String danbingzhong, Long yingerkeshi_id, Long yingerbingqu_id, Long bingqu_id) {
        this.paixu = paixu;
        this.paixu2 = paixu2;
        this.leixing = leixing;
        this.bingren_id = bingren_id;
        this.zhuye_id = zhuye_id;
        this.mengzheng_hao = mengzheng_hao;
        this.zhuyuan_hao = zhuyuan_hao;
        this.xingming = xingming;
        this.xingbie = xingbie;
        this.nianling = nianling;
        this.keshi = keshi;
        this.keshi_id = keshi_id;
        this.zhuyuan_yishi = zhuyuan_yishi;
        this.bingan_zhuangtai = bingan_zhuangtai;
        this.zhuanghao = zhuanghao;
        this.huli_dengji = huli_dengji;
        this.feibie = feibie;
        this.ruyuan_riq = ruyuan_riq;
        this.chuyuan_riqi = chuyuan_riqi;
        this.bingren_leixing = bingren_leixing;
        this.zhuangtai = zhuangtai;
        this.xianlei = xianlei;
        this.jiuzheng_kahao = jiuzheng_kahao;
        this.lujing_zhuangtai = lujing_zhuangtai;
        this.zhuyuan_tianshu = zhuyuan_tianshu;
        this.xingshenger_xuhao = xingshenger_xuhao;
        this.danbingzhong = danbingzhong;
        this.yingerkeshi_id = yingerkeshi_id;
        this.yingerbingqu_id = yingerbingqu_id;
        this.bingqu_id = bingqu_id;
    }

   
    // Property accessors

    public Double getId() {
        return this.id;
    }
    
    public void setId(Double id) {
        this.id = id;
    }

    public Double getPaixu() {
        return this.paixu;
    }
    
    public void setPaixu(Double paixu) {
        this.paixu = paixu;
    }

    public Double getPaixu2() {
        return this.paixu2;
    }
    
    public void setPaixu2(Double paixu2) {
        this.paixu2 = paixu2;
    }

    public String getLeixing() {
        return this.leixing;
    }
    
    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public Long getBingren_id() {
        return this.bingren_id;
    }
    
    public void setBingren_id(Long bingren_id) {
        this.bingren_id = bingren_id;
    }

    public Integer getZhuye_id() {
        return this.zhuye_id;
    }
    
    public void setZhuye_id(Integer zhuye_id) {
        this.zhuye_id = zhuye_id;
    }

    public Long getMengzheng_hao() {
        return this.mengzheng_hao;
    }
    
    public void setMengzheng_hao(Long mengzheng_hao) {
        this.mengzheng_hao = mengzheng_hao;
    }

    public Long getZhuyuan_hao() {
        return this.zhuyuan_hao;
    }
    
    public void setZhuyuan_hao(Long zhuyuan_hao) {
        this.zhuyuan_hao = zhuyuan_hao;
    }

    public String getXingming() {
        return this.xingming;
    }
    
    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getXingbie() {
        return this.xingbie;
    }
    
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    public String getNianling() {
        return this.nianling;
    }
    
    public void setNianling(String nianling) {
        this.nianling = nianling;
    }

    public String getKeshi() {
        return this.keshi;
    }
    
    public void setKeshi(String keshi) {
        this.keshi = keshi;
    }

    public Long getKeshi_id() {
        return this.keshi_id;
    }
    
    public void setKeshi_id(Long keshi_id) {
        this.keshi_id = keshi_id;
    }

    public String getZhuyuan_yishi() {
        return this.zhuyuan_yishi;
    }
    
    public void setZhuyuan_yishi(String zhuyuan_yishi) {
        this.zhuyuan_yishi = zhuyuan_yishi;
    }

    public Short getBingan_zhuangtai() {
        return this.bingan_zhuangtai;
    }
    
    public void setBingan_zhuangtai(Short bingan_zhuangtai) {
        this.bingan_zhuangtai = bingan_zhuangtai;
    }

    public String getZhuanghao() {
        return this.zhuanghao;
    }
    
    public void setZhuanghao(String zhuanghao) {
        this.zhuanghao = zhuanghao;
    }

    public String getHuli_dengji() {
        return this.huli_dengji;
    }
    
    public void setHuli_dengji(String huli_dengji) {
        this.huli_dengji = huli_dengji;
    }

    public String getFeibie() {
        return this.feibie;
    }
    
    public void setFeibie(String feibie) {
        this.feibie = feibie;
    }

    public Timestamp getRuyuan_riq() {
        return this.ruyuan_riq;
    }
    
    public void setRuyuan_riq(Timestamp ruyuan_riq) {
        this.ruyuan_riq = ruyuan_riq;
    }

    public Timestamp getChuyuan_riqi() {
        return this.chuyuan_riqi;
    }
    
    public void setChuyuan_riqi(Timestamp chuyuan_riqi) {
        this.chuyuan_riqi = chuyuan_riqi;
    }

    public String getBingren_leixing() {
        return this.bingren_leixing;
    }
    
    public void setBingren_leixing(String bingren_leixing) {
        this.bingren_leixing = bingren_leixing;
    }

    public Short getZhuangtai() {
        return this.zhuangtai;
    }
    
    public void setZhuangtai(Short zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public Short getXianlei() {
        return this.xianlei;
    }
    
    public void setXianlei(Short xianlei) {
        this.xianlei = xianlei;
    }

    public String getJiuzheng_kahao() {
        return this.jiuzheng_kahao;
    }
    
    public void setJiuzheng_kahao(String jiuzheng_kahao) {
        this.jiuzheng_kahao = jiuzheng_kahao;
    }

    public Double getLujing_zhuangtai() {
        return this.lujing_zhuangtai;
    }
    
    public void setLujing_zhuangtai(Double lujing_zhuangtai) {
        this.lujing_zhuangtai = lujing_zhuangtai;
    }

    public Double getZhuyuan_tianshu() {
        return this.zhuyuan_tianshu;
    }
    
    public void setZhuyuan_tianshu(Double zhuyuan_tianshu) {
        this.zhuyuan_tianshu = zhuyuan_tianshu;
    }

    public Short getXingshenger_xuhao() {
        return this.xingshenger_xuhao;
    }
    
    public void setXingshenger_xuhao(Short xingshenger_xuhao) {
        this.xingshenger_xuhao = xingshenger_xuhao;
    }

    public String getDanbingzhong() {
        return this.danbingzhong;
    }
    
    public void setDanbingzhong(String danbingzhong) {
        this.danbingzhong = danbingzhong;
    }

    public Long getYingerkeshi_id() {
        return this.yingerkeshi_id;
    }
    
    public void setYingerkeshi_id(Long yingerkeshi_id) {
        this.yingerkeshi_id = yingerkeshi_id;
    }

    public Long getYingerbingqu_id() {
        return this.yingerbingqu_id;
    }
    
    public void setYingerbingqu_id(Long yingerbingqu_id) {
        this.yingerbingqu_id = yingerbingqu_id;
    }

    public Long getBingqu_id() {
        return this.bingqu_id;
    }
    
    public void setBingqu_id(Long bingqu_id) {
        this.bingqu_id = bingqu_id;
    }
   








}