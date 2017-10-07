package com.lzw.atmm.model;
public class TbKucun  implements java.io.Serializable {
     /**
	 * 
	 */
	private static final long serialVersionUID = -2408784619049479562L;
	private String id;//库存ID
     private String spname;//商品名称
     private String jc;//商品简称
     private String cd;//产地
     private String gg;//规格
     private String bz;//包装
     private String dw;//单位
     private Double dj;//单价
     private Integer kcsl;//库存数量
    public TbKucun() {
    }
    public TbKucun(String id) {
        this.id = id;
    }
    public TbKucun(String id, String spname, String jc, String cd, String gg, String bz, String dw, Double dj, Integer kcsl) {
        this.id = id;
        this.spname = spname;
        this.jc = jc;
        this.cd = cd;
        this.gg = gg;
        this.bz = bz;
        this.dw = dw;
        this.dj = dj;
        this.kcsl = kcsl;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSpname() {
        return this.spname;
    }
    public void setSpname(String spname) {
        this.spname = spname;
    }
    public String getJc() {
        return this.jc;
    }
    public void setJc(String jc) {
        this.jc = jc;
    }
    public String getCd() {
        return this.cd;
    }
    public void setCd(String cd) {
        this.cd = cd;
    }
    public String getGg() {
        return this.gg;
    }
    public void setGg(String gg) {
        this.gg = gg;
    }
    public String getBz() {
        return this.bz;
    }
    public void setBz(String bz) {
        this.bz = bz;
    }
    public String getDw() {
        return this.dw;
    }
    public void setDw(String dw) {
        this.dw = dw;
    }
    public Double getDj() {
        return this.dj;
    }
    public void setDj(Double dj) {
        this.dj = dj;
    }
    public Integer getKcsl() {
        return this.kcsl;
    }
    public void setKcsl(Integer kcsl) {
        this.kcsl = kcsl;
    }
	public String toString() {
		return getSpname();
	}
}