package com.lzw.atmm.panel.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述    ： 信息服务面板
 * 类名        ：com.lzw.image.server.panel.ServerPanel     
 * 创建人    ：杨洪
 * 创建时间：2016年12月29日 上午11:38:58   
 * 修改人    ：
 * 修改时间：2016年12月29日 上午11:38:58   
 * 修改备注：   
 * @version   V1.0    
 */

public class ServerPanel extends JPanel{
	private static final long serialVersionUID = 265062917570432456L;
	private BufferedImage monitorImg;
	private BufferedImage barPicImg;
	private BufferedImage panelImg;
	private BufferedImage logoBarImg;
	
	
	public ServerPanel(){
		try {
			logoBarImg = ImageIO.read(new File("images/logoBar.png"));
			monitorImg = ImageIO.read(new File("images/faro.png"));
			barPicImg = ImageIO.read(new File("images/barPic.png"));
			panelImg = ImageIO.read(new File("images/plane.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static Color decorateColor = new Color(254, 247, 218);
	private static Color titleFontColor = new Color(0, 93, 171);
	private static Font titlelFont = new Font("黑体", Font.BOLD, 36);
	private static Color itemFontColor = titleFontColor.darker();
	private static Font itemFont = new Font("黑体", Font.PLAIN, 18);
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		boolean isSee = true;
		for (int i = 0; i < getComponentCount(); i++)
		{
			CloseTabPane tabPane = (CloseTabPane) getComponent(i);
			if (tabPane.getTabCount() > 0)
			{
				isSee = false;
				break;
			}
		}
		if (getComponentCount() == 0 || isSee)
		{
			Graphics2D gTemp = (Graphics2D) g.create();
			gTemp.setClip(0, 0, getWidth(), getHeight());
			gTemp.setColor(Color.white);
			gTemp.fill(gTemp.getClip());
			gTemp.setColor(decorateColor);
			gTemp.fillOval(-120, -140, 280, 280);
			gTemp.drawImage(logoBarImg, 0, 0, getWidth(), 47, null);
			gTemp.setColor(titleFontColor);
			gTemp.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			gTemp.setFont(titlelFont);
			gTemp.drawString("流量管理", 30, 90);
			gTemp.drawImage(monitorImg, 40, 155, null);
			gTemp.setFont(itemFont);
			gTemp.setColor(itemFontColor);
			gTemp.drawString("动态监控", 160, 195);
			gTemp.drawImage(panelImg, 32, 290, null);//绘制图片
			gTemp.drawString("航班预测", 160, 325);
			gTemp.drawImage(barPicImg, 35, 435, null);
			gTemp.drawString("流量预测结果的统计和显示", 160, 470);
			gTemp.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
			gTemp.setColor(g.getColor());
			gTemp.setFont(g.getFont());
			gTemp.drawString("流量管理，监控预测机场、航路点、航路、区域流量平台。", 40, 125);
			gTemp.drawString("时间跨度从当前时间一小时到未来六小时流量动态监控。", 160, 225);
			gTemp.drawString("预测航班信息，以及航班未来飞行航迹预测。", 160, 355);
			gTemp.drawString("统计流量预测信息，以图表、时间轴图、数据表格直观显示流量预测数据。", 160, 500);
			gTemp.dispose();
		}
	}

}
