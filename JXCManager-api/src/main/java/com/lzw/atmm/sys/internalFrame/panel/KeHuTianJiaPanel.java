package com.lzw.atmm.sys.internalFrame.panel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lzw.atmm.dao.DBDao;
import com.lzw.atmm.model.TbKhinfo;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述： 客户信息添加面板
 * 类名称：com.lzw.sys.internalFrame.panel.KeHuTianJiaPanel     
 * 创建人：杨洪
 * 创建时间：2016年8月10日 下午2:12:40   
 * 修改人：
 * 修改时间：2016年8月10日 下午2:12:40   
 * 修改备注：   
 * @version   V1.0    
 */

public class KeHuTianJiaPanel extends JPanel {
	private static final long serialVersionUID = 2294394589745813421L;
	private JLabel quanchengLabel;
	private JLabel addressLabel;
	private JLabel simpleNameLabel;//客户简称
	private JLabel emsCodeLabel;//邮政编码
	private JLabel phoneLabel;//座机
	private JLabel faxLabel;
	private JLabel manLabel;
	private JLabel manMobileLabel;
	private JLabel emailLabel;//电子邮件
	private JLabel yinhangLabel;
	private JLabel accountLabel;//银行账号
	private DBDao dbDao;
	private JTextField quanchengField;
	private JTextField addressField;
	private JTextField simpleNameField;
	private JTextField emsCodeField;
	private JTextField phoneField;
	private JTextField faxField;
	private JTextField manField;
	private JTextField manMobileField;
	private JTextField emailField;
	private JTextField yinhangField;
	private JTextField accountField;
	private JButton saveButton;
	private JButton resetButton;
	
	public KeHuTianJiaPanel(){
		dbDao = DBDao.newInstance();
		this.setLayout(new GridBagLayout());
		this.setBounds(10, 10, 460,300);
		this.initWindowComponent();
	}

	
	private void initWindowComponent() {
		quanchengLabel = new JLabel("客户全称:");
		setComponentConstraints(quanchengLabel,0,0,1,1,false);
		quanchengField = new JTextField();
		setComponentConstraints(quanchengField,1,0,3,350,true);
		
		addressLabel = new JLabel("供应商地址:");
		setComponentConstraints(addressLabel,0,1,1,1,false);
		addressField = new JTextField();
		setComponentConstraints(addressField,1,1,3,350,true);
		
		simpleNameLabel = new JLabel("客户简称:");
		setComponentConstraints(simpleNameLabel,0,2,1,1,false);
		simpleNameField = new JTextField();
		setComponentConstraints(simpleNameField,1,2,1,100,true);
		
		emsCodeLabel = new JLabel("邮政编码:");
		setComponentConstraints(emsCodeLabel,2,2,1,1,false);
		emsCodeField = new JTextField();
		setComponentConstraints(emsCodeField,3,2,1,100,true);
		
		phoneLabel = new JLabel("电话:");
		setComponentConstraints(phoneLabel,0,3,1,1,false);
		phoneField = new JTextField();
		setComponentConstraints(phoneField,1,3,1,1,true);
		
		faxLabel = new JLabel("传真:");
		setComponentConstraints(faxLabel,2,3,1,1,false);
		faxField = new JTextField();
		setComponentConstraints(faxField,3,3,1,1,true);
		
		manLabel = new JLabel("联系人:");
		setComponentConstraints(manLabel,0,4,1,1,false);
		manField = new JTextField();
		setComponentConstraints(manField,1,4,1,1,true);
        
		manMobileLabel = new JLabel("联系人手机:");
		setComponentConstraints(manMobileLabel,2,4,1,1,false);
		manMobileField = new JTextField();
		setComponentConstraints(manMobileField,3,4,1,1,true);
		
		emailLabel = new JLabel("邮箱:");
		setComponentConstraints(emailLabel,0,5,1,1,false);
		emailField = new JTextField();
		setComponentConstraints(emailField,1,5,3,1,true);
		
		yinhangLabel = new JLabel("开户银行:");
		setComponentConstraints(yinhangLabel,0,6,1,1,false);
		yinhangField = new JTextField();
		setComponentConstraints(yinhangField,1,6,1,1,true);
		
		accountLabel = new JLabel("账号:");
		setComponentConstraints(accountLabel,2,6,1,1,false);
		accountField = new JTextField();
		setComponentConstraints(accountField,3,6,1,1,true);	
		
		saveButton = new JButton("保存");
		saveButton.addActionListener(new SaveActionListener());
		setComponentConstraints(saveButton,1,7,1,0,false);
		
		resetButton = new JButton("重置");
		resetButton.addActionListener(new ResetActionListener());//为按钮注册监听器
		setComponentConstraints(resetButton,3,7,1,0,false);
	}
	
	
	private void setComponentConstraints(JComponent component,int gridx,int gridy,
			                             int gridwidth,int ipadx,boolean fill){
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx=gridx;
		gridBagConstraints.gridy=gridy;
		if(gridwidth>1){
			gridBagConstraints.gridwidth=gridwidth;
		}
		if(ipadx>0){
			gridBagConstraints.ipadx=ipadx;
		}
		if(fill){
			gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
		}
		gridBagConstraints.insets = new Insets(5,2,3,1);
		this.add(component,gridBagConstraints);
	}
	
