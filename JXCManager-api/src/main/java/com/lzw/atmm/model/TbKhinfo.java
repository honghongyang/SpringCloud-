/**  
* @Title: TbKhinfo.java
* @Package com.lzw.model
* @Description: TODO
* @author 杨洪   
* @date 2016年6月20日 上午11:06:10
* @version V1.0  
*/ 
package com.lzw.atmm.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：
 * 类名称：com.lzw.model.TbKhinfo     
 * 创建人：杨洪
 * 创建时间：2016年6月20日 上午11:06:10   
 * 修改人：
 * 修改时间：2016年6月20日 上午11:06:10   
 * 修改备注：   
 * @version   V1.0    
 */

public class TbKhinfo implements Serializable {
	private static final long serialVersionUID = 5830744980931733159L;
	private String id;//客户ID
	private String khname;// 客户名称
	private String jian;//简称
	private String address;//地址
	private String bianma;//编码
	private String tel;//电话
	private String fax;//传真
    private String lian;//联系人
	private String ltel;//联系电话
	private String mail;//邮箱
	private String xinhang;//开户行名称
	private String hao;//银行卡账号
    public TbKhinfo()
    { }
    public TbKhinfo(String id){
    	this.id=id;
    }
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param id
	* @param khname
	* @param jian
	* @param address
	* @param bianma
	* @param tel
	* @param fax
	* @param lian
	* @param ltel
	* @param mail
	* @param xinhang
	* @param hao
	*/ 
	public TbKhinfo(String id, String khname, String jian, String address,
			String bianma, String tel, String fax, String lian, String ltel,
			String mail, String xinhang, String hao) {
		super();
		this.id = id;
		this.khname = khname;
		this.jian = jian;
		this.address = address;
		this.bianma = bianma;
		this.tel = tel;
		this.fax = fax;
		this.lian = lian;
		this.ltel = ltel;
		this.mail = mail;
		this.xinhang = xinhang;
		this.hao = hao;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKhname() {
		return khname;
	}
	public void setKhname(String khname) {
		this.khname = khname;
	}
	public String getJian() {
		return jian;
	}
	public void setJian(String jian) {
		this.jian = jian;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBianma() {
		return bianma;
	}
	public void setBianma(String bianma) {
		this.bianma = bianma;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getLian() {
		return lian;
	}
	public void setLian(String lian) {
		this.lian = lian;
	}
	public String getLtel() {
		return ltel;
	}
	public void setLtel(String ltel) {
		this.ltel = ltel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getXinhang() {
		return xinhang;
	}
	public void setXinhang(String xinhang) {
		this.xinhang = xinhang;
	}
	public String getHao() {
		return hao;
	}
	public void setHao(String hao) {
		this.hao = hao;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
