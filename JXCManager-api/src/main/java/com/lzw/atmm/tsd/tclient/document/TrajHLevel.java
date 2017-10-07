package com.lzw.atmm.tsd.tclient.document;

import org.apache.commons.lang.builder.ToStringBuilder;

/**   
 * 版权所有：2017-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：
 * 类名称：com.lzw.atmm.tsd.tclient.document.TrajHLevel     
 * 创建人：杨洪
 * 创建时间：2017年1月4日 上午10:42:09   
 * 修改人：
 * 修改时间：2017年1月4日 上午10:42:09   
 * 修改备注：   
 * @version   V1.0    
 */

public class TrajHLevel {
	private Integer low;
	private Integer high;
	private String rgb;
	public Integer getLow() {
		return low;
	}
	public void setLow(Integer low) {
		this.low = low;
	}
	public Integer getHigh() {
		return high;
	}
	public void setHigh(Integer high) {
		this.high = high;
	}
	public String getRgb() {
		return rgb;
	}
	public void setRgb(String rgb) {
		this.rgb = rgb;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
		
	}

}
