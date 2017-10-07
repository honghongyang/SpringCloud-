package com.lzw.atmm.mainPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.Constructor;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.lzw.atmm.login.LoginFrame;
import com.lzw.atmm.tsd.data.IconFactory;
/*
 * 
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：进销存管理系统主窗体
 * 类名称：com.lzw.JXCFrame     
 * 创建人：杨洪
 * 创建时间：2016年7月21日 下午4:28:45   
 * 修改人：
 * 修改时间：2016年7月21日 下午4:28:45   
 * 修改备注：   
 * @version   V1.0
 */
public class JXCFrame extends JFrame{
	private static final long serialVersionUID = -2719711550208058166L;
	private static Logger logger=LoggerFactory.getLogger(JXCFrame.class);
	private JPanel sysManagerPanel;//  系统管理面板
	private JLabel backLabel;
	private JDesktopPane desktopPane;//创建桌面面板
	
	// 创建窗体的Map类型集合对象---主要用于短名称跟创建的内部窗体的一一对应
	private Map<String, JInternalFrame> ifs = Maps.newHashMap();
	public JXCFrame(){
		this.setTitle("百货商店进销存管理系统");
		ImageIcon icon =IconFactory.getIcon(IconFactory.ALERT_FILEPATH);//图标工厂
		this.setIconImage(icon.getImage());//设置系统图标
		this.getContentPane().setBackground(new Color(170,188,120));
		//设置原生的组件监听器
		this.addComponentListener(new FrameListener());
		//设置主窗体的布局
		this.getContentPane().setLayout(new BorderLayout());//设置主面板的布局为边框布局
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //打开的时候总是最大化
		/*this.setAlwaysOnTop(true);    //总在最前面
		this.setUndecorated(true); */   //不要边框
	}
	//初始化各组件
	private void initComponent(){
		//设置窗体的背景标签
				backLabel = new JLabel();
				//设置背景标签的摆放
				backLabel.setVerticalAlignment(SwingConstants.TOP);// 竖直方向重顶部开始平铺
				backLabel.setHorizontalAlignment(SwingConstants.CENTER);//水平方向居中
				updateBackImage();//更新初始化图片
				
				desktopPane = new JDesktopPane();
				//把背景标签添加到桌面面板中
				desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));//桌面面板
				//把桌面面板添加到主窗体中
				this.getContentPane().add(desktopPane);//没有指定具体放在哪个方位,默认为CENTER
				//创建选项导航面板
				JTabbedPane navigationPane =createNavigationPanel(); // 创建导航标签面板
				//添加导航面板到主窗体中
				this.getContentPane().add(navigationPane, BorderLayout.NORTH);//上北
	}
	private JTabbedPane createNavigationPanel(){// 创建导航标签面板
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFocusable(false);
		tabbedPane.setBackground(new Color(211, 230, 192));
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED));

		JPanel baseManagePanel = new JPanel(); // 基础信息管理面板
		baseManagePanel.setBackground(new Color(215, 223, 194));
		baseManagePanel.setLayout(new BoxLayout(baseManagePanel,BoxLayout.X_AXIS));
		baseManagePanel.add(createFrameButton("客户信息管理", "KeHuGuanLiFrame"));
		baseManagePanel.add(createFrameButton("商品信息管理", "ShangPinGuanLiFrame"));
		baseManagePanel.add(createFrameButton("供应商信息管理", "GysGuanLiFrame"));

		JPanel depotManagePanel = new JPanel(); // 库存管理面板
		depotManagePanel.setBackground(new Color(215, 223, 194));
		depotManagePanel.setLayout(new BoxLayout(depotManagePanel,BoxLayout.X_AXIS));
		depotManagePanel.add(createFrameButton("库存盘点", "KuCunPanDian"));
		depotManagePanel.add(createFrameButton("价格调整", "JiaGeTiaoZheng"));

		JPanel sellManagePanel = new JPanel();// 销售管理面板
		sellManagePanel.setBackground(new Color(215, 223, 194));
		sellManagePanel.setLayout(new BoxLayout(sellManagePanel,BoxLayout.X_AXIS));
		sellManagePanel.add(createFrameButton("销售单", "XiaoShouDan"));
		sellManagePanel.add(createFrameButton("销售退货", "XiaoShouTuiHuo"));

		JPanel searchStatisticPanel = new JPanel();// 查询统计面板
		searchStatisticPanel.setBounds(0, 0, 600, 41);
		searchStatisticPanel.setName("searchStatisticPanel");
		searchStatisticPanel.setBackground(new Color(215, 223, 194));
		searchStatisticPanel.setLayout(new BoxLayout(searchStatisticPanel,BoxLayout.X_AXIS));
		searchStatisticPanel.add(createFrameButton("客户信息查询", "KeHuChaXun"));
		searchStatisticPanel.add(createFrameButton("商品信息查询", "ShangPinChaXun"));
		searchStatisticPanel.add(createFrameButton("供应商信息查询","GongYingShangChaXun"));
		searchStatisticPanel.add(createFrameButton("销售信息查询", "XiaoShouChaXun"));
		searchStatisticPanel.add(createFrameButton("销售退货查询","XiaoShouTuiHuoChaXun"));
		searchStatisticPanel.add(createFrameButton("入库查询", "RuKuChaXun"));
		searchStatisticPanel.add(createFrameButton("入库退货查询", "RuKuTuiHuoChaXun"));
		searchStatisticPanel.add(createFrameButton("销售排行", "XiaoShouPaiHang"));

		JPanel stockManagePanel = new JPanel();// 进货管理面板
		stockManagePanel.setBackground(new Color(215, 223, 194));
		stockManagePanel.setLayout(new BoxLayout(stockManagePanel,BoxLayout.X_AXIS));
		stockManagePanel.add(createFrameButton("进货单", "JinHuoDan"));
		stockManagePanel.add(createFrameButton("进货退货", "JinHuoTuiHuo"));

		sysManagerPanel = new JPanel();// 系统管理面板
		sysManagerPanel.setBackground(new Color(215, 223, 194));
		sysManagerPanel.setLayout(new BoxLayout(sysManagerPanel, BoxLayout.X_AXIS));
		sysManagerPanel.add(createFrameButton("操作员管理", "CzyGLFrame"));
		sysManagerPanel.add(createFrameButton("更改密码", "GengGaiMiMaFrame"));
		sysManagerPanel.add(createFrameButton("权限管理", "QuanManagerFrame"));

		tabbedPane.addTab("   基础信息管理   ", null, baseManagePanel, "基础信息管理");//选项面板中包括各个面板
		tabbedPane.addTab("   进货管理   ", null, stockManagePanel, "进货管理");
		tabbedPane.addTab("   销售管理   ", null, sellManagePanel, "销售管理");
		tabbedPane.addTab("   查询统计   ", null, searchStatisticPanel, "查询统计");
		tabbedPane.addTab("   库存管理   ", null, depotManagePanel, "库存管理");
		tabbedPane.addTab("   系统管理   ", null, sysManagerPanel, "系统管理");
		

		return tabbedPane;
	}
	//创建打开窗体的按钮(相当于重写按钮的一些特性)--改写按钮的行为（使其具备一些动作行为）
	public JButton createFrameButton(String fName,String cname){
		String imgUrl = "res/ActionIcon/" + fName + ".png";
		String imgUrl_roll = "res/ActionIcon/" + fName	+ "_roll.png";
		String imgUrl_down = "res/ActionIcon/" + fName	+ "_down.png";
		Icon icon = new ImageIcon(imgUrl);
		Icon iconUrl_roll=null;
		if(imgUrl_roll != null){
			iconUrl_roll=new ImageIcon(imgUrl_roll);
		}
		Icon iconUrl_down =null;
		if(imgUrl_down != null){
			iconUrl_down=new ImageIcon(imgUrl_down);
		}
		Action action=new openFrameAction(fName,cname,icon);//为按钮的行为做准备,第一个参数为汉字的标识,第二个为字母的标识
		JButton button = new JButton(action);//具备特殊行为(当该按钮被点击时,会打开内部窗体)的按钮
		//设置按钮的内边距
		button.setMargin(new Insets(0,0,0,0));//设置内补丁
		/***@ hideActionText <code>true</code> if the button's
	     *                   <code>text</code> property should not reflect
	     *                   that of the <code>Action</code>; the default is
	     *                   <code>false</code>
	     ***/
		button.setHideActionText(true);//按钮的显示标签不会呈现
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		/** Whether the button should paint the content area
	     ** or leave it transparent.
	     ***/
		button.setContentAreaFilled(false);
		if(iconUrl_roll != null){
		    /**
		     * Sets the rollover icon for the button.
		     * @param rolloverIcon the icon used as the "rollover" image
		     * @see #getRolloverIcon
		     * @beaninfo
		     * @bound: true
		     * @attribute: visualUpdate true
		     * @description: The rollover icon for the button.
		     *
		     **/
			button.setRolloverIcon(iconUrl_roll);//设置包裹按钮的常态图标
		}
		if(iconUrl_down !=null ){
			button.setPressedIcon(iconUrl_down);//按钮按下时的呈现图标
		}
		return button;//返回带有特殊行为的按钮
		
	}
	//通过反射获得内部窗体
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JInternalFrame getFrame(String frameName){//通过传入内部窗体对应的类短名称找到该类创建的窗体对象
		JInternalFrame jf = null;
		if (!ifs.containsKey(frameName)) {//内部窗体要显示其中的面板组件,就必须把面板添加到内部窗体的桌面面板中,才能显示面板中的组件
			try {
				Class fClass = Class.forName("com.lzw.sys.internalFrame.frame." + frameName);//找到类所在的全路径类名
				System.out.println("internalFrame." + frameName);
				Constructor constructor = fClass.getConstructor(null);
				jf = (JInternalFrame) constructor.newInstance(null);
				ifs.put(frameName, jf);
				System.out.println("这里是放入缓存的key为："+frameName+",对应的内部窗体为："+jf);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			jf = ifs.get(frameName);
		return jf;
	}
	
	static{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private  void updateBackImage(){//窗体背景图片的处理逻辑
		if(backLabel!=null){
			int backw=JXCFrame.this.getWidth();//获得窗体的宽度
			int backh=JXCFrame.this.getHeight();
			backLabel.setSize(backw, backh);
			backLabel.setText("<html><body><img width='"+backw
					+"' height='"+(backh-110)+"' src='"
					+JXCFrame.this.getClass().getResource("welcome.jpg")
					+"' </img></body></html>");
		}
		
	}
	//窗体监听器(主要负责处理,当单击按钮时,创建内部窗体,并且加载到选项面板中 ,并且打开选项面板)
	private final class FrameListener extends ComponentAdapter{//组件适配器
		//对应适配器中的方法,可以根据触发时的时机,重写不同的方法,实现自己的业务逻辑
		@Override
		public void componentResized(ComponentEvent e) {//组件的大小发生变化时,触发该事件。
			logger.info("【the componentAdapter'event : {"+e.getSource()+"} resized ....组件大小发生改变时触发该事件.....】");
			updateBackImage();
			super.componentResized(e);
		}
		@Override
		public void componentMoved(ComponentEvent e) {
			logger.info("【the componentAdapter'event : {"+e.getSource()+"}  moved....组件 被移动时触发该事件.....】");
			super.componentMoved(e);
		}
		@Override
		public void componentShown(ComponentEvent e) {
			logger.info("【the componentAdapter'event : {"+e.getSource()+"} closed .....组件关闭时触发该事件....】");
			super.componentShown(e);
		}
		@Override
		public void componentHidden(ComponentEvent e) {
			logger.info("【the componentAdapter'event : {"+e.getSource()+"} hidden ......组件被隐藏时触发该事件...】");
			super.componentHidden(e);
		}
	}
	//主窗体菜单项的单击事件监听器(窗体中有单击事件发生时会触发该类)
	protected final class openFrameAction extends AbstractAction{//AbstractAction为抽象类 该类实现了Action接口
		private static final long serialVersionUID = -8555081847561154223L;
		private String frameName=null;// 标识窗体的名称--用类名标识
		@SuppressWarnings("unused")
		private openFrameAction(){
		}
		public openFrameAction(String cname, String frameName, Icon icon){//参数分别为触发事件的动作名称,窗体的短名称,按钮图标
			this.frameName = frameName;//窗体名称
			putValue(Action.NAME,cname);//命令名称
			putValue(Action.SHORT_DESCRIPTION,cname);//短描述
			putValue(Action.SMALL_ICON,icon);
			
		}
        
		@Override
		public void actionPerformed(final ActionEvent e) {
			logger.info("{。。。。。。。。。。。。。。。。窗体中发生了单击事件。。。。。。。。即将打开窗体。。。。。。。。}");
			System.out.println(frameName+"****111*******");
			JInternalFrame jf=getFrame(frameName);
			System.out.println(frameName+"程序走到这里了吗"+jf);
			jf.addInternalFrameListener(new InternalFrameAdapter(){//匿名内部类,为内部窗体注册窗体监听器事件

				@Override
				public void internalFrameOpened(InternalFrameEvent e) {
					logger.info("{============内部窗体打开时触发=========}");
					super.internalFrameOpened(e);
				}

				@Override
				public void internalFrameClosing(InternalFrameEvent e) {
					logger.info("{============内部窗体正在关闭时触发=========}");
					super.internalFrameClosing(e);
				}
				// 在内部窗体闭关时，从内部窗体容器ifs对象中清除该窗体。
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					logger.info("{============内部窗体被关闭时触发=========}");
					ifs.remove(frameName);//更加窗体的短名称,移除内存中该名称对应的内部窗体
					super.internalFrameClosed(e);
				}

				@Override
				public void internalFrameActivated(InternalFrameEvent e) {
					logger.info("{============内部窗体被激活时触发=========}");
					super.internalFrameActivated(e);
				}
			});
			if(jf.getDesktopPane()==null)//说明内部窗体中没有桌面面板,如果面板已经添加到
			{
				desktopPane.add(jf);//添加内部窗体到桌面面板
				jf.setVisible(true);//设置其显示
			}
			//并设置该面板处于选中状态
			try {
				jf.setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}	
		}	
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
			  LoginFrame login=  LoginFrame.getInstance();
			  login.setVisible(true);// 该属性通常在该位置设置,便于该窗体的显和隐藏,并且从哪里关闭,当激活打开时仍然从该处呈现出来
		
				}
			
		});

	}
}
