package com.lzw.atmm.component.Layout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;



/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：网格组布局管理器
 * 类名称：com.lzw.component.Layout.GradBagLayoutFrame     
 * 创建人：杨洪
 * 创建时间：2016年6月17日 下午4:20:27   
 * 修改人：
 * 修改时间：2016年6月17日 下午4:20:27   
 * 修改备注：   
 * @version   V1.0    
 */
public class GridBagLayoutFrame extends JFrame{//网格组布局管理器
	
	/************************************************************************************
	 *  GridBagConstraints()建立一个新的GridBagConstraints对象。
     *  GridBagConstraints(int gridx,int gridy,int gridwidth,int gridheight,double 
     *  weightx,double weighty, int anchor,int fill, Insets insets,int ipadx,int ipady)
     *  建立一个新的GridBagConstraints对象 ，并指定其参数的值
     *************************************************************************************
	 */
	private static final long serialVersionUID = -5737547282100385210L;
	private JButton buttonFirst,buttonSecond,buttonThere,buttonFore,lastButton;
	private GridBagConstraints c;//GridBagConstraints布局管理器约束对象
	private int gridx,//gridx,gridy:设置组件的位置，gridx设置为GridBagConstraints.RELATIVE代表此组件位于之前所加入组件的右边。 
	gridy,//若将gridy设置为GridBagConstraints.RELATIVE代表此组件位于以前所加入组件的下面。建议定义出gridx,gridy的位置，以便以后维护程序。
	//表示放在几行几列，gridx=0,gridy=0时放在0行0列
	gridWidth,//用来设置组件所占的单位长度与高度，默认值皆为1。你可以使用GridBagConstraints.REMAINDER常 量.
	gridHeight,//代表此组件为此行或此列的最后一个组件，而且会占据所有剩余的空间.
	anchor,//当组件空间大于组件本身时，要将组件置于何处，有CENTER(默认值)、NORTH、NORTHEAST、EAST、SOUTHEAST、 WEST、NORTHWEST可供选择
	fill,//值组件的摆放方式  GridBagConstraints.HORIZONTAL水平放置 GridBagConstraints.
	ipadx,
	ipady;//设置组件内的间距，默认值为0
	private double weightx,weighty;//用来设置窗口变大时，各组件跟着变大的比例，当数字越大，表示组件能得到更多的空间，默认值皆为0
	private Insets insets;//insets:设置组件之间彼此的间距，它有四个参数，分别是上，左，下，右，默认为(0,0,0,0)
	private GridBagLayout gridBag;
	private GridBagLayoutFrame(){
		initFrameComponent();
	}
	private static class SingletonGridBagLayoutHandler{
		private static GridBagLayoutFrame instance = new GridBagLayoutFrame();
	}
	public static GridBagLayoutFrame getInstance(){
		return GridBagLayoutFrame.SingletonGridBagLayoutHandler.instance;
	}
	
	
	public void initFrameComponent(){
		this.setTitle("*******************GridBagLayout布局管理器********************");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridBag = new GridBagLayout();//布局管理器对象
		Container contentPanel = this.getContentPane();
		contentPanel.setLayout(gridBag);//设置容器的布局为网格组布局
		
		buttonFirst = new JButton("测试按钮一");
		gridx = 0;
		gridy = 0;
		
		gridWidth = 1;//设置组件占多少个单元格
		gridHeight = 1;//设置
		
		weightx = 10;
		weighty = 1;
		
		
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.HORIZONTAL;//水平填充
		insets = new Insets(0,0,0,0);//设置组件之间彼此的间距
		ipadx = 0;
		ipady = 0;//设置组件之间的竖直方向之间的距离
		c = new GridBagConstraints(gridx,gridy,gridWidth,gridHeight,
				weightx,weighty,anchor,fill,insets,ipadx,ipady);
		gridBag.setConstraints(buttonFirst,c);//第一个参数为组件,第二个为组件的约束
		//把组件添加到容器中
		contentPanel.add(buttonFirst);//把组件添加到容器中
		
		buttonSecond = new JButton("测试按钮二");
		gridx = 1;
		gridy = 0;
		gridWidth = 2;
		gridHeight = 1;
		weightx = 1;
		weighty = 1;
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.HORIZONTAL;
		insets = new Insets(0, 0, 0, 0);
		ipadx = 50;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridWidth, gridHeight,
				weightx, weighty, anchor, fill, insets, ipadx, ipady);
		gridBag.setConstraints(buttonSecond, c);
		contentPanel.add(buttonSecond);

		buttonThere = new JButton("测试按钮三");
		gridx = 0;
		gridy = 1;
		gridWidth = 1;
		gridHeight = 1;
		weightx = 1;
		weighty = 1;
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.HORIZONTAL;
		insets = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 50;
		c = new GridBagConstraints(gridx, gridy, gridWidth, gridHeight,
				weightx, weighty, anchor, fill, insets, ipadx, ipady);
		gridBag.setConstraints(buttonThere, c);
		contentPanel.add(buttonThere);

		buttonFore = new JButton("测试按钮四");
		gridx = 1;
		gridy = 1;
		gridWidth = 1;
		gridHeight = 1;
		weightx = 1;
		weighty = 1;
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.HORIZONTAL;
		insets = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 0;
		c = new GridBagConstraints(gridx, gridy, gridWidth, gridHeight,
				weightx, weighty, anchor, fill, insets, ipadx, ipady);
		gridBag.setConstraints(buttonFore, c);
		contentPanel.add(buttonFore);

		lastButton = new JButton("测试按钮五");
		gridx = 2;
		gridy = 1;
		gridWidth = 1;
		gridHeight = 2;
		weightx = 1;
		weighty = 1;
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.HORIZONTAL;
		insets = new Insets(0, 0, 0, 0);
		ipadx = 0;
		ipady = 50;
		c = new GridBagConstraints(gridx, gridy, gridWidth, gridHeight,
				weightx, weighty, anchor, fill, insets, ipadx, ipady);
		gridBag.setConstraints(lastButton, c);
		contentPanel.add(lastButton);

		this.setTitle("GridBagLayout");
		this.pack();
		this.setBounds(200, 150, 400, 300);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		GridBagLayoutFrame.getInstance();	
	}
	

}
