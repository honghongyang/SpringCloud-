package com.lzw.atmm.tsd.tclient.document;

import java.io.File;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：本地XML文档解析
 * 类名称：com.lzw.tsd.tclient.doc.NativeDom     
 * 创建人：杨洪
 * 创建时间：2016年10月26日 上午11:36:54   
 * 修改人：
 * 修改时间：2016年10月26日 上午11:36:54   
 * 修改备注：   
 * @version   V1.0    
 */

public class NativeDom {
	
	private Document doc;
	
	public Document parse(File file) throws DocumentException{//解析本地XML文件
		SAXReader reader = new SAXReader();
		Document doc=reader.read(file);
		return doc;
		
	}
	
	
	public Document getDocument(String fileName){
		if(doc==null){
			File file = new File(fileName);
			if(file.exists()){
				try {
					doc=parse(file);
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}else{
				doc =DocumentHelper.createDocument();
			}
		}
		return doc;
		
	}
	//把Document转换为XML文档
	public void serializeToXml(OutputStream out,Document doc) throws Exception{
		OutputFormat format=OutputFormat.createPrettyPrint();//创建格式化的输出流
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.flush();
		writer.close();
	}
	
	

}
