package com.lzw.atmm.sys.internalFrame.window;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import org.apache.commons.lang.StringUtils;

import com.lzw.atmm.dao.DBDao;
import com.lzw.atmm.login.LoginFrame;
import com.lzw.atmm.model.TbUserlist;
import com.lzw.atmm.tsd.data.IconFactory;
import com.lzw.atmm.tsd.util.ColorUtils;
import com.lzw.atmm.tsd.util.JohnStringUtil;
import com.lzw.atmm.view.message.ConfirmDlg;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：     更改密码内部窗体
 * 类名称：com.lzw.sys.internalFrame.frame.GengGaiMiMaFrame     
 * 创建人：杨洪
 * 创建时间：2016年8月4日 上午11:56:45   
 * 修改人：
 * 修改时间：2016年8月4日 上午11:56:45   
 * 修改备注：   
 * @version   V1.0    
 */

public class GengGaiMiMaFrame extends JInternalFrame{
	private static final long serialVersionUID = 8010854679468124612L;
	private JLabel toolTipLable;// 提示标签
	private JLabel loginNameLabel;//登录名
	private JLabel loginNameField;//标签域
	private JLabel userNameLabel;//用户名
	private JLabel userNameField;//标签域
	private JLabel oldPasswordLabel;
	private JLabel newPasswordLabel;
	private JLabel anewPasswordLabel;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField anewPasswordField;//再次确认新密码
	private JButton okButton;//确认按钮
	private JButton cancleButton;//取消按钮
	private TbUserlist user;
	private DBDao dbDao;
	private Font font = new Font("",Font.PLAIN,14);
	
	public GengGaiMiMaFrame(){
		user = LoginFrame.getInstance().getUser();//获得登陆时用户的信息（内存中已经有值了,登录时传入的值）
		dbDao =DBDao.newInstance();
		/***设置内部窗体工具栏的系列图标***/
		ImageIcon icon = IconFactory.getIcon(IconFactory.ALERT_FILEPATH);
		//this.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.setFrameIcon(icon);//设置内部窗体的图标
		this.setTitle("更改密码");
		this.setMaximizable(false);//设置内部窗体显示最大化图标
		this.setClosable(true);//设置显示关闭按钮,不写改行代码,则不显示最小化图标
		this.setIconifiable(true);//设置显示最小化图标
		this.setBounds(100, 100, 400, 250);
		this.getContentPane().setLayout(new GridBagLayout());//设置其容器布局为网格组布局
		/***设置内部窗体工具栏的系列图标***/
		initWindowComponent();
	}
	
