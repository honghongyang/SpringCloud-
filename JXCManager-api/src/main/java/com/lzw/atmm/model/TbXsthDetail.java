package com.lzw.atmm.model;
public class TbXsthDetail implements java.io.Serializable {//销售退货详情
	/**
	 *  根据生活中实际业务场景, 综合实际业务需求,提取业务信息,融合软件开发实际成本, 统筹规划,
	 *  以打造满足用户需求为前提,旨在提高用户体验,紧抓用户消费走向,挖掘潜在客户,提高系统推广。
	 *  一切以客户为中心,构建以客户为中心源的生态系统循环圈。
	 */
	private static final long serialVersionUID = 3406627528501726718L;
	private Integer id;//详情ID
	private String tbXsthMain;//详情描述所属详情单
	private String spid;//商品ID
	private Double dj;//单价
	private Integer sl;//数量
	public TbXsthDetail() {
	}
	public TbXsthDetail(String tbXsthMain, String spid, Double dj, Integer sl) {
		this.tbXsthMain = tbXsthMain;
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

	public String getTbXsthMain() {
		return this.tbXsthMain;
	}

	public void setTbXsthMain(String tbXsthMain) {
		this.tbXsthMain = tbXsthMain;
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