package com.lzw.atmm.component;

import java.util.EventListener;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述： 双击监听器
 * 类名称：com.lzw.atmm.component.DoubleClickListener     
 * 创建人：杨洪
 * 创建时间：2016年12月29日 上午11:57:26   
 * 修改人：
 * 修改时间：2016年12月29日 上午11:57:26   
 * 修改备注：   
 * @version   V1.0    
 */

public interface DoubleClickListener extends EventListener{
	public void doubleClickOperation();
}
