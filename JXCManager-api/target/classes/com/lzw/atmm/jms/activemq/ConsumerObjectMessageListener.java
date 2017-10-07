package com.lzw.atmm.jms.activemq;
import java.util.Iterator;
import java.util.Set;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import com.google.common.collect.Sets;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：消息对象监听器
 * 类名称：com.lzw.attm.jms.activemq.ConsumerObjectMessageListener     
 * 创建人：杨洪
 * 创建时间：2016年12月13日 上午10:34:07   
 * 修改人：
 * 修改时间：2016年12月13日 上午10:34:07   
 * 修改备注：   
 * @version   V1.0    
 */

public class ConsumerObjectMessageListener implements MessageListener {
	Set<MessageVo> set = Sets.newHashSet();
	@Override
	public void onMessage(Message message) {
		try {
			/*System.out.println("收到的消息为:"+ ((TextMessage) message).getText());
			String messageJson = ((TextMessage) message).getText();
			MessageVo messageVo=(MessageVo) Object2JsonUtil.Decode(messageJson);*/
			MessageVo messageVo=(MessageVo) ((ObjectMessage)message).getObject();
			set.add(messageVo);
			/*System.out.println("这是json转换后的实体对象:"+messageVo.toString());
		    System.out.println("接受到的消息内容为:"+messageVo.getContent());*/
		    System.out.println("这是通过Object传递的实体对象:"+messageVo.toString());
		    System.out.println("接受到的消息内容为:"+messageVo.getContent());
		    Iterator<MessageVo> iter=	set.iterator();
		    if(iter.hasNext()){
		    	MessageVo vo =iter.next();
		    	System.out.println("这是set集合输出的消息"+vo.toString());
		      }
		    
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
