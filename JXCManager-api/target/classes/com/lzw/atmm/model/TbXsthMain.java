package com.lzw.atmm.model;
import java.util.HashSet;
import java.util.Set;
public class TbXsthMain implements java.io.Serializable {//销售退货单
	/**
	 *  一切源于客户实际需求,抽象实际业务场景,构建智能,通用的系统
	 */
	private static final long serialVersionUID = 2674100891353783774L;
	private String xsthId;//销售退货单编号
	private String pzs;//退货品种数量
	private String je;//金额
	private String ysjl;//验收结论
	private String khname;//客户姓名
	private String thdate;//退货日期
	private String czy;//操作员
	private String jsr;//经手人
	private String jsfs;//结算方式
	private Set<TbXsthDetail> tbXsthDetails = new HashSet<TbXsthDetail>(0);
	public TbXsthMain() {
	}
	public TbXsthMain(String xsthId,String pzs, String je, String ysjl, String khname,
			String thdate, String czy, String jsr, String jsfs) {
		this.xsthId=xsthId;
		this.pzs = pzs;
		this.je = je;
		this.ysjl = ysjl;
		this.khname = khname;
		this.thdate = thdate;
		this.czy = czy;
		this.jsr = jsr;
		this.jsfs = jsfs;
	}
	public String getXsthId() {
		return this.xsthId;
	}
	public void setXsthId(String xsthId) {
		this.xsthId = xsthId;
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

	public String getThdate() {
		return this.thdate;
	}

	public void setThdate(String thdate) {
		this.thdate = thdate;
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

	public Set<TbXsthDetail> getTbXsthDetails() {
		return this.tbXsthDetails;
	}

	public void setTbXsthDetails(Set<TbXsthDetail> tbXsthDetails) {
		this.tbXsthDetails = tbXsthDetails;
	}
}