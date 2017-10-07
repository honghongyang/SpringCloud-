package com.lzw.atmm.tsd.tclient.document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.tree.DefaultElement;

import com.google.common.collect.Lists;
/**   
 * 版权所有：2017-中实智达
 * 项目名称：JXCManager-api   
 * 类描述    ：解析XML获取节点数据
 * 类名称    ：com.lzw.atmm.tsd.tclient.document.TrajHLevelDom     
 * 创建人    ：杨洪
 * 创建时间：2017年1月4日 上午10:50:20   
 * 修改人    ：
 * 修改时间：2017年1月4日 上午10:50:20   
 * 修改备注：   
 * @version   V1.0    
 */
public class TrajHLevelDom extends NativeDom {
	private final static String filePath="config/trajHLevel.xml";
	private Document doc;
	
	public TrajHLevelDom(){
		this(filePath);//this指代当前类对象
	}
	public TrajHLevelDom(String filePath) {
		doc = getDocument(filePath);
	}
	/**
	 * 返回雷达航迹高度层设置
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public synchronized List<TrajHLevel>  getTrajHLevels(){//把节点的属性---属性值转换位对象
		if(!doc.hasContent()){
			getSingletonNode();
		}
		List<TrajHLevel> trajList = Lists.newArrayList();
		String nodePath = "//TrajHLevels";//根节点的路径
		Node node = doc.selectSingleNode(nodePath);//选择简单的节点路径
		Element elem = null;
		if(node != null && node instanceof DefaultElement){//节点树状结构
			elem = (Element) node;
			List<Element> list = elem.elements("TrajHLevel");
			for(int i = 0 ;i<list.size();i++){
				TrajHLevel trajHLevel = new TrajHLevel();
				Element element=list.get(i);
				trajHLevel.setLow(Integer.valueOf(element.attributeValue("low")));
				trajHLevel.setHigh(Integer.valueOf(element.attributeValue("high")));
				trajHLevel.setRgb(element.attributeValue("rgb"));
				trajList.add(trajHLevel);
			}
		}
		return trajList;
		
	}
	/**
	 * 获取父节点
	 * @return
	 */
	private Node getSingletonNode(){
		Element element=doc.getRootElement();
		if(element==null){
			Element root=doc.addElement("TrajHLevels");//创建根元素,名称为TrajHLevels
			return root;
		}
		return element;
	}
	
	/**
	 * 保存雷达航迹高度设置
	 * @param elem
	 */
	public void saveOrUpdate(List<TrajHLevel> elems){
		if(!doc.hasContent()){
			getSingletonNode();//创建根节点
		}
		String nodePath = "//TrajHLevels";
		Node node = doc.selectSingleNode(nodePath);
		if(node != null && node instanceof DefaultElement){
			Element trajs = (Element) node;
			trajs.clearContent();//清空文本内容
			if(elems != null){
				for(TrajHLevel elem : elems){
					Element trajElement = trajs.addElement("TrajHLevel");//创建TrajHLevel标签
					trajElement.addAttribute("low", String.valueOf(elem.getLow()));//塞入文本标签的属性里面
					trajElement.addAttribute("high",String.valueOf(elem.getHigh()));
					trajElement.addAttribute("rgb",String.valueOf(elem.getRgb()));
				}
			}
		}
		
	}
	/**
	 * 保存增删改结果，则持久化到本地文件中
	 */
	public void close(){//关闭的时候持久化存储
		File file = new File(filePath);
		if(!file.exists())
		{
		try {
			    file.getParentFile().mkdirs();//循环创建多层目录
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileOutputStream outPutStream 
			                 = new FileOutputStream(filePath,false);
			serializeToXml(outPutStream,getDocument(filePath));//持久化到文件中
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
