package com.lzw.atmm.jms.activemq;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：消息载体
 * 类名称：com.lzw.attm.jms.activemq.Message     
 * 创建人：杨洪
 * 创建时间：2016年12月13日 上午10:12:03   
 * 修改人：
 * 修改时间：2016年12月13日 上午10:12:03   
 * 修改备注：   
 * @version   V1.0    
 */
public class MessageVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;//消息ID
	private String title;//消息标题
	private String content;//消息内容
	private Date date;//发送消息的日期
	private String sendPerson;//消息发送者

	private MessageVo(){
	}
	private static class MessageSingleHandler{//私有的内部类
		private static MessageVo instance = new MessageVo();
	}
	public static MessageVo newInstance(){ //公有的静态方法
		return MessageVo.MessageSingleHandler.instance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSendPerson() {
		return sendPerson;
	}

	public void setSendPerson(String sendPerson) {
		this.sendPerson = sendPerson;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
