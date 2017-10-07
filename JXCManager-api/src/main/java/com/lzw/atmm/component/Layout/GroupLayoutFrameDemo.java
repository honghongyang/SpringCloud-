package com.lzw.atmm.component.Layout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.lzw.atmm.tsd.data.IconFactory;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：
 * 类名称：com.lzw.component.Layout.GroupLayoutFrameDemo     
 * 创建人：杨洪
 * 创建时间：2016年10月20日 下午2:55:56   
 * 修改人：
 * 修改时间：2016年10月20日 下午2:55:56   
 * 修改备注：   
 * @version   V1.0    
 */

public class GroupLayoutFrameDemo extends JFrame {
	private static final long serialVersionUID = 1L;
	//编码：水平和垂直两个方向我们都必须设定,实现方法详见程序
	//addComponent：向Group里添加组件，如JLabel、JTextBox
	//addGroup    : 向Group里添加组
	private JLabel jLabel;//标签
	private JTextField jtField;//文本框
	/**
	 * 复选框1~4
	 */
	private JCheckBox jcb1;
	private JCheckBox jcb2;
	private JCheckBox jcb3;
	private JCheckBox jcb4;
	private JButton jbFind;
	private JButton cancelFind;
	public GroupLayoutFrameDemo(){
		this.setTitle("【GroupLayout】【组】布局管理器");
		this.setBounds(200, 150, 550, 150);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon =IconFactory.getIcon(IconFactory.ALERT_FILEPATH);//图标工厂
		this.setIconImage(icon.getImage());//设置系统图标
		this.initWindowComponent();
	    try {
	    	
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//设置组件的样式
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	private void initWindowComponent(){
		jLabel = new JLabel("Find What:");
		jtField = new JTextField();
		jcb1 = new JCheckBox("Match Case");
		jcb2 = new JCheckBox("Whole Words");
		jcb3 = new JCheckBox("Warp Around");
		jcb4 = new JCheckBox("Search Backwards");
		
		jbFind = new JButton("Find");
		cancelFind = new JButton("Cancel");
		
		Container container =getContentPane();
		final GroupLayout groupLayout = new GroupLayout(container);
		//设置容器的布局管理器
		container.setLayout(groupLayout);//设置容器的布局为组布局
		 //自动设置组件,组之间的间隙
		groupLayout.setAutoCreateGaps(true);// 设置组件之间的间隙
		groupLayout.setAutoCreateContainerGaps(true);//设置容器组之间的间隙
		// //LEADING -- 左对齐    BASELINE -- 底部对齐  CENTER -- 中心对齐
		
		GroupLayout.ParallelGroup hpg2a = groupLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING);//创建一个并行组
		hpg2a.addComponent(jcb1);
		hpg2a.addComponent(jcb2);
		
		//http://www.blogjava.net/esls2008/archive/2006/12/18/88548.html
		//GroupLayout.ParallelGroup hpg2b 
		
		
		GroupLayout.ParallelGroup hpg2b = groupLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING);//创建一个水平的并行组
		hpg2b.addComponent(jcb3);
		hpg2b.addComponent(jcb4);
		
		
		//创建一个水平方向的串行组,该组包括hpg2a 和 hpg2b 这两个组
		GroupLayout.SequentialGroup hpg2H = groupLayout
				.createSequentialGroup();//创建水平方向的串行组
		hpg2H.addGroup(hpg2a).addGroup(hpg2b);
		
		
		/**
		 * 创建一个并行组,添加文本框和hpg2H
		 * 一个组件(jtField)和一个组(hpg2G)构成了一个并行组
		 */
		
		GroupLayout.ParallelGroup hpg2 = groupLayout
				.createParallelGroup();//创建一个并行组
		hpg2.addComponent(jtField);///添加文本框组件
		hpg2.addGroup(hpg2H);///添加组
		
		
		//创建一个延水平方向的并行组
		GroupLayout.ParallelGroup hpg3 = groupLayout
				.createParallelGroup();
		hpg3.addComponent(jbFind);//添加按钮
		hpg3.addComponent(cancelFind);//添加按钮
		
		
		//设置水平方向的组
		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addComponent(jLabel)
				.addGroup(hpg2)
				.addGroup(hpg3));
		
		//设置两个按钮【水平方向】的一样宽
		groupLayout.linkSize(SwingConstants.HORIZONTAL,new Component[]{jbFind,cancelFind});
		//设置四个复选框水平方向的宽度一样
		groupLayout.linkSize(SwingConstants.HORIZONTAL,new Component[]{jcb1,jcb2,jcb3,jcb4});
		
		//设置竖直方向的串行组
		GroupLayout.ParallelGroup vpg1 =
				groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);//紧靠HORIZONTAL水平轴
		vpg1.addComponent(jLabel);//标签
		vpg1.addComponent(jtField);//文本框
		vpg1.addComponent(jbFind);//按钮
		
		//创建VERTICAL方向的并行组
		GroupLayout.ParallelGroup vpg2 =
				groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER);//中间
		vpg2.addComponent(jcb1);
		vpg2.addComponent(jcb3);
		vpg2.addComponent(cancelFind);
		
		//创建VERTICAL方向的并行组
		GroupLayout.ParallelGroup vpg3 = groupLayout
				.createParallelGroup(GroupLayout.Alignment.BASELINE);
		vpg3.addComponent(jcb2);
		vpg3.addComponent(jcb4);
		
		
		//创建竖直方向布局组
		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
				.addGroup(vpg1)
				.addGroup(vpg2)
				.addGroup(vpg3));
		
	}

	public static void main(String[] args) {
		new GroupLayoutFrameDemo().setVisible(true);
	}
	

}
