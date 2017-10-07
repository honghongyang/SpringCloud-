package com.lzw.atmm.jms.topicActivemq;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：消息订阅监听器
 * 类名称：com.lzw.attm.jms.topicActivemq.TopicListener     
 * 创建人：杨洪
 * 创建时间：2016年12月1日 下午2:56:38   
 * 修改人：
 * 修改时间：2016年12月1日 下午2:56:38   
 * 修改备注：   
 * @version   V1.0    
 */

public class TopicListener implements MessageListener {


	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("订阅者一接收到的消息为:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
