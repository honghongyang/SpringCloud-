package com.lzw.atmm.sys.internalFrame.window;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.lzw.atmm.dao.DBDao;
import com.lzw.atmm.internalFrame.guanli.Item;
import com.lzw.atmm.model.TbUserlist;
import com.lzw.atmm.tsd.data.IconFactory;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：权限管理内部窗体
 * 类名称：com.lzw.sys.internalFrame.frame.QuanManagerFrame     
 * 创建人：杨洪
 * 创建时间：2016年8月5日 上午8:58:35   
 * 修改人：
 * 修改时间：2016年8月5日 上午8:58:35   
 * 修改备注：   
 * @version   V1.0    
 */
public class QuanManagerFrame extends JInternalFrame {
	private static final long serialVersionUID = 482046814134444296L;
	private JLabel loginNameLabel;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JLabel quanXian;
	private JLabel selectUser;//选中用户标签
	private JTextField loginNameField;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JComboBox<Object>  quanXianCombox;//权限组合框
	private JComboBox<Object>  chooseUserCombox;//选择用户组合框
	private JButton modifyButton;//修改按钮
	private JButton cancleButton;//取消按钮
	private DBDao dbDao;
	
	public QuanManagerFrame(){
		ImageIcon icon =IconFactory.getIcon(IconFactory.ALERT_FILEPATH);//图标工厂
		this.setFrameIcon(icon);
		dbDao =DBDao.newInstance();
		this.setClosable(true);//定制关闭按钮可用
		this.setIconifiable(true);//定制最小化图标可用
		this.setBounds(10, 10, 420, 170);
		this.setTitle("权限管理");
		this.setLayout(new GridBagLayout());//设置网格组布局
		initWindowComponent();
		this.setVisible(true);
	}

	public void initWindowComponent(){
		
		this.loginNameLabel = new JLabel("登录名:");
		this.setContainerComponent(loginNameLabel,0,0,1,0,false);
		this.loginNameField = new JTextField();
		this.loginNameField.setEnabled(false);
		this.setContainerComponent(loginNameField, 1, 0, 1, 10, true);//该变100看看效果
		
		this.userNameLabel = new JLabel("用户名:");
		this.setContainerComponent(userNameLabel, 2, 0, 1, 0, false);
		this.userNameField = new JTextField();
		this.userNameField.setEnabled(false);
		this.setContainerComponent(userNameField, 3, 0, 1,10, true);
		
		this.passwordLabel = new JLabel("密码 :");
		this.setContainerComponent(passwordLabel, 0, 1, 1, 0, false);
		this.passwordField = new JPasswordField();
		this.passwordField.setEnabled(false);
		this.setContainerComponent(passwordField, 1, 1, 1, 10, true);
		
		
		this.quanXian = new JLabel("权 限:");
		this.setContainerComponent(quanXian, 2, 1, 1,0, false);
		this.quanXianCombox = new JComboBox<Object>(new String[]{"管理员", "操作员"});
		this.setContainerComponent(quanXianCombox, 3, 1, 1, 10, true);
		
		this.selectUser = new JLabel("选择用户:");
		this.setContainerComponent(selectUser, 0, 2, 1, 0,false);
		this.chooseUserCombox = new JComboBox<Object>();
		this.chooseUserCombox.setPreferredSize(new Dimension(80,21));
		//定位用户信息的下拉选择框
		setContainerComponent(chooseUserCombox, 1, 2, 2, 10, true);
		chooseUserCombox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		JPanel panel = new JPanel();//面板默认为流布局
		modifyButton = new JButton("修改");
		cancleButton = new JButton("取消");
		panel.add(modifyButton);
		panel.add(cancleButton);
		this.setContainerComponent(panel, 3, 2, 1, 0, false);
		// 处理修改按钮的单击事件
				modifyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Item item = (Item) chooseUserCombox.getSelectedItem();
						TbUserlist user = dbDao.getUser(item);
						int index = quanXianCombox.getSelectedIndex();
						if (index == 0)
							user.setQuan("a");
						else
							user.setQuan("c");
						if (dbDao.updateUser(user) >= 1)
							JOptionPane.showMessageDialog(QuanManagerFrame.this, "修改完成");
						else
							JOptionPane.showMessageDialog(QuanManagerFrame.this, "修改失败");
					}
				});
				// 窗体激活事件
				addInternalFrameListener(new InternalFrameAdapter() {
					public void internalFrameActivated(InternalFrameEvent e) {
						initComboBox();// 初始化用户下拉选择框
					}
				});
		
		
		
		
	}
	// 初始化用户下拉选择框
		public void initComboBox() {
			List<List<String>> khInfo = dbDao.getUsers();
			List<Item> items = new ArrayList<Item>();
			chooseUserCombox.removeAllItems();
			for (Iterator<List<String>> iter = khInfo.iterator(); iter.hasNext();) {
				List<String> element = (List<String>) iter.next();
				Item item = new Item();
				item.setId(element.get(0).toString().trim());
				item.setName(element.get(1).toString().trim());
				if (items.contains(item))
					continue;
				items.add(item);
				chooseUserCombox.addItem(item);
			}
			doUserSelectAction();
		}
	
	/**针对内部窗体JInternalFrame窗体的添加窗体到容器或者内容面板中和为窗体中的组件添加约束的公用方法***/
	private void setContainerComponent(JComponent component,int gridx,int gridy,
			int gridwidth,int ipady,boolean fill){
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx=gridx;
		gridBagConstraints.gridy=gridy;
		if(fill){
			gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;//当窗体扩大时,组件延水平方向平铺
		}
		if(gridwidth>1){
		   gridBagConstraints.gridwidth=gridwidth;
		}
		
		//竖直方向组件之间的间距默认为0
		if(ipady>0){
		   gridBagConstraints.ipady=ipady;//ipadx,ipady:设置组件【"内"】的间距，默认值为0
		}
	
		gridBagConstraints.insets = new Insets(8, 1, 3, 1);//上左下右的顺序,insets:设置组件之间彼此的间距，它有四个参数，分别是上，左，下，右，默认为(0,0,0,0)
		this.add(component,gridBagConstraints);//为组件添加约束,同时添加组件到容器
		
	}
	
	private void doUserSelectAction() {
		Item selectedItem;
		if (!(chooseUserCombox.getSelectedItem() instanceof Item)) {
			return;
		}
		selectedItem = (Item)chooseUserCombox.getSelectedItem();
		TbUserlist user = dbDao.getUser(selectedItem);
		userNameField.setText(user.getUsername());
		loginNameField.setText(user.getName());
		passwordField.setText(user.getPass());
		if (user.getQuan().equals("a"))
			quanXianCombox.setSelectedIndex(0);
		else
			quanXianCombox.setSelectedIndex(1);
	}
}
