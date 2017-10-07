package com.lzw.atmm.jms.activemq;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述： 消息消费者-----监听消息的监听器
 * 类名称：com.lzw.attm.jms.activemq.ConsumerMessageListener     
 * 创建人：杨洪
 * 创建时间：2016年12月1日 上午10:51:17   
 * 修改人：
 * 修改时间：2016年12月1日 上午10:51:17   
 * 修改备注：   
 * @version   V1.0    
 */

public class ConsumerMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {//单消息中间件中有消息时,该监听器会监听到消息,并通知消费者
		try {
			System.out.println("收到的消息为:"+((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
