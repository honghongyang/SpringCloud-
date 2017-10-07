package com.lzw.atmm.sys.internalFrame.panel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import com.lzw.atmm.dao.DBDao;
import com.lzw.atmm.model.TbUserlist;
import com.lzw.atmm.view.message.ConfirmDlg;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：系统管理面板
 * 类名称：com.lzw.sys.internalFrame.panel.TJCzy     
 * 创建人：杨洪
 * 创建时间：2016年6月17日 下午3:59:49   
 * 修改人：
 * 修改时间：2016年6月17日 下午3:59:49   
 * 修改备注：   
 * @version   V1.0    
 */
public class TJCzyPanel extends JPanel {//系统管理面板
	private static final long serialVersionUID = 2572070624038246L;
	private JTextField loginName;//登录名文本域
	private JPasswordField  passwordField;//密码域
	private JPasswordField  surePasswordField;//确认密码域
	private JTextField operationNameField;//操作员名称
	private Font font = new Font("",Font.PLAIN,14);//设置字体
	private JLabel loginLabel;//登陆名称
	private JLabel operationNameLabel;//操作员名称
	private JLabel jPasswordLabel;//密码
	private JLabel enterPasswordLabel;//确认密码
	private JButton okButton;
	private JButton cencleButton;//取消按钮
	private DBDao dbDao;
	
	private static class SingletonTJCzyHandler{
		private static TJCzyPanel newInstance=new TJCzyPanel();
	}
	public static TJCzyPanel newInstance(){
		return TJCzyPanel.SingletonTJCzyHandler.newInstance;
	}
	private TJCzyPanel(){
		super();
		dbDao = DBDao.newInstance();
		this.setLayout(new GridBagLayout());//设置面板的布局为网格组布局,版面管理器
		this.setBounds(0, 0, 280, 236);//设置面板显示的位置和大小
		initComponent();//初始化组件
	}
	
	
	
