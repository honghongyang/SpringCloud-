package com.lzw.atmm.view.message;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import com.lzw.atmm.tclient.statistics.GBC;
import com.lzw.atmm.tsd.data.IconFactory;

/**
 * 
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：简单封装对话框
 * 类名称：com.lzw.view.message.ConfirmDlg     
 * 创建人：杨洪
 * 创建时间：2016年6月17日 上午11:53:22   
 * 修改人：
 * 修改时间：2016年6月17日 上午11:53:22   
 * 修改备注：   
 * @version   V1.0
 */
public class ConfirmDlg extends JDialog {
	private static final long serialVersionUID = -2772233454751975488L;
    private JButton okButton;
	
	private JButton cancelButton;
	
	private JButton confirmButton;
	
	private JPanel buttonPanel;
	
	private JLabel iconLabel;
	
	private JLabel contentLabel;
	
	private JPanel contentPanel;
	
	private int value = -1;
	
	public static final int NO_OPTION = 0;
	
	public static final int YES_OPTION = 1;
	
	private static final String BLANK = "";
	
	public static final int ERROR_MESSAGE = 0;
	
	public static final int INFORMATION_MESSAGE = 1;
	
	public static final int WARNING_MESSAGE = 2;
	
	public static final int QUESTION_MESSAGE = 3;
	
	private ConfirmDlg(){
		
	}
	
	private ConfirmDlg(Window window, String content, int messageType){
		super(window);
		okButton = new JButton("是(Y)");
		okButton.setPreferredSize(new Dimension(77, 25));
		setLayout(new BorderLayout());
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				value = YES_OPTION;
				dispose();
			}
		});
		
		cancelButton = new JButton("否(N)");
		cancelButton.setPreferredSize(new Dimension(77, 25));
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				value = NO_OPTION;
				dispose();
			}
		});
		
		confirmButton = new JButton("确定");
		confirmButton.setPreferredSize(new Dimension(77, 25));
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		
		iconLabel = new JLabel();
		contentLabel = new JLabel("",JLabel.CENTER);

		if(messageType == QUESTION_MESSAGE){
			buttonPanel.add(okButton, new GBC(1, 0).setAnchor(GBC.CENTER).setInsets(5, 0, 10, 0));
			buttonPanel.add(cancelButton, new GBC(2, 0).setAnchor(GBC.CENTER).setInsets(5, 0, 10, 0));
			iconLabel.setIcon(IconFactory.getIcon(IconFactory.QUESTION_FILEPATH));
		}else if(messageType == INFORMATION_MESSAGE){
			buttonPanel.add(confirmButton, new GBC(1, 0).setAnchor(GBC.CENTER).setInsets(5, 0, 10, 0));
			iconLabel.setIcon(IconFactory.getIcon(IconFactory.INFOMATION_FILEPATH));
		}else if(messageType == ERROR_MESSAGE){
			buttonPanel.add(confirmButton, new GBC(1, 0).setAnchor(GBC.CENTER).setInsets(5, 0, 10, 0));
			iconLabel.setIcon(IconFactory.getIcon(IconFactory.ERROR_FILEPATH));
		}
		content = content == null ? BLANK : content;
		contentLabel.setText(content);
		contentLabel.setForeground(Color.orange);
		setTitle("系统提示");

	    contentPanel = new JPanel();
	    
	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(contentPanel);
	    contentPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(contentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
	    
        add(contentPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(window);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setResizable(false);
		this.setModal(true);//设置窗体模态为true,表示当弹出该窗体时,如果该窗体没有关闭,则会屏蔽其他窗体的操作,直至关闭该窗体后,才可以进行其他的操作
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		pack();
	}
	
	protected JRootPane createRootPane() {
		KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		JRootPane rootPane = new JRootPane();
		rootPane.registerKeyboardAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				escapeKeyProc();
			}
		}, stroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

		return rootPane;
	}
	
	protected void escapeKeyProc() {
		// TODO Auto-generated method stub
		dispose();
	}

	private static Window getWindowForComponent(Component paramComponent)
			throws HeadlessException {
		if (paramComponent == null)
			return JOptionPane.getRootFrame();
		if ((paramComponent instanceof Frame) || (paramComponent instanceof Dialog))
			return ((Window) paramComponent);
		return getWindowForComponent(paramComponent.getParent());
	}

	public static int showConfirmDialog(Component component, String content, int messageType){
		Window window = getWindowForComponent(component);
		ConfirmDlg dlg = new ConfirmDlg(window, content, messageType);
		dlg.setBounds(1124, 690, 300, 150);
		dlg.setVisible(true);
		return dlg.getValue();
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	 
	public static void main(String[] args) {
		ConfirmDlg.showConfirmDialog(null, "这是提示消息的测试内容",ConfirmDlg.WARNING_MESSAGE);//改变消息类型,看看弹出窗体
	}


}
