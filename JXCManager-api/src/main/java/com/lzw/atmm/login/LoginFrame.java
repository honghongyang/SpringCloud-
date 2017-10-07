package com.lzw.atmm.login;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.lzw.atmm.dao.DBDao;
import com.lzw.atmm.mainPanel.JXCFrame;
import com.lzw.atmm.model.TbUserlist;
import com.lzw.atmm.sys.internalFrame.panel.LoginPanel;
import com.lzw.atmm.tsd.data.IconFactory;
import com.lzw.atmm.view.message.ConfirmDlg;
/**
 * 
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：登陆界面
 * 类名称：com.lzw.login.Login     
 * 创建人：杨洪
 * 创建时间：2016年6月17日 上午9:06:00   
 * 修改人：
 * 修改时间：2016年6月17日 上午9:06:00   
 * 修改备注：   
 * @version   V1.0
 */
public class LoginFrame extends JFrame {//登陆界面的绘制
	private static final long serialVersionUID = -4450587632295022671L;
	private JLabel userLabel;
	private JLabel passLabel;
	private JButton exit;
	private JButton login;
	private DBDao dbDao;
	private static LoginPanel panel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private  TbUserlist user;
	private String validTipText=BLANK;//提示标签
	private static final String BLANK="";
	private static Logger logger = Logger.getLogger(LoginFrame.class);
    private static final Color BKIMG_COLOR_IN_VALIDTIP=new Color(13,124,180);//提示标签显示的字符串
	private static final Font VALIDTIP_FONT=new Font("微软雅黑", Font.BOLD, 14);//提示字符串的字体
	
