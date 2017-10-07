package com.lzw.atmm.login;

import com.lzw.atmm.sys.tclient.util.LoadingDlg;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：
 * 类名称：com.lzw.login.RuntimeDemo     
 * 创建人：杨洪
 * 创建时间：2016年12月1日 下午4:30:53   
 * 修改人：
 * 修改时间：2016年12月1日 下午4:30:53   
 * 修改备注：   
 * @version   V1.0    
 */

public class RuntimeDemo {
	// a class that extends thread that is to be called when program is exiting
	   static class Message extends Thread {

	      public void run() {
	         System.out.println("Bye.");
	         //关闭加载对话框
	         LoadingDlg dialog = new LoadingDlg();
	         dialog.setVisible(true);
	      }
	   }

	   public static void main(String[] args) {
	      try {

	         // register Message as shutdown hook
	         Runtime.getRuntime().addShutdownHook(new Message());

	         // print the state of the program
	         System.out.println("Program is starting...");

	         // cause thread to sleep for 3 seconds
	         System.out.println("Waiting for 3 seconds...");
	         Thread.sleep(3000);

	         // print that the program is closing 
	         System.out.println("Program is closing...");


	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
}
