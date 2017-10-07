package com.lzw.atmm.tsd.util;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：XML文件辅助解析类
 * 类名称：com.lzw.attm.util.YangXmlHelper     
 * 创建人：杨洪
 * 创建时间：2016年10月25日 下午3:11:53   
 * 修改人：
 * 修改时间：2016年10月25日 下午3:11:53   
 * 修改备注：   
 * @version   V1.0    
 */

public class YangXmlHelper {
	private ThreadLocal<SAXReader> reader = new ThreadLocal<SAXReader>();
	private ThreadLocal<Document> doc = new ThreadLocal<Document>();
	private ThreadLocal<Element> root = new ThreadLocal<Element>();
	
	private YangXmlHelper(){
	}
	private  static class newInstance{
		private static YangXmlHelper instance = new YangXmlHelper();
	}
	public static YangXmlHelper newInstance(){
		return YangXmlHelper.newInstance.instance;
	}
	
	/**
	 * 读取xml文件流,如果不是null,即读取成功,返回值为根元素
	 */
	public Element read(InputStream is){
		try {
			if(reader.get()==null)
				reader.set(new SAXReader());
				doc.set(reader.get().read(is));
				root.set(doc.get().getRootElement());
			return root.get();//返回根元素
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 读取xml文件,如果不是null,即读取成功,返回值为根元素
	 */
	public Element read(String fileName){
		
		try {
			if(reader.get()==null)
				reader.set(new SAXReader());
			    doc.set(reader.get().read(new File(fileName)));
			    root.set(doc.get().getRootElement());
			    return root.get();
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
				
	}
	
	/**
	 * @return 读取器对象
	 */
	public SAXReader getReader(){
		return reader.get();
	}
	/**
	 * @Title: getDoc
	 * @return:获取文档对象
	 */
	public Document getDoc(){
		return doc.get();
	}
	/**
	 * @return 获取根节点
	 */
	public Element getRoot(){
		return root.get();
	}
	
	/**
	 * 查找某个属性特定值的元素的另外某个属性x
	 * @param e 父节点
	 * @param attrName 已知的属性名
	 * @param attrValue 已知的属性值
	 * @param findAttrName 要查找的未知属性值的属性名
	 * @return 查出的属性值
	 */
	@SuppressWarnings("unchecked")
	public String findAttrValueFromHadAttr(Element e,String attrName,String attrValue,String findAttrName)
	{
		List<Element> list=e.elements();
		for(Element el:list)
		{
			String value=el.attributeValue(attrName);
			if(value!=null&&value.equals(attrValue))
			{
				return el.attributeValue(findAttrName);
			}
		}
		return null;
	}
	
	/**
	 * @return parent为父节点的直接子节点的特定属性列表
	 */
	@SuppressWarnings("unchecked")
	public List<String> getChildAttr(Element parent,String attrName)
	{
		List<String> result=Lists.newArrayList();
		List<Element> list=parent.elements();
		for(Element el:list)
		{
			result.add(el.attributeValue(attrName));
		}
		return result;
	}
	
	
	/**
	 * @param attrNameKey 要作为键的属性名
	 * @param attrNameValue 要作为值的属性名
	 * @return parent为父节点的直接子节点的某两个属性的键值对表
	 */
	@SuppressWarnings("unchecked")
	public Map<String,String> getChildAttrsMaps(Element parent,String attrNameKey,String attrNameValue)
	{
		Map<String,String> map=Maps.newHashMap();
		List<Element> list=parent.elements();
		for(Element el:list)
		{
			map.put(el.attributeValue(attrNameKey), el.attributeValue(attrNameValue));
		}
		return map;
	}
	
	/**
	 * @return 将parent子节点们作为beanClass所指定的类型的对象以列表形式返回
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getPojoList(Element parent, Class<T> beanClass)///反射相关
	{
		try
		{
			List<T> result=new ArrayList<T>();
			List<Element> list=parent.elements();
			for(Element el:list)
			{
				 List<Element> bean=el.elements();
				 T instance=beanClass.newInstance();
				 for(Element property:bean)
				 {
					 String propName=property.getName();
					 String propValue=property.getText();
					 PropertyDescriptor pd=new PropertyDescriptor(propName, beanClass);
					 Method setMethod=pd.getWriteMethod();
					 Class<?>[] clazzes=setMethod.getParameterTypes();
					 Constructor<?> constructor=clazzes[0].getConstructor(String.class);
					 setMethod.invoke(instance, constructor.newInstance(propValue));
				 }
				 result.add(instance);
			}
			return result;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		} 
	}

}
