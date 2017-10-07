package com.lzw.atmm.sys.internalFrame.panel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.common.collect.Lists;
import com.lzw.atmm.dao.DBDao;
import com.lzw.atmm.internalFrame.guanli.Item;
import com.lzw.atmm.model.TbGysinfo;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：供应商修改和删除面板
 * 类名称：com.lzw.sys.internalFrame.panel.GysXiuGaiPanel     
 * 创建人：杨洪
 * 创建时间：2016年8月10日 上午9:13:43   
 * 修改人：
 * 修改时间：2016年8月10日 上午9:13:43   
 * 修改备注：   
 * @version   V1.0    
 */

public class GysXiuGaiPanel extends JPanel {
	private static final long serialVersionUID = -6245758142185278005L;
	private JLabel quanchengLabel;
	private JLabel jianchengLabel;
	private JLabel emsCodeLabel;//邮政编码
	private JLabel addressLabel;
	private JLabel phoneLabel;//座机
	private JLabel faxLabel;
	private JLabel manLabel;
	private JLabel manMobileLabel;//联系人电话
	private JLabel yinhangLabel;//开户银行
	private JLabel emailLabel;//电子邮箱
	private JLabel chooseGysLabel;//选择供应商
	
	private JTextField quanchengField;
	private JTextField jianchengField;
	private JTextField emsCodeField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField faxField;
	private JTextField manField;
	private JTextField manMobileField;
	private JTextField yinhangField;
	private JTextField emailField;
	private JComboBox<Object> chooseGysComboBox;
	private DBDao dbDao;
	private JButton modifyButton;
	private JButton cancleButton;
	private JPanel panel;
	
	public GysXiuGaiPanel(){
		dbDao = DBDao.newInstance();
		this.setLayout(new GridBagLayout());//网格组布局
		this.setBounds(10, 10, 510,302);
		initWindowComponent();
		
	}
	private void initWindowComponent(){
		quanchengLabel = new JLabel("供应商全称:");
		setComponentConstraints(quanchengLabel,0,0,1,1,false);
		quanchengField = new JTextField();
		quanchengField.setEditable(false);
		setComponentConstraints(quanchengField,1,0,3,400,true);//占三个单元格,当分给组件的空间大于组件时,组件增长幅度
		
		jianchengLabel = new JLabel("简称:");
		setComponentConstraints(jianchengLabel,0,2,1,1,false);
		jianchengField = new JTextField();
		setComponentConstraints(jianchengField,1,2,1,160,true);//这里的ipadx必须填,否则文本框的长度不会被撑起来
		
		emsCodeLabel = new JLabel("邮政编码:");
		setComponentConstraints(emsCodeLabel,2,2,1,1,false);
		emsCodeField = new JTextField();
		setComponentConstraints(emsCodeField,3,2,1,1,true);//  这里的ipadx会参照上面设置的ipadx
		
		addressLabel = new JLabel("地址:");
		setComponentConstraints(addressLabel,0,3,1,1,false);
		addressField = new JTextField();
		setComponentConstraints(addressField,1,3,3,1,true);//此处的ipadx为1,改主键会参照前面的设置进行拓展
		
		phoneLabel = new JLabel("电话:");
		setComponentConstraints(phoneLabel,0,4,1,1,false);
		phoneField = new JTextField();
		setComponentConstraints(phoneField,1,4,1,1,true);
		
		faxLabel = new JLabel("传真:");
		setComponentConstraints(faxLabel,2,4,1,1,false);
		faxField = new JTextField();
		setComponentConstraints(faxField,3,4,1,1,true);
		
		manLabel = new JLabel("联系人:");
		setComponentConstraints(manLabel,0,5,1,1,false);
		manField = new JTextField();
		setComponentConstraints(manField,1,5,1,1,true);
		
		manMobileLabel = new JLabel("联系人电话:");
		setComponentConstraints(manMobileLabel,2,5,1,1,false);
		manMobileField = new JTextField();
		setComponentConstraints(manMobileField,3,5,1,1,true);
		
		yinhangLabel = new JLabel("开户银行:");
		setComponentConstraints(yinhangLabel,0,6,1,1,false);
		yinhangField = new JTextField();
		setComponentConstraints(yinhangField,1,6,1,1,true);
		 
		emailLabel = new JLabel("电子邮箱:");
		setComponentConstraints(emailLabel,2,6,1,1,false);
		emailField = new JTextField();
		setComponentConstraints(emailField,3,6,1,1,true);
		
		chooseGysLabel = new JLabel("选择供应商:");
		setComponentConstraints(chooseGysLabel,0,7,1,1,false);
		chooseGysComboBox = new JComboBox<Object>();
		chooseGysComboBox.setPreferredSize(new Dimension(230,21));
		//初始化下拉框
		initComboBox();
		chooseGysComboBox.addActionListener(new ActionListener(){//匿名内部类
			@Override
			public void actionPerformed(ActionEvent e) {
				doGysSelectAction();
			}
		});
		setComponentConstraints(chooseGysComboBox,1,7,2,1,true);//占两个单元格
		modifyButton = new JButton("修改");
		cancleButton = new JButton("删除");
		panel = new JPanel();
		panel.add(modifyButton);
		panel.add(cancleButton);
		setComponentConstraints(panel,3,7,1,1,true);
		modifyButton.addActionListener(new ModifyActionListener());//为修改按钮注册监听器
		cancleButton.addActionListener(new CancleActionListener());
	}
	
