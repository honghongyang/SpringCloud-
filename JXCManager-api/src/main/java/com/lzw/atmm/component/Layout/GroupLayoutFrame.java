package com.lzw.atmm.component.Layout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.lzw.atmm.tsd.data.IconFactory;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：组布局管理器
 * 类名称：com.lzw.component.Layout.GroupLayoutFrame     
 * 创建人：杨洪
 * 创建时间：2016年10月17日 上午11:05:37   
 * 修改人：
 * 修改时间：2016年10月17日 上午11:05:37   
 * 修改备注：   
 * @version   V1.0    
 */

public class GroupLayoutFrame extends JFrame{
	private static final long serialVersionUID = -6808331813141272051L;
	private JLabel titleLabel;//标题
	private JLabel accountLabel;//账号
	private JLabel passwordLabel;//密码
	private JRadioButton jrb1;//记住密码
	private JRadioButton jrb2;//自动登录
	private JButton jb;//登录
	private final Font font =
			new Font("微软雅黑",Font.LAYOUT_LEFT_TO_RIGHT,16);

	private JTextField accountField;
	private JTextField passwordField;
	
	
	public GroupLayoutFrame(){
		this.setSize(260, 240);
		this.setLocation(400, 200);
		this.setResizable(false);
		this.setForeground(new Color(111,222,211));
		ImageIcon icon =IconFactory.getIcon(IconFactory.ALERT_FILEPATH);//图标工厂
		this.setIconImage(icon.getImage());//设置系统图标
		initWindowComponent();
	}
	
	
	private void initWindowComponent(){
		jb = new JButton("登录");
		jb.setFont(font);
		titleLabel = new JLabel("华软BBS快捷登陆");
		titleLabel.setFont(font);
		accountLabel = new JLabel("账号:");
		accountLabel.setFont(font);
		passwordLabel = new JLabel("密码:");
		passwordLabel.setFont(font);
		jrb1 = new JRadioButton("记住密码");
		jrb1.setFont(font);
		jrb2 = new JRadioButton("自动登录");
		jrb2.setFont(font);
		accountField = new JTextField();
		passwordField = new JTextField();
		//获得容器面板
		Container container =this.getContentPane();
		//为Container指定布局GroupLayout
		GroupLayout groupLayout = new GroupLayout(container);
		//设置容器的布局方式为【组】布局
		container.setLayout(groupLayout);
		
		 //创建GroupLayout的水平串行组连续组，，越先加入的ParallelGroup，优先级级别越高。
		GroupLayout.SequentialGroup hgroup = groupLayout.createSequentialGroup();//为组件创建串行组
		
		hgroup.addGap(5);//添加水平间隔
		hgroup.addGroup(groupLayout
				.createParallelGroup()//创建并行组,从上而下,先添加的优先级越高,后添加的优先级低。
				.addComponent(accountLabel)
				.addComponent(passwordLabel));//(账户和密码两个标签为同一组)
		
		hgroup.addGap(5);//添加间距
		/**
		 * 下面的组件为同一串行组
		 */
		hgroup.addGroup(groupLayout
				.createParallelGroup()
				.addComponent(titleLabel)//添加标题
				.addComponent(accountField)//添加账号文本框
				.addComponent(passwordField)//添加密码提示框
				.addComponent(jrb1)// 添加单选框
				.addComponent(jrb2)
				.addComponent(jb));//添加单选按钮
		
		hgroup.addGap(5);
		groupLayout.setHorizontalGroup(hgroup);//设置组控制器的组为水平组
		
		
		
		
		
		 //创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越(先添加的组件的优先级高,组件的优先级跟添加的先后顺序有关系!)。  
		GroupLayout.SequentialGroup vgroup = groupLayout.createSequentialGroup();
		
		vgroup.addGap(10);
		vgroup.addGroup(groupLayout.createParallelGroup()// 创建并行组,并为该组添加组件
				.addComponent(titleLabel));//添加标签提示框
		//添加竖直方向的间距
		vgroup.addGap(10);// 空白组件
		vgroup.addGroup(groupLayout.createParallelGroup()
				.addComponent(accountLabel)
				.addComponent(accountField));
		
		vgroup.addGap(10);
		vgroup.addGroup(groupLayout.createParallelGroup()
				.addComponent(passwordLabel)
				.addComponent(passwordField));
		
		//vgroup.addGap(10);//添加空白组件,增大组件间的距离
		vgroup.addGroup(groupLayout.createParallelGroup().addComponent(jrb1));
		
		//vgroup.addGap(10);
		vgroup.addGroup(groupLayout.createParallelGroup().addComponent(jrb2));
		
		//添加按钮
		//vgroup.addGap(10);
		vgroup.addGroup(groupLayout
				.createParallelGroup(Alignment.TRAILING)
				.addComponent(jb));
		vgroup.addGap(10);//竖直方向的间距
		
		//设置垂直组
		groupLayout.setVerticalGroup(vgroup);//设置布局管理器的竖直组

	}
	
	public static void main(String[] args) {
		new GroupLayoutFrame().setVisible(true);
	}
	

}
