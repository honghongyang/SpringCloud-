package com.lzw.atmm.sys.internalFrame.window;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.atmm.sys.internalFrame.panel.ShanChuCaoZuoYuanPanel;
import com.lzw.atmm.sys.internalFrame.panel.TJCzyPanel;
import com.lzw.atmm.tsd.data.IconFactory;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：操作员管理内部窗体
 * 类名称：com.lzw.sys.internalFrame.CzyGL     
 * 创建人：杨洪
 * 创建时间：2016年8月3日 上午9:47:39   
 * 修改人：
 * 修改时间：2016年8月3日 上午9:47:39   
 * 修改备注：   
 * @version   V1.0    
 */

public class CzyGLFrame extends JInternalFrame{ 
	private static final long serialVersionUID = -3915119162968746094L;
	private JTabbedPane tabPane ;//选项面板
	public CzyGLFrame(){
    ImageIcon icon=IconFactory.getIcon(IconFactory.ALERT_FILEPATH);
    this.setFrameIcon(icon);//设置内部窗体的图标
	this.setMaximizable(false);	//该选项为内部窗体设置最大化标签,或者去掉该项默认为false状态
	this.setIconifiable(true);///该选项主要是控制内部窗体的最小化图标,设置为true则显示为最小化图标,如果为 false,则不显示最小化图标,或者注释掉改行,相当于设置值为false
	this.setClosable(true);//该设置选项为设置工具栏上的关闭图标,true表示显示,false表示不显示
	//默认面板为流布局
	this.setBounds(100, 100, 600, 350);
	setTitle("操作员管理");
	tabPane = new JTabbedPane();
	final TJCzyPanel tjPanel=TJCzyPanel.newInstance();
	final ShanChuCaoZuoYuanPanel delPanel = ShanChuCaoZuoYuanPanel.newInstance();
	Icon tianjiaIcon =IconFactory.getIcon(IconFactory.ADD_GYS_FILEPATH);
	tabPane.addTab("添加操作员", tianjiaIcon, tjPanel, "添加操作员");//添加面板到内部窗体
	Icon xiugaiIcon = IconFactory.getIcon(IconFactory.MODIY_FILEPATH);
	tabPane.addTab("删除操作员", xiugaiIcon, delPanel, "删除操作员");
	this.getContentPane().add(tabPane);// 获取当前窗体的内容面板,添加选项面板
	tabPane.addChangeListener(new ChangeListener() {//监听选项卡的状态发生该变
		public void stateChanged(ChangeEvent e) {
			delPanel.initTable();
		}
	});
	
	//pack();
	/**
	 * 当面板或者窗体调用该方法是,this.setBounds(100, 100, 491, 287);对当前窗体失效,设置的宽,高 不管用
	 * 
	 * 注意:该处排查错误不易发现
	 */
	setVisible(true);
	}
	
}