	private void initComponent(){//竖直方向为Y坐标轴方向,水平方向为X坐标轴方向
		loginLabel = new JLabel("登录名称:");
		loginLabel.setFont(font);
		final GridBagConstraints loginLabelConstraints = new GridBagConstraints();//网格组布局约束
		loginLabelConstraints.gridx=0;//0行
		loginLabelConstraints.gridy=0;//0列
		loginLabelConstraints.insets=new Insets(10,0,0,10);
		this.add(loginLabel,loginLabelConstraints);//为 登录名标签设置约束, 添加组件到面板
		//为登录框设置约束
		loginName = new JTextField();
		loginName.setFont(font);
		final GridBagConstraints loginNameConstraints = new GridBagConstraints();//设置网格组布局
		loginNameConstraints.weightx=1.0;//(权重)用来设置窗口变大时，各组件跟着变大的比例，当数字越大，表示组件能得到更多的空间，默认值皆为0
		loginNameConstraints.insets=new Insets(10,0,0,10);//insets:设置组件之间彼此的间距，它有四个参数，分别是上，左，下，右，默认为(0,0,0,0).
	    loginNameConstraints.fill=GridBagConstraints.HORIZONTAL;//延着水平方向平铺
	    loginNameConstraints.gridwidth=2;//水平方向占两个单元格，用来设置组件所占的单位长度与高度,默认值皆为1。你可以使用GridBagConstraints.REMAINDER常 量，代表此组件为此行或此列的最后一个组件，而且会占据所有剩余的空间。
	    loginNameConstraints.gridx=1;
	    loginNameConstraints.gridy=0;//设置组件的位置，gridx设置为GridBagConstraints.RELATIVE代表此组件位于之前所加入组件的右边。 若将gridy设置为GridBagConstraints.RELATIVE代表此组件位于以前所加入组件的下面。建议定义出gridx,gridy的位置，以便以后维护程序。表示放在几行几列，gridx=0,gridy=0时放在0行0列
	    this.add(loginName,loginNameConstraints);
	    //设置操作员标签
	    operationNameLabel = new JLabel("操作员姓名:");
	    operationNameLabel.setFont(font);
	    final GridBagConstraints operationNameConstraints = new GridBagConstraints();
	    operationNameConstraints.gridx=0;//水平方向第一列
	    operationNameConstraints.gridy=1;//竖直方向第二列
	    operationNameConstraints.insets=new Insets(20,0,0,10);
	    this.add(operationNameLabel,operationNameConstraints);//添加组件到面板,同时添加约束
	    //设置操作员文本框
	    operationNameField = new JTextField();
	    operationNameField.setFont(font);
	    final GridBagConstraints operationNameFieldConstraints = new GridBagConstraints();
	    operationNameFieldConstraints.gridx=1;//水平方向第二列
	    operationNameFieldConstraints.gridy=1;//竖直方向第二列
	    operationNameFieldConstraints.weightx=1.0;//设置当窗体变大时,组件水平方向跟着变大的比例,数字越大,表示组件能得到的更多的空间,默认值为0
	    operationNameFieldConstraints.weighty=1.0;//竖直方向跟着变大的比较
	    operationNameFieldConstraints.gridwidth=2;//水平方向占两个单元格,不标注则默认占一个单元格
	    operationNameFieldConstraints.insets = new Insets(20,0,0,10);//设置组件之间的间距
	    operationNameFieldConstraints.fill=GridBagConstraints.HORIZONTAL;//水平方向平铺
	    operationNameFieldConstraints.ipadx = -250;//ipadx,ipady:设置组件内的间距，默认值为0
	    this.add(operationNameField,operationNameFieldConstraints);//添加组件到面板,同时为组件添加约束
	    
	    jPasswordLabel = new JLabel("输入密码:");
	    jPasswordLabel.setFont(font);
	    final GridBagConstraints passwordLabelConstraints = new GridBagConstraints();
	    passwordLabelConstraints.gridx=0;//水平方向第一列
	    passwordLabelConstraints.gridy=2;//竖直方向第三列
	    passwordLabelConstraints.insets=new Insets(10,0,0,10);
	    this.add(jPasswordLabel,passwordLabelConstraints);//添加到面板中
	    
	    //设置输入密码框
	    passwordField = new JPasswordField();
	    passwordField.setFont(font);
	    final GridBagConstraints passwordFieldConstraints = new GridBagConstraints();
	    passwordFieldConstraints.gridx=1;//水平方向第一列
	    passwordFieldConstraints.gridy=2;//竖直方向第三列
	    passwordFieldConstraints.gridwidth=20;//占两个单元格
	    passwordFieldConstraints.fill=GridBagConstraints.HORIZONTAL;//水平方向平铺
	    passwordFieldConstraints.insets = new Insets(10,0,0,10);//设置该组件跟各个组件的间距
	    passwordFieldConstraints.weightx=1.0;//组件水平方向变大的比例
	    passwordFieldConstraints.weighty=1.0;//竖直方向变大的比例
	    this.add(passwordField,passwordFieldConstraints);
	    
	    enterPasswordLabel = new JLabel("确认密码:");
	    enterPasswordLabel.setFont(font);
	    final GridBagConstraints enterPasswordLabelConstraints = new GridBagConstraints();
	    enterPasswordLabelConstraints.gridx=0;//水平方向第一列
	    enterPasswordLabelConstraints.gridy=3;//竖直方向第四列
	    enterPasswordLabelConstraints.insets=new Insets(10,0,0,10);
	    this.add(enterPasswordLabel,enterPasswordLabelConstraints);
	    
	    surePasswordField = new JPasswordField();
	    surePasswordField.setFont(font);
	    final GridBagConstraints surePasswordFieldConstraints = new GridBagConstraints();
	    surePasswordFieldConstraints.gridx=1;//水平方向第二列
	    surePasswordFieldConstraints.gridy=3;//竖直方向第四列
	    surePasswordFieldConstraints.gridwidth=2;//水平方向占两个单元格
	    surePasswordFieldConstraints.insets = new Insets(0,0,0,10);
	    surePasswordFieldConstraints.fill=GridBagConstraints.HORIZONTAL;//水平方向平铺
	    surePasswordFieldConstraints.weightx=1.0;
	    surePasswordFieldConstraints.weighty=1.0;//竖直方向变大的比例
	    surePasswordFieldConstraints.insets=new Insets(10,0,0,10);
	    this.add(surePasswordField,surePasswordFieldConstraints);
	    
	    okButton = new JButton("添加");
	    final GridBagConstraints okButtonConstraints = new GridBagConstraints();
	    okButtonConstraints.anchor=GridBagConstraints.WEST;//anchor:当组件空间大于组件本身时，要将组件置于何处，有CENTER(默认值)、NORTH、NORTHEAST、EAST、SOUTHEAST、 WEST、NORTHWEST可供选择。
	    //上北(NORTH)下南(SOUTH)左西(WEST)右东(EAST)
	    okButtonConstraints.gridx=1;
	    okButtonConstraints.gridy=5;//竖直方向放在第五行
        okButtonConstraints.weightx=1.0;
       
        okButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(final ActionEvent e) {
				String loginNameText=loginName.getText();
				String operationNameText= operationNameField.getText();
				String password =new String(passwordField.getPassword());
				String enterPassword = new String(surePasswordField.getPassword());
				if(StringUtils.isBlank(loginNameText)){
					ConfirmDlg.showConfirmDialog(null, "登录名称不能为空.", ConfirmDlg.INFORMATION_MESSAGE);// 提示信息
					loginName.setFocusable(true);//设置文本框获得焦点
					return ;
				}
				if(StringUtils.isEmpty(operationNameText)){
					ConfirmDlg.showConfirmDialog(null, "操作员姓名不能为空.", ConfirmDlg.INFORMATION_MESSAGE);
					operationNameField.setRequestFocusEnabled(true);//设置文本框获得请求焦点
					return;
				}
				if(StringUtils.isEmpty(password)){
					ConfirmDlg.showConfirmDialog(null, "密码不能为空.", ConfirmDlg.INFORMATION_MESSAGE);
					passwordField.setFocusable(true);
					return ;
				}
				if(StringUtils.isEmpty(enterPassword)){
					ConfirmDlg.showConfirmDialog(null, "确认密码不能为空.", ConfirmDlg.INFORMATION_MESSAGE);
					surePasswordField.setRequestFocusEnabled(true);
					return;
				}
				if(!password.equalsIgnoreCase(enterPassword)){
					/*ConfirmDlg.showConfirmDialog(null, "两次输入的密码不一样,请重新输入.", ConfirmDlg.INFORMATION_MESSAGE);*/
					JOptionPane.showMessageDialog(TJCzyPanel.this, "两次密码输入不相同");
					loginName.setFocusable(true);//设置文本框获得焦点
					return;
				}
				TbUserlist user=dbDao.getUser(loginNameText, password);
				if(user != null){
					ConfirmDlg.showConfirmDialog(null, "此登录名已经存在,请输入其他的名称.", ConfirmDlg.INFORMATION_MESSAGE);
					loginName.setRequestFocusEnabled(true);
					return ;
				}else{
					TbUserlist tbUserlist = TbUserlist.getInstance();
					tbUserlist.setQuan("c");
					tbUserlist.setPass(password);
					tbUserlist.setName(loginNameText.trim());
					tbUserlist.setUsername(operationNameText.trim());
					dbDao.addUser(tbUserlist);
					JOptionPane.showMessageDialog(TJCzyPanel.this, "操作员添加成功");
					clear();
				}
			}
        });
        this.add(okButton,okButtonConstraints);
        
        
        cencleButton = new JButton("重置");
        cencleButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				clear();
			}
		});
		final GridBagConstraints cencleButtonGridBagConstraints = new GridBagConstraints();
		cencleButtonGridBagConstraints.weighty = 1.0;
		cencleButtonGridBagConstraints.gridy = 5;
		cencleButtonGridBagConstraints.gridx = 2;
		cencleButtonGridBagConstraints.insets=new Insets(0,0,0,80);
		add( cencleButton,cencleButtonGridBagConstraints); 
	}
	private void clear() {
		loginName.setText(null);
		operationNameField.setText(null);
		passwordField.setText(null);
		surePasswordField.setText(null);
	}
	public DBDao getDbDao() {
		return dbDao;
	}
	public void setDbDao(DBDao dbDao) {
		this.dbDao = dbDao;
	}
	
}
