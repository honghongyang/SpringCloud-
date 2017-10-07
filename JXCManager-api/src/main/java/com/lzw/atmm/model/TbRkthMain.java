package com.lzw.atmm.model;
import java.util.HashSet;
import java.util.Set;
public class TbRkthMain implements java.io.Serializable {//�˻���
	private static final long serialVersionUID = 1223395907836561563L;
	private String rkthId;//入库退货单ID
	private String pzs;//退货品种数量
	private String je;//金额
	private String ysjl;//验收结论
	private String gysname;//供应商全称
	private String rtdate;//退货日期
	private String czy;//操作员
	private String jsr;//经手人
	private String jsfs;//结算方式
	private Set<TbRkthDetail> tbRkthDetails = new HashSet<TbRkthDetail>(0);
	public TbRkthMain() {
	}
	public TbRkthMain(String rkthId, String pzs, String je, String ysjl,
			String gysname, String rtdate, String czy, String jsr, String jsfs) {
		this.rkthId=rkthId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.gysname = gysname;
		this.rtdate = rtdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}
	public String getRkthId() {
		return this.rkthId;
	}

	public void setRkthId(String rkthId) {
		this.rkthId = rkthId;
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

	public String getGysname() {
		return this.gysname;
	}

	public void setGysname(String gysname) {
		this.gysname = gysname;
	}

	public String getRtdate() {
		return this.rtdate;
	}

	public void setRtdate(String rtdate) {
		this.rtdate = rtdate;
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

	public Set<TbRkthDetail> getTbRkthDetails() {
		return this.tbRkthDetails;
	}

	public void setTbRkthDetails(Set<TbRkthDetail> tbRkthDetails) {
		this.tbRkthDetails = tbRkthDetails;
	}
}