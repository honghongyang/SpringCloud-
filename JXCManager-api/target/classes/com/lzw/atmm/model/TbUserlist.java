package com.lzw.atmm.model;

import java.io.Serializable;
/**
 * 
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：系统用户实体类
 * 类名称：model.TbUserlist     
 * 创建人：杨洪
 * 创建时间：2016年6月17日 上午10:21:27   
 * 修改人：
 * 修改时间：2016年6月17日 上午10:21:27   
 * 修改备注：   
 * @version   V1.0
 */
public class TbUserlist implements Serializable{//系统操作员用户
	private static final long serialVersionUID = -6613529417848229828L;
	private String name;//账户/登录名
	private String username;//用户名
	private String pass;//密码
	private String quan;//权限
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	
	private static class singletonTbUserlistHolder {//匿名内部类
		//由JVM来保证线程安全,静态初始化类
		private static TbUserlist instance = new TbUserlist();//在类的内部初始化外部类
	}
	private TbUserlist(){//单例的必要条件,静态构造器
		
	}
	public static TbUserlist getInstance(){
		return TbUserlist.singletonTbUserlistHolder.instance;
	}
	/**  （1）什么是类级内部类？
	 *   简单点说，类级内部类指的是，有static修饰的成员内部类。如果没有static修饰的成员式内
	 *   部类被称为对象级内部类。
	 *   （2）类级内部类相当于其外部类的static成分，它的对象与外部类对象间不存在依赖关系，因此
	 *   可以直接创建。而对象级内部类的实例，是绑定在外部对象实例中的。
	 *   （3）类级内部类中，可以定义静态的方法。在静态方法中只能引用外部类中的静态成员方法或变量。
	 *   （4）类级内部类相当于其外部类的成员，只有在第一次被使用的时候才会被装载。
	 *  
	 *   多线程缺省同步锁的知识：
	 *   大家都知道，在多线程开发中，为了解决并发问题，主要是通过使用synchronized来加互斥锁进行同步控制，
	 *   但是在某些情况下，JVM已经隐含的为您执行了同步，这些情况下就不用自己再来进行同步控制了。
	 *   这些情况包括：
	 *   （1）由静态初始化器（在静态字段上或static{}块中的初始化器）初始化数据时
	 *   （2）访问final字段时
	 *   （3）在创建线程之前创建对象时
	 *   （4）线程可以看见它将要处理的对象时
	 *  
	 *  
	 *   2 解决方案的思路
	 *        要想很简单的实现线程安全，可以采用静态初始化器的方式，它可以由JVM来保证线程的
	 *   安全性。比如前面的饿汉式实现方式。但是这样一来，不是会浪费一定的空间吗？因为这种
	 *   实现方式，会在类装载的时候就初始化对象，不管你需不需要。
	 *        如果现在有一种方法能够让类装载的时候不去初始化对象，那不就解决问题了？一种可行的
	 *   方式就是采用类级内部类，在这个类级内部类里面去创建对象实例。这样一来，只要不使用到这个类级内部类，
	 *   那就不会创建对象实例，从而同步实现延迟加载和线程安全。

     **/
	

	
	
	
	
	

}
