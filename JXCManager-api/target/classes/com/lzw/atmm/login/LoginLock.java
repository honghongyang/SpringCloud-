package com.lzw.atmm.login;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.lzw.atmm.view.message.ConfirmDlg;
/**
 * 
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：客户端锁
 * 类名称：com.lzw.login.LoginLock     
 * 创建人：杨洪
 * 创建时间：2016年11月10日 下午4:20:46   
 * 修改人：
 * 修改时间：2016年11月10日 下午4:20:46   
 * 修改备注：   
 * @version   V1.0
 */
public class LoginLock {

	private static final Logger logger = Logger.getLogger(LoginLock.class);
	
	public LoginLock(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error("LoginFrameSW Exception", e);
				}
			}
		});
	}
	
	public void initLock() {
		// TODO Auto-generated method stub
        try {
            file = new File("RingOnRequest.lock");
            if (file.exists()) {
            	file.delete();
            }
            channel = new RandomAccessFile(file, "rw").getChannel();
            lock = channel.tryLock();
            if(lock == null)
            {
                channel.close();
                ConfirmDlg.showConfirmDialog(null, "客户端已打开，请关闭当前客户端再操作！", ConfirmDlg.ERROR_MESSAGE);
                throw new RuntimeException("Only 1 instance of TMonitor can run");
            }
            Runtime.getRuntime().addShutdownHook(new Thread(){
            	
            	@Override
            	public void run() {
            		// TODO Auto-generated method stub
            		unlockFile();
            	}
            	
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            	logger.error("initLock Exception", e);
            }
        }
        catch(IOException e)
        {
        	ConfirmDlg.showConfirmDialog(null, "文件损坏,客户端不能正常开启！", ConfirmDlg.ERROR_MESSAGE);
            throw new RuntimeException("Could not start process.", e);
        }
	}
	
	public void unlockFile() {
        try {
            if(lock != null) {
                lock.release();
                channel.close();
                file.delete();
            }
        } catch(IOException e) {
        	logger.error("unlockFile IOException", e);
        }
    }
	
	private File file;
    private FileChannel channel;
    private FileLock lock;
}
