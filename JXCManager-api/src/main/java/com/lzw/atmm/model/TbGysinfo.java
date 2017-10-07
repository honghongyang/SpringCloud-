package com.lzw.atmm.model;
import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：供应商信息实体类
 * 类名称：com.lzw.model.TbGysinfo     
 * 创建人：杨洪
 * 创建时间：2016年6月20日 上午10:42:29   
 * 修改人：
 * 修改时间：2016年6月20日 上午10:42:29   
 * 修改备注：   
 * @version   V1.0    
 */

public class TbGysinfo implements Serializable {
	
	private static final long serialVersionUID = -2759756941831101185L;
	
	private String id;//ID
	private String name;//供应商名称
	private String jc;//简称
	private String address;//供应商地址
	private String bianma;//编码
	private String fax;//传真
	private String tel;//电话
	private String lian;//联系人
	private String ltel;//联系人电话
	private String yh;//银行
	private String mail;//邮箱
	
	public TbGysinfo(){
	}
	public TbGysinfo(int id){
	}
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param id
	* @param name
	* @param jc
	* @param address
	* @param bianma
	* @param fax
	* @param tel
	* @param lian
	* @param ltel
	* @param yh
	* @param mail
	*/ 
	public TbGysinfo(String id, String name, String jc, String address,
			String bianma, String fax, String tel, String lian, String ltel,
			String yh, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.jc = jc;
		this.address = address;
		this.bianma = bianma;
		this.fax = fax;
		this.tel = tel;
		this.lian = lian;
		this.ltel = ltel;
		this.yh = yh;
		this.mail = mail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJc() {
		return jc;
	}
	public void setJc(String jc) {
		this.jc = jc;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public String getYh() {
		return yh;
	}
	public void setYh(String yh) {
		this.yh = yh;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
