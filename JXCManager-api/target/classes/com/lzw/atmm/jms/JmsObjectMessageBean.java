package com.lzw.atmm.jms;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：
 * 类名称：com.lzw.attm.jms.JmsObjectMessageBean     
 * 创建人：杨洪
 * 创建时间：2016年12月1日 下午5:21:21   
 * 修改人：
 * 修改时间：2016年12月1日 下午5:21:21   
 * 修改备注：   
 * @version   V1.0    
 */

public class JmsObjectMessageBean implements Serializable {
	private static final long serialVersionUID = 2620024932905963095L;

	private String userName;
	private int age = 16;
	private boolean flag = true;

	public JmsObjectMessageBean(String userName,int age,boolean flag){
	  this.setUserName(userName);
	  this.setAge(age);
	  this.setFlag(flag);
	}

	public String getUserName() {
	  return userName;
	}

	public void setUserName(String userName) {
	  this.userName = userName;
	}

	public int getAge() {
	  return age;
	}

	public void setAge(int age) {
	  this.age = age;
	}

	public boolean isFlag() {
	  return flag;
	}

	public void setFlag(boolean flag) {
	  this.flag = flag;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
