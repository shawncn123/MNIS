package com.his.mnis.entities;
// default package

/**
 * VmCzry entity. @author MyEclipse Persistence Tools
 */

public class VmCzry  implements java.io.Serializable {

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


    // Constructors

    /** default constructor */
    public VmCzry() {
    }

	/** minimal constructor */
    public VmCzry(Long czy_id, String yonghuming) {
        this.czy_id = czy_id;
        this.yonghuming = yonghuming;
    }
    
    /** full constructor */
    public VmCzry(Long czy_id, String renyuan_bianma, String jianma, String xingming, String yonghuming) {
        this.czy_id = czy_id;
        this.renyuan_bianma = renyuan_bianma;
        this.jianma = jianma;
        this.xingming = xingming;
        this.yonghuming = yonghuming;
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
   








}