package com.his.mnis.entities;
// default package



/**
 * vm_bmry entity. @author MyEclipse Persistence Tools
 */

public class VmBmry  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double id;
     private Long czy_id;
     private String renyuan_bianma;
     private String jianma;
     private String xingming;
     private String yonghuming;
     private Long bumeng_id;
     private String bumeng_bianma;
     private String bumeng_name;
     private Boolean quesheng_bumeng;


    // Constructors

    /** default constructor */
    public VmBmry() {
    }

	/** minimal constructor */
    public VmBmry(Long czy_id, String yonghuming, Long bumeng_id) {
        this.czy_id = czy_id;
        this.yonghuming = yonghuming;
        this.bumeng_id = bumeng_id;
    }
    
    /** full constructor */
    public VmBmry(Long czy_id, String renyuan_bianma, String jianma, String xingming, String yonghuming, Long bumeng_id, String bumeng_bianma, String bumeng_name, Boolean quesheng_bumeng) {
        this.czy_id = czy_id;
        this.renyuan_bianma = renyuan_bianma;
        this.jianma = jianma;
        this.xingming = xingming;
        this.yonghuming = yonghuming;
        this.bumeng_id = bumeng_id;
        this.bumeng_bianma = bumeng_bianma;
        this.bumeng_name = bumeng_name;
        this.quesheng_bumeng = quesheng_bumeng;
    }

   
    // Property accessors

    public Double getId() {
        return this.id;
    }
    
    public void setId(Double id) {
        this.id = id;
    }

    public Long getCzy_id() {
        return this.czy_id;
    }
    
    public void setCzy_id(Long czy_id) {
        this.czy_id = czy_id;
    }

    public String getRenyuan_bianma() {
        return this.renyuan_bianma;
    }
    
    public void setRenyuan_bianma(String renyuan_bianma) {
        this.renyuan_bianma = renyuan_bianma;
    }

    public String getJianma() {
        return this.jianma;
    }
    
    public void setJianma(String jianma) {
        this.jianma = jianma;
    }

    public String getXingming() {
        return this.xingming;
    }
    
    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getYonghuming() {
        return this.yonghuming;
    }
    
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming;
    }

    public Long getBumeng_id() {
        return this.bumeng_id;
    }
    
    public void setBumeng_id(Long bumeng_id) {
        this.bumeng_id = bumeng_id;
    }

    public String getBumeng_bianma() {
        return this.bumeng_bianma;
    }
    
    public void setBumeng_bianma(String bumeng_bianma) {
        this.bumeng_bianma = bumeng_bianma;
    }

    public String getBumeng_name() {
        return this.bumeng_name;
    }
    
    public void setBumeng_name(String bumeng_name) {
        this.bumeng_name = bumeng_name;
    }

    public Boolean getQuesheng_bumeng() {
        return this.quesheng_bumeng;
    }
    
    public void setQuesheng_bumeng(Boolean quesheng_bumeng) {
        this.quesheng_bumeng = quesheng_bumeng;
    }
   








}