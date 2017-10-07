package com.lzw.atmm.jms.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：消息消费者
 * 类名称：com.lzw.attm.jms.activemq.JMSConsumer     
 * 创建人：杨洪
 * 创建时间：2016年12月1日 上午10:04:56   
 * 修改人：
 * 修改时间：2016年12月1日 上午10:04:56   
 * 修改备注：   
 * @version   V1.0    
 */

public class JMSConsumer {
	
	private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;// 默认连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;// 默认连接地址
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;// 默认连接地址
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		//回话    接受或者发送消息的线程
		Session session = null;
		//消息的目的地
		Destination destination = null;
		//消息的消费者
		MessageConsumer messageConsumer = null;
		
		//实例化连接工厂
		connectionFactory 
		        = new ActiveMQConnectionFactory(JMSConsumer.USER_NAME, 
		        		                        JMSConsumer.PASSWORD, 
		        		                        JMSConsumer.BROKEURL);
		try {
			connection = connectionFactory.createConnection();//通过连接工厂获取连接
			connection.start();//启动连接
			session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);//创建回话线程，不开启事务
			destination = session.createQueue("FirstQueue1");//创建消息的目的地
			
			messageConsumer = session.createConsumer(destination);//通过目的地创建消息的消费者
			//创建一个循环
			while(true){
				//100毫秒接收一次
				//强制转换为文本消息
				TextMessage message =(TextMessage) messageConsumer.receive(100000);
				//判断当消息为空时,跳出循环
				if(message != null){
				   System.out.println("收到的消息为:"+message.getText());
				}else{
					break;//没有消息终止循环，节约系统资源
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
