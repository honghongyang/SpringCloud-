package com.lzw.atmm.jms.activemq;

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
 * 类描述：消息消费者
 * 类名称：com.lzw.attm.jms.activemq.JMSObjectConsumerAdvanced     
 * 创建人：杨洪
 * 创建时间：2016年12月13日 上午10:31:16   
 * 修改人：
 * 修改时间：2016年12月13日 上午10:31:16   
 * 修改备注：   
 * @version   V1.0    
 */

public class JMSObjectConsumerAdvanced {
	private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;//默认的用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认的用户名
	private static final String BROKEURL= ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接地址
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;//回话    接受或者发送消息的线程
		Destination destination = null;
		MessageConsumer messageConsumer = null;
		connectionFactory = new ActiveMQConnectionFactory(JMSObjectConsumerAdvanced.USER_NAME,
				                                          JMSObjectConsumerAdvanced.PASSWORD,
				                                          JMSObjectConsumerAdvanced.BROKEURL);
		try {
			connection = connectionFactory.createConnection();
			connection.start();//启动连接
			session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);//创建回话  --- 接受消息的线程
			destination = session.createQueue("FirstQueue2");//创建接收消息的队列
			messageConsumer = session.createConsumer(destination);//创建消息的连接者
			messageConsumer.setMessageListener(new ConsumerObjectMessageListener());//为生产者注册消息监听器,自监听消息队列中是否有消息
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
