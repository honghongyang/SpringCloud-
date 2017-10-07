package com.lzw.atmm.jms;

import javax.jms.JMSException;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：
 * 类名称：com.lzw.attm.jms.JmsTest     
 * 创建人：杨洪
 * 创建时间：2016年12月1日 下午5:23:32   
 * 修改人：
 * 修改时间：2016年12月1日 下午5:23:32   
 * 修改备注：   
 * @version   V1.0    
 */

public class JmsTestByte {
	public static void main(String[] args) throws JMSException, Exception {
		  JmsSender sender = new JmsSender();
		  JmsReceiver receiver = new JmsReceiver();
		  
		  sender.sendMessage("object");
		  sender.close();
		  
		  receiver.receiveMessage();
		  receiver.close();
		  
		}    

}
