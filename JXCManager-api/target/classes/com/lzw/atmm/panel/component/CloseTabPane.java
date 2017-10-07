package com.lzw.atmm.panel.component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.JPopupMenu;

import com.lzw.atmm.component.DoubleClickListener;
import com.lzw.atmm.component.MoveTabPane;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述    ：带关闭按钮的tabPane
 * 类名称    ：com.lzw.image.server.panel.CloseTabPane     
 * 创建人    ：杨洪
 * 创建时间：2016年12月29日 下午1:30:51   
 * 修改人   ：
 * 修改时间：2016年12月29日 下午1:30:51   
 * 修改备注：   
 * @version   V1.0    
 */

public class CloseTabPane extends MoveTabPane {
	private static final long serialVersionUID = -4662924222805150883L;
	private boolean closeAble = true;
	private int closeTab = -1;
	private JPopupMenu actionPopupMenu = new JPopupMenu();
	
	public CloseTabPane(){
		init();
	}

	private void init(){
		this.add(actionPopupMenu);
		this.addMouseListener(new MyMouseHandler());//为选项卡面板注册鼠标监听器
	}
	
	class MyMouseHandler implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {//鼠标被电击时出发
			if(e.getClickCount() > 1 && e.getButton() == MouseEvent.BUTTON1){
				CloseTabPane.this.fireDoubleClickListener();
			}
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
		}	
		@Override
		public void mouseReleased(MouseEvent e) {//释放鼠标事件
			if(e.isPopupTrigger()){//如果当前系统将MouseEvent视为弹出菜单触发器，则返回true
				actionPopupMenu.show(e.getComponent(), e.getX(), e.getY());//在调用者的坐标空间中的位置X、Y处显示弹出菜单
			}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	}
	
	/**
	 * 发生双击后触动DoubleClickListener中的动作
	 * @param e
	 */
	public void fireDoubleClickListener(){
		EventListener dClickListeners[] = getListeners(DoubleClickListener.class);//该方法返回所有的事件监听器
		for(int i=0;i<dClickListeners.length;i++){
		   ((DoubleClickListener)dClickListeners[i]).doubleClickOperation();	
		}
	}
	
	/**
	 * 增加closeListener
	 * @param l
	 */
	public synchronized void addCloseListener(CloseListener closeListener){//同时操作
		listenerList.add(CloseListener.class,closeListener);
	}
	
	/**
	 * Adds a <code>DoubleClickListener</code> to the tabbedPane.
	 * @param doubleClickListener
	 * the <code>DoubleClickListener</code> to add
	 * @see #fireDoubleClickTabEvent
	 * @see #removeDoubleClickListener
	 */
    public synchronized void addDoubleClickListener(DoubleClickListener doubleClickListener){
    	listenerList.add(DoubleClickListener.class, doubleClickListener);
    }
    
    /**
	 * 关闭之前应该做的动作
	 * @param closeTab
	 */
    public void fireCloseTabEvent(int closeTab){
    	this.setCloseTab(closeTab);//给关闭按钮
    	EventListener closeListeners[] = getListeners(CloseListener.class);
    	for(int i=0;i<closeListeners.length;i++){
    	     ((CloseListener)closeListeners[i]).closeOperation();	
    	}
    	this.remove(closeTab);//移除索引处的选项卡
    	if(this.getTabCount()==0){//如果获得的选项卡为0
    		this.setVisible(false);//则不显示
    	}
    }

	/**
	 * 发生双击后触动DoubleClickListener中的动作
	 * @param e
	 */
    public void firDoubleClickTabEvent(){
    	EventListener dDoubleClickListeners[] = getListeners(DoubleClickListener.class);
    	for(int i=0;i<dDoubleClickListeners.length;i++){
    		((DoubleClickListener)dDoubleClickListeners[i]).doubleClickOperation();
    	}
    	
    }
    
    public boolean isCloseAble() {
		return closeAble;
	}

	public void setCloseAble(boolean closeAble) {
		this.closeAble = closeAble;
	}

	public int getCloseTab() {
		return closeTab;
	}

	public void setCloseTab(int closeTab) {
		this.closeTab = closeTab;
	}

	public JPopupMenu getActionPopupMenu() {
		return actionPopupMenu;
	}

	public void setActionPopupMenu(JPopupMenu actionPopupMenu) {
		this.actionPopupMenu = actionPopupMenu;
	}
    
    

}
