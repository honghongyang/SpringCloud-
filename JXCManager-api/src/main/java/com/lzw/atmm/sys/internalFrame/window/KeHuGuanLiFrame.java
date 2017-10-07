package com.lzw.atmm.sys.internalFrame.window;
import javax.swing.Icon;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.atmm.sys.internalFrame.panel.KeHuTianJiaPanel;
import com.lzw.atmm.sys.internalFrame.panel.KeHuXiuGaiPanel;
import com.lzw.atmm.tsd.data.IconFactory;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述： 客户管理内部窗体
 * 类名称：com.lzw.sys.internalFrame.frame.KeHuGuanLiFrame     
 * 创建人：杨洪
 * 创建时间：2016年8月10日 下午3:24:12   
 * 修改人：
 * 修改时间：2016年8月10日 下午3:24:12   
 * 修改备注：   
 * @version   V1.0    
 */

public class KeHuGuanLiFrame extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	public KeHuGuanLiFrame(){
		this.setIconifiable(true);//最小化图标设置显示
		this.setMaximizable(false);//最大化图标设置显示
		this.setClosable(true);//设置关闭按钮图标显示
		Icon icon = IconFactory.getIcon(IconFactory.ALERT_FILEPATH);
		this.setFrameIcon(icon);
		this.setTitle("客户信息添加");
		final JTabbedPane  tabbedPane = new JTabbedPane();//选项卡面板,面板默认为流布局
		Icon kehuicon = IconFactory.getIcon(IconFactory.KEHU_FILEPATH);
		final KeHuTianJiaPanel khtjPanel = new KeHuTianJiaPanel();
		tabbedPane.addTab("客户信息添加", kehuicon,  khtjPanel,"客户信息添加");
		Icon khxgIcon =IconFactory.getIcon(IconFactory.MODIY_FILEPATH);
		final KeHuXiuGaiPanel khxgPanel = new KeHuXiuGaiPanel();
		tabbedPane.addTab("客户信息修改", khxgIcon, khxgPanel, "客户信息修改");
		this.getContentPane().add(tabbedPane);
		tabbedPane.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				//添加另外一个选项,同时初始化数据
				
			}
		});
		pack();
		setVisible(true);
		
	}

}
