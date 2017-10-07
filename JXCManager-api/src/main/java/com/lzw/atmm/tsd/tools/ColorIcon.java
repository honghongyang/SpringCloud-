package com.lzw.atmm.tsd.tools;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述： 带颜色的图标工具类
 * 类名称：com.lzw.atmm.tsd.tools.ColorIcon     
 * 创建人：杨洪
 * 创建时间：2016年12月30日 下午4:06:18   
 * 修改人：
 * 修改时间：2016年12月30日 下午4:06:18   
 * 修改备注：   
 * @version   V1.0    
 */
public class ColorIcon implements Icon{

    private Color color;
    
    public ColorIcon(Color color){
    	this.color = color;
    }
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, getIconWidth(),getIconHeight());
		g.setColor(Color.GRAY);
		g.drawRect(x, y, getIconWidth(),getIconHeight());

	}
	@Override
	public int getIconWidth() {	
		return 12;
	}

	@Override
	public int getIconHeight() {
		return 12;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	

}
