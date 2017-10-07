package com.lzw.atmm.tsd.property;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.apache.log4j.Logger;

import com.lzw.atmm.tsd.configer.ConfigerCenter;
import com.lzw.atmm.tsd.configer.SystemInfo;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述： 系统属性初始化类
 * 类名称：com.lzw.std.property.SysPropToolkit     
 * 创建人：杨洪
 * 创建时间：2016年11月10日 下午4:33:01   
 * 修改人：
 * 修改时间：2016年11月10日 下午4:33:01   
 * 修改备注：   
 * @version   V1.0    
 */
public class SysPropToolkit {
	
	private static final Logger logger = Logger.getLogger(SysPropToolkit.class);
	
	private SysPropToolkit(){
	}
	
	public static synchronized SysPropToolkit getInstance(){//单例
		if(sysPropToolkit==null){
			sysPropToolkit = new SysPropToolkit();
		}
		return sysPropToolkit;
	}
	
	
	private static SysPropToolkit sysPropToolkit;
	private  ScheduledExecutorService scheduler;//任务调度器
	
	/**
	 * 返回线程池
	 * @return
	 */
	public ScheduledExecutorService getScheduled(){
		logger.info("进入线程池调度");
		if(this.scheduler == null){
		   this.scheduler=Executors.newScheduledThreadPool(Integer.parseInt(ConfigerCenter.getIntance()
					 .getProperty(SystemInfo.CONSERVER_CORESIZE,"5")));
		}
		return this.scheduler;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/**
	 * 简介 

java.lang.Runtime 类允许应用程序接口与应用程序运行的环境中. 

类声明 

以下是声明java.lang.Runtime类： 
public class Runtime extends Object
 
类方法 
S.N. 
方法& 描述 

void addShutdownHook(Thread hook) 
 此方法注册一个新的虚拟机关闭挂钩. 

int availableProcessors() 
 此方法返回到Java虚拟机的可用的处理器数. 

Process exec(String command) 
 这种方法在一个单独的进程中执行指定字符串命令. 

Process exec(String[] cmdarray) 
 这种方法在一个单独的进程中执行指定的命令和参数. 

Process exec(String[] cmdarray, String[] envp) 
 这种方法在一个单独的进程中执行指定的命令和参数，在指定环境. 

Process exec(String[] cmdarray, String[] envp, File dir) 
 这种方法在一个单独的进程中执行指定的命令和参数，在指定环境和工作目录. 

Process exec(String command, String[] envp) 
 这种方法在一个单独的进程中执行指定字符串命令，在指定环境.  

Process exec(String command, String[] envp, File dir) 
 这种方法在一个单独的进程中执行指定字符串命令，在指定环境和工作目录. 

void exit(int status) 
 此方法终止当前运行的Java虚拟机启动的关机顺序. 

long freeMemory() 
 此方法返回Java虚拟机中的空闲内存量. 

void gc() 
 这种方法运行垃圾收集器. 

static Runtime getRuntime() 
 此方法返回与当前的Java应用相关的运行时对象. 

void halt(int status) 
 这种方法强行终止当前运行的Java虚拟机. 

void load(String filename) 
 这种方法作为一个动态库加载指定的文件名. 

void loadLibrary(String libname) 
 这种方法的动态库加载指定库名. 

long maxMemory() 
 此方法返回的Java虚拟机将尝试使用的最大内存量. 

boolean removeShutdownHook(Thread hook) 
 这种方法取消注册之前注册的虚拟机关闭挂钩. 

void runFinalization() 
 此方法的运行有待最后确定的任何对象的终止方法. 

long totalMemory() 
 此方法返回的Java虚拟机的内存总量. 

void traceInstructions(boolean on) 
 这种方法启用/禁用跟踪的指令. 

void traceMethodCalls(boolean on) 
 这种方法启用/禁用跟踪的方法调用. 

方法继承 

这个类继承的方法从以下类： 
•
java.lang.Object
 */
	
	
	

}
