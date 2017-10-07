package com.lzw.atmm.tsd.tclient.document;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：与XML文档对应的domain模型【与LocalFiles.xml对应】
 * 类名称：com.lzw.tsd.tclient.doc.AppElement     
 * 创建人：杨洪
 * 创建时间：2016年10月26日 下午1:28:45   
 * 修改人：
 * 修改时间：2016年10月26日 下午1:28:45   
 * 修改备注：   
 * @version   V1.0    
 */

public class AppElement implements Serializable {
	private static final long serialVersionUID = -6189412405604364689L;
	
	private String AppName;//标签名称
	private String version;//版本号标签
	public String getAppName() {
		return AppName;
	}
	public void setAppName(String appName) {
		AppName = appName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	
	

}