	private class SaveActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (addressField.getText().equals("")
					|| emsCodeField.getText().equals("")
					|| faxField.getText().equals("")
					|| accountField.getText().equals("")
					|| simpleNameField.getText().equals("")
					|| quanchengField.getText().equals("")
					|| manField.getText().equals("")
					|| manMobileField.getText().equals("")
					|| emailField.getText().equals("")
					|| phoneField.getText().equals("")
					|| yinhangField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请填写全部信息");
				return;
			}
			ResultSet haveUser = dbDao
					.query("select * from tb_khinfo where khname='"
							+ quanchengField.getText().trim() + "'");
			try {
				if (haveUser.next()){
					System.out.println("error");
					JOptionPane.showMessageDialog(KeHuTianJiaPanel.this,
							"客户信息添加失败，存在同名客户", "客户添加信息",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			} catch (Exception er) {
				er.printStackTrace();
			}
			ResultSet set = dbDao.query("select max(id) from tb_khinfo");
			String id = null;
			try {
				if (set != null && set.next()) {
					String sid = set.getString(1);
					if (sid == null)
						id = "kh1001";
					else {
						String str = sid.substring(2);
						id = "kh" + (Integer.parseInt(str) + 1);
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			TbKhinfo khinfo = new TbKhinfo();
			khinfo.setId(id);
			khinfo.setAddress(addressField.getText().trim());
			khinfo.setBianma(emsCodeField.getText().trim());
			khinfo.setFax(faxField.getText().trim());
			khinfo.setHao(accountField.getText().trim());
			khinfo.setJian(simpleNameField.getText().trim());
			khinfo.setKhname(quanchengField.getText().trim());
			khinfo.setLian(manField.getText().trim());
			khinfo.setLtel(manMobileField.getText().trim());
			khinfo.setMail(emailField.getText().trim());
			khinfo.setTel(phoneField.getText().trim());
			khinfo.setXinhang(yinhangField.getText());
			dbDao.addKeHu(khinfo);
			JOptionPane.showMessageDialog(KeHuTianJiaPanel.this, "已成功添加客户",
					"客户添加信息", JOptionPane.INFORMATION_MESSAGE);
			resetButton.doClick();
		}
	}
			
	private class ResetActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
				quanchengField.setText("");
				accountField.setText("");
				yinhangField.setText("");
				emailField.setText("");
				manMobileField.setText("");
				manField.setText("");
				faxField.setText("");
				phoneField.setText("");
				emsCodeField.setText("");
				addressField.setText("");
				simpleNameField.setText("");
			}	
		}
}
