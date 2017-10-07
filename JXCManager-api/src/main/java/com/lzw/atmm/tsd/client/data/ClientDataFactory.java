package com.lzw.atmm.tsd.client.data;
import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.lzw.atmm.tsd.util.YangXmlHelper;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：客户端数据更新检查工厂-----线程驱动
 * 类名称：com.lzw.tsd.client.data.ClientDataFactory     
 * 创建人：杨洪
 * 创建时间：2016年10月25日 下午2:17:45   
 * 修改人：
 * 修改时间：2016年10月25日 下午2:17:45   
 * 修改备注：   
 * @version   V1.0    
 */

public class ClientDataFactory implements Runnable {
	
   
    private static Logger logger = Logger.getLogger(ClientDataFactory.class);
    private static final String DEFAULT = "1.0.0";
    private static String PATH = System.getProperty("user.dir");//当前工作目录
    private static ClientDataFactory instance;
    
    private ClientDataFactory(){
    }
    public synchronized static ClientDataFactory newInstance(){//单例模式
    	if(instance==null){
    		instance = new ClientDataFactory();
    	}
    	return instance;
    }
    
    
    /**
     * 
     * @Title: getLocalVersion
     * @return 获得本地Xml中的软件版本
     */
    public String getLocalVersion(){
    	String localVersion = null;
    	try {
			YangXmlHelper xmlHelper = YangXmlHelper.newInstance();
			Element root=xmlHelper.read(new FileInputStream(PATH+"\\LocalFiles.xml"));//当前工作目录的项目名路径
			Element element=root.element("Updater");//标签名称
			localVersion=element.element("UpdaterVersion").getText();//获得指定标签的内容
		} catch (Exception e) {
			logger.error("获取LocalFiles.xml错误：", e);
		}
    	return localVersion == null ? DEFAULT : localVersion;
    }
	
	
	

	
	
    //private ClientVersionService service;
	
	@Override
	public void run() {
		//checkClientVersion();
	}
	
	/**
	 * 重启进程
	 */
	public void reStart(){//指定路径打开任何可以执行的文件
		try {
			File file01 = new File("C:\\Program Files\\Internet Explorer\\iexplore.exe");//打开IE,
			File file02 = new File("D:/001File/window.bat");//打开文件
			File file03 = new File("D:/001File/运营后台系统需求说明.docx");//打开文件
			File file04 = new File("D:/myeclipse14/myeclipse.exe");//打开文件
        	logger.info("start file: "+file01.getAbsolutePath().replaceAll(" ", "\" \""));
        	logger.info("start file: "+file02.getAbsolutePath().replaceAll(" ", "\" \""));
        	logger.info("start file: "+file03.getAbsolutePath().replaceAll(" ", "\" \""));
        	logger.info("start file: "+file04.getAbsolutePath().replaceAll(" ", "\" \""));
			Runtime.getRuntime().exec("cmd /c start "+file01.getAbsolutePath().replaceAll(" ", "\" \""));
			//Runtime.getRuntime().exec("cmd /c start "+file02.getAbsolutePath().replaceAll(" ", "\" \""));
			Runtime.getRuntime().exec("cmd /c start "+file03.getAbsolutePath().replaceAll(" ", "\" \""));
			Runtime.getRuntime().exec("cmd /c start "+file04.getAbsolutePath().replaceAll(" ", "\" \""));
		} catch (Exception e) {
			logger.error("重启客户端错误：", e);
		}
		//ConfigCenter.getInstance().pesistentProps2Files();
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		ClientDataFactory cmd=new ClientDataFactory();
		cmd.reStart();
		System.out.println("版本为:"+cmd.getLocalVersion());
	}
	
	
	/**
	 * 检查客户端版本
	 */
	/*public void checkClientVersion() {
		String localVersion = getLocalVersion();
		String serverVersion = getVersionService().retrieveLatestClientVersion().getApplicationVersion();
		if (null != serverVersion) {
			if (localVersion.compareTo(serverVersion) < 0) {
				SchedulerCenter.getInstance().cancelClientVersionTimer();
				SysPropToolkit.getInstance().getClientInfoDlg().setVisible(true);
			}
		}
	}

	public ClientVersionService getVersionService() {
		if (service == null) {
			service = new ClientVersionServiceBean(SysPropToolkit.getInstance().getClientConfig());
		}
		return service;
	}*/
	

}
