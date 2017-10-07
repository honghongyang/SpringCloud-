package com.lzw.atmm.sys.internalFrame.window;
import javax.swing.Icon;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lzw.atmm.sys.internalFrame.panel.GysTianJiaPanel;
import com.lzw.atmm.sys.internalFrame.panel.GysXiuGaiPanel;
import com.lzw.atmm.tsd.data.IconFactory;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：供应商管理内部窗体
 * 类名称：com.lzw.sys.internalFrame.frame.GysGuanLiFrame     
 * 创建人：杨洪
 * 创建时间：2016年8月9日 下午3:40:43   
 * 修改人：
 * 修改时间：2016年8月9日 下午3:40:43   
 * 修改备注：   
 * @version   V1.0    
 */

public class GysGuanLiFrame extends JInternalFrame {

	private static final long serialVersionUID = -865262891545196804L;
	public GysGuanLiFrame(){
		this.setMaximizable(false);	//该选项为内部窗体设置最大化标签,或者去掉该项默认为false状态
		this.setIconifiable(true);//设置显示最小化按钮图标
		this.setClosable(true);//设置显示关闭按钮图标
		this.setTitle("供应商管理");
		Icon icon = IconFactory.getIcon(IconFactory.ALERT_FILEPATH);
		this.setFrameIcon(icon);
		JTabbedPane  tabbedPane = new JTabbedPane();//选项卡面板
		final GysTianJiaPanel gysTianJiaPanel = new GysTianJiaPanel();
		Icon tianjiaIcon =IconFactory.getIcon(IconFactory.ADD_GYS_FILEPATH); 
		final GysXiuGaiPanel  gysXiuGaiPanel = new GysXiuGaiPanel();
		tabbedPane.addTab("添加供应商", tianjiaIcon, gysTianJiaPanel, "添加供应商");//第一个参数为标题,第二个参数为图标icon 第四个参数为tip
		Icon xiugaiIcon = IconFactory.getIcon(IconFactory.MODIY_FILEPATH);
		tabbedPane.addTab("供应商修改和删除",xiugaiIcon, gysXiuGaiPanel,"供应商修改和删除");
		tabbedPane.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				gysXiuGaiPanel.initComboBox();//初始化
			}
		});
		this.getContentPane().add(tabbedPane);//选项面板添加到内部窗体中
		this.pack();//该方法会屏蔽掉setBounds(x,x,x,x)方法, 如果没有改方法，则必须加上pack()方法，否则绘制的面板不显示
		this.setVisible(true);
	}
	

}
