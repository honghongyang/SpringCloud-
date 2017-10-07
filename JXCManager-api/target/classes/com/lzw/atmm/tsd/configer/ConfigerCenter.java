package com.lzw.atmm.tsd.configer;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.lzw.atmm.tsd.util.ColorUtils;


/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述： 这个类管理TSD的初始化配置。它读取TSD的configuration files 并且注册他们的内容。 包括信息如风格、地图颜色等等
 * <p/>
 * 这个配置类是单例模式。
 * <p/>
 * 当这个Configuration类首次初始化时读取
 * 并且register所有的信息
 * 类名称：com.lzw.tsd.configer.ConfigerCenter     
 * 创建人：杨洪
 * 创建时间：2016年6月17日 上午9:26:27   
 * 修改人：
 * 修改时间：2016年6月17日 上午9:26:27   
 * 修改备注：文件持久化配置中心   
 * @version   V1.0    
 */

public class ConfigerCenter {//属性加载中心工厂
	
	private static final String THEME_FILE_NAME="config/theme.properties";
	private static final String FTP_FILE_NAME="config/ftp.properties";
	private static final String SERVER_FILE_NAME="config/server.properties";
	private static final String DATABASE_FILE_NAME="config/database.properties";
	private static final String USER_FILE_NAME="config/user.properties";
	private static final String CONFIGURE_PROPERTIES_FILE_NAME="config/configure.properties";
	private static final String CONSERVER_FILE_NAME="config/conserver.properties";
	
	
	//=================================key键的前后缀================================================
	private static final String STR_FTP="ftp";
	private static final String STR_USER="user";
	private static final String STR_SERVER="server";
	private static final String STR_CONSERVER="conserver";
	private static final String STR_THEME="theme";
	private static final String STR_DATABASE="database";
	private static final String STR_CONFIGURE="configure";
	private static final String STR_COLOR="color";
	private static final String BOOL_DEFAULT="true";
	//==================================================================================
	
	
	private ConfigerCenter(){
		initDefaults();
		initTheme();
	}
	private static class SingletonConfigerCenterHandler{
		private static ConfigerCenter instance = new ConfigerCenter();
	}
	public static ConfigerCenter getIntance(){
		return ConfigerCenter.SingletonConfigerCenterHandler.instance;
	}
	
