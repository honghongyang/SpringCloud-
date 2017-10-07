package com.lzw.atmm.util.worker;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.lzw.atmm.tsd.data.IconFactory;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：声音播放器
 * 类名称：com.lzw.atmm.util.worker.VideoPlayDemo     
 * 创建人：杨洪
 * 创建时间：2016年12月27日 上午11:24:29   
 * 修改人：
 * 修改时间：2016年12月27日 上午11:24:29   
 * 修改备注：   
 * @version   V1.0    
 */


public class MusicPlayer extends JFrame {
	private static final long serialVersionUID = 890989959290445949L;
	private Container container;  
	    private JButton playbutton;  
	    private PlayBackThread playbackthread;  
	    //默认构造函数  
	    public MusicPlayer(String title){  
	       super(title);  
	        container = this.getContentPane();  
	        playbutton = new JButton("播放");  
	        playbutton.setSize(50,20);  
	        playbutton.addActionListener(new PlayActionListener());  
	        this.setLayout(new BorderLayout());  
	        this.setSize(500,400);  
	        container.add(playbutton,BorderLayout.CENTER);  
	        Toolkit toolkit = Toolkit.getDefaultToolkit();  
	        int x = (int)(toolkit.getScreenSize().getWidth()-this.getWidth())/2;  
	        int y = (int)(toolkit.getScreenSize().getHeight()-this.getHeight())/2;  
	        this.setLocation(x,y);  
	        this.setVisible(true); 
	        this.setResizable(false);
	        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
	    }  
	      
	    /** 
	     * @param args the command line arguments 
	     */  
	    public static void main(String[] args) {    
	        MusicPlayer mp = new MusicPlayer("Music播放器");  
	        ImageIcon icon =IconFactory.getIcon(IconFactory.LANG_TITLE_FILEPATH);//图标工厂
			mp.setIconImage(icon.getImage());//设置系统图标
	    }  
	    class PlayActionListener implements ActionListener{  
	  
	        @Override  
	        public void actionPerformed(ActionEvent e) {  
	            System.out.println(e.getActionCommand());  
	            playbackthread = new PlayBackThread();  
	            playbackthread.start();  
	        }  
	    }  


}
