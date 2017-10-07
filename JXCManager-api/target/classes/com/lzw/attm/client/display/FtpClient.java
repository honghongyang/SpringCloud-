package com.lzw.attm.client.display;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import com.lzw.atmm.view.message.ConfirmDlg;
/**   
 * 版权所有：2017-中实智达
 * 项目名称：JXCManager-api   
 * 类描述    ：ftp文件上传客户端
 * 类名称    ：com.lzw.attm.display.FtpClient     
 * 创建人    ：杨洪
 * 创建时间：2017年1月6日 上午11:18:49   
 * 修改人    ：
 * 修改时间：2017年1月6日 上午11:18:49   
 * 修改备注：   
 * @version   V1.0    
 */

public class FtpClient {
	private FTPClient ftp=null;
	private JProgressBar progressBar = new JProgressBar(0,100);
	private JButton startButton = new JButton("取消");
	private JLabel jlabel = new JLabel("文件正在下载中，请稍候...");
	private JDialog dialog = null;
	private int dialogkey = 0;
	
	public FtpClient(){
		ftp = new FTPClient();
	}
	public void ftpdisconnect(){
		if(ftp.isConnected()){
			try {
				ftp.disconnect();
			} catch (IOException e) {
				ConfirmDlg.showConfirmDialog(null, "关闭失败", ConfirmDlg.ERROR_MESSAGE);
			}
		}
	}
	public int getConn(String server,String username,String password,String path){
		int i = 0;
		int result = 0;
		if(ftp.isConnected()){
			String ftpserver = ftp.getLocalAddress().getHostAddress();//获取主机的地址
			if(!ftpserver.equals(server)){
				result = ConfirmDlg.showConfirmDialog(null, "是否断开"+ftpserver+"---链接"+server, ConfirmDlg.QUESTION_MESSAGE);
			}else{
				return i;
			}
		}
		if(result==ConfirmDlg.YES_OPTION){
			ftp.setControlEncoding("GBK");
			FTPClientConfig conf = new FTPClientConfig("GBK");
			conf.setServerLanguageCode("zh");//设置语言为中文
			try {
				ftp.connect(server);//主机链接
				ftp.setSoTimeout(60000);///超时十几秒的时间
				ftp.setDataTimeout(60000);//设置传输超时未60s
				ftp.setConnectTimeout(60000);;//设置默认超时未60s
				//如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器   
				ftp.login(username, password);//用户名和密码登录
				ftp.setFileType(FTPClient.BINARY_FILE_TYPE);//文件类型为【二进制】
				int reply = ftp.getReplyCode();//上传是否成功的返回码
				if(!FTPReply.isPositiveCompletion(reply)){
					ConfirmDlg.showConfirmDialog(null, "登录失败，用户名或者密码错误！", ConfirmDlg.ERROR_MESSAGE);
			        i=1;
				}
				if(!ftp.changeWorkingDirectory(path)){
			          i=3;
			      }
			} catch (Exception e) {
				ConfirmDlg.showConfirmDialog(null, "发生错误，请重新操作！", ConfirmDlg.ERROR_MESSAGE);
		        i=2;
			} 
		}
		return i;
	}
	
