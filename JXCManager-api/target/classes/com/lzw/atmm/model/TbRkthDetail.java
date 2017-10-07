package com.lzw.atmm.model;
public class TbRkthDetail implements java.io.Serializable {//入库退货详情
	private static final long serialVersionUID = -1933653817168250009L;
	private Integer id;//ID
	private String tbRkthMain;//入库退货详情所属退货单
	private String spid;//商品ID
	private Double dj;//商品单价
	private Integer sl;//商品数量
	public TbRkthDetail() {
	}
	public TbRkthDetail(String tbRkthMain, String spid, Double dj, Integer sl) {
		this.tbRkthMain = tbRkthMain;
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

	public String getTbRkthMain() {
		return this.tbRkthMain;
	}

	public void setTbRkthMain(String tbRkthMain) {
		this.tbRkthMain = tbRkthMain;
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