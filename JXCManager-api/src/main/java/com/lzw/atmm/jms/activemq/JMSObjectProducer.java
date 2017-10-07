package com.lzw.atmm.jms.activemq;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：消息生产者----对象模型
 * 类名称：com.lzw.attm.jms.activemq.JMSObjectProducer     
 * 创建人：杨洪
 * 创建时间：2016年12月12日 下午3:16:09   
 * 修改人：
 * 修改时间：2016年12月12日 下午3:16:09   
 * 修改备注：   
 * @version   V1.0    
 */

public class JMSObjectProducer {
	private static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;//默认链接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认密码
	private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL;//默认brokeUrl连接地址
	private static final int SENDNUM=50000;//发送的消息数
	
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageProducer messageProducer = null;//消息生产者
		try {
			connectionFactory = new ActiveMQConnectionFactory(JMSObjectProducer.USER_NAME,
                    JMSObjectProducer.PASSWORD,
                    JMSObjectProducer.BROKEURL);
			connection = connectionFactory.createConnection();
			connection.start();//启动连接
			//创建回话,发送或者接收消息的线程
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			//创建消息队列
			destination = session.createQueue("FirstQueue2");
			//创建消息生产者
			messageProducer = session.createProducer(destination);
			
			
            sendMessage(session,messageProducer);//发送消息
			
			session.commit();//提交确认消息已经发送
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
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
		MessageVo messageVo =MessageVo.newInstance();
		for(int i=0;i<SENDNUM;i++){//循环发送消息
			messageVo.setId(i);
			messageVo.setTitle("消息测试标题----"+i);
			messageVo.setDate(new Date());
			messageVo.setSendPerson("杨洪-----"+i);
			messageVo.setContent("{at com.lzw.attm.jms.activemq.Consumer【这是发送的消息内容】ObjectMessageListener.onMessage-----"+i+"}");
			
			
			ObjectMessage message=session.createObjectMessage(messageVo);//此处的实体一定要实现Serialize接口
			/*TextMessage message 
			            = session.createTextMessage(Object2JsonUtil.encode(messageVo));//对象转换为json字符串【Object<--->JSON】
*/			System.out.println("发送消息:"+"ActiveMQ发送的消息:"+message.toString());
			//生产者发送消息
			messageProducer.send(message);
		}
		
		
	}

}
