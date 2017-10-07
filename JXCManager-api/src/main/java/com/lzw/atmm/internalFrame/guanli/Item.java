package com.lzw.atmm.internalFrame.guanli;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：下拉选择框  ----Vo实体类
 * 类名称：com.lzw.internalFrame.guanli.Item     
 * 创建人：杨洪
 * 创建时间：2016年8月5日 下午3:48:19   
 * 修改人：
 * 修改时间：2016年8月5日 下午3:48:19   
 * 修改备注：   
 * @version   V1.0    
 */

public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	public String id;
	public String name;
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
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
