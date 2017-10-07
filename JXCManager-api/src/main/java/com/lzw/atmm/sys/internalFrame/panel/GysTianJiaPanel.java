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
import com.lzw.atmm.keyListener.InputKeyListener;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：供应商添加面板
 * 类名称：com.lzw.sys.internalFrame.panel.GysTianJiaPanel     
 * 创建人：杨洪
 * 创建时间：2016年8月8日 下午5:18:57   
 * 修改人：
 * 修改时间：2016年8月8日 下午5:18:57   
 * 修改备注：   
 * @version   V1.0    
 */
import com.lzw.atmm.model.TbGysinfo;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：供应商添加面板
 * 类名称：com.lzw.sys.internalFrame.panel.GysTianJiaPanel     
 * 创建人：杨洪
 * 创建时间：2016年8月8日 下午5:18:57   
 * 修改人：
 * 修改时间：2016年8月8日 下午5:18:57   
 * 修改备注：   
 * @version   V1.0    
 */

public class GysTianJiaPanel extends JPanel {
	private static final long serialVersionUID = -5417338113030040391L;
	private JLabel quanchengLabel;//供应商全称
	private JLabel simpleNameLabel;//供应商简称
	private JLabel gzipLabel;//邮政编码
	private JLabel addressLabel;// 地址
	private JLabel phoneLabel;//座机
	private JLabel faxLabel;// 传真
    private JLabel manLabel;//联系人
    private JLabel manMobileLabel;//联系人电话
    private JLabel yinhangLabel;//开户银行
    private JLabel emailLabel;//电子邮箱
    private JButton addButton;//添加
    private JButton reSetButton;//重置
    
    private JTextField quanchengField;//供应商全称文本框
    private JTextField simpleNameField;
    private JTextField gzipField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField faxField;
    private JTextField manField;
    private JTextField manMobileField;
    private JTextField yinhangField;
    private JTextField emailField;
    private DBDao dbDao;
    
    public GysTianJiaPanel(){
    	this.dbDao=DBDao.newInstance();
    	this.setLayout(new GridBagLayout());//设置面板的布局为网格组布局
    	setBounds(10, 10, 510, 302);
    	this.initWindowComponent();
    }
    
    
    
    private void initWindowComponent(){
    	quanchengLabel = new JLabel("供应商全称:");
    	setComponentConstraints(quanchengLabel,0,0,1,1,false);
    	quanchengField = new JTextField();
    	setComponentConstraints(quanchengField,1,0,3,400,true);//占三个单元格,沿水平方向平铺,ipadx=400,该参数表示当所给的空间大于组件自身的空间时,组件增长的比例
    	
    	simpleNameLabel= new JLabel("简称:");
    	setComponentConstraints(simpleNameLabel,0,1,1,1,false);
    	simpleNameField = new JTextField();
    	setComponentConstraints(simpleNameField,1,1,1,160,true);//ipadx=160  对后面的组件具有参照性
    	
    	gzipLabel = new JLabel("邮政编码:");
    	setComponentConstraints(gzipLabel,2,1,1,1,false);
    	gzipField = new JTextField();
    	gzipField.addKeyListener(new InputKeyListener());//为该文本框添加监听器对象,只能输入数字
    	setComponentConstraints(gzipField,3,1,1,1,true);
    	
    	addressLabel = new JLabel("地址:");
    	setComponentConstraints(addressLabel,0,2,1,1,false);
    	addressField = new JTextField();
    	setComponentConstraints(addressField,1,2,3,1,true);
    	
    	phoneLabel = new JLabel("座机:");
    	setComponentConstraints(phoneLabel,0,3,1,1,false);
    	phoneField = new JTextField();
    	setComponentConstraints(phoneField,1,3,1,1,true);
    	
    	faxLabel = new JLabel("传真:");
    	setComponentConstraints(faxLabel,2,3,1,1,false);
    	faxField = new JTextField();
    	setComponentConstraints(faxField, 3, 3, 1, 1, true);
    	
    	manLabel = new JLabel("联系人:");
    	setComponentConstraints(manLabel,0,4,1,1,false);
    	manField = new JTextField();
    	setComponentConstraints(manField,1,4,1,1,true);
    	manMobileLabel = new JLabel("联系人电话:");
    	setComponentConstraints(manMobileLabel,2,4,1,1,false);
    	manMobileField = new JTextField();
    	setComponentConstraints(manMobileField,3,4,1,1,true);
    	
    	
    	yinhangLabel = new JLabel("开户银行:");
    	setComponentConstraints(yinhangLabel,0,5,1,1,false);
    	yinhangField = new JTextField();
    	setComponentConstraints(yinhangField,1,5,1,1,true);
    	
    	emailLabel = new JLabel("电子邮箱:");
    	setComponentConstraints(emailLabel,2,5,1,1,false);
    	emailField = new JTextField();
    	setComponentConstraints(emailField,3,5,1,1,true);
    	
    	addButton = new JButton("添加");
    	addButton.addActionListener(new AddActionListener());
    	setComponentConstraints(addButton,1,6,1,0,false);
    	//为按钮注册监听器
    	
    	reSetButton = new JButton("重置");
    	setComponentConstraints(reSetButton,3,6,1,0,false);
    	reSetButton.addActionListener(new ResetActionListener());
    	
    }
    
