package com.lzw.atmm.util.worker;

import java.io.RandomAccessFile;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述    ：背后多线程处理器
 * 类名称    ：com.lzw.atmm.util.worker.PlayBackThread     
 * 创建人    ：杨洪
 * 创建时间：2016年12月27日 上午11:33:20   
 * 修改人    ：
 * 修改时间：2016年12月27日 上午11:33:20   
 * 修改备注：   
 * @version   V1.0    
 */

public class PlayBackThread extends Thread {
	 private SourceDataLine dataline;  
	     private final int dataOffset = 0x2e;  
	     public PlayBackThread(){  
	         super("playbackthread");  
	     }  
	       
	     @Override  
	     public void run(){  
	         try{  
	            @SuppressWarnings("resource")
				RandomAccessFile raf = new RandomAccessFile("D:\\001File\\第25课 情非得已 弹唱教学.wmv","r");
	            //RandomAccessFile raf = new RandomAccessFile("D:\\001File\\郭静_心墙.mp3","r");
	            AudioFormat af;  
	            af = new AudioFormat(44100,16,2,true,false);  
	           dataline = (SourceDataLine)AudioSystem.getSourceDataLine(af);  
	            dataline.open(af);  
	            raf.seek(dataOffset);  
	            int hasRead=0;  
	            dataline.start();  
	            byte[] buff=new byte[4096];  
	            @SuppressWarnings({ "unused", "resource" })
				Scanner input = new Scanner(System.in);  
	            while((hasRead=raf.read(buff))>0){  
	              print(raf.getFilePointer(),buff);  
	                dataline.write(buff, 0, hasRead);  
	            }  
	            dataline.stop();  
	         } catch(Exception e){  
	             e.printStackTrace();  
	         }  
	     }  
	         public static void print(long pointer, byte[] buff){  
	             System.out.format("%x: " ,pointer);  
	             System.out.format("%x ", buff[0]);  
	             System.out.format("%x ", buff[1]);  
	             System.out.format("%x ", buff[2]);  
	             System.out.format("%x ", buff[3]);  
	               
	             System.out.println();  
	     }  


}