	private static class SingleLoginHolder{//内部类
		private static LoginFrame instance = new LoginFrame();
	}
	public static LoginFrame getInstance(){
		
		return LoginFrame.SingleLoginHolder.instance;
	}
	 private LoginFrame(){
	 this.initLock();//初始化文件锁
	 this.setTitle("百货商店进销存管理系统");
	 this.initPaintComponent();
	 this.setResizable(false);
	 this.setAlwaysOnTop(true);    //总在最前面
	 //this.setUndecorated(true);    //取消窗体标题栏及边框
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initPaintComponent(){
		ImageIcon icon =IconFactory.getIcon(IconFactory.LANG_TITLE_FILEPATH);//图标工厂
		this.setIconImage(icon.getImage());//设置系统图标
		panel = LoginPanel.getInstance();//匿名内部类获取类对象
		panel.setLayout(null);//覆盖面板的默认流布局
		this.getContentPane().add(panel);//添加面板作为内容面板
		this.setBounds(300,250, panel.getWidth(), panel.getHeight());//设置面板的显示的位置
		
		userLabel = new JLabel("用户名：");
        userLabel.setBounds(100,135,200,18);
        panel.add(userLabel);//向面板中添加组件
        
        usernameField = new JTextField();//文本框
        usernameField.setBounds(150, 135, 200, 18);
        panel.add(usernameField);
        
		passLabel = new JLabel("密  码：");
		passLabel.setBounds(100,165,200,18);
		panel.add(passLabel);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter(){//键盘监听器----适配器
			@Override
			public void keyPressed(KeyEvent e) {//键盘被按下 触发该事件
				if(e.getKeyCode()==10)//获取键盘码 Enter键的键盘码为10
				{
				     login.doClick(10);//Enter键
				}
			}
			
		});
		passwordField.setBounds(150, 165, 200, 18);
		panel.add(passwordField);
		//=====================================================================================================================
		/******提示标签*****/
		final JLabel validTip = new JLabel(validTipText){
			private static final long serialVersionUID = -6361315783765726228L;
			@Override
			public void paintComponents(Graphics g) {//重绘组件
				super.paintComponents(g);
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				g.setColor(BKIMG_COLOR_IN_VALIDTIP);//设置颜色
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setColor(getForeground());//获得前景色
				g.setFont(VALIDTIP_FONT);
				g.drawString(getText(), 5, 18);
			}
		};
		validTip.setOpaque(true);//设置透明
		validTip.setBounds(100,230,300,24);
		panel.add(validTip);
		
		//====================== 进度条 =====================================================================================
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(100);//设置最大值
		progressBar.setValue(0);
		progressBar.setBounds(80, 230, 300, 25);
		//=================================================================================================================
		
		//======================================================================================================================
		login = new JButton("登  陆");
		login.setBounds(180, 195, 80, 24);
		panel.add(login);
		login.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {//异步查询比对数据
			//========================发声的关键代码=================================	
			Toolkit.getDefaultToolkit().beep();//发声的关键
			//=========================发声的关键代码================================
			final String username=usernameField.getText();
			final String password =new String(passwordField.getPassword());
			if(StringUtils.isBlank(username)||StringUtils.isEmpty(password))
			{
				ConfirmDlg.showConfirmDialog(null, "用户名或者密码不能为空!", ConfirmDlg.ERROR_MESSAGE);
				return ;
			}
			validTip.setText("正在登陆中...");
			validTip.setForeground(Color.DARK_GRAY);
			//提示信息	
			login.setEnabled(false);//设置按钮不可用,灰色
		      //提示信息条
			new SwingWorker<Boolean, Void>(){
                  boolean isSuc = false;
					
					@Override
					protected Boolean doInBackground() throws Exception {//在该方法中执行业务逻辑
					    try {					    	
							user=DBDao.newInstance().getUser(username, password);
							isSuc=true;
							if(logger.isDebugEnabled() && user != null){//是否处于调试模式下运行
							   logger.debug("user log............."+user.getUsername()+".................");
							}
						} catch (Exception e) {
							logger.debug("DBDao产生异常!", e);
						}
						return isSuc;
					}
					@Override
					protected void done() {//接口方法
						if(isSuc){//为true时
							if(user == null)
							{
								validTip.setForeground(Color.RED);
								validTip.setText("·用户名或密码错误！请重新输入！");
								login.setEnabled(true);//
							}else{//用户存在
								validTip.setText(BLANK);
								usernameField.setEnabled(false);
								passwordField.setEnabled(false);
								//显示加载进度条
								boolean flag=loading(progressBar);
								
								//加载完成后
								//login.setEnabled();//设置
								if(flag){
									setVisible(false);//隐藏本身
									JXCFrame frame=new JXCFrame();
									frame.setVisible(true);
								}
							}
						}else{//isSuc 为false
							validTip.setForeground(Color.RED);
							validTip.setText("·网络异常！请联系网络管理员！");
							login.setEnabled(true);
						}
					}	
				}.execute();//执行时, 该匿名类会自动开启单独线程
			}
		});
		exit = new JButton("退  出");
		exit.setBounds(260, 195, 80, 24);
		panel.add(exit);
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent even) {
				System.exit(0);
			}
		});
	}
	//程序加载进度条提示对话框
	public boolean loading(final JProgressBar progressBar){//起到缓冲的效果
		panel.add(progressBar,0);//加载进度条
		boolean finish=false;
		new Thread(){
			@Override
			public void run() {
			try {//优化技巧
				while(progressBar.getValue()<progressBar.getMaximum())//实际值更最大值比较
				{
					Thread.sleep(new Random().nextInt(1000));//0.1秒
					System.out.println(" 执行进度条加载   ");
					//
					progressBar.setValue(progressBar.getValue() +progressBar.getMaximum() / 100);
				}
				
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}.start();//启动线程
		finish=true;
		timer = new Timer(500,new ActionListener(){//定时器主要停止进度条
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable(){
					@Override
					public void run() {
						progressBar.setValue(100);						
					}
				});
				timer.stop();//停止定时器
			}
			});
		timer.start();//启动定时器
		return finish;
	}
	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		LoginFrame login= LoginFrame.getInstance();
		login.setVisible(true);
	}
	
	public DBDao getDbDao() {
		return dbDao;
	}
	public void setDbDao(DBDao dbDao) {
		this.dbDao = dbDao;
	}
	public TbUserlist getUser() {
		return user;
	}
	public  void setUser(TbUserlist user) {
		this.user = user;
	}
	public static LoginPanel getPanel() {
		return panel;
	}

	public static void setPanel(LoginPanel panel) {
		LoginFrame.panel = panel;
	}
	
	private Timer timer;//java.swing中的timer
	
	private File file;
	private FileChannel channel;//管道
	private FileLock lock;//文件锁
	
	//初始化客户端前,先调用
	public void initLock(){//通过对象锁---------锁定登录窗体
		try {
			file = new File("RingOnRequest.lock");
			if(file.exists()){
				//如果文件存在,则删除
				file.exists();
			}
			// Try to get the lock
			channel = new RandomAccessFile(file, "rw").getChannel();
			lock = channel.tryLock();//通过管道流获得文件锁
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
			//获得当前运行环境
			Runtime.getRuntime().addShutdownHook(new Thread(){

				@Override
				public void run() {
					super.run();
					unLockFile();//释放文件锁
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
	
}
