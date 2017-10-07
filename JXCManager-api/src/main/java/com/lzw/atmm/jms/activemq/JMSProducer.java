package com.lzw.atmm.jms.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api 
 * 类描述：消息生产者
 * 类名称：com.lzw.attm.jms.activemq.JMSProducer 
 * 创建人：杨洪 
 * 创建时间：2016年12月1日 上午9:19:37
 * 修改人： 
 * 修改时间：2016年12月1日 上午9:19:37
 * 修改备注：
 * 
 * @version V1.0
 */

public class JMSProducer {
	private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;// 默认连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;// 默认连接地址
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;// 默认连接地址
    private static final int SENDNUM=50000;//发送的消息数
	
	
	public static void main(String[] args) {
		
			ConnectionFactory connectionFactory = null;
			Connection connection = null;
			Session session = null;
			Destination destination = null;

			MessageProducer messageProducer = null;// 消息生产者
			try {
			// 创建连接工厂
			connectionFactory = new ActiveMQConnectionFactory(
					JMSProducer.USER_NAME, JMSProducer.PASSWORD,
					JMSProducer.BROKEURL);
			connection = connectionFactory.createConnection();

			connection.start();//启动连接
			//创建回话-----发送或者接受消息
			session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);//开启事务
			
			
			//创建消息的队列
			destination = session.createQueue("FirstQueue1");
			//创建消息生产者
			messageProducer = session.createProducer(destination);
			
			sendMessage(session,messageProducer);//发送消息
			
			session.commit();//提交确认消息已经发送
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(connection != null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	/**
	 * 
	 * @throws Exception 
	 * @Title: sendMessage
	 * @Description:发送消息
	 */
	protected static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{//那个线程对应的消息
		for(int i=0;i<SENDNUM;i++){//循环发送消息
			TextMessage message 
			            = session.createTextMessage("ActiveMQ发送的消息:"+i);
			System.out.println("发送消息:"+"ActiveMQ发送的消息:"+i);
			//生产者发送消息
			messageProducer.send(message);
		}
		
		
	}

}
