package com.lzw.atmm.sys.internalFrame.panel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.lzw.atmm.dao.DBDao;
import com.lzw.atmm.sys.internalFrame.window.CzyGLFrame;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：删除操作员面板
 * 类名称：com.lzw.sys.internalFrame.panel.ShanChuCaoZuoYuan     
 * 创建人：杨洪
 * 创建时间：2016年8月3日 下午1:33:36   
 * 修改人：
 * 修改时间：2016年8月3日 下午1:33:36   
 * 修改备注：   
 * @version   V1.0    
 */

public class ShanChuCaoZuoYuanPanel extends JPanel {
	private static final long serialVersionUID = 4018499865319868829L;
	private JLabel loginNameLabel;//登录名标签
	private JLabel userNameLabel;//用户名标签
	private JLabel passwordLabel;//密码标签
	private JTextField loginNameField;//登录名文本域
	private JTextField userNameField;//用户名标签
	private JPasswordField passwordField;
	private JTable table;
	private DBDao dbDao;
	private DefaultTableModel dftm;//默认的表格模型
	private String[] columnNames;//表头的列名称
	private JScrollPane scrollPane;//滚动面板
	private JButton deleteButton;//删除按钮
	private JButton closedButton;//关闭按钮
	
	
	private static class  SingtonSCCZYHandler{
		private static ShanChuCaoZuoYuanPanel newInstance = new ShanChuCaoZuoYuanPanel();
	}
	public static ShanChuCaoZuoYuanPanel newInstance(){
		return ShanChuCaoZuoYuanPanel.SingtonSCCZYHandler.newInstance;
	}
	
