package com.lzw.atmm.tsd.util;
import java.io.Serializable;
import com.mysql.jdbc.StringUtils;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：JSON 2 Object相互转换
 * 类名称：com.lzw.attm.util.Object2Json     
 * 创建人：杨洪
 * 创建时间：2016年12月12日 下午5:04:25   
 * 修改人：
 * 修改时间：2016年12月12日 下午5:04:25   
 * 修改备注：   
 * @version   V1.0    
 */

public class Object2JsonUtil implements Serializable{//日期类型的格式化转换
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @Title: encode
	 * @Description: 对象转换为JSON字符串
	 * @param ：o 对象类型 
	 * @return
	 */
	public static String encode(Object o){//对象转换为JSON
		if(o==null || o.toString().equals("null")) return null;
		if(o != null && o.getClass()==String.class){
			return o.toString();
		}
		JSONSerializer serializer = new JSONSerializer();
		return serializer.deepSerialize(o);
	}
	
	/**
	 * 
	 * @Title: Decode
	 * @Description: json字符串对象转换为Object
	 * @param json
	 * @return
	 */
	public static Object Decode(String json){
		if(StringUtils.isNullOrEmpty(json)) return "";
		JSONDeserializer<Object> deserializer = new JSONDeserializer<Object>();	
		Object o  = deserializer.deserialize(json);
		if(o != null && o.getClass()==String.class){
			return Decode(o.toString());
		}
		return o;
	}
}
