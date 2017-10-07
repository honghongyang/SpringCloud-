package com.lzw.atmm.tsd.tools;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import com.lzw.atmm.tclient.view.ColorSet;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述    ：  带选择颜色的按钮
 * 类名称    ：com.lzw.atmm.tools.ColorButton     
 * 创建人    ：杨洪
 * 创建时间：2016年12月29日 下午4:23:26   
 * 修改人    ：
 * 修改时间：2016年12月29日 下午4:23:26   
 * 修改备注：   
 * @version   V1.0    
 */
public class ColorButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 2069768360783603043L;
    protected Border unSelectedBorder;//未被选择时的边框
    protected Border selectedBorder;//被选择时的边框
    protected Border activeBorder;//激活时的边框
    
    private ColorStype colorStype;
    
    
    public ColorButton(Color color){
    	// int size = 17;
    	// setPreferredSize(new Dimension(size, size));
        // Make the button looks the same for all Laf's
    	this.setUI(new BasicButtonUI());//设置基本的按钮图标样式
    	unSelectedBorder = new CompoundBorder(new MatteBorder(1,1,1,1,
    			getBackground()),new BevelBorder(BevelBorder.RAISED,
    					Color.white,Color.gray));
    	selectedBorder = new CompoundBorder(new MatteBorder(2,2,2,2,
    			Color.red),new MatteBorder(1,1,1,1,
    					getBackground()));
    	activeBorder = new CompoundBorder(new BevelBorder(BevelBorder.LOWERED,
    			Color.white,
    			Color.gray),
    			new MatteBorder(1,1,1,1,
    					getBackground()));
    	
    	// Make it transparent
    	// setContentAreaFilled(false);
    	// No need to be focusable
    	// setFocusable(false);
    	if(color == null){
    		color = ColorSet.DEFAULT;
    	}
    	colorStype = new ColorStype(color);
    	Color showColor = colorStype.getShowColor();
    	String msg = "R="+showColor.getRed()
    			   +" G="+showColor.getGreen()
    			   +" B="+showColor.getBlue();
    	this.setToolTipText(msg);//设置提示文本
    	this.setBackground(showColor);
    	this.setBorder(unSelectedBorder);//边框为未被选择时
    	this.setPreferredSize(new Dimension(18,18));
    	// setBorderPainted(false);
    	// Making nice rollover effect
    	// we use the same listener for all buttons
        this.addActionListener(this);
        this.addMouseListener(buttonMouseListener);//注册鼠标监听器是事件
       /* 设置 rolloverEnabled 属性，若需要翻转效果，该属性必须为 
        true。rolloverEnabled 属性的默认值为 
        false。一些外观也许不实现翻转效果；它们将忽略此属性。*/
        this.setRolloverEnabled(true);
    }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Component comp = this;//把当前组件对象-----按钮对象
		if(this.getParent()!= null){
			comp = this.getParent();
		}
		Color color = JColorChooser.showDialog(comp,"选择颜色",
				      colorStype.getShowColor());
		setShowColor(color);

	}
	
	public void setShowColor(Color showColor){//设置鼠标显示的颜色
		colorStype.setShowColor(showColor);
		colorStype.setEdited(true);
		setBackground(showColor);
		String msg = "R=" + showColor.getRed() + " G=" + showColor.getGreen()
				+ " B=" + showColor.getBlue();
		setToolTipText(msg);

        //	repaint();	
	}
	class ColorStype{//内部类
		private boolean isEdited=true;//是否被修改过
		private Color showColor = ColorSet.DEFAULT;
		public  ColorStype(Color showColor){
			this.showColor = showColor;
		}
		public boolean isEdited() {
			return isEdited;
		}
		public void setEdited(boolean isEdited) {
			this.isEdited = isEdited;
		}
		//返回颜色
		public Color getShowColor() {
			return showColor;
		}
		public void setShowColor(Color showColor) {
			this.showColor = showColor;
		}		
	}
	
	
	//匿名内部类
	private MouseListener buttonMouseListener = new MouseAdapter() {//鼠标适配器,只需要实现自己的业务方法
		@Override
		public void mouseEntered(MouseEvent e) {//按Enter键后触发,将触发该事件
			super.mouseEntered(e);
			Component component = e.getComponent();
			if(component instanceof AbstractButton){
				AbstractButton abstractButton = (AbstractButton) component;
				abstractButton.setBorder(unSelectedBorder);
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {//当-------【鼠标释放】------鼠标离开组件时调用
			super.mouseExited(e);
			Component component = e.getComponent();
			if(component instanceof AbstractButton){//如果组件为按钮
				AbstractButton abstractButton = (AbstractButton) component;
				abstractButton.setBorder(activeBorder);//呈现激活状的边框
			}
		}
	};
	
	

}