    private void setComponentConstraints(JComponent component,int gridx,int gridy,
    		                             int gridwidth,int ipadx,boolean fill){//设置组件的布局
    	final GridBagConstraints gridBagConstraints = new GridBagConstraints();
    	gridBagConstraints.gridx=gridx;
    	gridBagConstraints.gridy=gridy;
    	gridBagConstraints.insets=new Insets(5,1,3,1);
    	if(gridwidth>1){
    		gridBagConstraints.gridwidth=gridwidth;
    	}
    	if(ipadx>0){
    		gridBagConstraints.ipadx=ipadx;
    	}
    	if(fill){
    		gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
    	}
    	this.add(component,gridBagConstraints);
    	
    }
    
    protected class ResetActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			quanchengField.setText("");
		    simpleNameField.setText("");
		    gzipField.setText("");
		    addressField.setText("");
		    phoneField.setText("");
		    faxField.setText("");
		    manField.setText("");
		    manMobileField.setText("");
		    yinhangField.setText("");
		    emailField.setText("");
		}
    }
    
    protected class AddActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (quanchengField.getText().equals("") || simpleNameField.getText().equals("")
					|| gzipField.getText().equals("")
					|| addressField.getText().equals("")
					|| phoneField.getText().equals("")
					||  faxField.getText().equals("")
					|| manField.getText().equals("")
					|| manMobileField.getText().equals("")
					||  yinhangField.getText().equals("")
					|| emailField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(GysTianJiaPanel.this, "请填写全部信息");
				return;
			}
			try {
				ResultSet haveUser = dbDao
						.query("select * from tb_gysinfo where name='"
								+ quanchengField.getText().trim() + "'");
				if (haveUser.next()) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this,
							"供应商信息添加失败，存在同名供应商", "供应商添加信息",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				ResultSet set = dbDao.query("select max(id) from tb_gysinfo");
				String id = null;
				if (set != null && set.next()) {
					String sid = set.getString(1).trim();
					if (sid == null)
						id = "gys1001";
					else {
						String str = sid.substring(3);
						id = "gys" + (Integer.parseInt(str) + 1);
					}
				}
				TbGysinfo gysInfo = new TbGysinfo();
				gysInfo.setId(id);
				gysInfo.setAddress(addressField.getText().trim());
				gysInfo.setBianma(gzipField.getText().trim());
				gysInfo.setFax(faxField.getText().trim());
				gysInfo.setYh(yinhangField.getText().trim());
				gysInfo.setJc(simpleNameField.getText().trim());
				gysInfo.setName(quanchengField.getText().trim());
				gysInfo.setLian(manField.getText().trim());
				gysInfo.setLtel(manMobileField.getText().trim());
				gysInfo.setMail(emailField.getText().trim());
				gysInfo.setTel(phoneField.getText().trim());
				dbDao.addGys(gysInfo);
				JOptionPane.showMessageDialog(GysTianJiaPanel.this, "已成功添加客户",
						"客户添加信息", JOptionPane.INFORMATION_MESSAGE);
				reSetButton.doClick();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
			
}


