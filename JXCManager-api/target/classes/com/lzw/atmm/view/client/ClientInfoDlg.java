package com.lzw.atmm.view.client;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import com.lzw.atmm.tsd.data.IconFactory;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：客户端消息通知对话框
 * 类名称：.ClientInfoDlg     
 * 创建人：杨洪
 * 创建时间：2016年10月14日 下午3:50:20   
 * 修改人：
 * 修改时间：2016年10月14日 下午3:50:20   
 * 修改备注：   
 * @version   V1.0    
 */
public class ClientInfoDlg extends JDialog {
	private static final long serialVersionUID = -5570391913846262262L;
	private JButton cancelButton;
	private JButton okButton;
	private JComboBox<String> jComboBox1;
	private JLabel jLabel1;
	private JPanel jPanel2;
	protected  static final String RIGHT_NOW = "立即重启升级";
	protected  static final String HOUR_1="1小时重启";
	protected  static final String HOUR_6="6小时重启";
	protected  static final String HOUR_24="24小时重启";
	
	public ClientInfoDlg(){
		this.setModal(true);
		this.setResizable(false);
		this.setAlwaysOnTop(true);//总是在窗体的最前端
		this.setLocationRelativeTo(null);
		ImageIcon icon =IconFactory.getIcon(IconFactory.ALERT_FILEPATH);//图标工厂
		this.setIconImage(icon.getImage());//设置系统图标
		initWindowComponent();
	}
	

	private void initWindowComponent(){
		okButton = new JButton("确认");
		cancelButton = new JButton("取消");
		jLabel1 = new JLabel("客户端发现新的版本");
		jPanel2 = new JPanel();
		jComboBox1 = new JComboBox<String>();
		this.setTitle("客户端升级");
		cancelButton.setFont(new Font("微软雅黑",0,12));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//关闭时释放内存
		cancelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_this_cancelActionPerformed(e);
			}
		});
		okButton.setFont(new Font("微软雅黑",0,12));
		okButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_this_okActionPerformed(e);
			}
		});
		
		jPanel2.setBorder(BorderFactory.createTitledBorder(//设置面板标题表框样式
				null,
				"",
			    TitledBorder.DEFAULT_JUSTIFICATION,
			    TitledBorder.DEFAULT_POSITION, 
			    new Font("微软雅黑",0,12)));
		
		jLabel1.setFont(new Font("微软雅黑",0,14));
		
		jComboBox1.setModel(
				new DefaultComboBoxModel<String>(//默认的下拉框数据模型
						new String[]{RIGHT_NOW,HOUR_1,HOUR_6,HOUR_24}));//设置下拉框的数据模型
		
		//布局面板--------------组布局管理器
		GroupLayout groupLayoutPanel = new GroupLayout(jPanel2);//根据面板对象创建组布局管理器
		// 设置面板的布局为组布局
		jPanel2.setLayout(groupLayoutPanel);//设置面板的布局为组布局
		
		groupLayoutPanel.setHorizontalGroup(
				groupLayoutPanel.createParallelGroup(GroupLayout.Alignment.LEADING)//左对齐
				.addGroup(groupLayoutPanel.createSequentialGroup()//创建串行组
						.addContainerGap()//添加容器的空隙【有首选默认尺寸】
						.addGroup(groupLayoutPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1)
								.addComponent(jComboBox1,GroupLayout.PREFERRED_SIZE,111,GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		groupLayoutPanel.setVerticalGroup(
				groupLayoutPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayoutPanel.createSequentialGroup()
						.addGap(6,6,6)//创建容器的空白间隙
						.addComponent(jLabel1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jComboBox1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
		);//左对齐
		
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(//创建水平组
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        
        layout.setVerticalGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jPanel2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
        				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        						.addComponent(okButton)
        						.addComponent(cancelButton))
        		.addGap(10,10,10))
        );
        
        layout.linkSize(SwingConstants.VERTICAL, new Component[]{okButton,cancelButton});
        
        
	}
	
	
	private void do_this_cancelActionPerformed(ActionEvent e){
		this.setVisible(false);//直接隐藏掉----没有释放内存-----
	}
	
	private void do_this_okActionPerformed(ActionEvent e){
		
	}
	
	private static String PATH = System.getProperty("user.dir");//获取项目所在的工作目录(包括项目名称)
	public static void main(String[] args) {
		ClientInfoDlg clientDlg=new ClientInfoDlg();
		clientDlg.setTitle(PATH);
		System.out.println(PATH);
		clientDlg.setBounds(1150, 735, 250, 155);
		clientDlg.setVisible(true);
		
	}
	

}
