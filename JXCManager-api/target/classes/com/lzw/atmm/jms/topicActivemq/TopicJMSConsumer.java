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
 * 类描述：消息消费者---消息订阅者一
 * 类名称：com.lzw.attm.jms.topicActivemq.TopicJMSConsumer     
 * 创建人：杨洪
 * 创建时间：2016年12月1日 下午2:31:18   
 * 修改人：
 * 修改时间：2016年12月1日 下午2:31:18   
 * 修改备注：   
 * @version   V1.0    
 */

public class TopicJMSConsumer {//消息订阅者一
	private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;  //默认连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认连接密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接URL
	
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;//连接工厂
		Connection connection = null;//连接
		Session session  = null;//回话   接受订阅消息的线程 
		Destination destination = null ;// 消息目的地
		MessageConsumer messageConsumer = null ;//消息消费者
		
		
		//实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(TopicJMSConsumer.USER_NAME,
				                                          TopicJMSConsumer.PASSWORD,
				                                          TopicJMSConsumer.BROKEURL);
		try {
			connection = connectionFactory.createConnection();//创建连接
			connection.start();//启动连接
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//创建接受消息的线程,不开启事务
			destination = session.createTopic("yangHongTopic001");//创建订阅者消息队列
			//实例化订阅者
			messageConsumer = session.createConsumer(destination);
			//为消息订阅者注册监听器
			messageConsumer.setMessageListener(new TopicListener());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
