package com.lzw.atmm.tclient.boot;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import com.lzw.atmm.login.LoginFrame;
import com.lzw.atmm.view.message.ConfirmDlg;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：  客户端锁定类
 * 类名称：com.lzw.tclient.boot.TClient     
 * 创建人：杨洪
 * 创建时间：2016年11月10日 下午1:39:12   
 * 修改人：
 * 修改时间：2016年11月10日 下午1:39:12   
 * 修改备注：   
 * @version   V1.0    
 */

public class TClient {//保证客户端只能打开一个窗口
	private File file;
	private FileChannel channel;//文件管道
	private FileLock lock;//文件管道锁
	
	
	public TClient(){
	   initLock();//调用该方法后,再打开客户端,自动给客户端加文件锁
	   LoginFrame frame = LoginFrame.getInstance();//锁定该登录窗体,一台电脑只能打开一个客户端
	   frame.setVisible(true);
	}
	/**
	 * 
	 * 在并发环境下，解决共享资源冲突问题时，可以考虑使用锁机制。
       1.对象的锁
                     所有对象都自动含有单一的锁。
       JVM负责跟踪对象被加锁的次数。如果一个对象被解锁，其计数变为0。在任务（线程）第一次给对象加锁的时候，计数变为1。
                     每当这个相同的任务（线程）在此对象上获得锁时，计数会递增。
                     只有首先获得锁的任务（线程）才能继续获取该对象上的多个锁。
                      每当任务离开一个synchronized方法，计数递减，当计数为0的时候，锁被完全释放，此时别的任务就可以使用此资源。
	 */
	
	// 初始化锁
	public void initLock(){
		try {
			file = new File("RingOnRequest.lock");//
			//Check if the lock exist
			if(file.exists()){//如果如果文件存在
				// if exist try to delete it
				file.delete();
			}
			// Try to get the lock
			channel = new RandomAccessFile(file, "rw").getChannel();//通过管道获取文件的读写权限
			lock=channel.tryLock();//通过管道返回锁信息
			if(lock == null){
				// File is lock by other application
				channel.close();
				ConfirmDlg.showConfirmDialog(null, "百货商店进销存管理系统客户端已经打开?Y\\N", ConfirmDlg.ERROR_MESSAGE);//显示确认对话款
				throw new RuntimeException("Only 1 instance of TClient can run.");
			}
			
			// Add shutdown hook to release lock when application shutdown
			/**
			 * 根据 Java API, 所谓 shutdown hook 就是已经初始化但尚未开始执行的线程对象。
			 * 在Runtime 注册后，如果 jvm 要停止前，这些 shutdown hook 便开始执行。
			 * 
			 * shutdown hook 只是一个已初始化但尚未启动的线程。这意味着它只在程序关闭的时候才会启动，而不是在程序一开始运行时就启动。
			 * 而在大多数的Java平台中，如果一个线程没有启动(即没有调用线程的start()函数)VM不会分配资源给线程。
			 * 因此维护一群没有启动的线程不会给VM带来太大的负担.
             * 最后还要注意以下两点：
             * 如果VM crash,那么不能保证关闭挂钩(shutdown hooks)能运行.试想一下如果Windows XP突然蓝屏了那么本来计划
             * 在关机之前的更新也就无法进行了.
             * 如果调用Runtime.halt()方法来结束程序的话，那么关闭挂钩(shutdown hooks)也不会执行
			 */
			Runtime.getRuntime().addShutdownHook(new Thread(){

				@Override
				public void run() {
					super.run();
					unLockFile();
				}
				
				
			});
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			ConfirmDlg.showConfirmDialog(null, "文件破损,百货商店进销存管理系统不能正常运行!",ConfirmDlg.ERROR_MESSAGE);
		}
		
	}
	/**
	 * 
	 * 描述 

java.lang.Runtime.addShutdownHook(Thread hook) 方法注册一个新的虚拟机关闭挂钩。 Java虚拟机的关机响应于两种类型的事件：
 
通常情况下，程序退出时的最后一个非守护线程退出时或退出（等价地，System.exit）方法被调用，或 

虚拟机终止在响应于一个用户中断，如打字^ C，或一个全系统的事件，如用户注销或系统关闭. 

关闭钩子是一个简单的初始化但尚未启动的线程。当虚拟机开始关机顺序，将一些未指定的顺序启动所有已注册的关闭钩子，让它们同时运行。当所有的钩子已经完成，它会然后运行所有uninvoked的终结，如果最终确定的出口已启用。最后，虚拟机将暂停。需要注意的是守护线程将继续运行在关机过程中，作为非守护线程，如果关机是通过调用exit方法.
 
声明 

以下是声明java.lang.Runtime.addShutdownHook()方法 
public void addShutdownHook(Thread hook) 
参数 

hook -- 一个初始化但尚未启动的线程对象 

返回值 

此方法不返回一个值。 

异常 
•
IllegalArgumentException -- 如果指定的钩已被注册，或如果它可以判定钩已经运行或已被运行 

•
IllegalStateException -- 如果虚拟机已经是在关闭的过程中 

•
SecurityException -- 如果存在安全管理器并且它拒绝的RuntimePermission（“shutdownHooks”） 


实例 

下面的例子说明了如何使用lang.Runtime.addShutdownHook()方法。 
package com.yiibai;

public class RuntimeDemo {

   // a class that extends thread that is to be called when program is exiting
   static class Message extends Thread {

      public void run() {
         System.out.println("Bye.");
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
让我们来编译和运行上面的程序，这将产生以下结果： 
Program is starting...
Waiting for 3 seconds...
Program is closing...
Bye.
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	
	public void unLockFile(){//给文件解锁
		// release and delete file lock
		try {
			if(lock != null){
				lock.release();
				channel.close();
				file.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new TClient();
	}

}
