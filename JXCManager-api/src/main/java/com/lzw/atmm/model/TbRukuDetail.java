package com.lzw.atmm.model;
public class TbRukuDetail implements java.io.Serializable {
	private static final long serialVersionUID = -108353725842388494L;
	private String id;// 入库详情编号
	private String tbSpinfo;//商品编号
	private String tbRukuMain;//入库单号
	private Double dj;//单价
	private Integer sl;//数量
	public TbRukuDetail() {
	}
	public TbRukuDetail(String tbSpinfo, String tbRukuMain, Double dj,
			Integer sl) {
		this.tbSpinfo = tbSpinfo;
		this.tbRukuMain = tbRukuMain;
		this.dj = dj;
		this.sl = sl;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String lsh) {
		this.id = lsh;
	}
	public String getTabSpinfo() {
		return this.tbSpinfo;
	}
	public void setTabSpinfo(String tbSpinfo) {
		this.tbSpinfo = tbSpinfo;
	}
	public String getTabRukuMain() {
		return this.tbRukuMain;
	}

	public void setTabRukuMain(String tbRukuMain) {
		this.tbRukuMain = tbRukuMain;
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