	//********************************************************************************
	private final Properties configProperties = new Properties();//全局配置配置文件
	private final Properties colorProperties= new Properties();//加载颜色的相关属性
	private final Properties themeProperties = new Properties();//定义主题的一些属性配置文件
	private final Properties ftpProperties = new Properties();//定义fpt属性属性文件
	private final Properties serverProperties = new Properties();//服务器的一些属性配置文件
	private final Properties userProperties = new Properties();//用户的一些属性配置文件
	private final Properties databaseProperties = new Properties();//数据库的一些属性配置文件
	private final Properties conserverProperties = new Properties();//
	private final Properties themeTempProperties = new Properties();//主题临时属性容器类
	//*********************************************************************************
	
	
	private FileInputStream fileReader;
	public void initDefaults(){//加载初始化属性文件
	 try{
			configProperties.clear();
			fileReader = new FileInputStream(CONFIGURE_PROPERTIES_FILE_NAME);
			configProperties.load(fileReader);
			fileReader = new FileInputStream(THEME_FILE_NAME);
			themeProperties.load(fileReader);
			fileReader = new FileInputStream(FTP_FILE_NAME);
			ftpProperties.load(fileReader);
			fileReader = new FileInputStream(SERVER_FILE_NAME);
			serverProperties.load(fileReader);
			fileReader = new FileInputStream(USER_FILE_NAME);
			userProperties.load(fileReader);
			fileReader = new FileInputStream(DATABASE_FILE_NAME);
			databaseProperties.load(fileReader);
			fileReader = new FileInputStream(CONSERVER_FILE_NAME);
			conserverProperties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fileReader != null){
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	public void initTheme(){// 初始化主题文件
		Set<Object> set =themeTempProperties.keySet();//Properties2Set<Object>//把Properties属性文件转换为Set<Object>集合对象
		Iterator<Object> iter=set.iterator();//把集合转换为迭代器对象
		while(iter.hasNext())
		{
			Object key  = iter.next();
			if(themeProperties.get(key)==null)
			{
				themeProperties.put(key, themeTempProperties.get(key));
			}	
		}
	}
	public String getProperty(String key){//根据key获取属性值
		if(key.startsWith(STR_FTP))
		{
			return ftpProperties.getProperty(key);
		}else if(key.startsWith(STR_USER)){
			return userProperties.getProperty(key);
		}else if(key.startsWith(STR_SERVER)){
			return serverProperties.getProperty(key);
		}else if(key.startsWith(STR_CONSERVER)){
			return conserverProperties.getProperty(key);
		}else if(key.startsWith(STR_DATABASE)){
			return databaseProperties.getProperty(key);
		}else if(key.startsWith(STR_THEME)){
			return themeProperties.getProperty(key);
		}else if(key.startsWith(STR_CONFIGURE)){
			return configProperties.getProperty(key);
		}else if(key.startsWith(STR_COLOR)){
			return colorProperties.getProperty(key);
		}else{
			return null;
		}
		
	}
	
	public void loadTheme2Default(String param){//加载主题到默认属性文件
		FileInputStream fileReader;
		    try {
				fileReader = new FileInputStream("theme/"+param);
				themeProperties.load(fileReader);
				fileReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	/********持久化属性key和value到对应的.properties文件*********/
	public void persistentProperty(String key,String value){//持久化key value到文件
		if(key.startsWith(STR_USER)){
			userProperties.put(key, value);//内存
			storeProperties(userProperties,USER_FILE_NAME);
		}else if(key.startsWith(STR_SERVER)){
			serverProperties.put(key, value);
			storeProperties(serverProperties,SERVER_FILE_NAME);
		}else if(key.startsWith(STR_CONSERVER)){
			conserverProperties.put(key, value);
			storeProperties(conserverProperties,CONSERVER_FILE_NAME);
		}else if(key.startsWith(STR_THEME)){
			themeProperties.put(key, value);
			storeProperties(themeProperties,THEME_FILE_NAME);
		}else if(key.startsWith(STR_CONFIGURE)){
			configProperties.put(key,value);
			storeProperties(configProperties,CONFIGURE_PROPERTIES_FILE_NAME);
		}else if(key.startsWith(STR_COLOR)){
			configProperties.put(key, value);
			storeProperties(colorProperties,THEME_FILE_NAME);
		}
	}
	
	
	/*********************************************持久化到内存中********************************************************/
	public void setProperty(String key,String value){
		if(key.startsWith(STR_FTP)){
			ftpProperties.put(key, value);
		}else if(key.startsWith(STR_USER)){
			userProperties.put(key, value);
		}else if(key.startsWith(STR_SERVER)){
			serverProperties.put(key, value);
		}else if(key.startsWith(STR_CONSERVER)){
			conserverProperties.put(key, value);
		}else if(key.startsWith(STR_CONFIGURE)){
			configProperties.put(key, value);
		}
		
	}
	
	
	/************************持久化到文件******************************/
	public void persistentProps2Files(){
		persistentUserProperties2Files();
		persistentConfigureProperties2Files();
		persistentConserverProperties2Files();
		persistentServerProperties2Files();
	}
	public void persistentUserProperties2Files(){
		storeProperties(userProperties,USER_FILE_NAME);
	}
	public void persistentServerProperties2Files(){
		storeProperties(serverProperties,SERVER_FILE_NAME);
	}
	public void persistentConfigureProperties2Files(){
		storeProperties(configProperties,CONFIGURE_PROPERTIES_FILE_NAME);
	}
	
	public void persistentConserverProperties2Files(){
		storeProperties(conserverProperties,CONSERVER_FILE_NAME);//持久化到对应的文件
	}
	
	
	public Color getColorFromInt(String colorName){//根据名称获取颜色
		String colorStr =getProperty(colorName);
		Color color;
		if(StringUtils.isBlank(colorStr)){
			color=ColorUtils.toColor(colorStr);
		}else{
			color=Color.RED;
		}
		return color;
	}
	
	public void persistentColor(String colorName ,Color color){///持久化到文件
		String colorStr=ColorUtils.toRgbColor(color);
		persistentProperty(colorName,colorStr);//持久化到文件
	}
	
	
	public void setPropertyColor(String colorName,Color color){
		String colorStr=ColorUtils.toRgbColor(color);
		setProperty(colorName,colorStr);//持久化到内存中
	}
	
	//***************************************************************************************************************
	private void storeProperties(Properties properties,String fileName){//相应的属性以流的形式存入文件========公共方法===========
		FileOutputStream fos =null;
	    try {
				fos = new FileOutputStream(fileName);
				properties.store(fos,new Date().toString());//以流的形式存入持久化文件
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	//***************************************************************************************************************
	
    public String getProperty(String key,String defaultValue){
    	String value=getProperty(key);
    	if(value == null){
    	    return defaultValue;
    	}else{
    		return value;
    	}
    }
    
    public Boolean getBoolean(String key){
    	String booleanStr=getProperty(key,BOOL_DEFAULT);
    	Boolean theBol = Boolean.valueOf(booleanStr);
    	return theBol.booleanValue();
    }
}
