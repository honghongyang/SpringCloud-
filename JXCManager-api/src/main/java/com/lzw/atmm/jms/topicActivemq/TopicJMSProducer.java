package com.lzw.atmm.jms.topicActivemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：消息生产者---topic主题---消息发布者
 * 类名称：com.lzw.attm.jms.topicActivemq.TopicProducer     
 * 创建人：杨洪
 * 创建时间：2016年12月1日 上午11:59:42   
 * 修改人：
 * 修改时间：2016年12月1日 上午11:59:42   
 * 修改备注：   
 * @version   V1.0    
 */

public class TopicJMSProducer {//发布与订阅模式
	private static final String USER_NAME=ActiveMQConnectionFactory.DEFAULT_USER;//默认连接的用户名称
	private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;//默认连接密码
	private static final String BROKEURL= ActiveMQConnectionFactory.DEFAULT_BROKER_URL;//默认连接URL
	private static final int SENDNUM = 50000;//消息发送数量
	
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;//连接工厂
		Connection connection = null;
		Session session = null;//回话   发送订阅消息的线程
		Destination destination = null;//发送消息的目的地
		MessageProducer messageProducer = null;//消息生产者对象
		
		
		
		//实例化连接工厂
		connectionFactory  = 
				new ActiveMQConnectionFactory(TopicJMSProducer.USER_NAME,
						                      TopicJMSProducer.PASSWORD,
						                      TopicJMSProducer.BROKEURL);
		try {
			connection = connectionFactory.createConnection();//创建连接
			//启动连接
			connection.start();
		    //通过连接创建回话
			session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);//创建连接,开启消息事务控制
			destination = session.createTopic("yangHongTopic001");//创建订阅消息队列--通道
			//创建消息生产者
			messageProducer = session.createProducer(destination);
			//发送消息
			sendMessage(session,messageProducer);
			session.commit();//告诉消息中间件------确认已经发送
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
    protected static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{
    	for(int i=0;i<SENDNUM;i++){
    		TextMessage message=session.createTextMessage("ActiveMQ发布的Topic类型文本消息为:"+i);
    		System.out.println("发送的消息为:"+"-----ActiveMQ发送的Topic类型文本消息为："+i);
    		messageProducer.send(message);
    	}
    }
	
	
	

}
