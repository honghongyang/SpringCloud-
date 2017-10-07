package com.lzw.attm.client.display;

import com.lzw.atmm.tsd.configer.ConfigerCenter;
import com.lzw.atmm.tsd.configer.SystemInfo;
import com.lzw.atmm.view.message.ConfirmDlg;



/**   
 * 版权所有：2017-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：下载文件的线程
 * 类名称：com.lzw.attm.client.display.NoticeDownThread     
 * 创建人：杨洪
 * 创建时间：2017年1月6日 下午3:02:16   
 * 修改人：
 * 修改时间：2017年1月6日 下午3:02:16   
 * 修改备注：   
 * @version   V1.0    
 */

public class NoticeDownThread implements Runnable{
	// FTP服务器的IP
		private String ip = "";
		// 连接服务器的用户名和密码
		private String username = "";
		private String password = "";
		// 待下载文件在FTP上的目录和文件名
		private String ftpDir = "";
		private String ftpFileName = "";
		// 下载到本地后的文件名
		private String localFileName = "";

		// 构造方法
		public NoticeDownThread(String path, String filename,
				String userpath) {
			this.ftpDir = path;
			this.ftpFileName = filename;
			this.localFileName = userpath;
		}

		public void run() {
			try {
				ip = ConfigerCenter.getIntance().getProperty(SystemInfo.FTP_IP);
				username =  ConfigerCenter.getIntance().getProperty(
						SystemInfo.FTP_USERNAME);
				password =  ConfigerCenter.getIntance().getProperty(
						SystemInfo.FTP_PASSWORD);
			   // 用用户名和密码登陆
				FtpClient ftpClient = new FtpClient();
				ftpClient.getConn(ip, username, password, ftpDir);
				ftpClient.downLoadFile(ftpFileName, localFileName);
			} catch (Exception e) {
				ConfirmDlg.showConfirmDialog(null, "发生错误，请重新操作！", ConfirmDlg.ERROR_MESSAGE);
			}
		}

}
