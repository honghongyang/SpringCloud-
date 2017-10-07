package com.lzw.atmm.sys.internalFrame.panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.lzw.atmm.tsd.data.IconFactory;
/**
 * 
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：登录面板
 * 类名称：com.lzw.login.LoginPanel     
 * 创建人：杨洪
 * 创建时间：2016年8月3日 下午1:29:31   
 * 修改人：
 * 修改时间：2016年8月3日 下午1:29:31   
 * 修改备注：   
 * @version   V1.0
 */
public class LoginPanel extends JPanel {//图片背景图片面板
	private static final long serialVersionUID = 6309226557253008745L;
	protected ImageIcon icon;
	public int width,height;
	private LoginPanel() {
		super();
		icon = new ImageIcon(IconFactory.LOGIN_FILEPATH);//创建图标对象
		width = icon.getIconWidth();//图片的宽度
		height = icon.getIconHeight();//图片的高度
		setSize(width, height+25);//设置面板的宽度和高度
	}
	private static class LoginPanelHolder {//匿名内部类
	    	private static LoginPanel instance = new LoginPanel();
	    }
	 
	public static LoginPanel getInstance(){//公共方法返回单例对象
			return LoginPanel.LoginPanelHolder.instance;
		}
	
    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = icon.getImage();
		g.drawImage(img, 0, 0,getParent());
	}
}
