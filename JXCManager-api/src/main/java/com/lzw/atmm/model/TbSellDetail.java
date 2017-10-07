package com.lzw.atmm.model;
public class TbSellDetail implements java.io.Serializable {//销售详情
	/**
	 * 
	 */
	private static final long serialVersionUID = -9204071259192396405L;
	private Integer id;//详情ID
	private String tbSellMain;//所属销售单号
	private String spid;//商品ID
	private Double dj;//单价
	private Integer sl;//销售商品数量
	public TbSellDetail() {
	}
	public TbSellDetail(String tbSellMain, String spid, Double dj, Integer sl) {
		this.tbSellMain = tbSellMain;
		this.spid = spid;
		this.dj = dj;
		this.sl = sl;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTbSellMain() {
		return this.tbSellMain;
	}

	public void setTbSellMain(String tbSellMain) {
		this.tbSellMain = tbSellMain;
	}

	public String getSpid() {
		return this.spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public Double getDj() {
		return this.dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public Integer getSl() {
		return this.sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}
}