	private void setComponentConstraints(JComponent component,int gridx,int gridy,
			                             int gridwidth,int ipadx,boolean fill){//添加各组件到面板和为组件添加约束
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
		gridBagConstraints.insets = new Insets(5,1,3,1);//设置各组件之间的间距-上-左-下-右
		this.add(component,gridBagConstraints);
	}
	/*初始化下拉匡*/
	public void initComboBox(){
		List<List<String>> gysInfo=dbDao.getGysInfos();
		List<Item> items =Lists.newArrayList();
		chooseGysComboBox.removeAllItems();//移除选择框中的所有的选项
		for(Iterator<List<String>> iter=gysInfo.iterator();iter.hasNext(); ){
			List<String> element=iter.next();
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if(items.contains(item))
				continue;
			items.add(item);
			chooseGysComboBox.addItem(item);
		}
	}
	
	// 处理供应商选择事件
	private void doGysSelectAction(){
		Item selectedItem;
		if(!(chooseGysComboBox.getSelectedItem() instanceof Item)){//如歌选择的对象不是的父类不是Item
			return;
		}
		selectedItem = (Item) chooseGysComboBox.getSelectedItem();//选择一次查询一次
		TbGysinfo gysInfo=dbDao.getGysInfo(selectedItem);
		quanchengField.setText(gysInfo.getName());
		jianchengField.setText(gysInfo.getJc());
		addressField.setText(gysInfo.getAddress());
		emsCodeField.setText(gysInfo.getBianma());
		faxField.setText(gysInfo.getFax());
		phoneField.setText(gysInfo.getTel());
		manField.setText(gysInfo.getLian());
		manMobileField.setText(gysInfo.getLtel());
		yinhangField.setText(gysInfo.getYh());
		emailField.setText(gysInfo.getMail());
	}
	private class ModifyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Item item=(Item) chooseGysComboBox.getSelectedItem();
			TbGysinfo gysInfo = new TbGysinfo();
			gysInfo.setId(item.id);
			gysInfo.setName(quanchengField.getText().trim());
			gysInfo.setJc(jianchengField.getText().trim());
			gysInfo.setAddress(addressField.getText());
			gysInfo.setFax(faxField.getText());
			gysInfo.setBianma(emsCodeField.getText());
			gysInfo.setLtel(manMobileField.getText());
			gysInfo.setMail(emailField.getText());
			gysInfo.setTel(phoneField.getText());
			gysInfo.setYh(yinhangField.getText());
			gysInfo.setLian(manField.getText());
			int n =dbDao.updateGys(gysInfo);
			if(n==1)
				JOptionPane.showConfirmDialog(GysXiuGaiPanel.this, "修改成功");
			else
				JOptionPane.showConfirmDialog(GysXiuGaiPanel.this, "修改失败");
		}
	}
	private class CancleActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Item selectedItem=(Item) chooseGysComboBox.getSelectedItem();
			if(selectedItem==null || selectedItem instanceof Item){
				return;
			}
			int confirm =JOptionPane.showConfirmDialog(GysXiuGaiPanel.this, "你确定要删除吗?");
			if (confirm == JOptionPane.YES_OPTION) {
				int rs = dbDao.delete("delete tb_gysInfo where id='"
						+ selectedItem.getId() + "'");
				if (rs > 0) {
					JOptionPane.showMessageDialog(GysXiuGaiPanel.this,
							"供应商：" + selectedItem.getName() + "。删除成功");
					chooseGysComboBox.removeItem(selectedItem);//从选择框中删除该选项
				} else {
					JOptionPane.showMessageDialog(GysXiuGaiPanel.this,
							"无法删除客户：" + selectedItem.getName() + "。");
				}
			}
			
		}
	}
}
