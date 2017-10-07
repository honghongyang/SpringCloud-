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
import com.lzw.atmm.model.TbKhinfo;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：客户信息修改及删除面板
 * 类名称：com.lzw.sys.internalFrame.panel.KeHuXiuGaiPanel     
 * 创建人：杨洪
 * 创建时间：2016年8月12日 下午12:02:11   
 * 修改人：
 * 修改时间：2016年8月12日 下午12:02:11   
 * 修改备注：   
 * @version   V1.0    
 */

public class KeHuXiuGaiPanel extends JPanel {
	private static final long serialVersionUID = 8652906340762347308L;
	private JLabel quanchengLabel;
	private JLabel addressLabel;
	private JLabel simpleNameLabel;
	private JLabel emsCodeLabel;
	private JLabel phoneLabel;
	private JLabel faxLabel;
	private JLabel manLabel;
	private JLabel manMobileLabel;
	private JLabel emailLabel;
	private JLabel yinhangLabel;
	private JLabel accountLabel;
	private JLabel chooseKeHuComboBoxLabel;
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
	private JComboBox<Object> chooseKeHuComboBoxField;
	private JButton modifyButton;
	private JButton cancleButton;
	private JPanel panel;
	public KeHuXiuGaiPanel(){
		this.dbDao = DBDao.newInstance();
		this.setBounds(10,10,460,300);
		this.setLayout(new GridBagLayout());//设置面板的布局为网格组布局
		this.initWindowComponent();
	}
	
	