	private void initWindowComponent(){//初始化窗体各组件
		this.addInternalFrameListener(new InternalFrameAdapter(){//当窗体的各组件创建完成后才触发该事件
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {//当窗体激活的时候触发该事件
			    userNameField.setText("<html><b>&nbsp;&nbsp;&nbsp;&nbsp;"+user.getUsername()+"</b></html>");
			    loginNameField.setText("<html><b>&nbsp;&nbsp;&nbsp;&nbsp;"+user.getName()+"</b></html>");  
			}
			
		});
		toolTipLable = new JLabel();
		toolTipLable.setForeground(ColorUtils.reverseColor(new Color(123,212,205)));
		toolTipLable.setText("<html>注：每个<b>操作员</b>只能修改自己的密码</html>");
		toolTipLable.setFont(font);
		final GridBagConstraints toolTipLableConstraints = new GridBagConstraints();
		toolTipLableConstraints.gridwidth=4;
		toolTipLableConstraints.gridx=0;
		toolTipLableConstraints.gridy=0;
		toolTipLableConstraints.weighty=1.0;
		this.getContentPane().add(toolTipLable,toolTipLableConstraints);//添加到容器
		
		userNameLabel = new JLabel("用户姓名:  ");
		userNameLabel.setFont(font);
		final GridBagConstraints userNameLabelConstraints = new GridBagConstraints();
		userNameLabelConstraints.gridx=0;
		userNameLabelConstraints.gridy=1;
		userNameLabelConstraints.anchor=GridBagConstraints.WEST;
		this.getContentPane().add(userNameLabel,userNameLabelConstraints);
		
		userNameField = new JLabel();
		userNameField.setPreferredSize(new Dimension(80,21));
		final GridBagConstraints userNameFieldConstraints = new GridBagConstraints();
		userNameFieldConstraints.gridx=1;
		userNameFieldConstraints.gridy=1;
		userNameFieldConstraints.weighty=1.0;
		userNameFieldConstraints.ipadx=30;//
		userNameFieldConstraints.insets = new Insets(0,0,0,10);
		userNameFieldConstraints.fill=GridBagConstraints.HORIZONTAL;//水平方向平铺
		this.getContentPane().add(userNameField,userNameFieldConstraints);
		
		
		loginNameLabel = new JLabel("登  录  名:  ");
		loginNameLabel.setFont(font);
		final GridBagConstraints loginNameLabelConstraints = new GridBagConstraints();
		loginNameLabelConstraints.gridx=0;
		loginNameLabelConstraints.gridy=2;
		loginNameLabelConstraints.anchor=GridBagConstraints.WEST;
		this.getContentPane().add(loginNameLabel,loginNameLabelConstraints);
		
		
		loginNameField = new JLabel();
		loginNameField.setPreferredSize(new Dimension(80,21));
		final GridBagConstraints loginNameFieldConstraints = new GridBagConstraints();
		loginNameFieldConstraints.gridx=1;
		loginNameFieldConstraints.gridy=2;
		loginNameFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
		this.getContentPane().add(loginNameField,loginNameFieldConstraints);
		
		
		oldPasswordLabel = new JLabel("旧  密  码:  ");
	    oldPasswordLabel.setFont(font);
	    final GridBagConstraints oldPasswordLabelConstraints = new GridBagConstraints();
	    oldPasswordLabelConstraints.gridx=0;
	    oldPasswordLabelConstraints.gridy=3;
	    oldPasswordLabelConstraints.anchor=GridBagConstraints.WEST;
	    oldPasswordLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
	    this.getContentPane().add(oldPasswordLabel,oldPasswordLabelConstraints);
	    
	    
	    oldPasswordField = new JPasswordField();
	    final GridBagConstraints oldPasswordFieldConstraints = new GridBagConstraints();
	    oldPasswordFieldConstraints.gridx=1;
	    oldPasswordFieldConstraints.gridy=3;
	    oldPasswordFieldConstraints.gridwidth=3;//占三个单元格
	    oldPasswordFieldConstraints.fill= GridBagConstraints.HORIZONTAL;
	    oldPasswordFieldConstraints.weighty=1.0;//竖直方向增长的权重
	    oldPasswordFieldConstraints.insets = new Insets(0,0,0,10);
	    this.getContentPane().add(oldPasswordField,oldPasswordFieldConstraints);
	    
	    newPasswordLabel = new JLabel("新  密  码:  ");
	    newPasswordLabel.setFont(font);
	    final GridBagConstraints newPasswordLabelConstraints = new GridBagConstraints();
	    newPasswordLabelConstraints.gridx=0;
	    newPasswordLabelConstraints.gridy=4;
	    newPasswordLabelConstraints.fill =GridBagConstraints.HORIZONTAL;
	    newPasswordLabelConstraints.anchor=GridBagConstraints.WEST;
	    this.getContentPane().add(newPasswordLabel,newPasswordLabelConstraints);
	    
	    newPasswordField = new JPasswordField();
	    final GridBagConstraints newPasswordFieldConstraints = new GridBagConstraints();
	    newPasswordFieldConstraints.gridx=1;
	    newPasswordFieldConstraints.gridy=4;
	    newPasswordFieldConstraints.gridwidth=3;//占三个单元格
	    newPasswordFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
	    newPasswordFieldConstraints.weighty=1.0;
	    newPasswordFieldConstraints.insets = new Insets(0,0,0,10);
	    this.getContentPane().add(newPasswordField,newPasswordFieldConstraints);
	    
	    
	    anewPasswordLabel = new JLabel("再次输入密码:");
	    anewPasswordLabel.setFont(font);
	    final GridBagConstraints anewPasswordLabelConstraints = new GridBagConstraints();
	    anewPasswordLabelConstraints.gridx=0;
	    anewPasswordLabelConstraints.gridy=5;
	    anewPasswordLabelConstraints.anchor=GridBagConstraints.WEST;
	    anewPasswordLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
	    this.getContentPane().add(anewPasswordLabel,anewPasswordLabelConstraints);
	    
	    anewPasswordField = new JPasswordField();
	    final GridBagConstraints anewPasswordFieldConstraints = new GridBagConstraints();
	    anewPasswordFieldConstraints.gridx=1;
	    anewPasswordFieldConstraints.gridy=5;
	    anewPasswordFieldConstraints.gridwidth=3;
	    anewPasswordFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
	    anewPasswordFieldConstraints.weighty=1.0;
	    anewPasswordFieldConstraints.insets =new Insets(0,0,0,10);
	    this.getContentPane().add(anewPasswordField,anewPasswordFieldConstraints);
		
		
		okButton = new JButton("确认");
		final GridBagConstraints okButtonConstraints = new GridBagConstraints();
		okButtonConstraints.gridx=1;
		okButtonConstraints.gridy=6;
		okButtonConstraints.anchor=GridBagConstraints.WEST;// 当组件自身的尺寸小于分配给组件的空间时,组件的摆放位置
		okButtonConstraints.weighty=1.0;
		this.getContentPane().add(okButton,okButtonConstraints);
		okButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String oldPassword =new String(oldPasswordField.getPassword());
				String newPassword =new String(newPasswordField.getPassword());
				String anewPassword = new String(anewPasswordField.getPassword());
				if(JohnStringUtil.isEmpty(oldPassword)){
					JOptionPane.showConfirmDialog(getContentPane(), "请输入旧密码.");
					return;
				}
				
				if(user.getPass().equals(oldPassword)){
					ConfirmDlg.showConfirmDialog(getContentPane(), "你输入的旧密码错误.", ConfirmDlg.ERROR_MESSAGE);
					return;
				}
				if(JohnStringUtil.isEmpty(newPassword)){
					JOptionPane.showConfirmDialog(getContentPane(),"请输入新密码.");
					return;
				}
				if(StringUtils.isBlank(anewPassword)){
					JOptionPane.showConfirmDialog(getContentPane(),"请在次输入新密码.");
					return;
				}
				if(newPassword.equals(anewPassword)){
					user.setPass(newPassword);
					dbDao.updateUser(user);
					oldPasswordField.setText(null);
					newPasswordField.setText(null);
					anewPasswordField.setText(null);
					JOptionPane.showMessageDialog(getContentPane(), "密码修改成功。");
				}else{
					JOptionPane.showMessageDialog(getContentPane(), "两次输入的新密码不一致.");
				}
				
			}
		});
		
		
		
		cancleButton= new JButton();
		cancleButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				oldPasswordField.setText(null);
				newPasswordField.setText(null);
				anewPasswordField.setText(null);
			}
		});
		cancleButton.setText("重写");
		final GridBagConstraints cancleButtonConstraints = new GridBagConstraints();
		cancleButtonConstraints.gridwidth = 2;
		cancleButtonConstraints.weighty = 1.0;
		cancleButtonConstraints.gridy = 6;
		cancleButtonConstraints.gridx = 2;
		this.getContentPane().add(cancleButton, cancleButtonConstraints);
	}
	
	
	

}