	private ShanChuCaoZuoYuanPanel(){
		this.setBounds(0, 0, 491, 287);
		this.setLayout(new GridBagLayout());
		dbDao=DBDao.newInstance();
		this.initComponent();
		this.setVisible(true);
	}
	
	
	private void initComponent(){//初始化各组件
		scrollPane = new JScrollPane();
		final GridBagConstraints jScrollPaneConstraints = new GridBagConstraints();
		jScrollPaneConstraints.weightx=1.0;
		jScrollPaneConstraints.weighty=1.0;
		jScrollPaneConstraints.insets = new Insets(0,0,20,0);
		jScrollPaneConstraints.gridx=0;
		jScrollPaneConstraints.gridy=0;
		jScrollPaneConstraints.fill=GridBagConstraints.BOTH;
		jScrollPaneConstraints.gridwidth=20;//水平方向占20个单元格
		jScrollPaneConstraints.ipadx=35;
		jScrollPaneConstraints.ipady=-195;
		this.add(scrollPane,jScrollPaneConstraints);//添加约束,同时添加滚动面板到初始化面板中
		
		table = new JTable();
		dftm = (DefaultTableModel) table.getModel();//获取表格模型
		columnNames = new String[]{"用户名","登录名","密码","权限"};
		dftm.setColumnIdentifiers(columnNames);//设置表格的表头模型
		//为表格添加鼠标监听器
		table.addMouseListener(new MouseAdapter(){
			String loginName,userName,password;
			@Override
			public void mouseClicked(MouseEvent e) {//重写鼠标单击事件,当单击表格的每一行时,给对应的文本框赋值
				int selrow=table.getSelectedRow();//获取被选中的表格的行数,就可用获得选中的行的所有列
			    loginName=table.getValueAt(selrow, 1).toString().trim();//第二列
			    userName=table.getValueAt(selrow, 0).toString().trim();//第一列
			    password=table.getValueAt(selrow, 2).toString().trim();//第三列
			    
			    //给文本框设置值
			    loginNameField.setText(loginName);
			    loginNameField.setToolTipText(loginName);//设置提示标签
			    userNameField.setText(userName);
			    userNameField.setToolTipText(userName);
			    passwordField.setText(password);
			    passwordField.setToolTipText(password);
			}
		});
		//scrollPane.add(table);
		scrollPane.setViewportView(table);
		userNameLabel = new JLabel("用户姓名:");
		final GridBagConstraints userNameLabelConstraints = new GridBagConstraints();
		userNameLabelConstraints.gridx=0;//水平方向第一列
		userNameLabelConstraints.gridy=2;//竖直方向第三行
		this.add(userNameLabel,userNameLabelConstraints);
		
		userNameField = new JTextField();
		userNameField.setEnabled(false);//不能编辑
		final GridBagConstraints userNameFieldConstraints = new GridBagConstraints();
		userNameFieldConstraints.gridx=3;//第四列
		userNameFieldConstraints.gridy=2;//第三行
		userNameFieldConstraints.weightx=1.0;
		userNameFieldConstraints.fill=GridBagConstraints.HORIZONTAL;
		userNameFieldConstraints.insets =new Insets(0,0,0,10);
		this.add(userNameField,userNameFieldConstraints);
		
		
		loginNameLabel = new JLabel("登录名:");
		final GridBagConstraints loginNameLabelConstraints = new GridBagConstraints();
		loginNameLabelConstraints.gridx=4;//第五列
		loginNameLabelConstraints.gridy=2;//第三行
		this.add(loginNameLabel,loginNameLabelConstraints);
		
		loginNameField = new JTextField();
		loginNameField.setEnabled(false);
		final GridBagConstraints loginNameFieldConstraints = new GridBagConstraints();
		loginNameFieldConstraints.gridx=5;
		loginNameFieldConstraints.gridy=2;
		loginNameFieldConstraints.weightx=1.0;
		loginNameFieldConstraints.fill=GridBagConstraints.HORIZONTAL;
		loginNameFieldConstraints.insets = new Insets(0,0,0,10);
		this.add(loginNameField,loginNameFieldConstraints);
		
		
		passwordLabel = new JLabel("密码：");
		final GridBagConstraints passwordLabelConstraints = new GridBagConstraints();
		passwordLabelConstraints.gridy = 2;
		passwordLabelConstraints.gridx = 6;
		add(passwordLabel, passwordLabelConstraints);
	

		passwordField = new JPasswordField();
		final GridBagConstraints passwordFieldConstraints = new GridBagConstraints();
		passwordFieldConstraints.insets = new Insets(0, 0, 0, 10);
		passwordFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
		passwordFieldConstraints.weightx = 1.0;
		passwordFieldConstraints.gridy = 2;
		passwordFieldConstraints.gridx = 7;
		add(passwordField, passwordFieldConstraints);
		passwordField.setEditable(false);

		deleteButton = new JButton("删除");
		final GridBagConstraints deleteButtonConstraints = new GridBagConstraints();
		deleteButtonConstraints.insets = new Insets(5, 0, 5, 0);
		deleteButtonConstraints.gridy = 7;
		deleteButtonConstraints.gridx = 4;
		add(deleteButton, deleteButtonConstraints);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(ShanChuCaoZuoYuanPanel.this,
						"确认要删除该操作员？");
				if (op == JOptionPane.OK_OPTION) {
					dbDao.delete("delete tb_userlist where username='"
							+ loginNameField.getText() + "'");
					loginNameField.setText("");
					passwordField.setText("");
					userNameField.setText("");
					initTable();
				}
			}
		});

		closedButton = new JButton("关闭");
		final GridBagConstraints closedButtonConstraints = new GridBagConstraints();
		closedButtonConstraints.insets = new Insets(5, 0, 5, 0);
		closedButtonConstraints.gridy = 7;
		closedButtonConstraints.gridx = 6;
		add(closedButton,closedButtonConstraints);
		closedButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				CzyGLFrame parent = (CzyGLFrame) ShanChuCaoZuoYuanPanel.this.getRootPane()
						.getParent();
				parent.doDefaultCloseAction();//获得父窗体的关闭行为
			}
		});
	}
	public void initTable(){
	List<List<String>>	list=dbDao.getUsers();
	Iterator<List<String>> tableData=list.iterator();
	dftm.setDataVector(null, columnNames);
	String[] data = new String[4];
	while(tableData.hasNext()){
		List<String> TD=tableData.next();
		data[0]=TD.get(0);
		data[1]=TD.get(1);
		data[2]=TD.get(2);
		data[3]=TD.get(3).equals("a")
				? "系统管理员"
				: "普通操作员";
		dftm.addRow(data);
	}
	
	this.setVisible(true);
	}

	public DBDao getDbDao() {
		return dbDao;
	}

	public void setDbDao(DBDao dbDao) {
		this.dbDao = dbDao;
	}
	
	

}