	private void initWindowComponent(){//初始化系统各组件
		quanchengLabel = new JLabel("客户全称:");
		setComponentConstraints(quanchengLabel,0,0,1,0,false);
		quanchengField = new JTextField();
		setComponentConstraints(quanchengField,1,0,3,370,true);//参照标准总是在最全面
		quanchengField.setEnabled(false);
		
		addressLabel = new JLabel("客户地址:");
		setComponentConstraints(addressLabel,0,1,1,0,false);
		addressField = new JTextField();
		setComponentConstraints(addressField,1,1,3,1,true);
		
		simpleNameLabel = new JLabel("客户简称:");
		setComponentConstraints(simpleNameLabel,0,2,1,0,false);
		simpleNameField = new JTextField();
		setComponentConstraints(simpleNameField,1,2,1,150,true);//参照标准总是在最全面
		emsCodeLabel = new JLabel("邮政编码:");
		setComponentConstraints(emsCodeLabel,2,2,1,1,false);
		emsCodeField = new JTextField();
		setComponentConstraints(emsCodeField,3,2,1,1,true);
		
		phoneLabel = new JLabel("电话:");
		setComponentConstraints(phoneLabel,0,3,1,0,false);
		phoneField = new JTextField();
		setComponentConstraints(phoneField,1,3,1,1,true);
		faxLabel = new JLabel("传真:");
		setComponentConstraints(faxLabel,2,3,1,1,false);
		faxField = new JTextField();
		setComponentConstraints(faxField,3,3,1,1,true);
		
		manLabel = new JLabel("联系人:");
		setComponentConstraints(manLabel,0,4,1,0,false);
		manField = new JTextField();
		setComponentConstraints(manField,1,4,1,1,true);
		manMobileLabel = new JLabel("联系电话:");
		setComponentConstraints(manMobileLabel,2,4,1,0,false);
		manMobileField = new JTextField();
		setComponentConstraints(manMobileField,3,4,1,1,true);
		
		emailLabel = new JLabel("邮箱:");
		setComponentConstraints(emailLabel,0,5,1,0,false);
		emailField = new JTextField();
		setComponentConstraints(emailField,1,5,3,1,true);
       
		yinhangLabel = new JLabel("开户银行:");
		setComponentConstraints(yinhangLabel,0,6,1,0,false);
		yinhangField = new JTextField();
		setComponentConstraints(yinhangField,1,6,1,1,true);
		accountLabel = new JLabel("账号:");
		setComponentConstraints(accountLabel,2,6,1,0,false);
		accountField = new JTextField();
		setComponentConstraints(accountField,3,6,1,1,true);
		
		chooseKeHuComboBoxLabel = new JLabel("选择客户:");
		setComponentConstraints(chooseKeHuComboBoxLabel,0,7,1,0,false);
		chooseKeHuComboBoxField = new JComboBox<Object>();
		chooseKeHuComboBoxField.setPreferredSize(new Dimension(230, 21));
		initComboBoxData();//初始化下拉框的数据
		//为下拉选择框添加监听器
		chooseKeHuComboBoxField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {//处理当选择下拉框中的某一项时,查询数据,该各文本框赋值------每次查询文本框中的值动态改变
			   doKeHuSelectedAction();
			}
		});
		setComponentConstraints(chooseKeHuComboBoxField,1,7,2,1,true);
		panel = new JPanel();
		modifyButton = new JButton("修改");
		modifyButton.addActionListener(new ModifyActionListener());
		cancleButton = new JButton("删除");
		cancleButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Item item = (Item)chooseKeHuComboBoxField.getSelectedItem();
				if (item == null || !(item instanceof Item))
					return;
				int confirm = JOptionPane.showConfirmDialog(
						KeHuXiuGaiPanel.this, "确认删除客户信息吗？");
				if (confirm == JOptionPane.YES_OPTION) {
					int rs = dbDao.delete("delete tb_khinfo where id='"
							+ item.getId() + "'");
					if (rs > 0) {
						JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this,
								"客户：" + item.getName() + "。删除成功");
						chooseKeHuComboBoxField.removeItem(item);
					}
				}
			}
		});
		panel.add(modifyButton);
		panel.add(cancleButton);
		setComponentConstraints(panel,3,7,1,1,false);
		
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
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		}
		gridBagConstraints.insets = new Insets(5,1,3,1);
		this.add(component,gridBagConstraints);//添加组件到容器,同时为组件添加约束
	}
	
	
	public void initComboBoxData(){//初始化下拉选择框
		List<List<String>> khInfo=dbDao.getKhInfos();
		List<Item> items = Lists.newArrayList();
		for(Iterator<List<String>> iter=khInfo.iterator();iter.hasNext();){
			List<String> element=iter.next();
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if(items.contains(item))
				continue;//跳过包含的,继续添加
			items.add(item);
			//同时把item选项添加到下拉框中
			chooseKeHuComboBoxField.addItem(item);
		}
		//同时初始化各个文本框
		doKeHuSelectedAction();	
	}
	private void doKeHuSelectedAction(){
		Item  selectedItem;//该实体类为所有下拉框中选项的填充值id---name
		if(!(chooseKeHuComboBoxField.getSelectedItem() instanceof Item)){//如果选择框中的选项不属于Item
			return;
		}
		selectedItem=(Item) chooseKeHuComboBoxField.getSelectedItem();//下拉选择框中的是一个对象
		TbKhinfo info =dbDao.getKhInfo(selectedItem);
		quanchengField.setText(info.getKhname());
		addressField.setText(info.getAddress());
		simpleNameField.setText(info.getJian());
		emsCodeField.setText(info.getBianma());
		phoneField.setText(info.getTel());
		faxField.setText(info.getFax());
		manField.setText(info.getLian());
		manMobileField.setText(info.getLtel());
		emailField.setText(info.getMail());
		yinhangField.setText(info.getXinhang());
		accountField.setText(info.getHao());
	}
	
	private class ModifyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Item item = (Item)chooseKeHuComboBoxField.getSelectedItem();
			TbKhinfo khinfo = new TbKhinfo();
			khinfo.setId(item.getId());
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
			if (dbDao.updateKeHu(khinfo) == 1)
				JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "修改完成");
			else
				JOptionPane.showMessageDialog(KeHuXiuGaiPanel.this, "修改失败");
		}
	  };
	}

	
	