	//判断是否有该文件
	public boolean pdFile(String filename){
		boolean flag = false;
		if(ftp.isConnected()){
			try {
				FTPFile[] files =ftp.listFiles(filename);
				if(files.length>0){
					flag = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
//	文件上传
	 public int upLoadFile(String filename,InputStream input){
		    int i=0;
		    if(ftp.isConnected()){
		      try{
		          if(!pdFile(filename)){
		            ftp.storeFile(filename, input);
		            input.close();
		          }else{
		  			ConfirmDlg.showConfirmDialog(null, "上传失败，请重新操作！", ConfirmDlg.ERROR_MESSAGE);
		            input.close();
		            i=1;
		        }
		      }
		      catch (Exception e) {
		        // TODO: handle exception
		  	    ConfirmDlg.showConfirmDialog(null, "上传失败，请重新操作！", ConfirmDlg.ERROR_MESSAGE);
		        i=2;
		      }
		    }else{
	  		  ConfirmDlg.showConfirmDialog(null, "未连接FTP服务器！", ConfirmDlg.ERROR_MESSAGE);
		      i=3;
		    }
		    return i;
		  }
	 //删除指定的文件
		  public int delete_file(String filename) throws Exception {
			  int i=0;
			    if(ftp.isConnected()){
			      try{
			          if(!pdFile(filename)){
			        	  String path=filename;
			        	  path=path.substring(0,path.lastIndexOf("_"))+path.substring(path.lastIndexOf("."),path.length());
						  ConfirmDlg.showConfirmDialog(null, "没有"+path+"文件", ConfirmDlg.ERROR_MESSAGE);
				          i=1;
			          }else{
			        	  ftp.deleteFile(filename);
			        }
			      }
			      catch (Exception e) {
			        // TODO: handle exception
			    	  String path=filename;
						path=path.substring(0,path.lastIndexOf("_"))+path.substring(path.lastIndexOf("."),path.length());
				    ConfirmDlg.showConfirmDialog(null, "删除"+path+"失败:", ConfirmDlg.ERROR_MESSAGE);
			        i=2;
			      }
			    }else{
				    ConfirmDlg.showConfirmDialog(null, "未连接FTP服务器", ConfirmDlg.ERROR_MESSAGE);
			      i=3;
			    }
			    return i;
			    }
			   
		  public int downLoadFile(String filename,String locapth){
		    int i=0;
		    String path=filename;
			path=path.substring(0,path.lastIndexOf("_"))+path.substring(path.lastIndexOf("."),path.length());
			if(ftp.isConnected()){
		      if(pdFile(filename)){
		        File file=new File(locapth);
		        try{
		        	
		        	SwingUtilities.invokeLater(new Runnable() {
		    			public void run() {	
		    				progressBar.setMinimum(0);
		    				progressBar.setMaximum(100);
		    				progressBar.setIndeterminate(true);
		    				progressBar.setStringPainted(true);
		    				progressBar.setString("..");
		    			}
		    		});
		        	Container contentPane = new Container();
		        	 
		        	contentPane.setLayout(new FlowLayout());
		        	contentPane.add(jlabel);
		        	contentPane.add(progressBar);
		        	contentPane.add(startButton);
		        	dialog=new JDialog();
					dialog.setTitle("下载文件");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.add(contentPane);
					dialog.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment()
							.getMaximumWindowBounds());
					dialog.setSize(200, 120);
					dialog.setVisible(true);
					dialog.setLocationRelativeTo(null);
					startButton.addActionListener(new ActionListener() {
		 				public void actionPerformed(ActionEvent e) {
		 					try {
		 						//系统退出
		 						ftp.abort();
		 						dialogkey=1;
		 						dialog.setVisible(false);
		 						/**
								  * 防止内存溢出,对于不再引用的对象，及时把它的引用赋为null。 obj = null;
								  * 	 然后调用System.gc()  方法让垃圾回收器开始回收垃圾。
								  */
								 dialog=null;
								 System.gc();
		 						if(dialogkey==1)
		 						{
		 						    ConfirmDlg.showConfirmDialog(null, "取消下载成功!", ConfirmDlg.INFORMATION_MESSAGE);
		 						 } 
		 					   }catch (IOException e1) {
		 						// TODO Auto-generated catch block
		 						e1.printStackTrace();
		 					}
		 				}
		 				});
			         FileOutputStream out=new FileOutputStream(file);
			         ftp.retrieveFile(filename, out);
		             out.close();
		             dialog.setVisible(false);
		             /**
					  * 防止内存溢出,对于不再引用的对象，及时把它的引用赋为null。 obj = null;
					  * 	 然后调用System.gc()  方法让垃圾回收器开始回收垃圾。
					  */
					 dialog=null;
					 System.gc();
		             if(dialogkey==0)
					{
						ConfirmDlg.showConfirmDialog(null, "下载文件成功!", ConfirmDlg.INFORMATION_MESSAGE);
					}
				}catch (Exception e) {
		          // TODO: handle exception
					ConfirmDlg.showConfirmDialog(null, "下载文件成功!", ConfirmDlg.INFORMATION_MESSAGE);
		          i=1;
		        }
		      }else{
					ConfirmDlg.showConfirmDialog(null, "下载文件不存在!", ConfirmDlg.INFORMATION_MESSAGE);
		        i=2;
		      }
		    }else{
				ConfirmDlg.showConfirmDialog(null, "未连接FTP服务器", ConfirmDlg.INFORMATION_MESSAGE);
		      i=3;
		    }
		    return i;
		  }

}
