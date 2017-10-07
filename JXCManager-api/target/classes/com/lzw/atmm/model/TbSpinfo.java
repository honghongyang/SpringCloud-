package com.lzw.atmm.model;
public class TbSpinfo implements java.io.Serializable {
	private static final long serialVersionUID = -1670254058020533674L;
	private String id;//商品ID
	private String spname;//商品全称
	private String jc;//简称
	private String cd;//产地
	private String dw;//单位
	private String gg;//规格
	private String bz;//包装
	private String ph;//批号
	private String pzwh;//批准文号
	private String memo;//备注
	private String gysname;//商品所属供应商
	public TbSpinfo() {
	}

	public TbSpinfo(String id) {
		this.id = id;
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

	public String getDw() {
		return this.dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
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

	public String getPh() {
		return this.ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getPzwh() {
		return this.pzwh;
	}

	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getGysname() {
		return this.gysname;
	}

	public void setGysname(String gysname) {
		this.gysname = gysname;
	}

	public String toString() {
		return getSpname();
	}
	
}