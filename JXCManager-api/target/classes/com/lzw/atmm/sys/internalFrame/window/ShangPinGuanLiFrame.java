package com.lzw.atmm.sys.internalFrame.window;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.lzw.atmm.sys.internalFrame.panel.ShangPinTianJiaPanel;
import com.lzw.atmm.sys.internalFrame.panel.ShangPinXiuGaiPanel;
import com.lzw.atmm.tsd.data.IconFactory;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：商品管理窗体
 * 类名称：com.lzw.sys.internalFrame.frame.ShangPinGuanLiFrame     
 * 创建人：杨洪
 * 创建时间：2016年8月15日 下午5:43:47   
 * 修改人：
 * 修改时间：2016年8月15日 下午5:43:47   
 * 修改备注：   
 * @version   V1.0    
 */

public class ShangPinGuanLiFrame extends JInternalFrame {
	private static final long serialVersionUID = -8314145432706051331L;
	private JTabbedPane tabbedPane;//选项卡面板
	private ShangPinTianJiaPanel sptjPanel ;
	private ShangPinXiuGaiPanel spxgPanel;
	public ShangPinGuanLiFrame(){
		this.setIconifiable(true);//设置内部窗体显示最小化图标
		this.setMaximizable(false);// 设置窗体显示最大化图标
		this.setClosable(true);//设置窗体 显示关闭图标
		ImageIcon icon = IconFactory.getIcon(IconFactory.ALERT_FILEPATH);
		ImageIcon goodAddIcon =IconFactory.getIcon(IconFactory.ADD_GYS_FILEPATH);//商品图标
		ImageIcon goodModifyIcon =IconFactory.getIcon(IconFactory.MODIY_FILEPATH);
		this.setFrameIcon(icon);//设置窗体图标
		this.setTitle("商品管理");
		tabbedPane = new JTabbedPane();
		sptjPanel = new ShangPinTianJiaPanel();
		spxgPanel = new ShangPinXiuGaiPanel();
		
		tabbedPane.addTab("商品信息添加", goodAddIcon, sptjPanel, "商品信息添加");
		tabbedPane.addTab("商品修改或删除", goodModifyIcon, spxgPanel,"商品修改或删除");
		
		tabbedPane.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {//选项卡面板状态发生变化时触发该函数
				spxgPanel.initGoodsItem();
				spxgPanel.initGysComboBox();
				
			}
		});
		
		this.getContentPane().add(tabbedPane);//添加选项卡到内容面板中
		//为窗体添加监听器
		//该事件在窗体被激活时触发
		//在商品管理窗口被激活时，初始化商品添加界面的供应商下拉选择框
		this.addInternalFrameListener(new InternalFrameAdapter(){
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				super.internalFrameActivated(e);
				sptjPanel.initDataComboBox();//初始化下拉框数据
			}
		});
		
		this.pack();
		this.setVisible(true);
	}
	
	
     

}
