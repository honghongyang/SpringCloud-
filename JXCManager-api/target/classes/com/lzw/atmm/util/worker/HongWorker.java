package com.lzw.atmm.util.worker;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：标记性接口,JohnSwingWorker,JohnProgressSynchroWorker都继承自该接口,
 *      以该接口变量承接,可迅速在同步和异步间切换而获得加载界面
 * 类名称：com.lzw.atmm.util.worker.HongWorker     
 * 创建人：杨洪
 * 创建时间：2016年12月13日 下午3:13:11   
 * 修改人：
 * 修改时间：2016年12月13日 下午3:13:11   
 * 修改备注：   
 * @version   V1.0    
 */

public interface HongWorker {
	/**设置进度值和描述*/
	
	public void setProgressValue(int value,String doingString);

}
