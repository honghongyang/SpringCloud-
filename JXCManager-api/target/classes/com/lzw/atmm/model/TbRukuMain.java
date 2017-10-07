package com.lzw.atmm.model;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
public class TbRukuMain  implements java.io.Serializable {//��ⵥ��Ϣ
	/**
	 * 
	 */
	private static final long serialVersionUID = 76967613984783342L;
	private String rkId;//入库单编号
	private String pzs;//品种数量
	private String je;//金额
	private String ysjl;//验收结论
	private String gysname;//供应商全称
	private String rkdate;//入库日期
	private String czy;//操作员
	private String jsr;//经手人
	private String jsfs;//结算方式
	private Set<TbRukuDetail> tabRukuDetails = new HashSet<TbRukuDetail>(0);
    public TbRukuMain() {
    }
    public TbRukuMain(String rkId, String pzs, String je, String ysjl, String gysname, String rkdate, String czy, String jsr, String jsfs) {
        this.rkId = rkId;
        this.pzs = pzs;
        this.je = je;
        this.ysjl = ysjl;
        this.gysname = gysname;
        this.rkdate = rkdate;
        this.czy = czy;
        this.jsr = jsr;
        this.jsfs = jsfs;
    }
    public String getRkId() {
        return this.rkId;
    }
    public void setRkId(String rkId) {
        this.rkId = rkId;
    }
    public String getPzs() {
        return this.pzs;
    }
    public void setPzs(String pzs) {
        this.pzs = pzs;
    }
    public String getJe() {
        return this.je;
    }
    public void setJe(String je) {
        this.je = je;
    }
    public String getYsjl() {
        return this.ysjl;
    }
    public void setYsjl(String sf) {
        this.ysjl = sf;
    }
    public String getGysname() {
        return this.gysname;
    }
    public void setGysname(String gysname) {
        this.gysname = gysname;
    }
    public String getRkdate() {
        return this.rkdate;
    }
    public void setRkdate(String rkdate) {
        this.rkdate = rkdate;
    }
    public String getCzy() {
        return this.czy;
    }
    public void setCzy(String czy) {
        this.czy = czy;
    }
    public String getJsr() {
        return this.jsr;
    }
    public void setJsr(String jsr) {
        this.jsr = jsr;
    }
    public String getJsfs() {
        return this.jsfs;
    }
    public void setJsfs(String jsfs) {
        this.jsfs = jsfs;
    }
    public Set<TbRukuDetail> getTabRukuDetails() {
        return this.tabRukuDetails;
    }
    public void setTabRukuDetails(Set<TbRukuDetail> tabRukuDetails) {
        this.tabRukuDetails = tabRukuDetails;
    }
    @Override
    public String toString(){
    	return ToStringBuilder.reflectionToString(this);
    }
}