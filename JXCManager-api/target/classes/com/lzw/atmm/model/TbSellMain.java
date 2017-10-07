package com.lzw.atmm.model;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
public class TbSellMain implements java.io.Serializable {//销售单
	private static final long serialVersionUID = -1569097343410934219L;
	private String sellId;//销售单号
	private String pzs;//品种数量
	private String je;//金额
	private String ysjl;//验收结论
	private String khname;//客户全称
	private String xsdate;//销售日期
	private String czy;//操作员
	private String jsr;//经手人
	private String jsfs;//结算方式
	private Set<TbSellDetail> tbSellDetails = new HashSet<TbSellDetail>(0);
	public TbSellMain() {
	}
	public TbSellMain(String sellId, String pzs, String je, String ysjl,
			String khname, String xsdate, String czy, String jsr, String jsfs) {
		this.sellId = sellId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.khname = khname;
		this.xsdate = xsdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
		
	}
	public String getSellId() {
		return this.sellId;
	}

	public void setSellId(String sellId) {
		this.sellId = sellId;
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

	public void setYsjl(String ysjl) {
		this.ysjl = ysjl;
	}

	public String getKhname() {
		return this.khname;
	}

	public void setKhname(String khname) {
		this.khname = khname;
	}

	public String getXsdate() {
		return this.xsdate;
	}

	public void setXsdate(String xsdate) {
		this.xsdate = xsdate;
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

	public Set<TbSellDetail> getTbSellDetails() {
		return this.tbSellDetails;
	}

	public void setTbSellDetails(Set<TbSellDetail> tbSellDetails) {
		this.tbSellDetails = tbSellDetails;
	}
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}