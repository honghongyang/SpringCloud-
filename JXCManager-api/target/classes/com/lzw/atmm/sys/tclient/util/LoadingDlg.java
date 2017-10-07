package com.lzw.atmm.sys.tclient.util;
import java.awt.BorderLayout;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXBusyLabel;


/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：模态界面加载等待对话框
 * 类名称：com.lzw.sys.tclient.util.LoadingDlg     
 * 创建人：杨洪
 * 创建时间：2016年10月26日 上午10:12:54   
 * 修改人：
 * 修改时间：2016年10月26日 上午10:12:54   
 * 修改备注：   
 * @version   V1.0    
 */

public class LoadingDlg extends JDialog {
	private static final long serialVersionUID = 1L;
	
	public LoadingDlg(Window window){
		super(window);
		this.setVisible(false);
		this.setModal(true);
		this.setUndecorated(true);//取消对话框的装饰
		this.setAlwaysOnTop(true);//总是置于最前面
        //创建忙状态的标签
		JXBusyLabel label = new JXBusyLabel();//默认忙的标签
		label.setText("loading");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());//设置布局为边框布局
		mainPanel.add(label,BorderLayout.CENTER);
		mainPanel.setBorder(BorderFactory.createTitledBorder("请等待,系统正在加载中>>>>>"));//创建标题边框
		this.add(mainPanel,BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setSize(200, 70);
		label.setBusy(true);
		
	}
	public LoadingDlg(){
		this.setVisible(false);
		this.setModal(true);//设置窗体模态,总是在所有的窗体的最前面
		this.setUndecorated(true);//取消对话框的装饰
		this.setAlwaysOnTop(true);//总是置于最前面
	
        //创建忙状态的标签
		JXBusyLabel label = new JXBusyLabel();//默认忙的标签
		label.setText("Loading");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());//设置布局为边框布局
		mainPanel.add(label,BorderLayout.CENTER);
		mainPanel.setBorder(BorderFactory.createTitledBorder("请等待,系统正在加载中>>>>>"));//创建标题边框
		this.add(mainPanel,BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setSize(200, 70);
		//设置标签处于忙的状态
		label.setBusy(true);//忙碌状态图标
	}
	public static void main(String[] args) {
		new LoadingDlg().setVisible(true);
	}

}
