package com.lzw.atmm.jms.topicActivemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：消息订阅者二
 * 类名称：com.lzw.attm.jms.topicActivemq.TopicOtherJMSConsumer     
 * 创建人：杨洪
 * 创建时间：2016年12月1日 下午3:26:12   
 * 修改人：
 * 修改时间：2016年12月1日 下午3:26:12   
 * 修改备注：   
 * @version   V1.0    
 */

public class TopicOtherJMSConsumer {//消息订阅者二
	private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接地址
	
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null ;//连接工厂
		Connection connection = null ;//连接
		Session session = null ;//回话  接收消息的线程管道
		Destination destination = null ;//消息的连接目的地
		MessageConsumer messageConsumer = null;//消息订阅者
		
		//实例化连接
		connectionFactory = new ActiveMQConnectionFactory(TopicOtherJMSConsumer.USER_NAME,
				                                          TopicOtherJMSConsumer.PASSWORD,
				                                          TopicOtherJMSConsumer.BROKEURL);
		try {
			connection = connectionFactory.createConnection();//实例化连接
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//实例化订阅消息线程渠道,并关闭事务控制
			destination = session.createTopic("yangHongTopic001");//创建订阅主题队列
			//实例化消息订阅者
			messageConsumer = session.createConsumer(destination);
			//为订阅者注册消息监听器
			messageConsumer.setMessageListener(new TopicOtherListener());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
