package com.lzw.atmm.util.worker;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.lzw.atmm.tsd.data.IconFactory;

/**
 * 版权所有：2016-中实智达 
 * 项目名称：JXCManager-api 
 * 类描述：测试Java发声
 * 类名称：com.lzw.atmm.util.worker.EventTestDeepMethod 
 * 创建人：杨洪 
 * 创建时间：2016年12月27日 上午10:58:07
 * 修改人： 
 * 修改时间：2016年12月27日 上午10:58:07 
 * 修改备注：
 * @version V1.0
 */

public class EventTestDeepMethod extends WindowAdapter implements ActionListener {
	JButton b1 = null;
	JButton b2 = null;
	
	public EventTestDeepMethod() {
		JFrame f = new JFrame("这是测试发声的综合控制窗体");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(1, 2));
		ImageIcon icon =IconFactory.getIcon(IconFactory.LANG_TITLE_FILEPATH);//图标工厂
		f.setIconImage(icon.getImage());//设置系统图标
		b1 = new JButton("点击按钮,带上耳机测试是否发声 ....");
		b2 = new JButton("点击按钮,打开新窗口.....");
		b1.addActionListener(this);
		b2.addActionListener(this);
		contentPane.add(b1);
		contentPane.add(b2);
		f.pack();
		f.setVisible(true);
		f.setBounds(300,400, 400,250);
		f.setResizable(false);
		f.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        int n=10;
        n++;
		if (e.getSource() == b1)
			Toolkit.getDefaultToolkit().beep();//发声的关键

		if (e.getSource() == b2) {
			JFrame jf = new JFrame("新产生的窗体");
			jf.setBounds(200, 200+n, 400, 350);
			ImageIcon icon =IconFactory.getIcon(IconFactory.LANG_TITLE_FILEPATH);//图标工厂
			jf.setIconImage(icon.getImage());//设置系统图标
			jf.setVisible(true);
			jf.setResizable(false);
			;

		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		new EventTestDeepMethod();
	}

}
